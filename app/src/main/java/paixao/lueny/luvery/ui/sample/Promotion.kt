package paixao.lueny.luvery.ui.sample

import paixao.lueny.luvery.R
import paixao.lueny.luvery.ui.model.Product
import java.math.BigDecimal

val samplePromotion = listOf(
    Product(
        name = "Hamburguer",
        price = BigDecimal("12.99"),
        image = R.drawable.burger
    ),
    Product(
        name = "Pizza",
        price = BigDecimal("29.99"),
        image = R.drawable.pizza
    ),
    Product(
        name = "Batata frita",
        price = BigDecimal("7.99"),
        image = R.drawable.fries
    )
)
