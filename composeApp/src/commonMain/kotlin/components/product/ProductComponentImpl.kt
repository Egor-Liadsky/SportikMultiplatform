package components.product

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import components.BaseComponent
import data.model.Dimension
import data.model.Image
import data.model.SubDimension
import data.repository.category.CategoryRepository
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
        scope.launch {
            getProduct(productId)
        }
    }

    override fun onBackButtonClicked() {
        onBackButtonClick()
    }

    override fun selectDimension(dimension: Dimension) {
        viewState = viewState.copy(selectedDimension = dimension)
    }

    override fun selectSubDimension(subDimension: SubDimension) {
        viewState = viewState.copy(selectSubDimension = subDimension)
    }

    override fun selectImage(image: Image) {
        viewState = viewState.copy(selectedImage = image)
    }

    private fun getProduct(productId: Int) {
        scope.launch(Dispatchers.Default) {
            exceptionHandleable(
                executionBlock = {
                    val product = productRepository.getProduct(productId)
                    val firstImage = product.images[0]
                    val firstDimension = product.dimensions[0]
                    viewState = viewState.copy(
                        product = product,
                        productLoadingState = LoadingState.Success,
                        selectedImage = firstImage,
                        selectedDimension = firstDimension
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