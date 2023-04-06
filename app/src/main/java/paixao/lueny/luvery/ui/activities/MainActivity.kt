package paixao.lueny.luvery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import paixao.lueny.luvery.ui.screens.MainScreen
import paixao.lueny.luvery.ui.screens.HomeScreen
import paixao.lueny.luvery.ui.viewmodels.HomeScreenViewModel

class MainActivity : ComponentActivity() {

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

                val viewModel by viewModels<HomeScreenViewModel>()
                HomeScreen(viewModel)
            }
        }
    }
}




