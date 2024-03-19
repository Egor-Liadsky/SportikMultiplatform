package ui.product

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.onClick
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import components.product.ProductComponent
import data.model.Dimension
import data.model.Image
import data.model.Product
import data.model.SubDimension
import ui.product.components.GalleryItem
import ui.product.components.ProductInfoItem
import utils.platformContext

@Composable
fun ProductScreen(component: ProductComponent) {

    val state by component.viewStates.subscribeAsState()

    Column(
        Modifier.fillMaxSize()
    ) {

        Button(onClick = { component.onBackButtonClicked() }) {
            Text("Back")
        }

        Column(
            Modifier.padding(horizontal = 120.dp)
        ) {
            if (state.product != null) {
                InfoItem(
                    product = state.product!!,
                    selectDimension = { component.selectDimension(it) },
                    selectSubDimension = { component.selectSubDimension(it) },
                    selectedDimension = state.selectedDimension,
                    selectedSubDimension = state.selectSubDimension,
                    selectedImage = state.selectedImage,
                    selectImage = { component.selectImage(it) }
                )
            }
        }
    }
}

@Composable
private fun InfoItem(
    product: Product,
    selectDimension: (Dimension) -> Unit,
    selectSubDimension: (SubDimension) -> Unit,
    selectedDimension: Dimension?,
    selectedSubDimension: SubDimension?,
    selectedImage: Image?,
    selectImage: (Image) -> Unit
) {

    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        GalleryItem(
            images = product.images,
            selectedImage = selectedImage,
            selectImage = { selectImage(it) }
        )

        AsyncImage(
            model = ImageRequest.Builder(platformContext())
                .data(selectedImage?.title)
                .crossfade(true)
                .build(),
            imageLoader = ImageLoader(platformContext()),
            modifier = Modifier
                .size(627.dp, 441.dp),
            contentDescription = null,
            onError = {
                println("TAGTAG  ${it.result.throwable}")
            }
        )

        ProductInfoItem(
            product = product,
            selectDimension = { selectDimension(it) },
            selectSubDimension = { selectSubDimension(it) },
            selectedDimension = selectedDimension,
            selectedSubDimension = selectedSubDimension
        )
    }
}
