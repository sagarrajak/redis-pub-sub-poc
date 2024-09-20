package co.thedebater.redispubsub.listener

import co.thedebater.common.OrderEvent
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.data.redis.connection.Message
import org.springframework.data.redis.connection.MessageListener
import org.springframework.stereotype.Component


@Component
class OrderEventListener() : MessageListener {

    override fun onMessage(message: Message, pattern: ByteArray?) {
        val mapper = jacksonObjectMapper()
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        if (pattern != null) {
             try {
                 println("New message received: $message");
                 val readValues: OrderEvent = mapper.readValue(message.body)
                 println("ReadValue: ${readValues}");
            } catch (e: JsonParseException) {
                 println("JSON parsing error: ${e.message}")
             } catch (e: JsonMappingException) {
                 println("JSON mapping error: ${e.message}")
             }
        }
    }
}