package net.da.net.rabbitmquickguide;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    private final Logger logger = LoggerFactory.getLogger(RabbitMQListener.class);

    @RabbitListener(queues = {"myQueue1"})
    public void processMyQueue(String message) {
        logger.info("Received from myQueue1 : {}", message);
    }

    @RabbitListener(queues = {"myQueue2"})
    public void processMyQueue2(String message) {
        logger.info("Received from myQueue2 : {}", message);
    }
}
