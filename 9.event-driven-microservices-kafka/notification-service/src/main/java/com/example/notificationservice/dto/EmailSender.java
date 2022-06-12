package com.example.notificationservice.dto;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Slf4j
public class EmailSender {

	@Autowired
	private ObjectMapper objectMapper;
	
	public void sendEmail(OrderDto orderDto) throws InterruptedException {
		log.info("## RabbitMQ -> Sending Email Confirmation for Order - {}", orderDto.getOrderNumber());
		Thread.sleep(100);
		log.info("Email Sent!!");
	}
	
	
	@KafkaListener(topics = "t-order")
	public void sendEmailKafka(String orderDtoString) throws JsonMappingException, JsonProcessingException {
		OrderDto orderDto = objectMapper.readValue(orderDtoString, OrderDto.class);
		
		log.info("Read Order : "+ orderDto.toString());
		
		log.info("## Kafka -> Sending Email Confirmation for Order - {}", orderDto.getOrderNumber());
	}
}