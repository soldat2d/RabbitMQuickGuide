package net.da.net.rabbitmquickguide;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class RabbitMQuickGuideApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMQuickGuideApplication.class, args);
    }

}
