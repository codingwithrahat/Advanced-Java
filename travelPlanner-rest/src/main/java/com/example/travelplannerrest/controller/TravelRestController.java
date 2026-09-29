package com.example.travelplannerrest.controller;

import com.example.travelplannerrest.model.TravelPlan;
import com.example.travelplannerrest.service.TravelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/travelplanner")
public class TravelRestController {
    private final TravelService travelService;

    @GetMapping("/allplan")
    public List<TravelPlan> allPlan(){
        return travelService.getAllPlans();
    }

    @GetMapping("/planByStatus")
    public List<TravelPlan> planByStatus(@RequestParam String status){
        return travelService.getPlanByStatus(status);
    }

    @PostMapping("/addplan")
    public TravelPlan addPlan(@Valid @RequestBody TravelPlan travelPlan){
        return travelService.createPlan(travelPlan);
    }

    @PutMapping("/updateplan/{id}")
    public TravelPlan updatePlan(@PathVariable String id,@Valid @RequestBody TravelPlan travelPlan){
        return travelService.updatePlan(id, travelPlan);
    }

    @DeleteMapping("/deleteplan/{id}")
    public void deletePlan(@PathVariable String id){
        travelService.deletePlan(id);
    }
}
