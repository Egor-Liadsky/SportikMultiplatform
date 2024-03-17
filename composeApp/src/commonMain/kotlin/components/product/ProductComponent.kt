package components.product

import com.arkivanov.decompose.value.Value

interface ProductComponent {

    val viewStates: Value<ProductState>

    fun onBackButtonClicked()
}