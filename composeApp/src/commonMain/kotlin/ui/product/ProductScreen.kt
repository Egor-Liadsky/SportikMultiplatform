package ui.product

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import components.product.ProductComponent

@Composable
fun ProductScreen(component: ProductComponent) {

    val state by component.viewStates.subscribeAsState()

    LazyColumn {
        item {
            Button(onClick = { component.onBackButtonClicked() }) {
                Text("Back")
            }
        }
        item {
            Text(state.product.toString())
        }
    }
}