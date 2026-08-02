package com.example.hotelbooking;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/guests")
public class GuestController {

    private GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public String getAllGuests(Model model) {
        model.addAttribute("guests", guestService.getAllGuests());
        return "guest-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("guest", new Guest());
        return "guest-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Guest guest = guestService.getGuest(id);

        if (guest == null) {
            return "redirect:/guests";
        }

        model.addAttribute("guest", guest);
        return "guest-form";
    }

    @PostMapping("/save")
    public String saveGuest(@ModelAttribute Guest guest) {
        if (guest.getId() == null) {
            guestService.createGuest(guest);
        } else {
            guestService.updateGuest(guest.getId(), guest);
        }
        return "redirect:/guests";
    }

    @GetMapping("/delete/{id}")
    public String deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
        return "redirect:/guests";
    }
}