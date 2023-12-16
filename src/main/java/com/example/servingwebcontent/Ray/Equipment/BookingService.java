package com.example.servingwebcontent.Ray.Equipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }


    public List<Booking> findAll() {return bookingRepository.findAll();}

    public void save(Booking newBooking){
        bookingRepository.save(newBooking);
    }

    public void deleteById(Long equipmentId){
        bookingRepository.deleteById(equipmentId);
    }

    public Optional<Booking> findById(Long equipmentId){
        return bookingRepository.findById(equipmentId);
    }
}
