package com.example.servingwebcontent.Ray.Booking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/booking")
public class BookingController {

    private final BookingService bookingService;
    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("Ray/booking/booking_list");
        // Retrieve data from MySQL and add it to the model

        Iterable<Booking> bookingList = bookingService.findAll();
//        Classroom classroom = classroomService.findById();
        modelAndView.addObject("bookingList", bookingList);
//        modelAndView.addObject("classroom", classroom);
        return modelAndView;
    }

    @GetMapping("/booking_detail")
    public ModelAndView bookingDetail(@RequestParam Long id_booking) {
        ModelAndView modelAndView = new ModelAndView("Ray/booking/booking_detail");
        Optional<Booking> optionalEquipment = bookingService.findById(id_booking);
        Booking booking = optionalEquipment.orElse(null); // or handle it in a way that suits your logic
        modelAndView.addObject("booking", booking);
        modelAndView.addObject("pass", "通過");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("Ray/booking/booking_add");
        Iterable<Booking> bookingList = bookingService.findAll();
        modelAndView.addObject("bookingList", bookingList);
        return modelAndView;
    }

    @PostMapping("/add")
    public String add(Booking newBooking){
        Iterable<Booking> bookingList = bookingService.findAll();
        for (Booking existingBooking : bookingList) {
            if (existingBooking.getStatus().equals("同意") && existingBooking.getId_classroom().equals(newBooking.getId_classroom()) ){
                if (tell_overlap(newBooking,existingBooking)){
                    System.out.println("nooooooo overlap"+existingBooking.getName());
                }
                else{
                    System.out.println("overlap"+existingBooking.getName());
                    return "redirect:/booking/add/error";

                }
            }
        }


        bookingService.save(newBooking);
        return "redirect:/booking/list";
    }
    @GetMapping("/add/error")
    public ModelAndView add_error() {
        ModelAndView modelAndView = new ModelAndView("Ray/booking/booking_add_overlap");
        return modelAndView;
    }
    public boolean tell_overlap(Booking newBooking,Booking existingBooking){
        return newBooking.getStart_time().isAfter(existingBooking.getEnd_time())|| newBooking.getEnd_time().isBefore(existingBooking.getStart_time())||newBooking.getStart_time().isEqual(existingBooking.getEnd_time())|| newBooking.getEnd_time().isEqual(existingBooking.getStart_time());
    }

    @PostMapping("/consent_apply")
    public String consent_apply(@RequestParam Long id_booking){
        bookingService.consent_apply(id_booking);
        return "redirect:/booking/list";
    }

    @PostMapping("/deleteBooking")
    public String deleteBooking(@RequestParam Long id_booking) {
        bookingService.deleteById(id_booking);
        return "redirect:/booking/list";
    }

    @GetMapping
    public List<Booking> getEquipment(){
        return bookingService.findAll();
    }



    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("Ray/findAllBooking");

        // Retrieve data from MySQL and add it to the model
        Iterable<Booking> bookingList = bookingService.findAll();
        modelAndView.addObject("bookingList", bookingList);

        return modelAndView;

    }



    @PostMapping("/addNewBooking")
    public String addNewBooking(Booking newBooking){
        bookingService.save(newBooking);
        return "redirect:/booking/findAll";
    }

    @PostMapping("/editBooking")
    public String editBooking(@ModelAttribute Booking updatedBooking) {
        bookingService.save(updatedBooking);
        return "redirect:/booking/findAll";
    }



}
