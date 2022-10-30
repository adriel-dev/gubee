package com.example.adapter.ingredient.out.persistence

import org.springframework.data.mongodb.repository.MongoRepository

interface IngredientMongoRepository : MongoRepository<IngredientModelMongo, String> {
}