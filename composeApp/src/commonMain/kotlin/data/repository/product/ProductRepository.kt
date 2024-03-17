package data.repository.product

import data.model.Product

interface ProductRepository {

    suspend fun getProducts(): List<Product>

    suspend fun getProduct(id: Int): Product
}