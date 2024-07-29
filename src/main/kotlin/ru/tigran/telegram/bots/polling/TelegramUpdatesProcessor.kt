package ru.tigran.telegram.bots.polling

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.springframework.stereotype.Component
import ru.tigran.telegram.bots.configuration.polling.TelegramPollerProperties
import ru.tigran.telegram.bots.util.AsyncJob

private val log = KotlinLogging.logger {  }

@Component
internal class TelegramUpdatesProcessor(
    private val queue: TelegramUpdatesQueue,
    private val properties: TelegramPollerProperties,
    private val updateProcessor: TelegramUpdateProcessor,
) : AsyncJob(properties.processingDelayDuration) {
    private val coroutinePool = Dispatchers.Default.limitedParallelism(properties.processingCoroutines)

    override suspend fun execute() {
        val updates = queue.dequeueBatch(properties.processingLimit)
        log.debug { "Dequeued ${updates.size} updates" }
        updates.forEach { launch(coroutinePool) {
            log.debug { "Start processing update id=${it.updateId}" }
            updateProcessor.process(it)
            log.debug { "End processing update id=${it.updateId}" }
        } }
    }
}