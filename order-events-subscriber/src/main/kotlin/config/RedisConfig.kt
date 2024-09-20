package co.thedebater.redispubsub.config

import co.thedebater.redispubsub.listener.OrderEventListener
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.listener.PatternTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer


@Configuration
class RedisConfig {
    @Value("\${redis.pubsub.topic:channel-events}")
    private lateinit var topic: String

    @Bean
    fun redisTemplate(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<String, Any> {
        val redisTemplate = RedisTemplate<String, Any>();
        redisTemplate.connectionFactory = redisConnectionFactory
        redisTemplate.valueSerializer = GenericJackson2JsonRedisSerializer()
        return redisTemplate;
    }

    @Bean
    fun getTopic(): PatternTopic {
        return PatternTopic(topic);
    }

    @Bean
    fun redisMessageListenerContainer(redisConnectionFactory: RedisConnectionFactory): RedisMessageListenerContainer {
        val container = RedisMessageListenerContainer()
        container.setConnectionFactory(redisConnectionFactory)
        container.addMessageListener(messageListener(), getTopic())
        return container
    }

    @Bean
    fun messageListener(): MessageListenerAdapter {
        return MessageListenerAdapter(OrderEventListener())
    }
}