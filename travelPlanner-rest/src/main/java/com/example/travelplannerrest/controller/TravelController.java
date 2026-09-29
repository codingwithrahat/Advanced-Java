package com.example.travelplannerrest.controller;

import com.example.travelplannerrest.model.TravelPlan;
import com.example.travelplannerrest.service.TravelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/travelplanner")
public class TravelController {
    private final TravelService travelService;

    @GetMapping("/allplan")
    public String allPlan(Model model){
        model.addAttribute("allPlan", travelService.getAllPlans());

        return "travel/list";
    }

    @GetMapping("/planByStatus")
    public String planByStatus(Model model, @RequestParam String status){
        model.addAttribute("planByStatus", travelService.getPlanByStatus(status));

        return "travel/list";
    }

    @GetMapping("/addplan")
    public String addPlan(Model model){
        model.addAttribute("travelPlan", new TravelPlan());

        return "travel/form";
    }

    @PostMapping("/addplan")
    public String addPlan(@Valid @ModelAttribute TravelPlan travelPlan, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "travel/form";
        }

        travelService.createPlan(travelPlan);

        return "redirect:/travelplanner/addplan";
    }

    @GetMapping("/updateplan/{id}")
    public String updateplan(Model model, @PathVariable String id){
        TravelPlan travelPlan = travelService.getPlanById(id);

        model.addAttribute("travelPlan", travelPlan);

        return "travel/updateform";
    }

    @PostMapping("/updateplan/{id}")
    public String updateplan(@PathVariable String id, @Valid @ModelAttribute TravelPlan travelPlan, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "travel/updateform";
        }

        travelService.updatePlan(id, travelPlan);

        return "redirect:/travelplanner/allplan";
    }

    @PostMapping("/delteplan/{id}")
    public String deleteplan(@PathVariable String id){

        travelService.deletePlan(id);

        return "redirect:/travelplanner/allplan";
    }

}
