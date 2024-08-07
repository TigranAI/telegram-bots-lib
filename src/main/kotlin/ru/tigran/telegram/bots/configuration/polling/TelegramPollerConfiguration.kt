package ru.tigran.telegram.bots.configuration.polling

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@ConditionalOnExpression("\${telegram.poller.enabled:true}")
@Configuration
@ComponentScan("ru.tigran.telegram.bots.polling")
@EnableConfigurationProperties(TelegramPollerProperties::class)
class TelegramPollerConfiguration
