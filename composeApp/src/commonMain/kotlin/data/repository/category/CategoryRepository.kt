package data.repository.category

import data.model.Category

interface CategoryRepository {

    suspend fun getCategories(): List<Category>
}