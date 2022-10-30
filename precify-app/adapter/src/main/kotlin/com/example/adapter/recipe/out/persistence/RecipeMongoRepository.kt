package com.example.adapter.recipe.out.persistence

import org.springframework.data.mongodb.repository.MongoRepository

interface RecipeMongoRepository : MongoRepository<RecipeModelMongo, String> {
}