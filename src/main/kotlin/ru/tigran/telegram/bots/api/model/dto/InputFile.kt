package ru.tigran.telegram.bots.api.model.dto

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import ru.tigran.telegram.bots.util.getMimeType
import java.io.File

interface InputFile {
    fun multipart(property: String): MultipartBody.Part? = null

    data class InputFileId(
        val fileId: String,
    ) : InputFile

    data class InputFileUrl(
        val url: String,
    ) : InputFile

    data class InputFileMultipart(
        val file: File,
    ) : InputFile {
        override fun multipart(property: String): MultipartBody.Part {
            val requestBody = RequestBody.create(MediaType.parse(file.getMimeType().toString()), file)
            return MultipartBody.Part.createFormData(property, file.name, requestBody)
        }
    }
}
