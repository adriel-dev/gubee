package com.example.adapter.config

import ingredient.port.out.IngredientRepository
import ingredient.service.IngredientService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import product.port.out.ProductCommandGateway
import product.port.out.ProductQueryGateway
import product.port.service.ProductService
import recipe.port.out.RecipeRepository
import recipe.service.RecipeService

@Configuration
class Config {

    @Bean
    fun ingredientService(ingredientRepository: IngredientRepository) : IngredientService {
        return IngredientService(ingredientRepository)
    }

    @Bean
    fun recipeService(recipeRepository: RecipeRepository, ingredientRepository: IngredientRepository): RecipeService {
        return RecipeService(recipeRepository, ingredientRepository)
    }

    @Bean
    fun productService(productCommandGateway: ProductCommandGateway, productQueryGateway: ProductQueryGateway): ProductService {
        return ProductService(productCommandGateway, productQueryGateway)
    }

}