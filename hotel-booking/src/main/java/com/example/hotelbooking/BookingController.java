package com.example.hotelbooking;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public String getAllBookings(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        return "booking-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("booking", new Booking());
        return "booking-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Booking booking = bookingService.getBooking(id);

        if (booking == null) {
            return "redirect:/bookings";
        }

        model.addAttribute("booking", booking);
        return "booking-form";
    }

    @PostMapping("/save")
    public String saveBooking(@ModelAttribute Booking booking) {
        if (booking.getId() == null) {
            bookingService.createBooking(booking);
        } else {
            bookingService.updateBooking(booking.getId(), booking);
        }
        return "redirect:/bookings";
    }

    @GetMapping("/delete/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return "redirect:/bookings";
    }
}