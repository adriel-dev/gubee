package ingredient.port.dto

import ingredient.Ingredient

class IngredientResponseDTO(
    val id: String,
    val name: String,
    val description: String,
    val price: Double
) {

    fun toDomainIngredient(): Ingredient {
        return Ingredient(
            this.id,
            this.name,
            this.description,
            this.price
        )
    }

}