package ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import components.home.HomeComponent
import data.model.Product
import ui.home.layout.HitsLayout
import ui.home.layout.NewsLayout
import ui.theme.Color
import ui.view.card.ProductItem
import ui.view.footer.FooterBar
import ui.view.layout.LoadingLayout
import ui.view.topbar.CategoryTopBar
import utils.LoadingState

@Composable
fun HomeScreen(component: HomeComponent) {

    val state by component.viewStates.subscribeAsState()

    Column(
        Modifier.fillMaxSize()
    ) {

        CategoryTopBar(categories = state.categories ?: listOf())

        LazyColumn(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            item {
                HitsLayout(
                    Modifier.padding(top = 75.dp).padding(horizontal = 120.dp),
                    products = state.products ?: listOf(),
                    loadingState = state.productsLoadingState,
                    onProductClick = { productId -> component.navigateToProduct(productId) }
                )
            }

            item {
                NewsLayout(
                    Modifier.padding(top = 100.dp).padding(horizontal = 120.dp),
                    products = state.products ?: listOf(),
                    loadingState = state.productsLoadingState,
                    onProductClick = { productId -> component.navigateToProduct(productId) }
                )
            }

            item {
                FooterBar(Modifier.padding(top = 100.dp))
            }
        }
    }
}
