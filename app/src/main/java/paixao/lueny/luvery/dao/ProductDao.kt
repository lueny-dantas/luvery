package paixao.lueny.luvery.dao

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import paixao.lueny.luvery.ui.model.Product

class ProductDao {

    companion object {
        private val products = MutableStateFlow<List<Product>>(emptyList())
    }

    fun productsDao():StateFlow<List<Product>> = products.asStateFlow()

    fun save(product: Product) {
        products.value = products.value + product
    }
}