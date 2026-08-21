package org.trutlesltd.mid_practice_product_shop_database;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "name laghbe")
    private String name;
    @NotBlank(message = "category laghbe")
    private String category;

    @NotNull(message = "stock laghbe")
    @PositiveOrZero(message = "stock 0 er cheye boro hote hobe")
    private Double stock;

    @NotNull(message = "price laghbe")
    @DecimalMin(value = "0.0", message = "price 0.0 er cheye boro hote hobe")
    private Double price;
}
