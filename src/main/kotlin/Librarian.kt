object Librarian {
    const val mailID: String = "lib@lib.com"
    private val data: LibrarianInterface = LibraryData
    private val userType: UserTypes = UserTypes.LIBRARIAN

    fun getBookDetails(): MutableMap<Int, Book> {
        return data.getBookDetails()
    }

    fun addUser(mailID: String) {
        data.addUser(mailID)
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

