package co.thedebater.redispubsub.service

import co.thedebater.common.OrderEvent
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.stereotype.Service


@Service
class EventService(
    val redisTemplate: RedisTemplate<String, Any>,
    val channelTopic: ChannelTopic
) {
    fun publish(orderEvent: OrderEvent?): Long {
        return redisTemplate.convertAndSend(channelTopic.topic, orderEvent as Any);
    }
}