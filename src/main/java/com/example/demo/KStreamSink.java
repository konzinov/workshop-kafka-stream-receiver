package com.example.demo;

import com.example.demo.domain.TrafficEvent;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;

public interface KStreamSink {

	static final String INPUT = "native-input";

	@Input(INPUT)
	KStream<String, TrafficEvent> input();
}
