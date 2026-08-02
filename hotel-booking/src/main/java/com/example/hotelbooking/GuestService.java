package com.example.hotelbooking;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public Guest createGuest(Guest guestReq) {
        return guestRepository.save(guestReq);
    }

    public Guest getGuest(Long id) {
        return guestRepository.findById(id).orElse(null);
    }

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Guest updateGuest(Long id, Guest guestReq) {
        Optional<Guest> existingGuest = guestRepository.findById(id);
        if (existingGuest.isEmpty()) return null;
        Guest updatedGuest = existingGuest.get();
        updatedGuest.setName(guestReq.getName());
        updatedGuest.setEmail(guestReq.getEmail());
        updatedGuest.setMobile(guestReq.getMobile());
        updatedGuest.setPassportNumber(guestReq.getPassportNumber());
        updatedGuest.setPassportExpiryDate(guestReq.getPassportExpiryDate());
        updatedGuest.setPassportCountry(guestReq.getPassportCountry());
        updatedGuest.setSeaView(guestReq.isSeaView());
        updatedGuest.setExtraBed(guestReq.isExtraBed());
        return guestRepository.save(updatedGuest);
    }

    public boolean deleteGuest(Long id) {
        if (!guestRepository.existsById(id)) {
            return false;
        }
        guestRepository.deleteById(id);
        return true;
    }
}