import java.time.LocalDateTime
import java.time.Duration

abstract class User {
    private var name: String = ""
    private var mailID: String = ""
    private var age: Int = 0
    private var account: UserAccount? = null
    private val data: UserInterface = LibraryData
    private var inLibrary: Boolean = false

    fun borrowBook(book: Book) {
        val now: LocalDateTime = LocalDateTime.now()
        account?.booksTaken?.put(book, now)
        data.borrowBook(book, mailID)
        return Unit
    }

    fun returnBook(bookID: Int) {
        var book: Book? = null
        for(eachBook in account?.booksTaken?.keys!!) {
            if (eachBook.bookID == bookID) {
                book = eachBook
            }
        }
        val now: LocalDateTime = LocalDateTime.now()
        val duration = Duration.between(now, account?.booksTaken?.get(book))
        Librarian.addFineToUser(duration.toDays().toInt(), mailID)
        account?.booksTaken?.remove(book)
        if (book != null) {
            data.returnBook(book)
        }
    }

    fun requestBook(title: String, reason: String) {
        data.requestBook(title, reason)
    }

    fun booksInHand(): MutableMap<Book, LocalDateTime>? {
        return account?.booksTaken
    }

    fun enterLibrary() {
        inLibrary = true
    }

    fun exitLibrary() {
        inLibrary = false
    }

    fun setDetails(name: String, mailID: String, age: Int) {
        this.name = name
        this.mailID = mailID
        this.age = age
        this.account = UserAccount(this.mailID)

        Authenticator.addCredential(mailID)
    }

    fun searchBook(title: String): MutableMap<Int, Book> {
        return data.searchBook(title)
    }

    fun payFine(amount: Int) {
        Librarian.removeFineFromUser(amount, mailID)
    }

}