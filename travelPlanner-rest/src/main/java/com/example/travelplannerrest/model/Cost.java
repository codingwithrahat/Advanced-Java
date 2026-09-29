package com.example.travelplannerrest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cost {

    private String category;

    private Double amount;

    private String description;
}
