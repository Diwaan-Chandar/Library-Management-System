interface UserInterface {
    fun getBooks(): MutableMap<Int, Book>
    fun searchBook(title: String): MutableMap<Int, Book>
    fun borrowBook(book: Book, mailID: String)
    fun returnBook(book: Book)
    fun requestBook(title: String, reason: String)
    fun getFineAmount(mailID: String): Int
}