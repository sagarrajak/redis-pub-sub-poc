package co.thedebater.redispubsub

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OrderEventPublisher

fun main(args: Array<String>) {
    runApplication<OrderEventPublisher>(*args)
}

