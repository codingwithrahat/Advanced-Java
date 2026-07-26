package com.turtlesltd.productshopdatabase;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name can't blank")
    private String name;

    @NotEmpty
    private String category;

    @NotNull(message = "Stock is required")
    @PositiveOrZero(message = "Stock can not be zero")
    private int stock;

    @NotNull(message = "price is required")
    private double price;
}