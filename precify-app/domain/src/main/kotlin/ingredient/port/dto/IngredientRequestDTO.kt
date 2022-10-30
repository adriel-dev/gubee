package ingredient.port.dto

import ingredient.Ingredient

class IngredientRequestDTO(
    val name: String,
    val description: String,
    val price: Double
) {
    fun toDomainIngredient(): Ingredient {
        return Ingredient(
            "",
            this.name,
            this.description,
            this.price
        )
    }
}