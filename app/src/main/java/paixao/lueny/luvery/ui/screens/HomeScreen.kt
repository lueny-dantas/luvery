package paixao.lueny.luvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import paixao.lueny.luvery.ui.model.Product
import paixao.lueny.luvery.ui.sampledata.sampleSections
import paixao.lueny.luvery.ui.theme.LuveryTheme

@Composable
fun HomeScreen(sections: Map<String, List<Product>>) {

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(Modifier)
        for (section in sections) {
            val title = section.key
            val products = section.value
            ProductsSection(
                title = title,
                products = products)}
        Spacer(Modifier)
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