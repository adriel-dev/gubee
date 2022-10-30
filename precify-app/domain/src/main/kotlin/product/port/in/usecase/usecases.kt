package product.port.`in`.usecase

import product.port.dto.ProductRequestDTO
import java.util.concurrent.CompletableFuture

interface FindProductById {
    fun findProductById(productId: String): CompletableFuture<Any>
}

interface CreateProduct {
    fun createProduct(productRequestDTO: ProductRequestDTO): CompletableFuture<Any>
}

interface AttacheRecipeToProduct {
    fun attachRecipeToProduct(productId: String, recipeId: String): CompletableFuture<Any>
}

interface CalculateCostPrice {
    fun calculateCostPrice(productId: String): CompletableFuture<Any>
}

interface CalculateSalePrice {
    fun calculateSalePrice(productId: String): CompletableFuture<Any>
}