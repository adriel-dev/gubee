package recipe

import exception.ResourceAlreadyPresentException
import exception.ResourceNotFoundException
import ingredient.Ingredient
import recipe.port.dto.RecipeRequestDTO
import recipe.port.dto.RecipeResponseDTO

data class Recipe(val id: String, val ingredients: MutableSet<Ingredient> = mutableSetOf()) {

    fun addIngredient(ingredient: Ingredient) {
        val wasAdded = this.ingredients.add(ingredient)
        if(!wasAdded) throw ResourceAlreadyPresentException()
    }

    fun removeIngredient(ingredient: Ingredient) {
        val wasRemoved = this.ingredients.remove(ingredient)
        if(!wasRemoved) throw ResourceNotFoundException()
    }

    fun toRecipeRequestDTO(): RecipeRequestDTO {
        val ingredientsRequestDtoSet = this.ingredients.map { it.toIngredientRequestDTO() }.toMutableSet()
        return RecipeRequestDTO(ingredientsRequestDtoSet)
    }

    fun toRecipeResponseDTO(): RecipeResponseDTO {
        val ingredientsResponseDtoSet = this.ingredients.map { it.toIngredientResponseDTO() }.toMutableSet()
        return RecipeResponseDTO(this.id, ingredientsResponseDtoSet)
    }

}