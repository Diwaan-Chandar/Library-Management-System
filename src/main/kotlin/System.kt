fun main() {
    Librarian.addBook("Harry Potter", "JK Rowling", 500) // Librarian adds new Books
    Librarian.addBook("400 Days", "Chetan Bhagat", 250)
    val user: User = Librarian.addStudent("ABC", "abc@lib.com", 19) // Librarian adds a new Student to the library
    if (Authenticator.authenticateUser("abc@lib.com")) { // Authenticator verify user ID
        user.enterLibrary() // User enters library
        println("Entered Library...")
        println("Books Available: ")
        val availableBooks = Librarian.getBookDetails() // Librarian provides the book details
        for (book in availableBooks.values) {
            if (book.isAvailable) {
                println("${book.bookID} ${book.title} ${book.author} ")
            }
        }
        val bookID = 101
        if (Librarian.getFineAmount("abc@lib.com") == 0) { // Librarian checks for fine before checkout
            if (bookID in availableBooks.keys) {  // Check if it is a valid book ID (Valid in this case)
                val message = availableBooks[bookID]?.let { user.borrowBook(it) } // User borrows book if he is not holding more than 4 books
                println(message)
            }
        } else {
            println("Please pay fine") // No fine in this case (This is not executed)
        }
        println("Books in hand:")
        val borrowedBooks = user.booksInHand() // User checks the Borrowed books
        if (borrowedBooks.isEmpty() == true) {
            println("No books in hand")
        }
        for ((book, date) in borrowedBooks.entries) {
            println("${book.bookID} ${book.title} $date ")
        }
        user.exitLibrary() // User exits library
        println("Exited Library...")
    } else {
        println("User not authenticated")
    }

    println()
    println()

    val user2: User = Librarian.addStudent("DEF", "def@lib.com", 19) // Librarian adds a new Student to the library
    if (Authenticator.authenticateUser("def@lib.com")) { // Authenticator verify User 2 ID
        user2.enterLibrary() // User 2 enters library
        println("Entered Library...")
        println("Books Available: ")
        val availableBooks = Librarian.getBookDetails() // Librarian provides the book details
        for (book in availableBooks.values) {
            if (book.isAvailable) {
                println("${book.bookID} ${book.title} ${book.author} ")
            }
        }
        println("Books in hand:") // User 2 checks borrowed books
        val borrowedBooks = user2.booksInHand()
        if (borrowedBooks.isEmpty() == true) {
            println("No books in hand") // User 2 has no books borrowed
        }
        for ((book, date) in borrowedBooks.entries) {
            println("${book.bookID} ${book.title} $date ")
        }
        user2.exitLibrary()
        println("Exited Library...") // User 2 exited library without borrowing any books
    } else {
        println("User not authenticated")
    }

    println()
    println()

    if (Authenticator.authenticateUser("abc@lib.com")) { // Authenticator verify User ID
        user.enterLibrary() // User enters library
        println("Entered Library...")
        println("Books in hand:")
        val borrowedBooks = user.booksInHand() // User checks books in hand
        if (borrowedBooks.isEmpty() == true) {
            println("No books in hand")
        }
        for ((book, date) in borrowedBooks.entries) {
            println("${book.bookID} ${book.title} $date ")
        }
        val bookID = 101
        user.returnBook(bookID) // User returns a book
        println("Book Returned")
        println("Books Available: ")
        val availableBooks = Librarian.getBookDetails() // User search the returned book in library to verify if it is returned
        for (book in availableBooks.values) {
            if (book.isAvailable == true) {
                println("${book.bookID} ${book.title} ${book.author} ")
            }
        }
        user.exitLibrary() // User exits library
        println("Exited Library...")
    } else {
        println("User not authenticated")
    }

    println()
    println()

    if (Authenticator.authenticateUser("abc@lib.com")) { // Authenticator verify user ID
        user.enterLibrary() // User enters library
        println("Entered Library...")
        println("Books in hand:")
        val borrowedBooks = user.booksInHand() // User checks for books in hand
        val bookID = 101
        if (borrowedBooks.isEmpty()) {
            println("No books in hand") // User has no books in hand
        } else {                        // This is not executed
            for ((book, date) in borrowedBooks.entries) {
                println("${book.bookID} ${book.title} $date ")
            }
            user.returnBook(bookID) // Not returned
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

    if (Authenticator.authenticateUser("abc@lib.com")) { // Authenticator verify user ID
        user.enterLibrary() // User enters library
        println("Entered Library...")
        val searchedBooks = Librarian.searchBook("400") // Librarian searches and provide the matching book details for user using a keyword
        for (book in searchedBooks.values) {
            if (book.isAvailable) {
                println("${book.bookID} ${book.title} ${book.author}")
            }
        }
        val bookID = 102
        if (bookID in searchedBooks.keys) {
            if (Librarian.getFineAmount("abc@lib.com") == 0) { // Librarian checks for fine before checkout (No fine in this case)
                val message = user.borrowBook(searchedBooks[bookID]!!) // User borrows book
                println(message)
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

    if (Authenticator.authenticateUser("abc@lib.com")) { // Authenticator verify user ID
        user.enterLibrary() // User Enters Library
        println("Entered Library...")
        val searchedBooks = Librarian.searchBook("Machine Learning") // Librarian searches and provide the matching book details for user using a keyword
        if (searchedBooks.isEmpty()) { // The book is not available
            println("No result found!")
        }
        for (book in searchedBooks.values) {
            if (book.isAvailable) {
                println("${book.bookID} ${book.title} ${book.author}")
            }
        }
        user.requestBook("Machine Learning", "To learn ML") // User requests librarian to buy a book on the topic
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
    Librarian.addBook("Machine Learning", "Andrew NG", 700) // Librarian adds new book on request
    println("Book added successfully")

    println()
    println()

    if (Authenticator.authenticateUser("abc@lib.com")) { // Authenticator verify user ID
        user.enterLibrary() // User Enters Library again
        println("Entered Library...")
        val searchedBooks = Librarian.searchBook("Machine Learning") // User searches a book using keyword again
        if (searchedBooks.isEmpty()) { // The book is available now since it is added by Librarian
            println("No result found!")
        }
        for (book in searchedBooks.values) {
            if (book.isAvailable) {
                println("${book.bookID} ${book.title} ${book.author}")
            }
        }
        val bookID = 103
        if (bookID in searchedBooks.keys) {
            if (Librarian.getFineAmount("abc@lib.com") == 0) { // Checks for fine (No fine in this case)
                val message = user.borrowBook(searchedBooks[bookID]!!) // User borrows requested book after it is added
                println(message)
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

    Librarian.addBook("Book 1", "Author 1", 200) // Librarian adds 5 new books to the library
    Librarian.addBook("Book 2", "Author 2", 200)
    Librarian.addBook("Book 3", "Author 3", 200)
    Librarian.addBook("Book 4", "Author 4", 200)
    Librarian.addBook("Book 5", "Author 5", 200)
    println("5 books added to library")

    println()
    println()

    if (Authenticator.authenticateUser("abc@lib.com")) { // Authenticator verify user ID
        user.enterLibrary() // User Enters Library again
        println("Entered Library...")
        var availableBooks = Librarian.getBookDetails() // Librarian provides available book details
        for (book in availableBooks.values) {
            if (book.isAvailable) {
                println("${book.bookID} ${book.title} ${book.author} ")
            }
        }
        var bookID = 104
        if (Librarian.getFineAmount("abc@lib.com") == 0) { // Library checks for fine
            if (bookID in availableBooks.keys) {  // Check if it is a valid book ID (Valid in this case)
                val message =
                    availableBooks[bookID]?.let { user.borrowBook(it) }  //User borrows third book
                println(message)
            }
        } else {
            println("Please pay fine") // Checks for fine (No fine in this case) (This is not executed)
        }
        bookID = 105
        if (Librarian.getFineAmount("abc@lib.com") == 0) { // Library checks for fine
            if (bookID in availableBooks.keys) {  // Check if it is a valid book ID (Valid in this case)
                val message = availableBooks[bookID]?.let { user.borrowBook(it) } // User borrows fourth book
                println(message)
            }
        } else {
            println("Please pay fine") // Checks for fine (No fine in this case) (This is not executed)
        }
        bookID = 106
        if (Librarian.getFineAmount("abc@lib.com") == 0) { // Library checks for fine
            if (bookID in availableBooks.keys) {  // Check if it is a valid book ID (Valid in this case)
                val message = availableBooks[bookID]?.let { user.borrowBook(it) } // User tries to borrow book but its fifth book hence it is not borrowed
                println(message)
            }
        } else {
            println("Please pay fine") // Checks for fine (No fine in this case) (This is not executed)
        }

        println("Available Books")
        availableBooks = Librarian.getBookDetails() // Book is still available in Available Books
        for (eachBookID in availableBooks.keys) {
            if (availableBooks[eachBookID]?.isAvailable == true) {
                println("${availableBooks[eachBookID]?.bookID} ${availableBooks[eachBookID]?.title} ${availableBooks[eachBookID]?.author} ")
            }
        }
        user.exitLibrary() // User exits Library
        println("Exited Library...")
    } else {
        println("User not authenticated")
    }

    println()
    println()

    val bookDetails = Librarian.getBookDetails() // Librarian checks for book details
    for(book in bookDetails.values) {
        val message = if(book.isAvailable) {
            "Available in Library"
        } else {
            "Borrowed by ${book.holderMailID}"
        }
        println("${book.bookID}\t${book.title}\t${book.author}\t$message ")
    }

    println()
    println()

    if (Authenticator.authenticateUser("abc@lib.com")) { // Authenticator verify User ID
        user.enterLibrary() // User enters library
        println("Entered Library...")
        println("Books in hand:")
        val borrowedBooks = user.booksInHand() // User checks books in hand
        if (borrowedBooks.isEmpty() == true) {
            println("No books in hand")
        }
        for ((book, date) in borrowedBooks.entries) {
            println("${book.bookID} ${book.title} $date ")
        }

        // User missed 104 - Book 1
        user.reportMissedBook(104) // User reports missed book
        var fine = Librarian.getFineAmount("abc@lib.com")
        println(fine)

        if(user.payFine(200)) { // User paid fine for the missing book
            println("Paid Fine")
        } else println("Invalid Fine Amount")

        fine = Librarian.getFineAmount("abc@lib.com") // Fine amount is deduced
        println(fine)

        user.exitLibrary() // User exits library
        println("Exited Library...")
    } else {
        println("User not authenticated")
    }
}
