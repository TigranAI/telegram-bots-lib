package ru.tigran.telegram.bots.util

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.time.Duration

abstract class AsyncJob(
    private val delay: Duration,
    private val job: Job = Job()
) : CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.Default + job

    init {
        start()
    }

    abstract suspend fun execute()

    fun stop() = job.cancel()

    private fun start() = launch {
        while (true) {
            execute()
            delay(delay)
        }
    }
}