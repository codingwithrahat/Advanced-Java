package com.turtlesltd.productshop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cake {

    @Id
    @NotNull(message = "Order ID is required")
    @Size(min = 1, max = 100, message = "Order ID must be between 1 and 100 characters")
    private int id;

    @NotBlank(message = "Customer name can't be blank")
    private String customerName;

    @NotBlank(message = "Phone number can't be blank")
    private String phone;

    @NotBlank(message = "Cake flavor can't be blank")
    private String flavor;

    @NotNull(message = "Cake weight is required")
    @Positive(message = "Cake weight must be greater than 0")
    @DecimalMin(value = "0.0", message = "Price cannot be negative")
    private Double weight;
}