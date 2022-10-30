package product.port.dto

import product.Product
import recipe.Recipe

class ProductResponseDTO(
    val id: String,
    val name: String,
    val description: String,
    val profitMargin: Double,
    val recipe: Recipe,
    var costPrice: Double = 0.0,
    var salePrice: Double = 0.0
) {

    fun toDomainProduct(): Product {
        return Product(
            this.id,
            this.name,
            this.description,
            this.profitMargin,
            this.recipe,
            this.costPrice,
            this.salePrice
        )
    }

}