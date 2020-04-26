package com.onlyfullstack.springkafkaapp.models;

import lombok.Data;

@Data
public class Student {

    private String name;
    private Double marks;
    private Address address;
}
