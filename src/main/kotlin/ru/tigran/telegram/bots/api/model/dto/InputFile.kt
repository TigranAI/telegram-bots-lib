package ru.tigran.telegram.bots.api.model.dto

import java.io.File

interface InputFile : MultipartFile {
    override fun convertToAttach(): MultipartFile {
        return this
    }

    data class InputFileId(
        val fileId: String,
    ) : InputFile

    data class InputFileUrl(
        val url: String,
    ) : InputFile

    data class InputFileMultipart(
        val file: File,
    ) : InputFile {
        override fun hasFile() = true

        override fun convertToAttach(): MultipartFile {
            return InputFileAttach(file.name)
        }
    }

    data class InputFileAttach(
        val fileName: String,
    ) : InputFile
}
