package components.home

import com.arkivanov.decompose.ComponentContext
import components.BaseComponent
import data.repository.category.CategoryRepository
import data.repository.product.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.LoadingState
import utils.exceptionHandleable

class HomeComponentImpl(
    componentContext: ComponentContext,
    private val navigateToProductComponent: (Int) -> Unit
) : BaseComponent<HomeState>(componentContext, HomeState()), HomeComponent, KoinComponent {

    private val productRepository: ProductRepository by inject()

    init {
        getProducts()
    }

    override fun navigateToProduct(productId: Int) {
        navigateToProductComponent(productId)
    }

    private fun getProducts() {
        scope.launch(Dispatchers.Default) {
            exceptionHandleable(
                executionBlock = {
                    val products = productRepository.getProducts()
                    viewState = viewState.copy(
                        products = products,
                        productsLoadingState = LoadingState.Success
                    )
                },
                failureBlock = {
                    viewState =
                        viewState.copy(productsLoadingState = LoadingState.Error(it.message.toString()))
                }
            )
        }
    }
}