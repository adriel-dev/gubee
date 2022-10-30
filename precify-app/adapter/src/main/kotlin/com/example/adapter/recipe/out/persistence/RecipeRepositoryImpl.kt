package com.example.adapter.recipe.out.persistence

import com.example.adapter.ingredient.out.persistence.IngredientModelMongo
import exception.ResourceNotFoundException
import org.springframework.stereotype.Repository
import recipe.Recipe
import recipe.port.dto.RecipeRequestDTO
import recipe.port.dto.RecipeResponseDTO
import recipe.port.out.RecipeRepository
import java.util.*

@Repository
class RecipeRepositoryImpl(val recipeMongoRepository: RecipeMongoRepository) : RecipeRepository {

    override fun findById(id: String): RecipeResponseDTO {
        val recipeMongo = recipeMongoRepository.findById(id).orElseThrow { ResourceNotFoundException() }
        return recipeMongo.toRecipeResponseDTO()
    }

    override fun create(): RecipeResponseDTO {
        val recipeMongo = RecipeModelMongo(UUID.randomUUID().toString())
        return recipeMongoRepository.save(recipeMongo).toRecipeResponseDTO()
    }

    override fun update(id: String, recipe: Recipe): RecipeResponseDTO {
        val mongoRecipe = recipeMongoRepository.findById(id).orElseThrow { ResourceNotFoundException() }
        val mongoIngredientSet = recipe.ingredients.map { IngredientModelMongo( it.id, it.name, it.description, it.price ) }.toMutableSet()
        mongoRecipe.ingredients = mongoIngredientSet
        return recipeMongoRepository.save(mongoRecipe).toRecipeResponseDTO()
    }

    override fun deleteById(id: String) {
        recipeMongoRepository.deleteById(id)
    }

}