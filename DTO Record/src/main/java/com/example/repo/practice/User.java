package com.example.repo.practice;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    String id;
    String name;
    String email;
    String phn;
    String pass;
}
