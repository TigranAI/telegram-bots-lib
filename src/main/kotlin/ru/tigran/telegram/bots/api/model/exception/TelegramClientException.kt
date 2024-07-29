package ru.tigran.telegram.bots.api.model.exception

import org.springframework.http.HttpStatusCode
import org.springframework.web.client.HttpStatusCodeException

class TelegramClientException(
    errorCode: Int,
    description: String,
) : HttpStatusCodeException(HttpStatusCode.valueOf(errorCode), description)
