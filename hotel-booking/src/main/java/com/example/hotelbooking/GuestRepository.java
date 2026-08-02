package com.example.hotelbooking;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hotelbooking.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
