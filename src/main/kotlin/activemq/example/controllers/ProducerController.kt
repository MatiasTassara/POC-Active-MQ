package activemq.example.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.jms.core.JmsTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.jms.Queue

@RestController
@RequestMapping("api/publish")
class ProducerController {

    @Autowired
    private lateinit var jmsTemplate: JmsTemplate

    @Autowired
    private lateinit var queue: Queue

    @GetMapping("/{message}")
    fun publish(@PathVariable("message") message: String): ResponseEntity<String>{

        jmsTemplate.convertAndSend(queue,message)
        return ResponseEntity(message,HttpStatus.OK)
    }
}