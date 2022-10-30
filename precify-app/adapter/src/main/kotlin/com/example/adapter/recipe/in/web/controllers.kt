package com.example.adapter.recipe.`in`.web

import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.created
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.*
import recipe.port.dto.RecipeResponseDTO
import recipe.port.`in`.usecase.*
import recipe.port.`in`.usecase.AddIngredientToRecipe
import recipe.port.`in`.usecase.DeleteRecipeById
import java.net.URI

private const val API_PATH = "/api/recipes"

@RestController
@RequestMapping(API_PATH)
class CreateRecipeController(val useCase: CreateRecipe) {

    @PostMapping
    fun createRecipe(): ResponseEntity<RecipeResponseDTO> {
        return created(URI.create(API_PATH)).body(useCase.createRecipe())
    }

}

@RestController
@RequestMapping(API_PATH)
class FindRecipeByIdController(val useCase: FindRecipeById) {

    @GetMapping("/{id}")
    fun findRecipeById(@PathVariable("id") id: String): ResponseEntity<RecipeResponseDTO> {
        return ok().body(useCase.findRecipeById(id))
    }

}

@RestController
@RequestMapping(API_PATH)
class DeleteRecipeById(val useCase: DeleteRecipeById) {

    @DeleteMapping("/delete/{id}")
    fun deleteRecipeById(@PathVariable("id") id: String): ResponseEntity<Any> {
        useCase.deleteRecipeById(id)
        return ok().build()
    }

}

@RestController
@RequestMapping(API_PATH)
class AddIngredientToRecipe(val useCase: AddIngredientToRecipe) {

    @PatchMapping("/{recipeId}/add/{ingredientId}")
    fun addIngredientToRecipe(@PathVariable ingredientId: String, @PathVariable recipeId: String): ResponseEntity<RecipeResponseDTO> {
        return ok().body(useCase.addIngredientToRecipe(recipeId, ingredientId))
    }

}

@RestController
@RequestMapping(API_PATH)
class RemoveIngredientToRecipe(val useCase: RemoveIngredientFromRecipe) {

    @PatchMapping("/{recipeId}/remove/{ingredientId}")
    fun removeIngredientToRecipe(@PathVariable ingredientId: String, @PathVariable recipeId: String): ResponseEntity<RecipeResponseDTO> {
        return ok().body(useCase.removeIngredientFromRecipe(recipeId, ingredientId))
    }

}