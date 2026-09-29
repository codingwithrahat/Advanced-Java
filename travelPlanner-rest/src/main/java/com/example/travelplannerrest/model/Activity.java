package com.example.travelplannerrest.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    @NotNull(message = "Day is rwquired")
    @Min(value = 1, message = "Day Must be at least 1")
    private Long day;

    @NotBlank(message = "Place is required")
    @Size(min = 2, max = 100, message = "Place must be between 2 and 100 characters")
    private String place;

    @NotBlank(message = "Time is required")
    private String time;

    @Size(max = 500, message = "Note cannot exceed 500 characters")
    private String note;

}
