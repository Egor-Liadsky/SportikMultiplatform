package components.home

import data.model.Category
import data.model.Product
import utils.LoadingState

data class HomeState(
    val products: List<Product>? = null,
    val categories: List<Category>? = null,

    val productsLoadingState: LoadingState = LoadingState.Loading,
    val categoriesLoadingState: LoadingState = LoadingState.Loading
)