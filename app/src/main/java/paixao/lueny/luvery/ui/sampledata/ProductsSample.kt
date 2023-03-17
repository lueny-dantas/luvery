package paixao.lueny.luvery.ui.sampledata

import paixao.lueny.luvery.ui.model.Product
import java.math.BigDecimal


val sampleSavory = listOf(
    Product(
        name = "Torta de Camarao",
        price = BigDecimal("18.99"),
        image = "https://tudodereceitas.com.br/wp-content/uploads/2022/12/Torta-de-camarao-perfeita.jpg"
    ),
    Product(
        name = "Hamburguer",
        price = BigDecimal("12.99"),
        image = "https://images.pexels.com/photos/1639557/pexels-photo-1639557.jpeg"
    ),
    Product(
        name = "Pizza",
        price = BigDecimal("29.99"),
        image = "https://images.pexels.com/photos/825661/pexels-photo-825661.jpeg"
    ),
    Product(
        name = "Batata frita",
        price = BigDecimal("7.99"),
        image = "https://images.pexels.com/photos/1583884/pexels-photo-1583884.jpeg"
    )
)

val sampleDrinks = listOf(
    Product(
        name = "Cerveja",
        price = BigDecimal("5.99"),
        image = "https://images.pexels.com/photos/1552630/pexels-photo-1552630.jpeg",
    ),
    Product(
        name = "Refrigerante",
        price = BigDecimal("4.99"),
        image = "https://images.pexels.com/photos/2775860/pexels-photo-2775860.jpeg"
    ),
    Product(
        name = "Suco",
        price = BigDecimal("7.99"),
        image = "https://images.pexels.com/photos/96974/pexels-photo-96974.jpeg"
    ),
    Product(
        name = "Água",
        price = BigDecimal("2.99"),
        image = "https://images.pexels.com/photos/327090/pexels-photo-327090.jpeg"
    )
)

val sampleCandies = listOf(
    Product(
        name = "Chocolate",
        price = BigDecimal("3.99"),
        image = "https://images.pexels.com/photos/65882/chocolate-dark-coffee-confiserie-65882.jpeg"
    ),
    Product(
        name = "Brigadeiro",
        price = BigDecimal("1.99"),
        image = "https://cdn.panelinha.com.br/receita/958014000000-Brigadeiro.jpg"
    ),
    Product(
        name = "Cocada",
        price = BigDecimal("1.99"),
        image = "https://www.easyanddelish.com/wp-content/uploads/2015/11/cocada-de-leite-condensado-capa-coconut-bars-featured.jpg"
    )
)

val sampleDesserts = listOf(
    Product(
        name = "Bolo de Chocolate",
        price = BigDecimal("11.99"),
        image = "https://images.pexels.com/photos/291528/pexels-photo-291528.jpeg",
    ),
    Product(
        name = "Pudim",
        price = BigDecimal("4.99"),
        image = "https://s2.glbimg.com/115DQucrWsNOUxf_ncmMUisprZI=/0x0:1080x819/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_e84042ef78cb4708aeebdf1c68c6cbd6/internal_photos/bs/2020/w/a/cB6VP5QoOByFKEuCleIQ/jonreceitas-109758346-416338779271002-5424220606850697813-n.jpg"
    ),
    Product(
        name = "Sorvete",
        price = BigDecimal("5.99"),
        image = "https://images.pexels.com/photos/1352278/pexels-photo-1352278.jpeg",
    )
)


val sampleProducts: List<Product> = listOf(

    *sampleSavory.toTypedArray(), *sampleDrinks.toTypedArray(),
    *sampleCandies.toTypedArray(), *sampleDesserts.toTypedArray()
)

val sampleSections = mapOf(
    "Promoções" to sampleProducts,
    "Salgados" to sampleSavory,
    "Bebidas" to sampleDrinks,
    "Doces" to sampleCandies,
    "Sobremesas" to sampleDesserts

)