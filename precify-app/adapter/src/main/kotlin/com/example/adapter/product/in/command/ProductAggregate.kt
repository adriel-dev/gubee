package com.example.adapter.product.`in`.command

import com.example.adapter.product.`in`.event.CostPriceCalculatedEvent
import com.example.adapter.product.`in`.event.ProductCreatedEvent
import com.example.adapter.product.`in`.event.RecipeAttachedEvent
import com.example.adapter.product.`in`.event.SalePriceCalculatedEvent
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle.apply
import org.axonframework.spring.stereotype.Aggregate
import recipe.Recipe

@Aggregate
class ProductAggregate {

    @AggregateIdentifier
    lateinit var productId: String
    lateinit var name: String
    lateinit var description: String
    var profitMargin: Double = 0.0
    lateinit var recipe: Recipe
    var costPrice: Double = 0.0
    var salePrice: Double = 0.0

    constructor() {}

    @CommandHandler
    constructor(command: CreateProductCommand) {
        apply(ProductCreatedEvent(
            command.productId,
            command.name,
            command.description,
            command.profitMargin,
            command.recipe,
            command.costPrice,
            command.salePrice
        ))
    }

    @EventSourcingHandler
    fun on(event: ProductCreatedEvent) {
        this.productId = event.productId
        this.name = event.name
        this.description = event.description
        this.profitMargin = event.profitMargin
        this.recipe = Recipe("", mutableSetOf())
        this.costPrice = 0.0
        this.salePrice = 0.0
    }

    @CommandHandler
    fun handle(command: AttachRecipeCommand) {
        apply(RecipeAttachedEvent(command.productId, command.recipeId))
    }

    @EventSourcingHandler
    fun on(event: RecipeAttachedEvent) {

    }

    @CommandHandler
    fun handle(command: CalculateCostPriceCommand) {
        apply(CostPriceCalculatedEvent(command.productId))
    }

    @EventSourcingHandler
    fun on(event: CostPriceCalculatedEvent) {

    }

    @CommandHandler
    fun handle(command: CalculateSalePriceCommand) {
        apply(SalePriceCalculatedEvent(command.productId))
    }

    @EventSourcingHandler
    fun on(event: SalePriceCalculatedEvent) {

    }

}