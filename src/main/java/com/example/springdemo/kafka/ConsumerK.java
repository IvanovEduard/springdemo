package com.example.springdemo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by Eduard Ivanov on 6/30/21
 */
@Component
public class ConsumerK {
    @KafkaListener(topics = "tutorialspoint", groupId = "group-id")
    public void listen(String message) {
        System.out.println("Received Messasge in group - group-id: " + message);
    }
}
