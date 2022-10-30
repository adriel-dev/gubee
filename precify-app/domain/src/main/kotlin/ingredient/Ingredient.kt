package ingredient

import ingredient.port.dto.IngredientRequestDTO
import ingredient.port.dto.IngredientResponseDTO

data class Ingredient(
    val id: String,
    val name: String,
    val description: String,
    val price: Double
) {
    fun toIngredientRequestDTO(): IngredientRequestDTO {
        return IngredientRequestDTO(
            this.name,
            this.description,
            this.price
        )
    }

    fun toIngredientResponseDTO(): IngredientResponseDTO {
        return IngredientResponseDTO(
            this.id,
            this.name,
            this.description,
            this.price
        )
    }

}