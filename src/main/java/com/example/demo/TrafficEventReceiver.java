package com.example.demo;

import com.example.demo.domain.TrafficEvent;
import com.example.demo.domain.VehicleClass;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(KStreamSink.class)
public class TrafficEventReceiver {

	private static final Logger logger = LoggerFactory.getLogger(TrafficEvent.class);

	@StreamListener
	public void consumeEvent(@Input(KStreamSink.INPUT) KStream<String, TrafficEvent> stream) {
		logger.info("Received stream: {}", stream);
		stream.filter((key, event) -> VehicleClass.CAR.equals(event.getVehicleClass()))
				.print(Printed.toSysOut());
	}


}
