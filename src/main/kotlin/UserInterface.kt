interface UserInterface {
    fun getBooks(): MutableMap<Int, Book>
    fun borrowBook(book: Book, mailID: String)
    fun returnBook(book: Book)
    fun requestBook(title: String, reason: String)
}