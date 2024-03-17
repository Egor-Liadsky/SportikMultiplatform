package components.product

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import components.BaseComponent
import data.repository.product.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.LoadingState
import utils.exceptionHandleable

class ProductComponentImpl(
    componentContext: ComponentContext,
    productId: Int,
    val onBackButtonClick: () -> Unit
) : BaseComponent<ProductState>(componentContext, ProductState()), ProductComponent, KoinComponent {

    private val productRepository: ProductRepository by inject()

    init {
        getProduct(productId)
    }

    override fun onBackButtonClicked() {
        onBackButtonClick()
    }

    private fun getProduct(productId: Int) {
        scope.launch(Dispatchers.Default) {
            exceptionHandleable(
                executionBlock = {
                    val product = productRepository.getProduct(productId)
                    viewState = viewState.copy(
                        product = product,
                        productLoadingState = LoadingState.Success
                    )
                },
                failureBlock = {
                    viewState = viewState.copy(
                        productLoadingState = LoadingState.Error(it.message.toString())
                    )
                }
            )
        }
    }
}