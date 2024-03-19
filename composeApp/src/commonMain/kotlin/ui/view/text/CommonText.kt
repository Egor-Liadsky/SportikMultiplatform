package ui.view.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import ui.theme.Fonts

@Composable
fun CommonText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 16.sp,
    fontFamily: FontFamily = Fonts.Montserrat.medium(),
    color: Color = ui.theme.Color.white
) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = fontSize,
            fontFamily = fontFamily,
            color = color
        ),
        modifier = modifier
    )
}