package com.example.travelplannerrest.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelPlan {
    @Id
    private String id;

    private Long userId;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max=100, message = "Title must be between 3 and 100 characters")
    private String title;

    @NotBlank(message = "Destination is required")
    @Size(min = 2, max=100, message = "Destination must be between 2 and 100 characters")
    private String destination;

    @NotBlank(message = "Start Location is required")
    @Size(min = 2, max=100, message = "Start Location must be between 2 and 100 characters")
    private String stratLoaction;

    @NotBlank(message = "Start Date is required")
    private LocalDate startDate;

    @NotBlank(message = "End Date is required")
    private LocalDate endDate;

    @NotBlank(message = "Budget is required")
    @PositiveOrZero(message = "Budget cannot be negative")
    private Double budget;

    @NotBlank(message = "Status is required")
    private Status status;

    @NotBlank(message = "Transport Type is required")
    private Transport transportType;

    private List<Activity> activityList;

    private List<Cost> costList;



}
