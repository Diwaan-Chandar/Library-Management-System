object Librarian {
    const val mailID: String = "lib@lib.com"
    private val userType: UserTypes = UserTypes.LIBRARIAN

    fun addBook(title: String, author: String, price: Int) {
        LibraryData.addBook(title, author, price)
    }

    fun removeBook(bookID: Int) {
        LibraryData.removeBook(bookID)
    }

    fun getBookDetails(): MutableMap<Int, Book> {
        return LibraryData.getBookDetails()
    }

    fun addStudent(name: String, mailID: String, age: Int): User {
        val user: User = Student(name, mailID, age)
        LibraryData.addUser(mailID, user)
        return user
    }

    fun addFaculty(name: String, mailID: String, age: Int): User {
        val user: User = Faculty(name, mailID, age)
        LibraryData.addUser(mailID, user)
        return user
    }

    fun removeUser(mailID: String) {
        LibraryData.removeUser(mailID)
    }

    fun borrowBookForUser(book: Book, mailID: String) {
        LibraryData.borrowBook(book, mailID)
    }

    fun returnBookForUser(book: Book) {
        LibraryData.returnBook(book)
    }

    fun requestBookForUser(title: String, reason: String) {
        LibraryData.requestBook(title, reason)
    }

    fun addFineToUser(amount: Int, mailID: String) {
        LibraryData.addFineToUser(mailID, amount)
    }

    fun removeFineFromUser(amount: Int, mailID: String) {
        LibraryData.removeFineFromUser(mailID, amount)
    }

    fun getRequests() : MutableMap<String, String> {
        return LibraryData.getRequests()
    }

    fun getFineAmount(mailID: String): Int {
        return LibraryData.getFineAmount(mailID)
    }

    fun searchBook(title: String): MutableMap<Int, Book> {
        return LibraryData.searchBook(title)
    }
}

