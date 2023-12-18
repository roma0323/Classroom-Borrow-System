package com.example.servingwebcontent.Ray.Booking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
//        Iterable<OtherTableData> otherTableData = otherTableService.findAll(); // Change this line as per your service method
//        modelAndView.addObject("otherTableData", otherTableData);
        return modelAndView;

    }

    @PostMapping("/addNewBooking")
    public String addNewBooking(Booking newBooking){
        bookingService.save(newBooking);
        return "redirect:/booking/findAll";
    }

    @GetMapping("/editEquipment")
    public ModelAndView editEquipmentForm(@RequestParam Long equipmentId) {
        ModelAndView modelAndView = new ModelAndView("Daniel/editEquipment");
        Optional<Booking> optionalEquipment = bookingService.findById(equipmentId);
        Booking booking = optionalEquipment.orElse(null); // or handle it in a way that suits your logic
        modelAndView.addObject("equipment", booking);
        return modelAndView;
    }

    @PostMapping("/editEquipment")
    public String editEquipment(@ModelAttribute Booking updatedBooking) {
        bookingService.save(updatedBooking);
        return "redirect:/equipment/findAll";
    }

    @PostMapping("/deleteEquipment")
    public String deleteEquipment(@RequestParam Long equipmentId) {
        bookingService.deleteById(equipmentId);
        return "redirect:/equipment/findAll";
    }

}
