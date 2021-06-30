package com.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class SpringdemoApplication  { //implements ApplicationRunner
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send("tutorialspoint", msg);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringdemoApplication.class, args);
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        System.out.println("hELLO");
//        sendMessage("Hi Welcome to Spring For Apache Kafka");
//    }

    @Scheduled(initialDelay = 10000, fixedDelay = 5000)
    public void sendMessage() {
        sendMessage("Hi Welcome to Spring For Apache Kafka");
    }
}
