package paixao.lueny.luvery.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import paixao.lueny.luvery.ui.theme.LuveryTheme

@Composable
fun SearchTextField(
    searchText: String,
    onSearchChange: (String) -> Unit,
    modifier: Modifier = Modifier
){
    OutlinedTextField(
        value = searchText,
        onValueChange = { newValue -> onSearchChange (newValue) },
        modifier,
        shape = RoundedCornerShape(100),
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Icone de pesquisa") },
        label = { Text(text = "Produto") },
        placeholder = { Text(text = "O que você procura?") })

}

@Preview(showBackground = true)
@Composable
fun SearchTextFieldPreview() {
    LuveryTheme {
        Surface {
            SearchTextField(
                "",
                onSearchChange = {},
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchTextFieldWithSearchTextPreview() {
    LuveryTheme {
        Surface {
            SearchTextField(
                searchText = "a",
                onSearchChange = {},
            )
        }
    }
}