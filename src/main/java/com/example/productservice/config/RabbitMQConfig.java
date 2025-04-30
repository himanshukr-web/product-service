package com.example.productservice.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("product-exchange");
    }

    @Bean
    public Queue queue() {
        return new Queue("product-queue");
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("product-routing-key");
    }
}
