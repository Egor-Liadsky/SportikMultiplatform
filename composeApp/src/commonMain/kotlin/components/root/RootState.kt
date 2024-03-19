package components.root

import data.model.Category
import data.model.Product
import utils.LoadingState

data class RootState(
    val categories: List<Category>? = null,

    val categoriesLoadingState: LoadingState = LoadingState.Loading
)