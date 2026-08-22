package com.example.auth;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private  static List<User> users = new ArrayList<>();

    public void signup(User user){
        users.add(user);
        IO.println("user signed up" + user.getEmail());
    }
}
