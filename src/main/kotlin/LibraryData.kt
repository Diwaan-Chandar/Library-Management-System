object LibraryData: UserInterface, LibrarianInterface {
    private val booksAvailable = mutableMapOf<Int, Book>()           // Book ID to Book object reference
    private val users = mutableMapOf<String, User>()                // Mail ID to User object reference
    private val bookRequests = mutableMapOf<String, String>()      // Book Name to Reason
    private var bookID = 101
    private val fineData = mutableMapOf<String, Int>()          // MailID to Fine Amount of Users

    override fun addBook(title: String, author: String) {
        booksAvailable[bookID] = Book(bookID ++, title, author)
    }

    override fun removeBook(bookID: Int) {
        booksAvailable.remove(bookID)
    }

    override fun editBook() {

    }

    override fun borrowBook(book: Book, mailID: String) {
        booksAvailable[book.bookID]?.isAvailable = false
        booksAvailable[book.bookID]?.holderMailID = mailID
    }

    override fun returnBook(book: Book) {
        booksAvailable[book.bookID]?.isAvailable = true
        booksAvailable[book.bookID]?.holderMailID = null
    }

    override fun requestBook(title: String, reason: String) {
        bookRequests[title] = reason
    }

    override fun addUser(mailID: String) {

    }

    override fun removeUser(mailID: String) {

    }

    override fun getBooks(): MutableMap<Int, Book> {
        return booksAvailable
    }

    override fun searchBook(title: String): MutableMap<Int, Book> {
        val matchingBooks = mutableMapOf<Int, Book>()
        for((bookID, book) in booksAvailable.entries) {
            if(book.title.contains(title)) {
                matchingBooks[bookID] = book
            }
        }
        return matchingBooks
    }

    override fun addFineToUser(mailID: String, noOfDays: Int) {
        if(mailID !in fineData.keys) {
            fineData[mailID] = noOfDays * 5
        } else {
            fineData[mailID] = fineData[mailID]!! + noOfDays * 5
        }
    }

    override fun removeFineFromUser(mailID: String, amount: Int) {
        if(mailID in fineData.keys) {
            fineData[mailID] = fineData[mailID]!! - amount
        }
    }

    override fun getFineAmount(mailID: String): Int {
        if(mailID !in fineData.keys) return 0
        return fineData[mailID]!!
    }

    override fun getRequests(): MutableMap<String, String> {
        return bookRequests
    }
}

