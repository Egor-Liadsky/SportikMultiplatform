package ui.view.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.ImageLoader
import coil3.request.ImageRequest
import coil3.request.crossfade
import data.model.Product
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import sportikmultiplatform.composeapp.generated.resources.Res
import sportikmultiplatform.composeapp.generated.resources.icon
import ui.theme.Color
import ui.theme.Fonts
import ui.view.button.ProductButton
import utils.platformContext
import coil3.compose.AsyncImage

@OptIn(ExperimentalMaterialApi::class, ExperimentalResourceApi::class)
@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    product: Product,
    isHit: Boolean = false,
    onClick: () -> Unit
) {

    Card(
        modifier = modifier.size(220.dp, 380.dp),
        onClick = { onClick() },
        elevation = 3.dp,
    ) {
        Column(Modifier.padding(16.dp)) {

            AsyncImage(
                model = ImageRequest.Builder(platformContext())
                    .data(product.images[0].title)
                    .crossfade(true)
                    .build(),
                imageLoader = ImageLoader(platformContext()),
                modifier = Modifier
                    .height(193.dp)
                    .fillMaxWidth(),
                contentDescription = null,
                onError = {
                    println("TAGTAG  ${it.result.throwable}")
                }
            )

            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "${product.price} ₽",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = Fonts.Montserrat.semiBold(),
                        fontWeight = FontWeight.Bold,
                        color = Color.black
                    ),
                    modifier = Modifier.padding(top = 19.dp)
                )

                if (isHit) {
                    Box(
                        modifier = Modifier
                            .size(48.dp, 14.dp)
                            .background(color = Color.red, RectangleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Хит",
                            style = TextStyle(
                                fontSize = 8.sp,
                                fontFamily = Fonts.Montserrat.bold(),
                                color = Color.white,
                                textAlign = TextAlign.Center
                            ),
                        )
                    }
                }
            }

            Text(
                product.title,
                style = TextStyle(
                    fontSize = 10.sp,
                    fontFamily = Fonts.Montserrat.semiBold(),
                    fontWeight = FontWeight.SemiBold,
                    color = Color.black
                ),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(Modifier.weight(1f))

            ProductButton(
                title = "В КОРЗИНУ",
            ) {

            }
        }
    }
}