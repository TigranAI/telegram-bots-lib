package ru.tigran.telegram.bots.util

import com.fasterxml.jackson.databind.util.StdConverter
import ru.tigran.telegram.bots.api.model.dto.InputFile


class TelegramInputFileConverter : StdConverter<InputFile, String?>() {
    override fun convert(file: InputFile) = when(file) {
        is InputFile.InputFileId -> file.fileId
        is InputFile.InputFileUrl -> file.url
        else -> null
    }
}