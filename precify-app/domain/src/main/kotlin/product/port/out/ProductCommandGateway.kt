package product.port.out

import product.port.dto.ProductRequestDTO
import java.util.concurrent.CompletableFuture

interface ProductCommandGateway {

    fun sendCreateProductCommand(productRequestDTO: ProductRequestDTO): CompletableFuture<Any>
    fun sendAttachRecipeCommand(productId: String, recipeId: String): CompletableFuture<Any>
    fun sendCalculateCostPriceCommand(productId: String): CompletableFuture<Any>
    fun sendCalculateSalePriceCommand(productId: String): CompletableFuture<Any>


}