package ru.tigran.telegram.bots.api.model.dto

import ru.tigran.telegram.bots.api.model.enums.InputMediaType
import ru.tigran.telegram.bots.api.model.enums.ParseModeType

interface InputMedia : MultipartFile {
    val type: InputMediaType
    val media: InputFile
    val caption: String?
    val parseMode: ParseModeType?
    val captionEntities: List<MessageEntity>?

    override fun hasFile(): Boolean {
        return media.hasFile()
    }

    data class InputMediaPhoto(
        override val media: InputFile,
        override val caption: String? = null,
        override val parseMode: ParseModeType? = null,
        override val captionEntities: List<MessageEntity>? = null,
        val showCaptionAboveMedia: Boolean? = null,
        val hasSpoiler: Boolean? = null,
    ) : InputMedia {
        override val type: InputMediaType = InputMediaType.PHOTO

        override fun convertToAttach(): MultipartFile {
            return this.copy(media = media.convertToAttach() as InputFile)
        }
    }

    data class InputMediaVideo(
        override val media: InputFile,
        override val caption: String? = null,
        override val parseMode: ParseModeType? = null,
        override val captionEntities: List<MessageEntity>? = null,
        val showCaptionAboveMedia: Boolean? = null,
        val hasSpoiler: Boolean? = null,
        val thumbnail: InputFile? = null,
        val width: Int? = null,
        val height: Int? = null,
        val duration: Int? = null,
        val supportsStreaming: Boolean? = null,
    ) : InputMedia {
        override val type: InputMediaType = InputMediaType.VIDEO

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

    data class InputMediaAnimation(
        override val media: InputFile,
        override val caption: String? = null,
        override val parseMode: ParseModeType? = null,
        override val captionEntities: List<MessageEntity>? = null,
        val showCaptionAboveMedia: Boolean? = null,
        val hasSpoiler: Boolean? = null,
        val thumbnail: InputFile? = null,
        val width: Int? = null,
        val height: Int? = null,
        val duration: Int? = null,
        val supportsStreaming: Boolean? = null,
    ) : InputMedia {
        override val type: InputMediaType = InputMediaType.ANIMATION

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

    data class InputMediaAudio(
        override val media: InputFile,
        override val caption: String? = null,
        override val parseMode: ParseModeType? = null,
        override val captionEntities: List<MessageEntity>? = null,
        val thumbnail: InputFile? = null,
        val duration: Int? = null,
        val performer: String? = null,
        val title: String? = null,
    ) : InputMedia {
        override val type: InputMediaType = InputMediaType.AUDIO

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

    data class InputMediaDocument(
        override val media: InputFile,
        override val caption: String? = null,
        override val parseMode: ParseModeType? = null,
        override val captionEntities: List<MessageEntity>? = null,
        val thumbnail: InputFile? = null,
        val disableContentTypeDetection: Boolean? = null,
    ) : InputMedia {
        override val type: InputMediaType = InputMediaType.DOCUMENT

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