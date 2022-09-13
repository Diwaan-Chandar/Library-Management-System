class Faculty (private var name: String, private var mailID: String, private var age: Int): User(name, mailID, age) {
    override val maxBooks = 8
    override val userType: UserTypes = UserTypes.FACULTY
}