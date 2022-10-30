package recipe.service

import ingredient.port.out.IngredientRepository
import recipe.port.dto.RecipeRequestDTO
import recipe.port.dto.RecipeResponseDTO
import recipe.port.`in`.usecase.*
import recipe.port.out.RecipeRepository

class RecipeService(private val recipeRepository: RecipeRepository,
                    private val ingredientRepository: IngredientRepository) : FindRecipeById, CreateRecipe, DeleteRecipeById,
                                                                                AddIngredientToRecipe, RemoveIngredientFromRecipe {

    override fun createRecipe(): RecipeResponseDTO {
        return recipeRepository.create()
    }

    override fun deleteRecipeById(id: String) {
        recipeRepository.deleteById(id)
    }

    override fun findRecipeById(id: String): RecipeResponseDTO {
        return recipeRepository.findById(id)
    }

    override fun addIngredientToRecipe(recipeId: String, ingredientId: String): RecipeResponseDTO {
        val foundIngredient = ingredientRepository.findById(ingredientId).toDomainIngredient()
        val recipe = recipeRepository.findById(recipeId).toDomainRecipe()
        recipe.addIngredient(foundIngredient)
        return recipeRepository.update(recipeId, recipe)
    }

    override fun removeIngredientFromRecipe(recipeId: String, ingredientId: String): RecipeResponseDTO {
        val foundIngredient = ingredientRepository.findById(ingredientId).toDomainIngredient()
        val recipe = recipeRepository.findById(recipeId).toDomainRecipe()
        recipe.removeIngredient(foundIngredient)
        return recipeRepository.update(recipeId, recipe)
    }

}