package paixao.lueny.luvery.ui.sample

import paixao.lueny.luvery.R
import paixao.lueny.luvery.ui.model.Product
import java.math.BigDecimal

val sampleSweet = listOf(
    Product(
        name = "Bolo de Chocolate",
        price = BigDecimal("11.99"),
        image = R.drawable.tortachocolate
    ),
    Product(
        name = "Pudim",
        price = BigDecimal("4.99"),
        image = R.drawable.pudim
    ),
    Product(
        name = "Brigadeiro",
        price = BigDecimal("1.99"),
        image = R.drawable.brigadeiro
    ),
    Product(
        name = "Cocada",
        price = BigDecimal("1.99"),
        image = R.drawable.cocada
    )
)