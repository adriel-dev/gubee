package com.example.adapter.product.out.gateway

import com.example.adapter.product.`in`.query.FindProductByIdQuery
import org.axonframework.queryhandling.QueryGateway
import org.springframework.stereotype.Component
import product.port.out.ProductQueryGateway
import java.util.concurrent.CompletableFuture

@Component
class ProductQueryGatewayImpl(private val queryGateway: QueryGateway): ProductQueryGateway {

    override fun sendFindProductQuery(productId: String): CompletableFuture<Any> {
        val query = FindProductByIdQuery(productId)
        return queryGateway.query(query, Any::class.java)
    }

}