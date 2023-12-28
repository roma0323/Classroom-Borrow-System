package com.example.servingwebcontent.WayLun.BorrowEquipment;

import com.example.servingwebcontent.Daniel.Equipment.Equipment;
import com.example.servingwebcontent.WayLun.Borrow.BorrowService;
import com.example.servingwebcontent.Daniel.Equipment.EquipmentService;
import com.example.servingwebcontent.WayLun.BorrowForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/borrorequipment")
public class BorrowEquipmentController {

    private final BorrowEquipmentService borrowEquipmentService;
    private final BorrowService borrowService;
    private final EquipmentService equipmentService;

    @Autowired
    public BorrowEquipmentController(BorrowEquipmentService borrowEquipmentService, BorrowService borrowService, EquipmentService equipmentService) {
        this.borrowEquipmentService = borrowEquipmentService;
        this.borrowService = borrowService;
        this.equipmentService = equipmentService;
    }

    /*@GetMapping("/addNewBorrowEquipment")
    public ModelAndView addNewBorrowEquipment(Model model) {
        ModelAndView modelAndView = new ModelAndView("Borrow2");
        modelAndView.addObject("borrowForm", new BorrowForm());

        Iterable<Equipment> equipments = equipmentService.findAll();
        modelAndView.addObject("equipments", equipments);
        return modelAndView;
    }

    @PostMapping("/addNewBorrowEquipment")
    public String addNewBorrowEquipment(@ModelAttribute("borrowForm") BorrowForm borrowForm) {
        borrowService.save(borrowForm.getBorrow());
        borrowForm.getBorrowEquipment().setBorrow(borrowForm.getBorrow());
        borrowForm.getBorrowEquipment().setEquipment(borrowForm.getEquipment());
        borrowEquipmentService.save(borrowForm.getBorrowEquipment());
        return "redirect:/borrorequipment/addNewBorrowEquipment";
    }*/

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("WayLun/BorrowEquipment");

        Iterable<BorrowEquipment> borrowEquipments = borrowEquipmentService.getBorrowEquipment();
        modelAndView.addObject("borrowEquipments", borrowEquipments);
        return modelAndView;
    }
}
