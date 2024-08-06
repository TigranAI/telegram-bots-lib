package ru.tigran.telegram.bots.api.model.dto

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.tigran.telegram.bots.api.model.enums.InputPaidMediaType
import ru.tigran.telegram.bots.util.converter.TelegramInputFileConverter

interface InputPaidMedia : MultipartFile {
    val type: InputPaidMediaType
    val media: InputFile

    override fun hasFile(): Boolean {
        return media.hasFile()
    }

    data class InputPaidMediaPhoto(
        @field:JsonSerialize(converter = TelegramInputFileConverter::class)
        override val media: InputFile,
    ) : InputPaidMedia {
        override val type: InputPaidMediaType = InputPaidMediaType.PHOTO

        override fun convertToAttach(): MultipartFile {
            return this.copy(media = media.convertToAttach() as InputFile)
        }
    }

    data class InputPaidMediaVideo(
        @field:JsonSerialize(converter = TelegramInputFileConverter::class)
        override val media: InputFile,
        val thumbnail: InputFile? = null,
        val width: Int? = null,
        val height: Int? = null,
        val duration: Int? = null,
        val supportsStreaming: Boolean? = null,
    ) : InputPaidMedia {
        override val type: InputPaidMediaType = InputPaidMediaType.VIDEO

        override fun hasFile(): Boolean {
            return super.hasFile() || thumbnail?.hasFile() == true
        }

        override fun convertToAttach(): MultipartFile {
            return this.copy(
                media = media.convertToAttach() as InputFile,
                thumbnail = thumbnail?.convertToAttach() as InputFile,
            )
        }
    }
}
