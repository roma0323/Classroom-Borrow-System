package com.example.servingwebcontent.WayLun.Borrow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/borrow")
public class BorrowController {

    private final BorrowService borrowService;

    @Autowired
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("WayLun/findAllBorrow");

        // Retrieve data from MySQL and add it to the model
        Iterable<Borrow> borrowList = borrowService.findAll();
        modelAndView.addObject("borrowList", borrowList);

        return modelAndView;
    }

    @GetMapping("/addNewBorrow")
    public ModelAndView addNewBorrowForm() {
        ModelAndView modelAndView = new ModelAndView("WayLun/Borrow");
        modelAndView.addObject("borrow", new Borrow());
        return modelAndView;
    }

    @PostMapping("/addNewBorrow")
    public String addNewBorrow(Borrow newBorrow) {
        borrowService.save(newBorrow);
        return "redirect:/borrow/Borrow";
    }

    @GetMapping("/editBorrow")
    public ModelAndView editBorrowForm(@RequestParam Long borrowId) {
        ModelAndView modelAndView = new ModelAndView("WayLun/editBorrow");
        Optional<Borrow> optionalBorrow = borrowService.findById(borrowId);
        Borrow borrow = optionalBorrow.orElse(null);
        modelAndView.addObject("borrow", borrow);
        return modelAndView;
    }

    @PostMapping("/editBorrow")
    public String editBorrow(@ModelAttribute Borrow updatedBorrow) {
        borrowService.save(updatedBorrow);
        return "redirect:/borrow/findAll";
    }

    @PostMapping("/deleteBorrow")
    public String deleteBorrow(@RequestParam Long borrowId) {
        borrowService.deleteById(borrowId);
        return "redirect:/borrow/findAll";
    }

    @GetMapping("/details/{id}")
    public ModelAndView showBorrowDetails(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("WayLun/borrowDetails");

        Optional<Borrow> optionalBorrow = borrowService.findById(id);
        Borrow borrow = optionalBorrow.orElse(null);

        modelAndView.addObject("borrow", borrow);

        return modelAndView;
    }
}
