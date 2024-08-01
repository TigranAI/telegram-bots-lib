package ru.tigran.telegram.bots.api.model.enums

enum class ParseModeType {
    MarkdownV2,
    HTML,
    @Deprecated(
        message = "This is a legacy mode, retained for backward compatibility",
        replaceWith = ReplaceWith("MarkdownV2"),
    )
    Markdown,
}