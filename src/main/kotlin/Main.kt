//fun signIn(mailID: String, password: String) {
//    Authenticator.authenticateUser(mailID, password)
//    Home.userHome(mailID) //If logged In as user
//    Home.librarianHome(mailID) //If logged In as librarian
//}
//
//fun signUp() {
//    Validator.isEmailValid("")
//    Validator.isPasswordValid("")
//    LibraryData.addUser("Mail ID Here")
//}

fun main(args: Array<String>) {
    val user: User = Student() // Add a new Student to the library
    LibraryData.addBook("Harry Potter", "JK Rowling") // Add new Books
    LibraryData.addBook("400 Days", "Chetan Bhagat")
    user.setDetails("ABC", "abc@lib.com", 19) // Set user details
    if (Authenticator.authenticateUser("abc@lib.com")) { // Verify user ID
        user.enterLibrary() // User enters library
        println("Entered Library...")
        println("Books Available: ")
        val availableBooks = LibraryData.getBooks() // User searches book
        for (eachBookID in availableBooks.keys) {
            if (availableBooks[eachBookID]?.isAvailable == true) {
                println("${availableBooks[eachBookID]?.bookID} ${availableBooks[eachBookID]?.title} ${availableBooks[eachBookID]?.author} ")
            }
        }
        if (LibraryData.getFineAmount("abc@lib.com") == 0) { // Library checks for fine
            if (101 in availableBooks.keys) {  // Check if it is a valid book ID (Valid in this case)
                availableBooks[101]?.let { user.borrowBook(it) } // User borrows book
            }
        } else {
            println("Please pay fine") // Checks for fine (No fine in this case) (This is not executed)
        }
        println("Books in hand:")
        val borrowedBooks = user.booksInHand() // User checks the Borrowed books
        if (borrowedBooks?.isEmpty() == true) {
            println("No books in hand")
        }
        for ((book, date) in borrowedBooks?.entries!!) {
            println("${book.bookID} ${book.title} $date ")
        }
        user.exitLibrary() // User exits library
        println("Exited Library...")
    } else {
        println("User not authenticated")
    }

    println()
    println()

    val user2: User = Student() // Add new user to Library
    user2.setDetails("DEF", "def@lib.com", 19) // Set new user details
    if (Authenticator.authenticateUser("def@lib.com")) { // Verify User 2 ID
        user2.enterLibrary() // User 2 enters library
        println("Entered Library...")
        println("Books Available: ")
        val availableBooks = LibraryData.getBooks() // User 2 searches book
        for (eachBookID in availableBooks.keys) {
            if (availableBooks[eachBookID]?.isAvailable == true) {
                println("${availableBooks[eachBookID]?.bookID} ${availableBooks[eachBookID]?.title} ${availableBooks[eachBookID]?.author} ")
            }
        }
        println("Books in hand:") // User 2 checks borrowed books
        val borrowedBooks = user2.booksInHand()
        if (borrowedBooks?.isEmpty() == true) {
            println("No books in hand") // User 2 has no books borrowed
        }
        for ((book, date) in borrowedBooks?.entries!!) {
            println("${book.bookID} ${book.title} $date ")
        }
        user2.exitLibrary()
        println("Exited Library...") // User 2 exited library without borrowing any books
    } else {
        println("User not authenticated")
    }

    println()
    println()

    if (Authenticator.authenticateUser("abc@lib.com")) { // User ID is verified
        user.enterLibrary() // User enters library
        println("Entered Library...")
        println("Books in hand:")
        val borrowedBooks = user.booksInHand() // User checks books in hand
        if (borrowedBooks?.isEmpty() == true) {
            println("No books in hand")
        }
        for ((book, date) in borrowedBooks?.entries!!) {
            println("${book.bookID} ${book.title} $date ")
        }
        user.returnBook(101) // User returns a book
        println("Book Returned")
        println("Books Available: ")
        val availableBooks =
            LibraryData.getBooks() // User search the returned book in library to verify if it is returned
        for (eachBookID in availableBooks.keys) {
            if (availableBooks[eachBookID]?.isAvailable == true) {
                println("${availableBooks[eachBookID]?.bookID} ${availableBooks[eachBookID]?.title} ${availableBooks[eachBookID]?.author} ")
            }
        }
        user.exitLibrary() // User exits library
        println("Exited Library...")
    } else {
        println("User not authenticated")
    }

    println()
    println()

    if (Authenticator.authenticateUser("abc@lib.com")) { // User ID is verified
        user.enterLibrary() // User enters library
        println("Entered Library...")
        println("Books in hand:")
        val borrowedBooks = user.booksInHand() // User checks for books in hand
        if (borrowedBooks?.isEmpty() == true) {
            println("No books in hand") // User has no books in hand
        } else { // This is not executed
            for ((book, date) in borrowedBooks?.entries!!) {
                println("${book.bookID} ${book.title} $date ")
            }
            user.returnBook(101) // Not returned
            println("Book Returned")
        }
        user.exitLibrary() // User exits library without any books
        println("Exited Library...")
    } else {
        println("User not authenticated")
    }

    println()
    println()

    if (Authenticator.authenticateUser("abcd@lib.com")) {  // Invalid Mail ID is provided
        user.enterLibrary()
        println("Entered Library...")
        user.exitLibrary()
        println("Exited Library...")
    } else { // Hence the user is not allowed
        println("User not authenticated")
    }

    println()
    println()

    if (Authenticator.authenticateUser("abc@lib.com")) { // Validates the user
        user.enterLibrary() // User enters library
        println("Entered Library...")
        val searchedBooks = user.searchBook("400") // User searches book using keyword
        for (book in searchedBooks.values) {
            if (book.isAvailable) {
                println("${book.bookID} ${book.title} ${book.author}")
            }
        }
        if (102 in searchedBooks.keys) {
            if (LibraryData.getFineAmount("abc@lib.com") == 0) { // Checks for fine (No fine in this case)
                user.borrowBook(searchedBooks[102]!!) // User borrows book
            }
            else {
                println("Please pay fine")  // This is not executed
            }
        } else {
            println("Invalid Book ID")
        }
        user.exitLibrary() // User exits Library
        println("Exited Library...")
    } else {
        println("User not authenticated")
    }

    println()
    println()

    if (Authenticator.authenticateUser("abc@lib.com")) { // Validates user ID
        user.enterLibrary() // User Enters Library
        println("Entered Library...")
        val searchedBooks = user.searchBook("Machine Learning") // User searches a book using keyword
        if (searchedBooks.isEmpty()) { // The book is not available
            println("No result found!")
        }
        for (book in searchedBooks.values) {
            if (book.isAvailable) {
                println("${book.bookID} ${book.title} ${book.author}")
            }
        }
        user.requestBook("Machine Learning", "To learn ML") // User requests library to buy a bool on the topic
        user.exitLibrary() // User exits Library
        println("Exited Library...")
    } else {
        println("User not authenticated")
    }

    println()
    println()

    val bookRequests = Librarian.getRequests() // Librarian checks for request
    for((request, reason) in bookRequests.entries) {
        println("$request : $reason")
    }
    LibraryData.addBook("Machine Learning", "Andrew NG") // Librarian adds new book on request
    println("Book added successfully")

    println()
    println()

    if (Authenticator.authenticateUser("abc@lib.com")) { // Validates user ID
        user.enterLibrary() // User Enters Library again
        println("Entered Library...")
        val searchedBooks = user.searchBook("Machine Learning") // User searches a book using keyword again
        if (searchedBooks.isEmpty()) { // The book is available now since it is added by Librarian
            println("No result found!")
        }
        for (book in searchedBooks.values) {
            if (book.isAvailable) {
                println("${book.bookID} ${book.title} ${book.author}")
            }
        }
        if (103 in searchedBooks.keys) {
            if (LibraryData.getFineAmount("abc@lib.com") == 0) { // Checks for fine (No fine in this case)
                user.borrowBook(searchedBooks[103]!!) // User borrows requested book after added
                println("Book Borrowed")
            }
            else {
                println("Please pay fine")  // This is not executed
            }
        } else {
            println("Invalid Book ID")
        }
        user.exitLibrary() // User exits Library
        println("Exited Library...")
    } else {
        println("User not authenticated")
    }
}

