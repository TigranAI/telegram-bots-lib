package ru.tigran.telegram.bots.api.model.exception

import org.springframework.http.HttpStatus
import retrofit2.HttpException
import retrofit2.Response
import ru.tigran.telegram.bots.api.model.TelegramResponse

data class TelegramException(
    val errorCode: HttpStatus,
    val description: String,
) : Throwable(message = description) {
    companion object {
        fun of(exception: HttpException) = TelegramException(
            errorCode = HttpStatus.valueOf(exception.code()),
            description = exception.message(),
        )

        fun of(response: Response<*>) = when(response.body()) {
            is TelegramResponse<*> -> TelegramException(
                errorCode = HttpStatus.valueOf(response.code()),
                description = "amogus",
            )
            else -> TelegramException(
                errorCode = HttpStatus.valueOf(response.code()),
                description = TelegramResponse.parse(response.errorBody()!!).description!!,
            )
        }
    }
}
