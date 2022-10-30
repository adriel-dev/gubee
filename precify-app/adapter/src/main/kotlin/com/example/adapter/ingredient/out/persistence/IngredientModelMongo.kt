package com.example.adapter.ingredient.out.persistence

import ingredient.Ingredient
import ingredient.port.dto.IngredientRequestDTO
import ingredient.port.dto.IngredientResponseDTO
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "ingredient")
data class IngredientModelMongo(
    @Id val id: String?,
    var name: String,
    var description: String,
    var price: Double
) {
    fun toDomainIngredient(): Ingredient {
        return Ingredient(
            this.id ?: "",
            this.name,
            this.description,
            this.price
        )
    }

    fun toIngredientRequestDTO(): IngredientRequestDTO {
        return IngredientRequestDTO(
            this.name,
            this.description,
            this.price
        )
    }

    fun toIngredientResponseDTO(): IngredientResponseDTO {
        return IngredientResponseDTO(
            this.id ?: "",
            this.name,
            this.description,
            this.price
        )
    }
}