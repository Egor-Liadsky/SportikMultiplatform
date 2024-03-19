package ui.home.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.model.Product
import sportikmultiplatform.composeapp.generated.resources.Res
import sportikmultiplatform.composeapp.generated.resources.montserrat
import ui.theme.Color
import ui.theme.Fonts
import ui.view.card.ProductItem
import ui.view.layout.LoadingLayout
import utils.LoadingState

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HitsLayout(
    modifier: Modifier = Modifier,
    products: List<Product>,
    loadingState: LoadingState,
    onProductClick: (Int) -> Unit
) {
    Column(
        modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            "Хиты продаж",
            style = TextStyle(
                fontSize = 36.sp,
                fontFamily = Fonts.MontserratAlternates.semiBold(),
                color = Color.black
            ),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        when (loadingState) {
            LoadingState.Loading -> {
                LoadingLayout()
            }

            LoadingState.Success -> {
                FlowRow(
                    modifier = Modifier.padding(top = 36.dp),
                    verticalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    Spacer(Modifier.padding(start = 8.dp))
                    products.forEachIndexed { index, product ->
                        if (index <= 4) {
                            ProductItem(
                                Modifier.padding(horizontal = 8.dp),
                                product = product,
                                isHit = true
                            ) {
                                onProductClick(product.id)
                            }
                        }
                    }
                    Spacer(Modifier.padding(start = 8.dp))
                }
            }

            LoadingState.Empty -> TODO()
            is LoadingState.Error -> TODO()
        }
    }
}
