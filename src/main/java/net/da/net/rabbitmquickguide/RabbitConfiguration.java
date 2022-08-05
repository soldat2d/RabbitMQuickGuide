package net.da.net.rabbitmquickguide;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public Queue myQueue1() {
        return new Queue("myQueue1");
    }

    @Bean
    public Queue myQueue2() {
        return new Queue("myQueue2");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("FanoutExchange");
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("DirectExchange");
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("TopicExchange");
    }

//    @Bean
//    public Binding binding1() {
//        return BindingBuilder.bind(myQueue1()).to(fanoutExchange());
//    }
//
//    @Bean
//    public Binding binding2() {
//        return BindingBuilder.bind(myQueue2()).to(fanoutExchange());
//    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(myQueue1()).to(topicExchange()).with("key.one");
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder.bind(myQueue2()).to(topicExchange()).with("key.*");
    }

//    @Bean
//    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory());
//        container.setQueueNames("myQueue");
//        container.setMessageListener(message -> logger.info("Received from myQueue : " + new String(message.getBody())));
//        return container;
//    }

}
