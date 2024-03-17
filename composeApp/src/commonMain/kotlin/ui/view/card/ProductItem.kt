package ui.view.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.model.Product
import ui.theme.Color
import ui.view.button.ProductButton

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductItem(modifier: Modifier = Modifier, product: Product, onClick: () -> Unit) {

    Card(
        modifier = modifier.width(220.dp).fillMaxHeight(),
        onClick = { onClick() },
        elevation = 4.dp,
        shape = RoundedCornerShape(0.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(193.dp)
                    .background(Color.gray)
            )

            Text(
                "${product.price} ₽",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.black
                ),
                modifier = Modifier.padding(top = 19.dp)
            )

            Text(
                product.title,
                style = TextStyle(
                    fontSize = 10.sp,
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