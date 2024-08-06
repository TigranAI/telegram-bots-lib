package ru.tigran.telegram.bots.util.converter

import com.fasterxml.jackson.databind.util.StdConverter
import ru.tigran.telegram.bots.api.model.dto.InputFile

private const val attachPrefix = "attach://"
class TelegramInputFileConverter : StdConverter<InputFile, String?>() {
    override fun convert(file: InputFile) = when(file) {
        is InputFile.InputFileId -> file.fileId
        is InputFile.InputFileUrl -> file.url
        is InputFile.InputFileAttach -> "$attachPrefix${file.fileName}"
        else -> null
    }
}