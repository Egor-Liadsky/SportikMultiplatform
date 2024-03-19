package components.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import components.BaseComponent
import components.home.HomeComponentImpl
import components.product.ProductComponentImpl
import data.repository.category.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.LoadingState
import utils.exceptionHandleable

class RootComponentImpl(
    componentContext: ComponentContext
) : BaseComponent<RootState>(componentContext, RootState()), RootComponent, KoinComponent {

    private val categoryRepository: CategoryRepository by inject()

    private val navigation = StackNavigation<Config>()

    init {
        getCategories()
    }

    override val childStack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.Home,
            childFactory = ::childFactory
        )

    override fun onBackButtonClick() {
        navigation.pop()
    }

    private fun childFactory(
        config: Config,
        componentContext: ComponentContext
    ): RootComponent.Child =
        when (config) {
            Config.Home -> homeComponent(componentContext)
            is Config.Product -> productComponent(componentContext, config.productId)
        }

    private fun homeComponent(componentContext: ComponentContext): RootComponent.Child =
        RootComponent.Child.HomeChild(
            HomeComponentImpl(
                componentContext = componentContext,
                navigateToProductComponent = { productId -> navigation.push(Config.Product(productId)) }
            )
        )

    private fun productComponent(
        componentContext: ComponentContext,
        productId: Int
    ): RootComponent.Child =
        RootComponent.Child.ProductChild(
            ProductComponentImpl(
                componentContext = componentContext,
                productId = productId,
                onBackButtonClick = ::onBackButtonClick
            )
        )

    private fun getCategories() {
        scope.launch(Dispatchers.Default) {
            exceptionHandleable(
                executionBlock = {
                    val categories = categoryRepository.getCategories()
                    viewState = viewState.copy(
                        categories = categories,
                        categoriesLoadingState = LoadingState.Success
                    )
                },
                failureBlock = {
                    viewState =
                        viewState.copy(categoriesLoadingState = LoadingState.Error(it.message.toString()))
                }
            )
        }
    }

    @Serializable
    private sealed interface Config {

        @Serializable
        data object Home : Config

        @Serializable
        data class Product(val productId: Int) : Config
    }
}