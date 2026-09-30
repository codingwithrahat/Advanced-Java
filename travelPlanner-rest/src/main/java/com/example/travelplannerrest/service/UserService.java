package com.example.travelplannerrest.service;

import com.example.travelplannerrest.model.User;
import com.example.travelplannerrest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User registerUser(User user) {
        user.setHashPassword(passwordEncoder.encode(user.getHashPassword()));
        return userRepository.save(user);
    }
}
