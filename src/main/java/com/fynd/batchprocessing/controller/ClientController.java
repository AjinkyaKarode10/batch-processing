package com.fynd.batchprocessing.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fynd.batchprocessing.kafkautility.BatchProducer;
import com.fynd.batchprocessing.pojo.CustomerPayload;

@RestController
public class ClientController {

	
    @Autowired
    BatchProducer producer;
   
    private static final Logger LOGGER=LoggerFactory.getLogger(ClientController.class);
    
    @PostMapping("/publish")
    public void messageToTopic(@RequestBody CustomerPayload payload){
//@RequestParam("message") String message
    	LOGGER.info("Received request");
        this.producer.sendMessage(payload);


    }
    
    
	/*
	 * private final Producer producer;
	 * 
	 * @Autowired public TestController(Producer producer) { this.producer =
	 * producer; }
	 * 
	 * @PostMapping("/publish") public void messageToTopic(@RequestParam("message")
	 * String message){
	 * 
	 * this.producer.sendMessage(message);
	 * 
	 * 
	 * }
	 */
}
