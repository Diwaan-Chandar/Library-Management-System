class Faculty : User() {
    override fun calculateFine(durationInDays: Int) {
        if(durationInDays > 28) {
            fineAmount += durationInDays - 24
        }
    }
}