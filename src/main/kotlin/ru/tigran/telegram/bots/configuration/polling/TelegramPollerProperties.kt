package ru.tigran.telegram.bots.configuration.polling

import org.springframework.boot.context.properties.ConfigurationProperties
import kotlin.time.Duration

@ConfigurationProperties(prefix = "telegram.poller")
data class TelegramPollerProperties(
    val delay: String = "100ms",
    val timeout: String = "1s",
    val limit: Int = 100,
    val processingDelay: String = "50ms",
    val processingLimit: Int = 100,
    val processingCoroutines: Int = 20,
) {
    internal val delayDuration
        get() = Duration.parse(delay)
    internal val timeoutDuration
        get() = Duration.parse(timeout)
    internal val processingDelayDuration
        get() = Duration.parse(processingDelay)
}