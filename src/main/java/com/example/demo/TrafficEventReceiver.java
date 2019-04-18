package com.example.demo;

import com.example.demo.domain.TrafficEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;


@Component
@EnableBinding(Sink.class)
public class TrafficEventReceiver {

	private static final Logger logger = LoggerFactory.getLogger(TrafficEvent.class);

	@StreamListener(Sink.INPUT)
	public void consumeEvent(TrafficEvent event) {
		logger.info("Received event: {}", event);
	}


}
