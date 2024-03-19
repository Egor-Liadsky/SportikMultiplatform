package components.product

import data.model.Dimension
import data.model.Image
import data.model.Product
import data.model.SubDimension
import utils.LoadingState

data class ProductState(
    val product: Product? = null,

    val selectedDimension: Dimension? = null,
    val selectSubDimension: SubDimension? = null,

    val selectedImage: Image? = null,

    val productLoadingState: LoadingState = LoadingState.Loading,
)