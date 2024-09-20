package co.thedebater.redispubsub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OrderEventSubscriber

fun main(args: Array<String>) {
    runApplication<OrderEventSubscriber>(*args)
}

