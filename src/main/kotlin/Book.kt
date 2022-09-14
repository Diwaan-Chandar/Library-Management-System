data class Book (
    val bookID: Int,
    val title: String,
    val author: String,
    val price: Int
) {
    var isAvailable = true
    var holderMailID: String? = null
}