package com.example.servingwebcontent.Ray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")//進入此網址 http://localhost:8080/Ray_greeting
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,Model model) {
        model.addAttribute("name", name);
        return "Ray/greeting";   //呼叫此html檔案 在src/main/resources/templates/Ray/greeting.html
        }

    @GetMapping("/add_page")
    @ResponseBody
    public Person add_page() {
        Person person = new Person();
        person.setName("Alice");
        person.setAge(30);
        return person;
    }

    @GetMapping("/test")
    public String test(@RequestParam(name="name", required=false, defaultValue="World") String name,@RequestParam( required=false, defaultValue="World") String getValue, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("getValue", getValue);
        return "test";
    }
}

