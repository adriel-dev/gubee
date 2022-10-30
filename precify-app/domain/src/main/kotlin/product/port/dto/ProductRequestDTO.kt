package product.port.dto

import product.Product
import recipe.Recipe

class ProductRequestDTO(
    val name: String,
    val description: String,
    val profitMargin: Double
) {

    fun toDomainProduct(): Product {
        return Product(
            "",
            this.name,
            this.description,
            this.profitMargin,
            Recipe("", mutableSetOf()),
            0.0,
            0.0
        )
    }

}