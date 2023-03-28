package paixao.lueny.luvery.dao

import androidx.compose.runtime.mutableStateListOf
import paixao.lueny.luvery.ui.model.Product
import paixao.lueny.luvery.ui.sampledata.sampleProducts

class ProductDao {

    companion object{
        private val products = mutableStateListOf<Product>()
    }

    fun productsDao() = products.toList()

    fun save( product: Product){
        products.add(product)
    }
}