package ru.tigran.telegram.bots.api.model.dto

import java.io.File

interface InputFile {
    data class InputFileId(
        val fileId: String,
    ) : InputFile

    data class InputFileUrl(
        val url: String,
    ) : InputFile

    data class InputFileMultipart(
        val file: File,
    ) : InputFile
}
