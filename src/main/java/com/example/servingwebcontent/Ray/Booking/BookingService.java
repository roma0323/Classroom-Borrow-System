package com.example.servingwebcontent.Ray.Booking;

import com.example.servingwebcontent.Daniel.Classroom.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, ClassroomRepository classroomRepository){
        this.bookingRepository = bookingRepository;
    }


    public List<Booking> findAll() {
        System.out.println("Hello, world!");

        return bookingRepository.findAll();}

    public void save(Booking newBooking){
        bookingRepository.save(newBooking);
    }

    public void deleteById(Long equipmentId){
        bookingRepository.deleteById(equipmentId);
    }

    public Optional<Booking> findById(Long id_booking){
        System.out.println(bookingRepository.findById(id_booking));
        System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkk");

        return bookingRepository.findById(id_booking);
    }

    public boolean tell_overlap(Booking newBooking,Booking existingBooking){
        return newBooking.getStart_time().isAfter(existingBooking.getEnd_time())|| newBooking.getEnd_time().isBefore(existingBooking.getStart_time())||newBooking.getStart_time().isEqual(existingBooking.getEnd_time())|| newBooking.getEnd_time().isEqual(existingBooking.getStart_time());
    }


}
