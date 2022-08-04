package net.da.net.rabbitmquickguide;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQListener {

    private final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @RabbitListener(queues = "myQueue")
    public void processMyQueue(String message) {
        logger.info("Received first from myQueue : {}", message);
    }

    @RabbitListener(queues = "myQueue")
    public void processMyQueue2(String message) {
        logger.info("Received second from myQueue : {}", message);
    }
}
