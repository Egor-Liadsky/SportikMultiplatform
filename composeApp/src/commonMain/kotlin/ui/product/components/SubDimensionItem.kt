package ui.product.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.model.SubDimension
import ui.theme.Color
import ui.theme.Fonts

@Composable
fun SubDimensionItem(
    subDimension: SubDimension,
    selectedSubDimension: SubDimension?,
    selectSubDimension: (SubDimension) -> Unit
) {
    val isSelectedSubDimension = selectedSubDimension == subDimension
    TextButton(
        onClick = { selectSubDimension(subDimension) },
        border = BorderStroke(
            width = 0.5.dp, color =
            if (isSelectedSubDimension) Color.blue else Color.black
        )
    ) {
        Text(
            subDimension.size,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = Fonts.Montserrat.regular(),
                color = if (isSelectedSubDimension) Color.blue else Color.black,
            ),
        )
    }
}