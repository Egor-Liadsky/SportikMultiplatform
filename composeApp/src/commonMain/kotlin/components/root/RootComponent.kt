package components.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import components.home.HomeComponent
import components.product.ProductComponent

interface RootComponent {

    val childStack: Value<ChildStack<*, Child>>

    val viewStates: Value<RootState>

    fun onBackButtonClick()

    sealed class Child {
        data class HomeChild(val component: HomeComponent): Child()
        data class ProductChild(val component: ProductComponent): Child()
    }
}