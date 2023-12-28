package com.example.servingwebcontent.Ray.Booking;

import com.example.servingwebcontent.LuXuaU.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final MailService mailService;

    @Autowired
    public BookingService(BookingRepository bookingRepository, MailService mailService){
        this.bookingRepository = bookingRepository;
        this.mailService = mailService;
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
    public void delete_booking_notify(String email, String hold_classroom_name, String start_time, String end_time,String emailType){
        mailService.sendPlainText(email, "預約失敗通知",
                "教室："+hold_classroom_name+
                        "\n時段："+start_time+"到"+end_time+
                        "\n預約失敗"+
                        "\n失敗原因："+emailType
                );
    }

}
