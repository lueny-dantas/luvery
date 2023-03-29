package paixao.lueny.luvery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import paixao.lueny.luvery.dao.ProductDao
import paixao.lueny.luvery.stateHolders.HomeScreenUiState
import paixao.lueny.luvery.ui.sampledata.*
import paixao.lueny.luvery.ui.screens.MainScreen
import paixao.lueny.luvery.ui.screens.HomeScreen

class MainActivity : ComponentActivity() {

    private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(
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
                val state = remember{ HomeScreenUiState() }
                HomeScreen(sections = sections, state = state)
            }
        }
    }
}




