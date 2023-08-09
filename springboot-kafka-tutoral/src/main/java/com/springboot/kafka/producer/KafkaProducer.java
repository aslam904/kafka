package com.springboot.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
	private static final Logger LOGGER=LoggerFactory.getLogger(KafkaProducer.class);

	@Autowired
	private KafkaTemplate<String,String> kt;
	
	public void sendMessage(String event) {
		LOGGER.info(String.format("Message sent %s", event));
		kt.send("newTopic",event);
	}
	
}
