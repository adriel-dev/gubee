package com.example.adapter.product.`in`.web


import org.springframework.web.bind.annotation.*
import product.port.dto.ProductRequestDTO
import product.port.`in`.usecase.*
import product.port.`in`.usecase.FindProductById
import java.util.*
import java.util.concurrent.CompletableFuture

private const val API_PATH = "/api/products"

@RestController
@RequestMapping(API_PATH)
class CreateProductController(private val useCase: CreateProduct) {

    @PostMapping
    fun createProduct(@RequestBody productRequestDTO: ProductRequestDTO): CompletableFuture<Any> {
        return useCase.createProduct(productRequestDTO)
    }

}

@RestController
@RequestMapping(API_PATH)
class AttachRecipeToProduct(private val useCase: AttacheRecipeToProduct) {

    @PostMapping("/{productId}/recipe/{recipeId}")
    fun attachRecipeToProduct(@PathVariable productId: String, @PathVariable recipeId: String): CompletableFuture<Any> {
        return useCase.attachRecipeToProduct(productId, recipeId)
    }

}

@RestController
@RequestMapping(API_PATH)
class FindProductById(private val useCase: FindProductById) {

    @GetMapping("/{productId}")
    fun findProductById(@PathVariable productId: String): CompletableFuture<Any> {
        return useCase.findProductById(productId)
    }

}

@RestController
@RequestMapping(API_PATH)
class CalculateProductCostPrice(private val useCase: CalculateCostPrice) {

    @PostMapping("/calc/cost/{productId}")
    fun calculateCostPrice(@PathVariable productId: String): CompletableFuture<Any> {
        return useCase.calculateCostPrice(productId)
    }

}

@RestController
@RequestMapping(API_PATH)
class CalculateProductSalePrice(private val useCase: CalculateSalePrice) {

    @PostMapping("/calc/sale/{productId}")
    fun calculateSalePrice(@PathVariable productId: String): CompletableFuture<Any> {
        return useCase.calculateSalePrice(productId)
    }

}