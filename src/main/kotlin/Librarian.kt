object Librarian {
    const val mailID: String = "lib@lib.com"
    private val data: LibrarianInterface = LibraryData
    private val userType: UserTypes = UserTypes.LIBRARIAN

    fun addBook(title: String, author: String, price: Int) {
        LibraryData.addBook(title, author, price)
    }

    fun removeBook(bookID: Int) {
        LibraryData.removeBook(bookID)
    }

    fun getBookDetails(): MutableMap<Int, Book> {
        return data.getBookDetails()
    }

    fun addStudent(name: String, mailID: String, age: Int): User {
        val user: User = Student(name, mailID, age)
        data.addUser(mailID, user)
        return user
    }

    fun addFaculty(name: String, mailID: String, age: Int): User {
        val user: User = Faculty(name, mailID, age)
        data.addUser(mailID, user)
        return user
    }

    fun removeUser(mailID: String) {
        data.removeUser(mailID)
    }

    fun addFineToUser(amount: Int, mailID: String) {
        data.addFineToUser(mailID, amount)
    }

    fun removeFineFromUser(amount: Int, mailID: String) {
        data.removeFineFromUser(mailID, amount)
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

