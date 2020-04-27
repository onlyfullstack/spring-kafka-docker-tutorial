package com.onlyfullstack.springkafkaapp.controllers;

import com.onlyfullstack.springkafkaapp.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/kafka")
public class ProducerController {

    private final KafkaTemplate<String, String> simpleProducer;
    private final KafkaTemplate<String, Student> studentKafkaTemplate;

    public ProducerController(KafkaTemplate<String, String> simpleProducer,
                              KafkaTemplate<String, Student> studentKafkaTemplate) {
        this.simpleProducer = simpleProducer;
        this.studentKafkaTemplate = studentKafkaTemplate;
    }

    @GetMapping(value = "/{message}")
    public String message(@PathVariable("message") String message) {
        simpleProducer.send("simple-string-topic", message);
        return "Message received: " + message;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String message(@RequestBody Student student) {
        log.debug("Received Student in controller : {}", student);
        studentKafkaTemplate.send("complex-object-student-topic", student);
        return "Message received: " + student;
    }
}
