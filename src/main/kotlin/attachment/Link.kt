package attachment

data class Link(
    val url: String,
    val title: String,
    val caption: String = "",
    val description: String = "",
    val photo: Photo? = null,
    val product: LinkProduct? = null,
    val button: LinkButton? = null,
    val previewPage: String? = null,
    val previewUrl: String? = null
)


data class LinkProduct(
    val price: Price
) {
    class Price(
        val amount: Int,
        val currency: Currency,
        val text: String
    )

    class Currency(
        val id: Int,
        val name: String
    )
}

data class LinkButton(
    val title: String,
    val actionType: String,
    val actionUrl: String
)