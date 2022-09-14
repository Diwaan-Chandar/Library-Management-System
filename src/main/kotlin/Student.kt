class Student(
    name: String,
    mailID: String,
    age: Int,
) : User(name, mailID, age) {
    override val maxBooks = 4
    override val userType: UserTypes = UserTypes.STUDENT
    override val borrowableDuration = 14
}