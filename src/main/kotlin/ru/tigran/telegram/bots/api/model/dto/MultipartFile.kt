package ru.tigran.telegram.bots.api.model.dto

interface MultipartFile {
    fun hasFile() = false

    fun convertToAttach(): MultipartFile
}