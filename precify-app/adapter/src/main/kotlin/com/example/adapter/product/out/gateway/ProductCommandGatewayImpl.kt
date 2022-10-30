package com.example.adapter.product.out.gateway

import com.example.adapter.product.`in`.command.AttachRecipeCommand
import com.example.adapter.product.`in`.command.CalculateCostPriceCommand
import com.example.adapter.product.`in`.command.CalculateSalePriceCommand
import com.example.adapter.product.`in`.command.CreateProductCommand
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.stereotype.Component
import product.port.dto.ProductRequestDTO
import product.port.out.ProductCommandGateway
import recipe.Recipe
import java.util.*
import java.util.concurrent.CompletableFuture

@Component
class ProductCommandGatewayImpl(private val commandGateway: CommandGateway) : ProductCommandGateway {

    override fun sendCreateProductCommand(productRequestDTO: ProductRequestDTO): CompletableFuture<Any> {
        return commandGateway.send(CreateProductCommand(
            UUID.randomUUID().toString(),
            productRequestDTO.name,
            productRequestDTO.description,
            productRequestDTO.profitMargin,
            Recipe("", mutableSetOf()),
            0.0,
            0.0
        ))
    }

    override fun sendAttachRecipeCommand(productId: String, recipeId: String): CompletableFuture<Any> {
        return commandGateway.send(AttachRecipeCommand(productId, recipeId))
    }

    override fun sendCalculateCostPriceCommand(productId: String): CompletableFuture<Any> {
        return commandGateway.send(CalculateCostPriceCommand(productId))
    }

    override fun sendCalculateSalePriceCommand(productId: String): CompletableFuture<Any> {
        return commandGateway.send(CalculateSalePriceCommand(productId))
    }

}