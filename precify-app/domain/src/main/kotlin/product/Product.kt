package product

import recipe.Recipe

data class Product(
    val id: String,
    val name: String,
    val description: String,
    val profitMargin: Double,
    val recipe: Recipe,
    var costPrice: Double = 0.0,
    var salePrice: Double = 0.0
) {

    fun calculateCostPrice() {
        var priceSum: Double = 0.0
        recipe.ingredients.stream().forEach() { priceSum += it.price }
        this.costPrice = priceSum
    }

    fun calculateSalePrice() {
        this.salePrice = costPrice + (costPrice * (profitMargin/100));
    }

}
