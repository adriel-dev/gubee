package product.port.out

import java.util.concurrent.CompletableFuture

interface ProductQueryGateway {

    fun sendFindProductQuery(productId: String): CompletableFuture<Any>

}