class Student: User() {
    override fun calculateFine(durationInDays: Int) {
        if(durationInDays > 14) {
            fineAmount += durationInDays - 10
        }
    }
}