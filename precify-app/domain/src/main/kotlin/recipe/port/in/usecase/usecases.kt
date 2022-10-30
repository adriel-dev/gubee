package recipe.port.`in`.usecase

import recipe.port.dto.RecipeRequestDTO
import recipe.port.dto.RecipeResponseDTO

interface CreateRecipe {
    fun createRecipe(): RecipeResponseDTO
}

interface FindRecipeById {
    fun findRecipeById(id: String): RecipeResponseDTO
}

interface UpdateRecipe {
    fun updateRecipe(id: String, recipeDTO: RecipeRequestDTO): RecipeResponseDTO
}

interface DeleteRecipeById {
    fun deleteRecipeById(id: String)
}

interface AddIngredientToRecipe {
    fun addIngredientToRecipe(recipeId: String, ingredientId: String) : RecipeResponseDTO
}

interface RemoveIngredientFromRecipe {
    fun removeIngredientFromRecipe(recipeId: String, ingredientId: String) : RecipeResponseDTO
}