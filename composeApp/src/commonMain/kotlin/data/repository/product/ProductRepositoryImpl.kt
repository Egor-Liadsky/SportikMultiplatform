package data.repository.product

import data.model.Product
import data.repository.BaseRepository
import io.ktor.http.HttpMethod
import kotlinx.serialization.json.Json

class ProductRepositoryImpl : ProductRepository, BaseRepository() {

    override suspend fun getProducts(): List<Product> {
        val products = executeCall(
            type = HttpMethod.Get,
            path = "product"
        )
        return Json.decodeFromString(products)
    }

    override suspend fun getProduct(id: Int): Product {
        val product = executeCall(
            type = HttpMethod.Get,
            path = "product/$id"
        )
        return Json.decodeFromString(product)
    }
}