package ui.view.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.theme.Color
import ui.theme.Fonts

@Composable
fun ProductButton(modifier: Modifier = Modifier, title: String, onClick: () -> Unit) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(30.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.blue
        ),
        shape = RoundedCornerShape(0.dp)
    ) {
        Text(
            title,
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = Fonts.Montserrat.bold(),
                color = Color.white
            ),
        )
    }
}