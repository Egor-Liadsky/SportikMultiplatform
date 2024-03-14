package exceptions

data class ServerException(
    val errorCode: Int,
    val errorMessage: String
): Exception(errorMessage)