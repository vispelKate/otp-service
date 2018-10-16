package com.ks.otpservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMqConfig {

    @Value("${otp.service.rabbitmq.sms.queue}")
    String smsQueue;

    @Value("${otp.service.rabbitmq.email.queue}")
    String emailQueue;

    @Value("${otp.service.rabbitmq.exchange}")
    String exchange;

    @Value("${otp.service.rabbitmq.sms.routingkey}")
    private String smsRoutingkey;

    @Value("${otp.service.rabbitmq.email.routingkey}")
    private String emailRoutingkey;

    @Bean
    Queue smsQueue() {
        return new Queue(smsQueue, false);
    }

    @Bean
    Queue emailQueue() {
        return new Queue(emailQueue, false);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Binding bindingSms(Queue smsQueue, DirectExchange exchange) {
        return BindingBuilder.bind(smsQueue).to(exchange).with(smsRoutingkey);
    }

    @Bean
    Binding bindingEmail(Queue emailQueue, DirectExchange exchange) {
        return BindingBuilder.bind(emailQueue).to(exchange).with(emailRoutingkey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

}
