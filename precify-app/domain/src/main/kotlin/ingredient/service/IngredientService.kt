package ingredient.service

import ingredient.port.dto.IngredientRequestDTO
import ingredient.port.dto.IngredientResponseDTO
import ingredient.port.`in`.usecase.CreateIngredient
import ingredient.port.`in`.usecase.DeleteIngredientById
import ingredient.port.`in`.usecase.FindIngredientById
import ingredient.port.`in`.usecase.UpdateIngredient
import ingredient.port.out.IngredientRepository

class IngredientService(private val ingredientRepository: IngredientRepository) : CreateIngredient, FindIngredientById, DeleteIngredientById, UpdateIngredient {

    override fun findIngredientById(id: String): IngredientResponseDTO {
        return ingredientRepository.findById(id)
    }

    override fun createIngredient(ingredientRequestDTO: IngredientRequestDTO): IngredientResponseDTO {
        return ingredientRepository.save(ingredientRequestDTO)
    }

    override fun updateIngredient(id: String, ingredientRequestDTO: IngredientRequestDTO): IngredientResponseDTO {
        return ingredientRepository.update(id, ingredientRequestDTO)
    }

    override fun deleteIngredientById(id: String) {
        ingredientRepository.deleteById(id)
    }

}