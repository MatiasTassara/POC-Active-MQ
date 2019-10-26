package activemq.example.listeners

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.jms.annotation.JmsListener
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.handler.annotation.Headers
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class Consumer {

    val logger: Logger = LoggerFactory.getLogger(Consumer::class.java)

    @JmsListener(destination = "standalone.queue")
    fun consume(@Payload message: String,
                @Headers headers: MessageHeaders){

        logger.info("Received: < $message >")
        logger.info("Headers: $headers")
    }

}