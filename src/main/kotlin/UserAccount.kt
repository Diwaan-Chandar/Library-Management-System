import java.time.LocalDateTime

data class UserAccount(val mailID: String) {
    val booksTaken = mutableMapOf<Book, LocalDateTime>() // Book object reference to Date
    val booksReturned = mutableListOf<Book>() // Book object reference
}
