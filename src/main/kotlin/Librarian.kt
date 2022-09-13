object Librarian {
    const val mailID: String = "lib@lib.com"
    private val data: LibrarianInterface = LibraryData
    private val userType: UserTypes = UserTypes.LIBRARIAN

    fun addBook(title: String, author: String) {
        LibraryData.addBook(title, author)
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

    fun addFineToUser(noOfDays: Int, mailID: String) {
        data.addFineToUser(mailID, noOfDays)
    }

    fun removeFineFromUser(amount: Int, mailID: String) {
        data.removeFineFromUser(mailID, amount)
    }

    fun getRequests() : MutableMap<String, String> {
        return LibraryData.getRequests()
    }
}

