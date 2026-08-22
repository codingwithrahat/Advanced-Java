package com.example.repo.dto;

public record StudentGpa(
        String name,
        double gpa
) {


    public StudentGpa{
        name = name.toUpperCase();
        gpa = 4;
    }
}
