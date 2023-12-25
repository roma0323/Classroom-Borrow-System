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
        return bookingRepository.findById(id_booking);
    }

    public boolean tell_overlap(Booking newBooking,Booking existingBooking){
        return newBooking.getStart_time().isAfter(existingBooking.getEnd_time())|| newBooking.getEnd_time().isBefore(existingBooking.getStart_time())||newBooking.getStart_time().isEqual(existingBooking.getEnd_time())|| newBooking.getEnd_time().isEqual(existingBooking.getStart_time());
    }
//    public  LocalDateTime DateTimeFormattingExample (){
//            // Assuming you have a LocalDateTime object representing December 25, 2023, at 10:31 PM
//            LocalDateTime dateTime = LocalDateTime.parse("2023-12-25T22:31");
//
//            // Define the desired format pattern
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd HH:mm");
//
//            // Format the LocalDateTime object using the defined formatter
//            String formattedDateTime = dateTime.format(formatter);
//
//            // Display the formatted date-time
//            System.out.println("Formatted Date-Time: " + formattedDateTime);
//            return formattedDateTime
//
//    }

}
