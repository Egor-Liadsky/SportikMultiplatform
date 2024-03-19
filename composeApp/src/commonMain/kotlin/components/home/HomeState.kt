package components.home

import data.model.Category
import data.model.Product
import utils.LoadingState

data class HomeState(
    val products: List<Product>? = null,

    val productsLoadingState: LoadingState = LoadingState.Loading,
)