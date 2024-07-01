package com.rabbitmq.example.model;

import lombok.Data;

@Data
public class StudentModel {

    private int id;
    private String firstName;
    private String lastName;
    private String collegeName;
    private Object data;
}
