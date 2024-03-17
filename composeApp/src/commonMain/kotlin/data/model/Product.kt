package data.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Int,
    val title: String,
    val brand: String,
    val description: String,
    val color: String,
    val price: String,
    val vendorCode: String,
    val category: Category,
    val dateCreated: String,
    val characteristics: List<Characteristic>,
    val dimensions: List<Dimension>,
    val images: List<Image>,
)

@Serializable
data class Characteristic(
    val id: Int,
    val title: String,
    val productId: Int,
    val subCharacteristic: List<SubCharacteristic>,
)

@Serializable
data class Dimension(
    val id: Int,
    val title: String,
    val productId: Int,
    val subDimensions: List<SubDimension>,
)

@Serializable
data class Image(
    val id: Int,
    val productId: Int,
    val title: String
)

@Serializable
data class SubCharacteristic(
    val id: Int,
    val title: String,
    val description: String,
    val characteristicId: Int
)

@Serializable
data class SubDimension(
    val id: Int,
    val size: String,
    val dimensionId: Int,
)