package ui.product.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextButton
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DimensionItem(
    product: Product,
    selectDimension: (Dimension) -> Unit,
    selectSubDimension: (SubDimension) -> Unit,
    selectedDimension: Dimension?,
    selectedSubDimension: SubDimension?
) {
    Row(
        Modifier.padding(top = 28.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            "Выберите размер:",
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = Fonts.Montserrat.regular(),
                color = Color.gray_light,
            ),
        )

        FlowRow(
            Modifier.padding(start = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(18.dp),
        ) {
            product.dimensions.forEach { dimension ->
                TextButton(onClick = { selectDimension(dimension) }) {
                    Text(
                        dimension.title,
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = Fonts.Montserrat.regular(),
                            color = if (selectedDimension == dimension) Color.blue else Color.black,
                        ),
                    )
                }
            }
        }
    }

    FlowRow(
        Modifier.padding(top = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(11.dp),
    ) {
        product.dimensions.forEach { dimension ->
            if (selectedDimension == dimension) {
                dimension.subDimensions.forEach { subDimension ->
                    SubDimensionItem(
                        subDimension = subDimension,
                        selectedSubDimension = selectedSubDimension,
                    ) {
                        selectSubDimension(it)
                    }
                }
            }
        }
    }
}