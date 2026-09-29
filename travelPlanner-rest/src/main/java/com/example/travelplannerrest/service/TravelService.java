package com.example.travelplannerrest.service;

import com.example.travelplannerrest.model.TravelPlan;
import com.example.travelplannerrest.repository.TravelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TravelService {
    private final TravelRepository travelRepository;

    @CacheEvict(value = {"travelplan", "travelplanstatus"}, allEntries = true)
    public TravelPlan createPlan(TravelPlan travelPlan){
        return travelRepository.save(travelPlan);
    }

    @Cacheable("travelplan")
    public List<TravelPlan> getAllPlans(){
        return travelRepository.findAll();
    }

    @Cacheable("travelplanstatus")
    public List<TravelPlan> getPlanByStatus(String status){
        return travelRepository.findByStatus(status);
    }

    public TravelPlan getPlanById(String id){
        return travelRepository.findById(id).orElse(null);
    }

    @CacheEvict(value = {"travelplan", "travelplanstatus"}, allEntries = true)
    public TravelPlan updatePlan(String id, TravelPlan updateTravelPlan){
        TravelPlan travelPlan = getPlanById(id);

        if(travelPlan != null){
            travelPlan.setTitle(updateTravelPlan.getTitle());
            travelPlan.setDestination(updateTravelPlan.getDestination());
            travelPlan.setStratLoaction(updateTravelPlan.getStratLoaction());
            travelPlan.setStartDate(updateTravelPlan.getStartDate());
            travelPlan.setEndDate(updateTravelPlan.getEndDate());
            travelPlan.setBudget(updateTravelPlan.getBudget());
            travelPlan.setTransportType(updateTravelPlan.getTransportType());
            travelPlan.setStatus(updateTravelPlan.getStatus());
            travelPlan.setActivityList(updateTravelPlan.getActivityList());
            travelPlan.setCostList(updateTravelPlan.getCostList());
        }

        travelRepository.save(travelPlan);

        return travelRepository.save(travelPlan);
    }

    @CacheEvict(value = {"travelplan", "travelplanstatus"}, allEntries = true)
    public void deletePlan(String id){
        travelRepository.deleteById(id);
    }





}
