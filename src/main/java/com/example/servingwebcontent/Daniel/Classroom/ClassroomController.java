package com.example.servingwebcontent.Daniel.Classroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/classroom")
public class ClassroomController {

    private final ClassroomService classroomService;

    @Autowired
    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping
    public List<Classroom> getClassroom(){
        return classroomService.findAll();
    }

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("Daniel/Classroom/findall");

        // Retrieve data from MySQL and add it to the model
        Iterable<Classroom> classroomList = classroomService.findAll();
        modelAndView.addObject("classroomList", classroomList);
        return modelAndView;
    }




    @PostMapping("/addNewClassroom")
    public String addNewClassroom(Classroom newClassroom){
        classroomService.save(newClassroom);
        return "redirect:/classroom/findAll";
    }

    @GetMapping("/edit")
    public ModelAndView editClassroomForm(@RequestParam Long classroomId) {
        ModelAndView modelAndView = new ModelAndView("image");
        Optional<Classroom> optionalClassroom = classroomService.findById(classroomId);
        Classroom classroom = optionalClassroom.orElse(null); // or handle it in a way that suits your logic
        modelAndView.addObject("classroom", classroom);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editClassroom(@ModelAttribute Classroom updatedClassroom) {
        classroomService.save(updatedClassroom);
        return "redirect:/classroom/findAll";
    }

    @PostMapping("/delete")
    public String deleteClassroom(@RequestParam Long classroomId) {
        classroomService.deleteById(classroomId);
        return "redirect:/classroom/findAll";
    }





}
