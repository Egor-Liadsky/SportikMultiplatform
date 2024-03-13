package ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.home.HomeComponent
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(component: HomeComponent) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        
        val list = List(100) { it }
        
        Text("Profile Screen")
        
        LazyColumn {
            items(items = list) {
                InfoCard(Modifier.padding(32.dp), it.toString())
            }
        }
    }
}

@Composable
fun InfoCard(modifier: Modifier = Modifier, number: String) {
    Card(
        modifier.fillMaxWidth(),
        elevation = 24.dp
    ) {
        Text(number, modifier = Modifier.padding(top = 16.dp))
    }
}