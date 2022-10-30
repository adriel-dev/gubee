package ingredient.port.`in`.usecase

import ingredient.port.dto.IngredientRequestDTO
import ingredient.port.dto.IngredientResponseDTO

interface CreateIngredient {
    fun createIngredient(ingredientRequestDTO: IngredientRequestDTO): IngredientResponseDTO
}

interface DeleteIngredientById {
    fun deleteIngredientById(id: String)
}

interface FindIngredientById {
    fun findIngredientById(id: String): IngredientResponseDTO
}

interface UpdateIngredient {
    fun updateIngredient(id: String, ingredientRequestDTO: IngredientRequestDTO): IngredientResponseDTO
}