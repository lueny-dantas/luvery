package paixao.lueny.luvery.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import paixao.lueny.luvery.R
import paixao.lueny.luvery.stateHolders.ProductFormUiState
import paixao.lueny.luvery.ui.model.Product
import paixao.lueny.luvery.ui.theme.LuveryTheme
import paixao.lueny.luvery.ui.viewmodels.ProductFormScreenViewModel
import java.math.BigDecimal
import java.text.DecimalFormat

@Composable
fun ProductFormScreen(
    viewModel: ProductFormScreenViewModel,
    onSaveClick: () -> Unit = {}
) {
    val state by viewModel.uiState.collectAsState()

    ProductFormScreen(
        state = state,
        onSaveClick = {
            viewModel.save()
            onSaveClick()
        }
    )
}


@Composable
fun ProductFormScreen(
    state: ProductFormUiState = ProductFormUiState(),
    onSaveClick: () -> Unit = {}
) {
    val url = state.url
    val name = state.name
    val price = state.price
    val description = state.description

    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Spacer(modifier = Modifier)
        Text(
            text = "Criando o produto",
            Modifier.fillMaxWidth(),
            fontSize = 28.sp,
        )

        if (state.isShowPreview) {
            AsyncImage(
                model = url, contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder)
            )
        }
        TextField(
            value = url,
            onValueChange = state.onUrlChange,
            Modifier.fillMaxWidth(),
            label = {
                Text(text = "Url da imagem")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Next
            )
        )
        TextField(
            value = name,
            onValueChange = state.onNameChange,
            Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nome")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            )
        )

        TextField(
            value = price,
            onValueChange = state.onPriceChange,
            Modifier.fillMaxWidth(),
            label = {
                Text(text = "Preço")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            )
        )
        TextField(
            value = description,
            onValueChange = state.onDescriptionChange,
            Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp),
            label = {
                Text(text = "Descrição")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Sentences
            )
        )
        Button(
            onClick = onSaveClick,
            Modifier.fillMaxWidth(),
        ) {
            Text(text = "Salvar")
        }
        Spacer(modifier = Modifier)
    }
}

@Preview
@Composable
fun ProductFormScreenPreview() {
    LuveryTheme {
        Surface {
            ProductFormScreen(state = ProductFormUiState())
        }
    }
}

@Preview
@Composable
fun ProductFormScreenFilledPreview() {
    LuveryTheme {
        Surface {
            ProductFormScreen(
                state = ProductFormUiState(
                    url = "url teste",
                    name = "nome teste",
                    price = "123",
                    description = "descrição teste"
                )
            )
        }
    }
}