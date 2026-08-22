package com.example.repo;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Student {
    private int id;
    private String name;
    private double gpa;
    private String createdBy;
    private LocalDateTime createdAt;
}
