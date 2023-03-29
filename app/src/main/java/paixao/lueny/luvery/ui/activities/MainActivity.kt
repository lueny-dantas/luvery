package paixao.lueny.luvery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import paixao.lueny.luvery.dao.ProductDao
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

                val products = dao.productsDao()
                HomeScreen(products = products)
            }
        }
    }
}




