package paixao.lueny.luvery.ui.model

import androidx.annotation.DrawableRes
import java.math.BigDecimal

data class Product(
    val name: String,
    val price: BigDecimal,
    val image: String? = null,
    val description:String? = null
)
