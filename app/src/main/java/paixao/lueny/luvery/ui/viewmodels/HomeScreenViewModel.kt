package paixao.lueny.luvery.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import paixao.lueny.luvery.dao.ProductDao
import paixao.lueny.luvery.stateHolders.HomeScreenUiState
import paixao.lueny.luvery.ui.model.Product
import paixao.lueny.luvery.ui.sampledata.*

class HomeScreenViewModel : ViewModel() {

    private val dao = ProductDao()

    var uiState: HomeScreenUiState by mutableStateOf(
        HomeScreenUiState(
            sections = mapOf(
                "Todos produtos" to dao.productsDao(),
                "Promoções" to sampleDrinks + sampleCandies,
                "Salgados" to sampleSavory,
                "Doces" to sampleCandies,
                "Sobremesas" to sampleDesserts,
                "Bebidas" to sampleDrinks
            ),
            onSearchChange = {
                uiState = uiState.copy(
                    searchText = it,
                    searchedProducts = searchedProducts(it)
                )
            }
        )
    )
        private set


    private fun containsInNameOrDescription(text: String) = { product: Product ->
        product.name.contains(
            text,
            ignoreCase = true,
        ) || product.description?.contains(
            text,
            ignoreCase = true,
        ) ?: false
    }

    private fun searchedProducts(text: String): List<Product> =
        if (text.isNotBlank()) {
            sampleProducts.filter(containsInNameOrDescription(text)) +
                    dao.productsDao().filter(containsInNameOrDescription(text))
        } else emptyList()
}

