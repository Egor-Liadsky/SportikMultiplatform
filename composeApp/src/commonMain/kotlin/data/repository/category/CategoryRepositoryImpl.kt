package data.repository.category

import data.model.Category
import data.repository.BaseRepository
import io.ktor.http.HttpMethod
import kotlinx.serialization.json.Json

class CategoryRepositoryImpl : CategoryRepository, BaseRepository() {

    override suspend fun getCategories(): List<Category> {
        val categories = executeCall(
            type = HttpMethod.Get,
            path = "category"
        )
        return Json.decodeFromString(categories)
    }
}