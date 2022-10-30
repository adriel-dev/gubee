package com.example.adapter.product.`in`.query

import com.example.adapter.ingredient.out.persistence.IngredientModelMongo
import com.example.adapter.product.`in`.event.CostPriceCalculatedEvent
import com.example.adapter.product.`in`.event.ProductCreatedEvent
import com.example.adapter.product.`in`.event.RecipeAttachedEvent
import com.example.adapter.product.`in`.event.SalePriceCalculatedEvent
import com.example.adapter.product.out.persistence.ProductModelMongo
import com.example.adapter.product.out.persistence.ProductMongoRepository
import com.example.adapter.recipe.out.persistence.RecipeModelMongo
import com.example.adapter.recipe.out.persistence.RecipeMongoRepository
import exception.ResourceNotFoundException
import org.axonframework.eventhandling.EventHandler
import org.axonframework.queryhandling.QueryHandler
import org.springframework.stereotype.Component
import product.Product

@Component
class ProductProjection(private val productRepository: ProductMongoRepository, private val recipeRepository: RecipeMongoRepository) {

    @QueryHandler
    fun handle(query: FindProductByIdQuery): ProductModelMongo {
        return productRepository.findById(query.productId).orElseThrow { ResourceNotFoundException() }
    }

    @EventHandler
    fun on(event: ProductCreatedEvent) {
        val recipeMongo = RecipeModelMongo(
            event.recipe.id,
            event.recipe.ingredients.map { IngredientModelMongo(it.id, it.name, it.description, it.price) }.toMutableSet()
        )
        val product = ProductModelMongo(
            event.productId,
            event.name,
            event.description,
            event.profitMargin,
            recipeMongo,
            event.costPrice,
            event.salePrice
        )
        productRepository.save(product)
    }

    @EventHandler
    fun on(event: RecipeAttachedEvent) {
        val foundProduct = productRepository.findById(event.productId).orElseThrow { ResourceNotFoundException() }
        val foundRecipe = recipeRepository.findById(event.recipeId).orElseThrow { ResourceNotFoundException() }
        foundProduct.recipe = foundRecipe
        productRepository.save(foundProduct)
    }

    @EventHandler
    fun on(event: CostPriceCalculatedEvent) {
        val product = productRepository.findById(event.productId).orElseThrow { ResourceNotFoundException() }.toDomainProduct()
        product.calculateCostPrice()
        val productMongo = mapToProductMongo(product)
        productRepository.save(productMongo)
    }

    @EventHandler
    fun on(event: SalePriceCalculatedEvent) {
        val product = productRepository.findById(event.productId).orElseThrow { ResourceNotFoundException() }.toDomainProduct()
        product.calculateSalePrice()
        val productMongo = mapToProductMongo(product)
        productRepository.save(productMongo)
    }

    private fun mapToProductMongo(product: Product): ProductModelMongo {
        val recipeMongo = RecipeModelMongo(
            product.recipe.id,
            product.recipe.ingredients.map { IngredientModelMongo(it.id, it.name, it.description, it.price) }.toMutableSet()
        )
        return ProductModelMongo(
            product.id,
            product.name,
            product.description,
            product.profitMargin,
            recipeMongo,
            product.costPrice,
            product.salePrice
        )
    }

}