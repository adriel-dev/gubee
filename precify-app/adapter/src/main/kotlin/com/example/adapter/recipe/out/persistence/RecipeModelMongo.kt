package com.example.adapter.recipe.out.persistence

import com.example.adapter.ingredient.out.persistence.IngredientModelMongo
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import recipe.Recipe
import recipe.port.dto.RecipeRequestDTO
import recipe.port.dto.RecipeResponseDTO

@Document(collection = "recipe")
data class RecipeModelMongo(
    @Id val id: String?,
    @DBRef var ingredients: MutableSet<IngredientModelMongo> = mutableSetOf()
) {
    fun toRecipeRequestDTO(): RecipeRequestDTO {
        val ingredientRequestDtoSet = this.ingredients.map { it.toIngredientRequestDTO() }.toMutableSet()
        return RecipeRequestDTO(ingredientRequestDtoSet)
    }

    fun toRecipeResponseDTO(): RecipeResponseDTO {
        val ingredientResponseDtoSet = this.ingredients.map { it.toIngredientResponseDTO() }.toMutableSet()
        return RecipeResponseDTO(
            this.id ?: "",
            ingredientResponseDtoSet
        )
    }

    fun toDomainRecipe(): Recipe {
        return Recipe(
            this.id ?: "",
            this.ingredients.map { it.toDomainIngredient() }.toMutableSet()
        )
    }

}