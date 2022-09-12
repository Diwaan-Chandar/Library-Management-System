object Authenticator {
    private val authentication = mutableListOf<String>() // MailID

    fun authenticateUser(mailID: String): Boolean {
        return mailID in authentication
    }

    fun addCredential(mailID: String){
        authentication.add(mailID)
    }
}