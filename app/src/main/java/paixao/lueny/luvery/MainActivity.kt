package paixao.lueny.luvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import paixao.lueny.luvery.ui.components.HomeScreen
import paixao.lueny.luvery.ui.sampledata.sampleSections
import paixao.lueny.luvery.ui.theme.LuveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}


@Composable
fun App() {
    LuveryTheme {
        Surface {
            HomeScreen(
                sampleSections
            )
            }
        }
    }






