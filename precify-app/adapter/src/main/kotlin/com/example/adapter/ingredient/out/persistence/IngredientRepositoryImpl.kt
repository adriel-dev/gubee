package com.example.adapter.ingredient.out.persistence

import exception.ResourceNotFoundException
import ingredient.port.dto.IngredientRequestDTO
import ingredient.port.dto.IngredientResponseDTO
import ingredient.port.out.IngredientRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class IngredientRepositoryImpl(private val ingredientMongoRepository: IngredientMongoRepository) : IngredientRepository {

    override fun findById(id: String): IngredientResponseDTO {
        val ingredientMongo = ingredientMongoRepository.findById(id).orElseThrow { ResourceNotFoundException() }
        return ingredientMongo.toIngredientResponseDTO()
    }

    override fun save(ingredientRequestDTO: IngredientRequestDTO): IngredientResponseDTO {
        val ingredientMongo = IngredientModelMongo(UUID.randomUUID().toString(), ingredientRequestDTO.name, ingredientRequestDTO.description, ingredientRequestDTO.price)
        return ingredientMongoRepository.save(ingredientMongo).toIngredientResponseDTO()
    }

    override fun update(id: String, ingredientRequestDTO: IngredientRequestDTO): IngredientResponseDTO {
        val ingredientMongo = ingredientMongoRepository.findById(id).orElseThrow { ResourceNotFoundException() }
        ingredientMongo.name = ingredientRequestDTO.name
        ingredientMongo.description = ingredientRequestDTO.description
        ingredientMongo.price = ingredientRequestDTO.price
        return ingredientMongoRepository.save(ingredientMongo).toIngredientResponseDTO()
    }

    override fun deleteById(id: String) {
        ingredientMongoRepository.deleteById(id)
    }

}