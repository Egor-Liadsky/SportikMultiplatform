package ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import components.home.HomeComponent
import data.model.Product
import ui.theme.Color
import ui.view.card.ProductItem
import ui.view.layout.LoadingLayout
import ui.view.topbar.CategoryTopBar
import utils.LoadingState

@Composable
fun HomeScreen(component: HomeComponent) {

    val state by component.viewStates.subscribeAsState()

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        CategoryTopBar(categories = state.categories ?: listOf())

        HitsItem(
            Modifier.padding(top = 75.dp),
            products = state.products ?: listOf(),
            loadingState = state.productsLoadingState,
            onProductClick = { productId -> component.navigateToProduct(productId) }
        )
    }
}

@Composable
fun HitsItem(
    modifier: Modifier = Modifier,
    products: List<Product>,
    loadingState: LoadingState,
    onProductClick: (Int) -> Unit
) {
    Column(
        modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            "Хиты продаж",
            style = TextStyle(
                fontSize = 36.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.black
            ),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        when (loadingState) {
            LoadingState.Loading -> {
                LoadingLayout()
            }

            LoadingState.Success -> {
                LazyRow(
                    Modifier
                        .fillMaxWidth()
                        .height(380.dp)
                        .padding(top = 36.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    item { Spacer(Modifier.padding(start = 8.dp)) }

                    items(items = products) { product ->
                        ProductItem(Modifier.padding(horizontal = 8.dp), product = product) {
                            onProductClick(product.id)
                        }
                    }

                    item { Spacer(Modifier.padding(end = 8.dp)) }
                }
            }

            LoadingState.Empty -> TODO()
            is LoadingState.Error -> TODO()
        }
    }
}