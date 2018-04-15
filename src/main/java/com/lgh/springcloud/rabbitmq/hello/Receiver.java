package com.lgh.springcloud.rabbitmq.hello;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@RabbitListener(queues = "hello")
@Slf4j
public class Receiver {

	@RabbitHandler
	public void process(Object msg) throws UnsupportedEncodingException {
		Message msg2 = (Message) msg;
		log.info("Receiver========: " + new String(msg2.getBody(), "UTF-8"));
	}
}
