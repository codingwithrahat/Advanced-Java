package org.trutlesltd.practicemidproductshop;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @NotBlank(message = "id laghbe")
    @Size(min = 1, max= 3)
    private String id;
    @NotBlank(message = "name laghbe")
    private String name;
    @NotBlank(message = "category laghbe")
    private String category;

    @PositiveOrZero
    private double stock;
    @DecimalMin("0.0")
    private double price;
}
