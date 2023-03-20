package paixao.lueny.luvery.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import paixao.lueny.luvery.ui.model.Product
import paixao.lueny.luvery.ui.sampledata.sampleProducts
import paixao.lueny.luvery.ui.sampledata.sampleSections
import paixao.lueny.luvery.ui.theme.LuveryTheme

@Composable
fun HomeScreen(sections: Map<String, List<Product>>) {

    Column {
        var text by remember { mutableStateOf("") }
        OutlinedTextField(
            value = text,
            onValueChange = { newValue -> text = newValue },

            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(100),
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Icone de pesquisa") },
            label = { Text(text = "Produto") },
            placeholder = { Text(text = "O que você procura?") })

        LazyColumn(
            Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(sampleProducts) { p ->
                CardProductItem(
                    product = p,
                    Modifier.padding(horizontal = 16.dp)
                )

//            for (section in sections) {
//                val title = section.key
//                val products = section.value
//                item {
//                    ProductsSection(
//                        title = title,
//                        products = products
//                    )
//                }
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
