package com.fynd.batchprocessing.kafkautility;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fynd.batchprocessing.pojo.CustomerPayload;

@Service
public class BatchProducer {

	private static final Logger LOGGER=LoggerFactory.getLogger(BatchProducer.class);
	private static final String USER_CREATED_TOPIC = "userCreated";
	private static final String USER_MODIFIED_TOPIC = "userModified";
	private static final String USER_INVOICE_GENERATED_TOPIC = "userInvoiceGenerated";
	
//    @Autowired
//    private KafkaTemplate<String,String> kafkaTemplate;
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(CustomerPayload payload){

    	//this.kafkaTemplate.send(TOPIC, payload);
    	if(payload.getEventType().equals(USER_CREATED_TOPIC))
    	{
    		this.kafkaTemplate.send(USER_CREATED_TOPIC,payload);
    	}
    	else if(payload.getEventType().equals(USER_MODIFIED_TOPIC))
    	{
    		this.kafkaTemplate.send(USER_MODIFIED_TOPIC,payload);
    	}
    	else if(payload.getEventType().equals(USER_INVOICE_GENERATED_TOPIC))
    	{
    		this.kafkaTemplate.send(USER_INVOICE_GENERATED_TOPIC,payload);
    	}
    	
        //this.kafkaTemplate.send(TOPIC,message);
    }

//    @Bean
//    public NewTopic createTopic(){
//
//        return new NewTopic(TOPIC,3,(short) 1);
//    }
	
}
