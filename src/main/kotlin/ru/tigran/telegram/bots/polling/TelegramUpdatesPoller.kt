package ru.tigran.telegram.bots.polling

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.stereotype.Component
import ru.tigran.telegram.bots.api.TelegramAsyncClient
import ru.tigran.telegram.bots.api.model.request.GetUpdatesRequest
import ru.tigran.telegram.bots.configuration.polling.TelegramPollerProperties
import ru.tigran.telegram.bots.util.AsyncJob

private val log = KotlinLogging.logger {  }

@Component
internal class TelegramUpdatesPoller(
    private val properties: TelegramPollerProperties,
    private val telegramClient: TelegramAsyncClient,
    private val queue: TelegramUpdatesQueue,
) : AsyncJob(delay = properties.delayDuration) {
    private var offset: Long? = null

    init {
        log.debug { "Initialize update poller, delay is ${properties.delay}" }
    }

    override suspend fun execute() {
        val updates = telegramClient.getUpdates(
            GetUpdatesRequest(
                offset = offset,
                limit = properties.limit,
                timeout = properties.timeoutDuration.inWholeSeconds.toInt(),
            )
        )
        updates.maxByOrNull { it.updateId }?.let { offset = it.updateId + 1 }
        log.debug { "Got ${updates.size} updates, last update id offset is $offset" }
        queue.enqueueAll(updates)
    }
}