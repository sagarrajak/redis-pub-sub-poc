package co.thedebater.redispubsub.controller

import OrderRequestMapper
import co.thedebater.common.OrderEvent
import co.thedebater.redispubsub.service.EventService
import common.request.OrderEventDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/push")
class RedisTopicController(
    private val eventService: EventService
){

    @PostMapping()
    fun pushToRedis(@RequestBody orderEvent: OrderEventDto) {
        println("pushToRedis: pushing message to topic ${orderEvent.orderId}")
        val orderEvent1 = OrderEvent(
            orderId = orderEvent.orderId,
            userId = orderEvent.userId,
            productName = orderEvent.productName,
            price = orderEvent.price,
            quantity = orderEvent.quantity
        )
        this.eventService.publish(orderEvent1);
    }
}