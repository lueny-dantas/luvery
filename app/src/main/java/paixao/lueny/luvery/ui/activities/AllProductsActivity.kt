package paixao.lueny.luvery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import paixao.lueny.luvery.ui.sampledata.sampleProducts
import paixao.lueny.luvery.ui.screens.AllProductsScreens
import paixao.lueny.luvery.ui.theme.LuveryTheme

class AllProductsActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LuveryTheme {
                Surface {
                    AllProductsScreens(products = sampleProducts)
                }
            }
        }
    }
}