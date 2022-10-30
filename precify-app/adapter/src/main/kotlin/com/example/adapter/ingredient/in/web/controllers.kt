package com.example.adapter.ingredient.`in`.web

import ingredient.port.dto.IngredientRequestDTO
import ingredient.port.dto.IngredientResponseDTO
import ingredient.port.`in`.usecase.CreateIngredient
import ingredient.port.`in`.usecase.DeleteIngredientById
import ingredient.port.`in`.usecase.FindIngredientById
import ingredient.port.`in`.usecase.UpdateIngredient
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.created
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.*
import java.net.URI

private const val API_PATH = "/api/ingredients"

@RestController
@RequestMapping(API_PATH)
class CreateIngredientController(val useCase: CreateIngredient) {

    @PostMapping
    fun createIngredient(@RequestBody ingredientRequestDTO: IngredientRequestDTO): ResponseEntity<IngredientResponseDTO> {
        return created(URI.create(API_PATH)).body(useCase.createIngredient(ingredientRequestDTO))
    }

}

@RestController
@RequestMapping(API_PATH)
class DeleteIngredientById(val useCase: DeleteIngredientById) {

    @DeleteMapping("/delete/{id}")
    fun deleteIngredientById(@PathVariable id: String): ResponseEntity<Any> {
        useCase.deleteIngredientById(id)
        return ok().build()
    }

}

@RestController
@RequestMapping(API_PATH)
class FindIngredientByIdController(val useCase: FindIngredientById) {

    @GetMapping("/{id}")
    fun findIngredientById(@PathVariable("id") id: String): ResponseEntity<IngredientResponseDTO> {
        return ok().body(useCase.findIngredientById(id))
    }

}

@RestController
@RequestMapping(API_PATH)
class UpdateIngredientController(val useCase: UpdateIngredient) {

    @PutMapping("/update/{id}")
    fun updateIngredient(@PathVariable("id") id: String, @RequestBody ingredientRequestDTO: IngredientRequestDTO): ResponseEntity<IngredientResponseDTO> {
        return ok().body(useCase.updateIngredient(id, ingredientRequestDTO))
    }

}