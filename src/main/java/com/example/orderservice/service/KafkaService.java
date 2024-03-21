package com.example.orderservice.service;

import org.apache.hc.core5.http.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.orderservice.config.AppConstants;

@Service
public class KafkaService {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	Logger logger = LoggerFactory.getLogger(KafkaService.class);
	
	public boolean updateLocation(String location) {
		this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME, location);
		logger.info("Message produced");
		return true;
	}
	
}
