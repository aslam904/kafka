package com.springboot.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kafka.producer.KafkaProducer;

@RestController
@RequestMapping("/api/kafka")
public class MessageController {
	
	@Autowired
	private KafkaProducer kp;
	
	
	//http:localhost:8080/api/kafka/publish?message=hello world
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message){
		kp.sendMessage(message);
		return ResponseEntity.ok("Message sent sucessfully");
	}

}
