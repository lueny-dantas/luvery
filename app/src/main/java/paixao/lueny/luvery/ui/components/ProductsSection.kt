package paixao.lueny.luvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import paixao.lueny.luvery.ui.model.Product
import paixao.lueny.luvery.ui.sampledata.sampleProducts
import paixao.lueny.luvery.ui.theme.LuveryTheme

@Composable
fun ProductsSection(
    title: String,
    modifier: Modifier = Modifier,
    products: List<Product>
) {
    Column (modifier){
        Text(
            text = title,
            Modifier.padding(
                start = 16.dp,
                end = 16.dp
            ),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        LazyRow(
                Modifier
                    .padding(
                        top = 8.dp,
                    )
                    .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(products) { p ->
                ProductItem(product = p)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsSectionPreview() {
    LuveryTheme {
        Surface {
            ProductsSection("Promoções", products = sampleProducts)
        }
    }
}