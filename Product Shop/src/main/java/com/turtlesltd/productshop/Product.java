package com.turtlesltd.productshop;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @NotNull(message = "ID is required")
    @Size(min=1,max=100,message = "ID must be between 1-100")
    private String id;
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