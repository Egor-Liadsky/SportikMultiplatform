package components.product

import com.arkivanov.decompose.value.Value
import data.model.Dimension
import data.model.Image
import data.model.SubDimension

interface ProductComponent {

    val viewStates: Value<ProductState>

    fun onBackButtonClicked()

    fun selectDimension(dimension: Dimension)

    fun selectSubDimension(subDimension: SubDimension)

    fun selectImage(image: Image)
}