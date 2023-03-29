package paixao.lueny.luvery.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import paixao.lueny.luvery.stateHolders.HomeScreenUiState
import paixao.lueny.luvery.ui.components.CardProductItem
import paixao.lueny.luvery.ui.components.ProductsSection
import paixao.lueny.luvery.ui.components.SearchTextField
import paixao.lueny.luvery.ui.model.Product
import paixao.lueny.luvery.ui.sampledata.*
import paixao.lueny.luvery.ui.theme.LuveryTheme

@Composable
fun HomeScreen(products: List<Product>) {

    val sections = mapOf(
        "Todos produtos" to products,
        "Promoções" to sampleDrinks + sampleCandies,
        "Salgados" to sampleSavory,
        "Doces" to sampleCandies,
        "Sobremesas" to sampleDesserts,
        "Bebidas" to sampleDrinks
    )
    var text by remember {
        mutableStateOf("")
    }

    fun containsInNameOrDescrioption() = { product: Product ->
        product.name.contains(
            text,
            ignoreCase = true,
        ) || product.description?.contains(
            text,
            ignoreCase = true,
        ) ?: false
    }

    val searchedProducts = remember(text, products) {
        if (text.isNotBlank()) {
            sampleProducts.filter(containsInNameOrDescrioption()) +
                    products.filter(containsInNameOrDescrioption())
        } else emptyList()
    }

    val state = remember(products, text) {
        HomeScreenUiState(
            sections = sections,
            searchedProducts = searchedProducts,
            searchText = text,
            onSearchChange = {
                text = it
            }
        )
    }
    HomeScreen(state = state)
}

@Composable
fun HomeScreen (state: HomeScreenUiState = HomeScreenUiState()) {

    Column {
        val sections  = state.sections
        val text = state.searchText
        val searchedProducts = remember(text) { state.searchedProducts }

        SearchTextField(
            searchText = state.searchText,
            onSearchChange = state.onSearchChange,
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        )

        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            if (state.isShowSections()) {
                for (section in sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductsSection(
                            title = title,
                            products = products
                        )
                    }
                }
            } else {
                items(searchedProducts) { p ->
                    CardProductItem(
                        product = p,
                        Modifier.padding(horizontal = 16.dp)
                    )

                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    LuveryTheme {
        Surface {
            HomeScreen(HomeScreenUiState(sections = sampleSections))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenWithSearchTextPreview() {
    LuveryTheme {
        Surface {
            HomeScreen(
                state = HomeScreenUiState(
                sections = sampleSections,
                searchText = " a"
                )
            )
        }
    }
}
