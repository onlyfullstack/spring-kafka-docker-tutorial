package com.onlyfullstack.springkafkaapp.models;

import lombok.Data;

@Data
public class Address {
    private String addressLine1;
    private String zipCode;
    private String country;
}
