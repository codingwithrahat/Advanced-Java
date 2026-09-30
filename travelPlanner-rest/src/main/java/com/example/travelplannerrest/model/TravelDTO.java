package com.example.travelplannerrest.model;

import java.time.LocalDate;
import java.util.List;

public record TravelDTO(
        String title,
        String destination,
        String startLocation,
        String endLocation,
        LocalDate startdate,
        LocalDate endDate,
        double budget,
        Status status,
        Transport transportType,
        List<Activity> activityList,
        List<Cost> costList

) {
}
