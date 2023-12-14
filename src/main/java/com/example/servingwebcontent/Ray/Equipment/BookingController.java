package com.example.servingwebcontent.Ray.Equipment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping
    public List<Booking> getEquipment(){
        return bookingService.findAll();
    }

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("Daniel/findAllEquipment");

        // Retrieve data from MySQL and add it to the model
        Iterable<Booking> equipmentList = bookingService.findAll();
        modelAndView.addObject("equipmentList", equipmentList);
        return modelAndView;
    }

    @PostMapping("/addNewEquipment")
    public String addNewEquipment(Booking newBooking){
        bookingService.save(newBooking);
        return "redirect:/equipment/findAll";
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
