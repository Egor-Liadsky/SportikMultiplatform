package ui.product.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.model.Dimension
import data.model.Product
import data.model.SubDimension
import ui.theme.Color
import ui.theme.Fonts

@Composable
fun ProductInfoItem(
    modifier: Modifier = Modifier,
    product: Product,
    selectDimension: (Dimension) -> Unit,
    selectSubDimension: (SubDimension) -> Unit,
    selectedDimension: Dimension?,
    selectedSubDimension: SubDimension?
) {
    Column(modifier) {
        Text(
            product.brand,
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = Fonts.Montserrat.semiBold(),
                color = Color.black,
            )
        )

        Text(
            product.title,
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = Fonts.Montserrat.semiBold(),
                color = Color.black,
            ),
            modifier = Modifier.padding(top = 24.dp)
        )

        Text(
            "Артикул: ${product.vendorCode}",
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = Fonts.Montserrat.regular(),
                color = Color.gray_light,
            ),
            modifier = Modifier.padding(top = 23.dp)
        )

        Text(
            "${product.price} ₽",
            style = TextStyle(
                fontSize = 48.sp,
                fontFamily = Fonts.MontserratAlternates.semiBold(),
                color = Color.black,
            ),
            modifier = Modifier.padding(top = 36.dp)
        )

        Row(
            Modifier.padding(top = 36.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Цвет:",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = Fonts.Montserrat.regular(),
                    color = Color.gray_light,
                )
            )
            Text(
                product.color,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = Fonts.Montserrat.regular(),
                    color = Color.black,
                ),
                modifier = Modifier.padding(start = 24.dp)
            )
        }

        DimensionItem(
            product = product,
            selectDimension = { selectDimension(it) },
            selectSubDimension = { selectSubDimension(it) },
            selectedDimension = selectedDimension,
            selectedSubDimension = selectedSubDimension
        )

        Button(
            modifier = Modifier
                .width(360.dp)
                .padding(top = 45.dp),
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.blue
            ),
        ) {
            Text(
                "Добавить в корзину",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = Fonts.Montserrat.semiBold(),
                    color = Color.white
                ),
            )
        }
    }
}