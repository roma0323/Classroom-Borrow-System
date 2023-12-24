package com.example.servingwebcontent.Ray.calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class calendarController {

    @GetMapping("/weekly_calendar")
    public String showWeeklyCalendar() {
        return "Ray/calendar/calendar"; // Return the name of the HTML file without the extension
    }
}