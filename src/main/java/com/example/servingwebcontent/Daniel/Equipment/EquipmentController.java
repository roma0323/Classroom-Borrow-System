package com.example.servingwebcontent.Daniel.Equipment;


import com.example.servingwebcontent.Daniel.Equipment.Equipment;
import com.example.servingwebcontent.Daniel.Equipment.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/equipment")
public class EquipmentController {

    private final EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("Daniel/equipment/equipmentlist");
        // Retrieve data from MySQL and add it to the model
        Iterable<Equipment> equipmentList = equipmentService.findAll();
        modelAndView.addObject("equipmentList", equipmentList);
        // Get distinct category
        List<String> categories = equipmentService.findDistinctCategories();
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/addNewEquipment")
    public ModelAndView addNewEquipment(){
        ModelAndView modelAndView = new ModelAndView("Daniel/equipment/addEquipment");
        // Get distinct category
        List<String> categories = equipmentService.findDistinctCategories();
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping
    public List<Equipment> getEquipment(){
        return equipmentService.findAll();
    }

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("Daniel/findAllEquipment");

        // Retrieve data from MySQL and add it to the model
        Iterable<Equipment> equipmentList = equipmentService.findAll();
        modelAndView.addObject("equipmentList", equipmentList);
        // Get distinct category
        List<String> categories = equipmentService.findDistinctCategories();
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }
    @GetMapping("searchByCategory")
    public ModelAndView searchByCategory(@RequestParam String category) {
        ModelAndView modelAndView = new ModelAndView("Daniel/findAllEquipment");
        if (category.equals("")){
            // Retrieve data from MySQL and add it to the model
            Iterable<Equipment> equipmentList = equipmentService.findAll();
            modelAndView.addObject("equipmentList", equipmentList);
            // Get distinct category
            List<String> categories = equipmentService.findDistinctCategories();
            modelAndView.addObject("categories", categories);
            return modelAndView;
        }
//        System.out.println(category);


        Iterable<Equipment> equipmentList = equipmentService.findByCategory(category);
        modelAndView.addObject("equipmentList", equipmentList);

        // Get distinct category
        List<String> categories = equipmentService.findDistinctCategories();
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @PostMapping("/addNewEquipment")
    public String addNewEquipment(Equipment newEquipment){
        equipmentService.save(newEquipment);
        return "redirect:/equipment/list";
    }

    @GetMapping("/editEquipment")
    public ModelAndView editEquipmentForm(@RequestParam Long equipmentId) {
        ModelAndView modelAndView = new ModelAndView("Daniel/equipment/editEquipment");
        Optional<Equipment> optionalEquipment = equipmentService.findById(equipmentId);
        Equipment equipment = optionalEquipment.orElse(null); // or handle it in a way that suits your logic
        modelAndView.addObject("equipment", equipment);
        return modelAndView;
    }

    @PostMapping("/editEquipment")
    public String editEquipment(@ModelAttribute Equipment updatedEquipment) {
        equipmentService.updateEquipment(updatedEquipment);
        System.out.println("hello world");
        return "redirect:/equipment/list";
    }

    @PostMapping("/deleteEquipment")
    public String deleteEquipment(@RequestParam Long equipmentId) {
        equipmentService.deleteById(equipmentId);
        return "redirect:/equipment/list";
    }

    @GetMapping("/getEquipmentByCategory")
    public ResponseEntity<List<String>> getEquipmentByCategory(@RequestParam String category){
        List<String> labels = equipmentService.findLabelsByCategory(category);
        return new ResponseEntity<>(labels, HttpStatus.OK);
    }

}
