package com.example.adapter.product.`in`.command

import org.axonframework.modelling.command.TargetAggregateIdentifier
import recipe.Recipe

data class CreateProductCommand(
    @TargetAggregateIdentifier
    val productId: String,
    val name: String,
    val description: String,
    val profitMargin: Double,
    val recipe: Recipe,
    val costPrice: Double,
    val salePrice: Double
)

data class AttachRecipeCommand(
    @TargetAggregateIdentifier val productId: String,
    val recipeId: String
)

data class CalculateCostPriceCommand(
    @TargetAggregateIdentifier
    val productId: String
)

data class CalculateSalePriceCommand(
    @TargetAggregateIdentifier
    val productId: String
)