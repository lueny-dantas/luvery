package paixao.lueny.luvery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import paixao.lueny.luvery.dao.ProductDao
import paixao.lueny.luvery.ui.sampledata.*
import paixao.lueny.luvery.ui.screens.HomeScreen
import paixao.lueny.luvery.ui.theme.LuveryTheme

class MainActivity : ComponentActivity() {

    private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(
                onFabClick = {
                    startActivity(
                        Intent(
                            this, ProductFormActivity::class.java
                        )
                    )
                }) {
                val sections = mapOf(
                    "Todos produtos" to dao.productsDao(),
                    "Promoções" to sampleDrinks + sampleCandies,
                    "Salgados" to sampleSavory,
                    "Doces" to sampleCandies,
                    "Sobremesas" to sampleDesserts,
                    "Bebidas" to sampleDrinks
                )
                HomeScreen(sections = sections)
            }
        }
    }
}

@Composable
fun App(
    onFabClick: () -> Unit = {}, content: @Composable () -> Unit = {},
) {
    LuveryTheme {
        Surface {
            Scaffold(floatingActionButton = {
                FloatingActionButton(onClick = onFabClick) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            }) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    content()
                }
            }
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    App{
        HomeScreen(sections = sampleSections)
    }
}


