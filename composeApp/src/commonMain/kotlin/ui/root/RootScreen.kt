package ui.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import components.root.RootComponent
import ui.home.HomeScreen
import ui.product.ProductScreen

@Composable
fun RootScreen(component: RootComponent, modifier: Modifier = Modifier) {
    Children(
        stack = component.childStack,
        modifier = modifier,
        animation = stackAnimation(fade())
    ) {
        when(val child = it.instance) {
            is RootComponent.Child.HomeChild -> HomeScreen(component = child.component)
            is RootComponent.Child.ProductChild -> ProductScreen(component = child.component)
        }
    }
}