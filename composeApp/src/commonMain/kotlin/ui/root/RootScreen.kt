package ui.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import components.root.RootComponent
import ui.home.HomeScreen
import ui.product.ProductScreen
import ui.view.footer.FooterBar
import ui.view.topbar.CategoryTopBar

@Composable
fun RootScreen(component: RootComponent, modifier: Modifier = Modifier) {
    val state by component.viewStates.subscribeAsState()

    Column(
        Modifier.fillMaxSize()
    ) {
        CategoryTopBar(categories = state.categories ?: listOf())

        LazyColumn(Modifier.fillMaxWidth()) {
            item {
                Children(
                    stack = component.childStack,
                    modifier = modifier,
                    animation = stackAnimation(fade())
                ) {
                    when (val child = it.instance) {
                        is RootComponent.Child.HomeChild -> HomeScreen(component = child.component)
                        is RootComponent.Child.ProductChild -> ProductScreen(component = child.component)
                    }
                }
            }
            item {
                Spacer(Modifier.weight(1f))
                FooterBar(Modifier.padding(top = 100.dp))
            }
        }

    }
}