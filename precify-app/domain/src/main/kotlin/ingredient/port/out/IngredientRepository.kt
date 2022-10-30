package ingredient.port.out

import ingredient.port.dto.IngredientRequestDTO
import ingredient.port.dto.IngredientResponseDTO

interface IngredientRepository {

    fun findById(id: String): IngredientResponseDTO
    fun save(ingredientRequestDTO: IngredientRequestDTO): IngredientResponseDTO
    fun update(id: String, ingredientRequestDTO: IngredientRequestDTO): IngredientResponseDTO
    fun deleteById(id: String)

}