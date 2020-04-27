package com.onlyfullstack.springkafkaapp.consumers;

import com.onlyfullstack.springkafkaapp.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SimpleConsumer {
    @KafkaListener(id = "simple-string-consumer", topics = "simple-string-topic", groupId = "group_id",
            containerFactory = "stringKafkaListenerContainerFactory")
    public void consumeMessage(String message) {
        log.info("Consumer got Simple String message: {}", message);
    }

    @KafkaListener(id = "complex-object-consumer", topics = "complex-object-student-topic",
            containerFactory = "studentKafkaListenerFactory", groupId = "group_json")
    public void consumeMessage(Student student) {
        log.info("Consumer got Student message: {}", student);
    }
}
