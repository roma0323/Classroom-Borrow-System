package com.example.servingwebcontent.Daniel;

import com.example.servingwebcontent.Ray.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DanielGreetingController {

    @GetMapping("/Daniel_greeting") //進入此網址 http://localhost:8080/Daniel_greeting
    public String greeting(@RequestParam(name="name" , required=false, defaultValue="Daniel") String name,Model model) {
        model.addAttribute("name", name);
        return "Daniel/greeting";   //呼叫此html檔案 在src/main/resources/templates/Daniel/greeting.html
    }

    @GetMapping("/Daniel_greeting_add_page")
    @ResponseBody
    public Person add_page() {
        Person person = new Person();
        person.setName("Daniel");
        person.setAge(30);
        return person;
    }

}

