package ru.tigran.telegram.bots.configuration.polling

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@ConditionalOnProperty("telegram.poller.enabled")
@Configuration
@ComponentScan("ru.tigran.telegram.bots.polling")
@EnableConfigurationProperties(TelegramPollerProperties::class)
class TelegramPollerConfiguration
