package com.example.servingwebcontent.Ray.calendar;

import com.example.servingwebcontent.Ray.Booking.Booking;
import com.example.servingwebcontent.Ray.Booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

@Controller
public class calendarController {

    private final BookingService bookingService;
    @Autowired
    public calendarController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @GetMapping("/weekly_calendar")
    public String showWeeklyCalendar() {
        return "Ray/calendar/calendar"; // Return the name of the HTML file without the extension
    }

    @GetMapping("/test")
    public ModelAndView bookingDetail() {
        ModelAndView modelAndView = new ModelAndView("Ray/calendar/test_calendar");
        Iterable<Booking> bookingList = bookingService.findAll();
        modelAndView.addObject("bookingList", bookingList);
        List<Events> EventsList = new ArrayList<>();
        for (Booking booking : bookingList) {
            Events event = new Events();
            System.out.println(booking.getName());

            event.setTitle(booking.getName());
            event.setId(booking.getId_booking());
            event.setStart(booking.getStart_time());
            event.setEnd(booking.getEnd_time());
            EventsList.add(event);
            System.out.println("end"+event.getEnd());

        }
        modelAndView.addObject("testJson",EventsList);


        return modelAndView;
    }
}