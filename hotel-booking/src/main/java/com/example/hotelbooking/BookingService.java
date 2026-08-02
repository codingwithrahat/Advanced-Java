package com.example.hotelbooking;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import com.example.hotelbooking.Booking;
import com.example.hotelbooking.BookingRepository;


@RequiredArgsConstructor
@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    private long calculateDays(Booking booking) {
        if (booking.getCheckInDate() == null || booking.getCheckOutDate() == null) {
            return 0;
        }
        long result = ChronoUnit.DAYS.between(booking.getCheckInDate(), booking.getCheckOutDate());
        return Math.max(result, 0);
    }

    public Booking createBooking(Booking bookingReq) {
        bookingReq.setDays(calculateDays(bookingReq));
        return bookingRepository.save(bookingReq);
    }

    public Booking getBooking(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking updateBooking(Long id, Booking bookingReq) {
        Optional<Booking> existingBooking = bookingRepository.findById(id);

        if (existingBooking.isEmpty()) return null;

        Booking updatedBooking = existingBooking.get();
        updatedBooking.setGuestName(bookingReq.getGuestName());
        updatedBooking.setGuestEmail(bookingReq.getGuestEmail());
        updatedBooking.setFloor(bookingReq.getFloor());
        updatedBooking.setRoomNumber(bookingReq.getRoomNumber());
        updatedBooking.setCheckInDate(bookingReq.getCheckInDate());
        updatedBooking.setCheckOutDate(bookingReq.getCheckOutDate());
        updatedBooking.setDays(calculateDays(bookingReq));
        updatedBooking.setAmount(bookingReq.getAmount());
        updatedBooking.setPaymentStatus(bookingReq.getPaymentStatus());

        return bookingRepository.save(updatedBooking);
    }

    public boolean deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            return false;
        }
        bookingRepository.deleteById(id);
        return true;
    }
}