package com.example.hotelbooking;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hotelbooking.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}