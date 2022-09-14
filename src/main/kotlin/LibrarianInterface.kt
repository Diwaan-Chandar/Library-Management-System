interface LibrarianInterface {
    fun addBook(title: String, author: String, price: Int)
    fun removeBook(bookID: Int)
    fun editBook()
    fun addUser(mailID: String, user: User)
    fun removeUser(mailID: String)
    fun getBookDetails(): MutableMap<Int, Book>
    fun searchBook(title: String): MutableMap<Int, Book>
    fun addFineToUser(mailID: String, amount: Int)
    fun removeFineFromUser(mailID: String, amount: Int)
    fun getRequests(): MutableMap<String, String>
    fun getFineAmount(mailID: String): Int
}