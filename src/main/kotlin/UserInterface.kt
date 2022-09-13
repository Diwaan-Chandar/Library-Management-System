interface UserInterface {
    fun borrowBook(book: Book, mailID: String)
    fun returnBook(book: Book)
    fun requestBook(title: String, reason: String)
}