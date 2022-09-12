object Librarian {
    const val mailID: String = "lib@lib.com"
    private val data: LibrarianInterface = LibraryData

    fun getBooks() {
        data.getBooks()
    }

    fun addUser(mailID: String) {
        data.addUser(mailID)
    }

    fun removeUser(mailID: String) {
        data.removeUser(mailID)
    }

    fun addFine(noOfDays: Int, mailID: String) {
        data.calculateFine(noOfDays, mailID)
    }

}

