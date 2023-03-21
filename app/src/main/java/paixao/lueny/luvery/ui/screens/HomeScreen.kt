package paixao.lueny.luvery.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import paixao.lueny.luvery.ui.components.CardProductItem
import paixao.lueny.luvery.ui.components.ProductsSection
import paixao.lueny.luvery.ui.components.SearchTextField
import paixao.lueny.luvery.ui.model.Product
import paixao.lueny.luvery.ui.sampledata.sampleProducts
import paixao.lueny.luvery.ui.sampledata.sampleSections
import paixao.lueny.luvery.ui.theme.LuveryTheme

@Composable
fun HomeScreen(sections: Map<String, List<Product>>, searchText: String = "") {

    Column {

        var text by remember { mutableStateOf(searchText) }
        SearchTextField(
            searchText = text,
            onSearchChange = {
                text = it
            },
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        )

        val searchedProducts = remember(text) {
            if (text.isNotBlank()) {
                sampleProducts.filter { product ->
                    product.name.contains(text, ignoreCase = true) ||
                            product.description?.contains(text, ignoreCase = true) ?: false
                }
            } else emptyList()
        }

        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            if (text.isBlank()) {
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
fun HomeScreenPreview() {
    LuveryTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}
