package recipe.port.dto

import ingredient.port.dto.IngredientRequestDTO
import ingredient.port.dto.IngredientResponseDTO
import recipe.Recipe

class RecipeResponseDTO(val id: String, val ingredients: MutableSet<IngredientResponseDTO> = mutableSetOf()) {

    fun toDomainRecipe(): Recipe {
        val ingredientsDomainSet = this.ingredients.map { it.toDomainIngredient() }.toMutableSet()
        return Recipe(this.id, ingredientsDomainSet)
    }

}