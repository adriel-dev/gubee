package com.example.adapter.product.out.persistence

import org.springframework.data.mongodb.repository.MongoRepository

interface ProductMongoRepository : MongoRepository<ProductModelMongo, String> {
}