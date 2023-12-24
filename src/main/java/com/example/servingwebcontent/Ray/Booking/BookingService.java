package com.example.servingwebcontent.Ray.Booking;

import com.example.servingwebcontent.Daniel.Classroom.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ClassroomRepository classroomRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository, ClassroomRepository classroomRepository){
        this.bookingRepository = bookingRepository;
        this.classroomRepository = classroomRepository;
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

    public void consent_apply(Long id_booking){
//        System.out.println(bookingRepository.findById(id_booking));
        Optional<Booking> optionalEquipment = bookingRepository.findById(id_booking);
        Booking booking = optionalEquipment.orElse(null); // or handle it in a way that suits your logic
        assert booking != null;
        booking.setStatus("同意");
        bookingRepository.save(booking);
//        System.out.println(bookingRepository.findById(id_booking));

    }


}
