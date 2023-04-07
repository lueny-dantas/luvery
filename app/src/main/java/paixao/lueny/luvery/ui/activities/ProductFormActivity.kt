package paixao.lueny.luvery.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import paixao.lueny.luvery.dao.ProductDao
import paixao.lueny.luvery.ui.screens.ProductFormScreen
import paixao.lueny.luvery.ui.theme.LuveryTheme
import paixao.lueny.luvery.ui.viewmodels.ProductFormScreenViewModel

class ProductFormActivity : ComponentActivity() {

    private val dao = ProductDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LuveryTheme {
                Surface {
                    val viewModel: ProductFormScreenViewModel by viewModels()
                    ProductFormScreen(
                        viewModel = viewModel,
                        onSaveClick = {
                            finish()
                        })
                }
            }
        }
    }
}




