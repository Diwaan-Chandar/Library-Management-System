object LibraryData {
    private val booksAvailable = mutableMapOf<Int, Book>()           // Book ID to Book object reference
    private val users = mutableMapOf<String, User>()                // Mail ID to User object reference
    private val bookRequests = mutableMapOf<String, String>()      // Book Name to Reason
    private var bookID = 101
    private val fineData = mutableMapOf<String, Int>()           // MailID to Fine Amount of Users

    fun addBook(title: String, author: String, price: Int) {
        booksAvailable[bookID] = Book(bookID++, title, author, price)
    }

    fun removeBook(bookID: Int) {
        booksAvailable.remove(bookID)
    }

    fun borrowBook(book: Book, mailID: String) {
        book.isAvailable = false
        book.holderMailID = mailID
    }

    fun returnBook(book: Book) {
        book.isAvailable = true
        book.holderMailID = null
    }

    fun requestBook(title: String, reason: String) {
        bookRequests[title] = reason
    }

    fun addUser(mailID: String, user: User) {
        users[mailID] = user
    }

    fun removeUser(mailID: String) {
        users.remove(mailID)
    }

    fun getBookDetails(): MutableMap<Int, Book> = booksAvailable

    fun searchBook(title: String): MutableMap<Int, Book> {
        val matchingBooks = mutableMapOf<Int, Book>()
        for((bookID, book) in booksAvailable.entries) {
            if(book.title.contains(title)) {
                matchingBooks[bookID] = book
            }
        }
        return matchingBooks
    }

    fun addFineToUser(mailID: String, amount: Int) {
        fineData[mailID] = (fineData[mailID] ?: 0) + amount
    }

    fun removeFineFromUser(mailID: String, amount: Int) {
        if(mailID in fineData.keys) {
            fineData[mailID] = (fineData[mailID] ?: return) - amount
        }
    }

    fun getFineAmount(mailID: String): Int {
        return fineData[mailID] ?: 0
    }

    fun getRequests(): MutableMap<String, String> = bookRequests
}

