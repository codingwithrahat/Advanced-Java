package com.example.travelplannerrest;

import com.example.travelplannerrest.model.User;
import com.example.travelplannerrest.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void createUserTest(){
        User user = User.builder().name("Rahat")
                .email("rahat@gmail.com")
                .hashPassword("1234")
                .build();

        userRepository.save(user);

        assertEquals("Rahat", user.getName());
    }
}
