package components.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import components.home.HomeComponentImpl
import components.product.ProductComponentImpl
import kotlinx.serialization.Serializable

class RootComponentImpl(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

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

    @Serializable
    private sealed interface Config {

        @Serializable
        data object Home : Config

        @Serializable
        data class Product(val productId: Int) : Config
    }
}