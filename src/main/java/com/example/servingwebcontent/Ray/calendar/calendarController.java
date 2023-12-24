package com.example.servingwebcontent.Ray.calendar;

import com.example.servingwebcontent.Ray.Booking.Booking;
import com.example.servingwebcontent.Ray.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class calendarController {

    @GetMapping("/weekly_calendar")
    public String showWeeklyCalendar() {
        return "Ray/calendar/calendar"; // Return the name of the HTML file without the extension
    }

    @GetMapping("/test")
    public ModelAndView bookingDetail() {
        ModelAndView modelAndView = new ModelAndView("Ray/calendar/test_calendar");
        modelAndView.addObject("pass", "通過");
        return modelAndView;
    }
}