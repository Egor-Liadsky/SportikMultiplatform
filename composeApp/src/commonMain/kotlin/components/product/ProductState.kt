package components.product

import data.model.Product
import utils.LoadingState

data class ProductState(
    val product: Product? = null,
    val productLoadingState: LoadingState = LoadingState.Loading
)