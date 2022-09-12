object LibraryData: UserInterface, LibrarianInterface {
    private val booksAvailable = mutableMapOf<Int, Book>()           // Book ID to Book object reference
    private val users = mutableMapOf<String, User>()                // Mail ID to User object reference
    private val bookRequests = mutableMapOf<String, String>()      // Book Name to Reason
    private var bookID = 101

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
}

