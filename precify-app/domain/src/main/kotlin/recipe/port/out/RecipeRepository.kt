package recipe.port.out

import recipe.Recipe
import recipe.port.dto.RecipeResponseDTO

interface RecipeRepository {

    fun findById(id: String): RecipeResponseDTO
    fun create(): RecipeResponseDTO
    fun update(id: String, recipe: Recipe): RecipeResponseDTO
    fun deleteById(id: String)

}