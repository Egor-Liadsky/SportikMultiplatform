package ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import components.home.HomeComponent
import ui.home.layout.HitsLayout
import ui.home.layout.NewsLayout

@Composable
fun HomeScreen(component: HomeComponent) {

    val state by component.viewStates.subscribeAsState()

    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        HitsLayout(
            Modifier.padding(top = 75.dp).padding(horizontal = 120.dp),
            products = state.products ?: listOf(),
            loadingState = state.productsLoadingState,
            onProductClick = { productId -> component.navigateToProduct(productId) }
        )

        NewsLayout(
            Modifier.padding(top = 100.dp).padding(horizontal = 120.dp),
            products = state.products ?: listOf(),
            loadingState = state.productsLoadingState,
            onProductClick = { productId -> component.navigateToProduct(productId) }
        )
    }
}
