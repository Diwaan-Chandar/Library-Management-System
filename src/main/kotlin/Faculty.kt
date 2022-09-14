class Faculty (
    name: String,
    mailID: String,
    age: Int,
) : User(name, mailID, age) {
    override val maxBooks = 8
    override val userType: UserTypes = UserTypes.FACULTY
    override val borrowableDuration = 28
}