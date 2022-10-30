package com.example.adapter.product.out.persistence

import com.example.adapter.recipe.out.persistence.RecipeModelMongo
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import product.Product
import recipe.Recipe

@Document(collection = "product")
data class ProductModelMongo(
    @Id val id: String?,
    val name: String,
    val description: String,
    val profitMargin: Double,
    @DBRef var recipe: RecipeModelMongo?,
    var costPrice: Double = 0.0,
    var salePrice: Double = 0.0
) {

    fun toDomainProduct(): Product {
        return Product(
            this.id ?: "",
            this.name,
            this.description,
            this.profitMargin,
            this.recipe?.toDomainRecipe() ?: Recipe("", mutableSetOf()),
            this.costPrice,
            this.salePrice
        )
    }

}