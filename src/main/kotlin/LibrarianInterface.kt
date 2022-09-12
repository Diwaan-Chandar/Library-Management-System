interface LibrarianInterface {
    fun addBook(title: String, author: String)
    fun removeBook(bookID: Int)
    fun editBook()
    fun addUser(mailID: String)
    fun removeUser(mailID: String)
    fun getBooks(): MutableMap<Int, Book>
    fun searchBook(title: String): MutableMap<Int, Book>
    fun addFineToUser(mailID: String, noOfDays: Int)
    fun removeFineFromUser(mailID: String, amount: Int)
}