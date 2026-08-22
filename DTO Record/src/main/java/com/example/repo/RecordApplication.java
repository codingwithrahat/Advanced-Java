package com.example.repo;

import com.example.repo.dto.StudentGpa;
import com.example.repo.practice.User;
import com.example.repo.practice.UserDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecordApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecordApplication.class, args);


        Student student = new Student();
        student.setId(1);
        student.setName("Rahat");
        student.setGpa(3.91);

        StudentGpa stuRecord = new StudentGpa(student.getName(), student.getGpa());

        StudentGpa stu2Record = new StudentGpa("Rakib", 3.92);

        IO.println(stuRecord.name()); //no need setter or getter


        //practice
        User user = new User();

        user.setId("1");
        user.setName("Rahat");
        user.setEmail("d");
        user.setPhn("3");
        user.setPass("3");


        UserDto response = new UserDto(user.getName(), user.getEmail(), user.getPhn());

        IO.println(response.email() + response.phn() + response.name());




    }

}
