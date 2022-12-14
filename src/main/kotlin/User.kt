import java.time.LocalDateTime
import java.time.Duration

abstract class User(
    private var name: String,
    private var mailID: String,
    private var age: Int,
    ) {
    abstract val maxBooks: Int
    abstract val userType: UserTypes
    abstract val borrowableDuration: Int // No of days borrowable
    private var userAccount: UserAccount = UserAccount(this.mailID)
    private var inLibrary: Boolean = false

    init {
        Authenticator.addCredential(mailID)
    }

    fun borrowBook(book: Book): String {
        val now: LocalDateTime = LocalDateTime.now()
        return if (this.userType == UserTypes.STUDENT && userAccount.booksTaken.count() >= (this as Student).maxBooks) {
            "Return some books to borrow books"
        } else if (this.userType == UserTypes.FACULTY && userAccount.booksTaken.count() >= (this as Faculty).maxBooks) {
            "Return some books to borrow books"
        } else {
            userAccount.booksTaken[book] = now
            Librarian.borrowBookForUser(book, mailID)
            "Book borrowed"
        }
    }

    fun returnBook(bookID: Int) {
        for(book in userAccount.booksTaken.keys) {
            if (book.bookID == bookID) {
                val now: LocalDateTime = LocalDateTime.now()
                val duration = Duration.between(now, userAccount.booksTaken[book])
                if(duration.toDays().toInt() > borrowableDuration) {
                    Librarian.addFineToUser((duration.toDays().toInt() - duration.toDays().toInt()) * 5, mailID)
                }
                userAccount.booksTaken.remove(book)
                userAccount.booksReturned.add(book)
                Librarian.returnBookForUser(book)
                break
            }
        }
    }

    fun requestBook(title: String, reason: String) {
        Librarian.requestBookForUser(title, reason)
    }

    fun reportMissedBook(bookID: Int) {
        for(book in userAccount.booksTaken.keys) {
            if (book.bookID == bookID) {
                Librarian.addFineToUser(book.price, mailID)
            }
        }
        returnBook(bookID)
        Librarian.removeBook(bookID)
    }

    fun booksInHand(): MutableMap<Book, LocalDateTime> {
        return userAccount.booksTaken
    }

    fun enterLibrary() {
        inLibrary = true
    }

    fun exitLibrary() {
        inLibrary = false
    }

    fun payFine(amount: Int): Boolean {
        return if(amount == Librarian.getFineAmount(mailID)) {
            Librarian.removeFineFromUser(amount, mailID)
            true
        } else false
    }
}