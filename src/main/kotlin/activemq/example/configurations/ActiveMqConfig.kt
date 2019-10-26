package activemq.example.configurations

import org.apache.activemq.ActiveMQConnectionFactory
import org.apache.activemq.command.ActiveMQQueue
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.core.JmsTemplate
import javax.jms.Queue

@Configuration
class ActiveMqConfig {

    @Value("\${activemq.broker-url}")
    private lateinit var brokerUrl: String

    @Bean
    fun getQueue(): Queue{
        return ActiveMQQueue("standalone.queue")
    }

    @Bean
    fun activeMQConnectionFactory(): ActiveMQConnectionFactory{
        val factory = ActiveMQConnectionFactory()
        factory.brokerURL = brokerUrl
        return factory
    }

    @Bean
    fun jmsTemplate(): JmsTemplate{
        return JmsTemplate(activeMQConnectionFactory())
    }
}