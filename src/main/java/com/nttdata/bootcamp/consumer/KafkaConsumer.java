package com.nttdata.bootcamp.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nttdata.bootcamp.config.Util;
import com.nttdata.bootcamp.models.Bootcoin;
import com.nttdata.bootcamp.services.BootcoinService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaConsumer {
	
	@Autowired
	private BootcoinService bootcoinService;

	@KafkaListener(topics ="${kafka.subscribed-topic.name}")
	public void consumeEvent(String message) throws JsonProcessingException, InterruptedException {
		Bootcoin bootcoin = Util.objectMapper.readValue(message, Bootcoin.class);
		log.info("Message received "+ message);
		bootcoinService.processBootcoin(bootcoin);
	}
}
