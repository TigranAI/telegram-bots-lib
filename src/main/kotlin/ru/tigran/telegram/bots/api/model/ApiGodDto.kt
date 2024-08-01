package ru.tigran.telegram.bots.api.model

interface ApiGodDto<ChildType> {
    fun typify(): ChildType
}