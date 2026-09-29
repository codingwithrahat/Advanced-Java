package com.example.travelplannerrest.repository;

import com.example.travelplannerrest.model.TravelPlan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRepository extends MongoRepository<TravelPlan, String> {
    List<TravelPlan> findByStatus(String status);
}
