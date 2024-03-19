package ui.product.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.onClick
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import data.model.Image
import utils.platformContext

@OptIn(ExperimentalLayoutApi::class, ExperimentalFoundationApi::class)
@Composable
fun GalleryItem(
    images: List<Image>,
    selectedImage: Image?,
    selectImage: (Image) -> Unit
) {
    FlowColumn(
        Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        images.forEach { image ->
            val isSelectedImage = selectedImage == image
            AsyncImage(
                model = ImageRequest.Builder(platformContext())
                    .data(image.title)
                    .crossfade(true)
                    .build(),
                imageLoader = ImageLoader(platformContext()),
                modifier = Modifier
                    .size(100.dp, 133.dp)
                    .onClick { selectImage(image) },
                contentDescription = null,
                onError = {
                    println("TAGTAG  ${it.result.throwable}")
                },
                alpha = if (isSelectedImage) 1f else 0.5f
            )
        }
    }
}
