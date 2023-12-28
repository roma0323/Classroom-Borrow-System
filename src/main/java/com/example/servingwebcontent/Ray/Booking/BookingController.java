package com.example.servingwebcontent.Ray.Booking;


import com.example.servingwebcontent.Daniel.Classroom.Classroom;
import com.example.servingwebcontent.Daniel.Classroom.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final ClassroomService classroomService;
    @Autowired
    public BookingController(BookingService bookingService,ClassroomService classroomService) {
        this.bookingService = bookingService;
        this.classroomService = classroomService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("Ray/booking/booking_list");
        Iterable<Booking> bookingList = bookingService.findAll();

        for (Booking booking : bookingList) {
            Optional<Classroom> optionalClassroom = classroomService.findById(booking.getId_classroom());
            Classroom classroom = optionalClassroom.orElse(null);

            booking.setHold_classroom_name(classroom.getName());
        }

        modelAndView.addObject("bookingList", bookingList);
        return modelAndView;
    }

    @GetMapping("/booking_detail")
    public ModelAndView bookingDetail(@RequestParam Long id_booking) {
        ModelAndView modelAndView = new ModelAndView("Ray/booking/booking_detail");
        Optional<Booking> optionalEquipment = bookingService.findById(id_booking);
        Booking booking = optionalEquipment.orElse(null); // or handle it in a way that suits your logic
        Optional<Classroom> optionalClassroom = classroomService.findById(booking.getId_classroom());
        Classroom classroom = optionalClassroom.orElse(null);

        booking.setHold_classroom_name(classroom.getName());
        modelAndView.addObject("booking", booking);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add(@RequestParam(value = "start_time", required = false) String start_time,
                            @RequestParam(value = "end_time", required = false) String end_time) {
        ModelAndView modelAndView = new ModelAndView("Ray/booking/booking_add");
        if(start_time!=null){
            modelAndView.addObject("start_time", start_time.substring(0, start_time.length() - 9));
            modelAndView.addObject("end_time", end_time.substring(0, start_time.length() - 9));
        }
        Iterable<Classroom> classroomList = classroomService.findAll();
        modelAndView.addObject("classroomList", classroomList);

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String memberEmail = authentication.getName();
        modelAndView.addObject("memberEmail", memberEmail);

        return modelAndView;
    }

    @PostMapping("/add")
    public String add(Booking newBooking){
        Iterable<Booking> bookingList = bookingService.findAll();
        for (Booking existingBooking : bookingList) {
            if (existingBooking.getStatus().equals("同意") && existingBooking.getId_classroom().equals(newBooking.getId_classroom()) ){
                if (bookingService.tell_overlap(newBooking,existingBooking)){
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


    @PostMapping("/consent_apply")
    public String consent_apply(@RequestParam Long id_booking){

        Optional<Booking> optionalBooking = bookingService.findById(id_booking);
        Booking booking = optionalBooking.orElse(null); // or handle it in a way that suits your logic
        assert booking != null;

        Iterable<Booking> bookingList = bookingService.findAll();
        for (Booking existingBooking : bookingList) {
            if (existingBooking.getStatus().equals("同意") && existingBooking.getId_classroom().equals(booking.getId_classroom())) {
                if (bookingService.tell_overlap(booking, existingBooking)) {
                    System.out.println("nooooooo overlap" + existingBooking.getName());
                } else {
                    System.out.println("overlap" + existingBooking.getName());
                    return "redirect:/booking/add/error";

                }
            }
        }
        booking.setStatus("同意");
        bookingService.save(booking);
        return "redirect:/booking/list";
    }

    @PostMapping("/deleteBooking")
    public String deleteBooking(@RequestParam Long id_booking,@RequestParam String email,@RequestParam String hold_classroom_name,@RequestParam String start_time,@RequestParam String end_time,@RequestParam String emailType) {
        bookingService.delete_booking_notify(email,hold_classroom_name,start_time,end_time,emailType);


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
