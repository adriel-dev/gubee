package product.port.service

import product.port.dto.ProductRequestDTO
import product.port.`in`.usecase.*
import product.port.out.ProductCommandGateway
import product.port.out.ProductQueryGateway
import java.util.concurrent.CompletableFuture

class ProductService(
    private val commandGateway: ProductCommandGateway,
    private val queryGateway: ProductQueryGateway
) : CreateProduct, AttacheRecipeToProduct, FindProductById, CalculateCostPrice, CalculateSalePrice {

    override fun createProduct(productRequestDTO: ProductRequestDTO): CompletableFuture<Any> {
        return commandGateway.sendCreateProductCommand(productRequestDTO)
    }

    override fun attachRecipeToProduct(productId: String, recipeId: String): CompletableFuture<Any> {
        return commandGateway.sendAttachRecipeCommand(productId, recipeId)
    }

    override fun findProductById(productId: String): CompletableFuture<Any> {
        return queryGateway.sendFindProductQuery(productId)
    }

    override fun calculateCostPrice(productId: String): CompletableFuture<Any> {
        return commandGateway.sendCalculateCostPriceCommand(productId)
    }

    override fun calculateSalePrice(productId: String): CompletableFuture<Any> {
        return commandGateway.sendCalculateSalePriceCommand(productId)
    }

}