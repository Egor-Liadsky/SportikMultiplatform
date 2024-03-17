package ui.view.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.model.Category
import ui.theme.Color

@Composable
fun CategoryTopBar(modifier: Modifier = Modifier, categories: List<Category>) {

    LazyRow(
        modifier
            .fillMaxWidth()
            .height(72.dp)
            .background(Color.blue),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        item { Spacer(Modifier.padding(start = 8.dp)) }
        items(items = categories) { category ->
            Text(
                category.title,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.white
                ),
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
        item { Spacer(Modifier.padding(start = 8.dp)) }
    }
}