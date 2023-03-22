package paixao.lueny.luvery.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import paixao.lueny.luvery.ui.theme.LuveryTheme

@Composable
fun ProductFormScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {

        Text(
            text = "Criando o produto",
            Modifier.fillMaxWidth(),
            fontSize = 28.sp,
        )

        var url by remember { mutableStateOf("") }

        TextField(value = url,
            onValueChange = { url = it },
            Modifier.fillMaxWidth(),
            label = { Text(text = "Url da imagem") }
        )

        var name by remember { mutableStateOf("") }

        TextField(value = name,
            onValueChange = { name = it },
            Modifier.fillMaxWidth(),
            label = { Text(text = "Nome") }
        )

        var price by remember { mutableStateOf("") }

        TextField(value = price,
            onValueChange = { price = it },
            Modifier.fillMaxWidth(),
            label = { Text(text = "Preço") }
        )

        var description by remember { mutableStateOf("") }

        TextField(value = description,
            onValueChange = { description = it },
            Modifier.fillMaxWidth(),
            label = { Text(text = "Descrição") }
        )

        Button(
            onClick = { /*TODO*/ },
            Modifier.fillMaxWidth())
        {
            Text(text = "Salvar")
        }
    }
}

@Preview
@Composable
fun ProductFormScreenPreview() {
    LuveryTheme {
        Surface {
            ProductFormScreen()
        }
    }
}