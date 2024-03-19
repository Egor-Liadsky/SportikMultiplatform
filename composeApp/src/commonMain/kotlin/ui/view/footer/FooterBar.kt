package ui.view.footer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.theme.Color
import ui.view.text.CommonText

@Composable
fun FooterBar(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(65.dp)
            .background(Color.blue)
    ) {
        Row(
            Modifier.fillMaxWidth(0.8f).align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CommonText(text = "© Спортик 2024. Все права защищены.")

            Row {
                CommonText(text = "Политика  конфиденциальности")
                CommonText(text = "О нас", modifier = Modifier.padding(start = 33.dp))
                CommonText(text = "Контакты", modifier = Modifier.padding(start = 33.dp))
            }
        }
    }
}