package recipe.port.dto

import ingredient.port.dto.IngredientRequestDTO

class RecipeRequestDTO(val ingredients: MutableSet<IngredientRequestDTO> = mutableSetOf())