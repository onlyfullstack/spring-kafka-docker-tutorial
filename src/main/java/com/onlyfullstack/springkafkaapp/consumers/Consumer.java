package com.onlyfullstack.springkafkaapp.consumers;

import com.onlyfullstack.springkafkaapp.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Consumer {
    @KafkaListener(id = "simple-string-consumer", topics = "simple-string-topic", groupId = "group_id")
    public void consumeMessage(String message) {
        log.info("Consumer got Simple String message: {}", message);
    }


    // group id is used to send the message to only one consumer per group
    // here it only 2 consumer will rcv the message.
    @KafkaListener(id = "complex-object-consumer", topics = "complex-object-student-topic", groupId = "group_json"
    , containerFactory = "studentKafkaListenerFactory")
    public void consumeMessage(Student student) {
        log.info("Consumer got Student message: {}", student);
    }

    @KafkaListener(id = "complex-object-consumer1", topics = "complex-object-student-topic", groupId = "group_json1"
            , containerFactory = "studentKafkaListenerFactory")
    public void consumeMessage1(Student student) {
        log.info("Consumer got Student message: {}", student);
    }

    @KafkaListener(id = "complex-object-consumer2", topics = "complex-object-student-topic", groupId = "group_json1"
            , containerFactory = "studentKafkaListenerFactory")
    public void consumeMessage2(Student student) {
        log.info("Consumer got Student message: {}", student);
    }
}
