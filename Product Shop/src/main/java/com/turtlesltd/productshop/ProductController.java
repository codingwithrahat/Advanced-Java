package com.turtlesltd.productshop;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/cake")
public class CakeController {

    private final List<Cake> cakeOrders = new ArrayList<>();


    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("cake", new Cake());
        return "form";
    }


    @PostMapping("/add")
    public String submit(@Valid @ModelAttribute("cake") Cake cake,
                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        cakeOrders.add(cake);

        log.info("Cake Order {} has been saved.", cake);

        return "redirect:/cake/list";
    }


    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("cakes", cakeOrders);
        return "list";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable String id) {

        for (int i = 0; i < cakeOrders.size(); i++) {
//
//            if (cakeOrders.get(i).getId()) {
//                cakeOrders.remove(i);
//                break;
//            }
        }

        log.info("Cake Order with ID {} has been removed.", id);

        return "redirect:/cake/list";
    }
}