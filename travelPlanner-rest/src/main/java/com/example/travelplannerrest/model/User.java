package com.example.travelplannerrest.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;

    @NotBlank(message = "need name")
    private String name;

    @NotBlank(message = "need email")
    private String email;

    @NotBlank(message = "need pass")
    private String hashPassword;

    private List<String> roles = new ArrayList<>();
}
