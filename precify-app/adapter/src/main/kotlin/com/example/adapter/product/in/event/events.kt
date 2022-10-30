package com.example.adapter.product.`in`.event

import recipe.Recipe

class ProductCreatedEvent(
    val productId: String,
    val name: String,
    val description: String,
    val profitMargin: Double,
    val recipe: Recipe,
    val costPrice: Double,
    val salePrice: Double
)

class RecipeAttachedEvent(
    val productId: String,
    val recipeId: String
)

class CostPriceCalculatedEvent(
    val productId: String
)

class SalePriceCalculatedEvent(
    val productId: String
)