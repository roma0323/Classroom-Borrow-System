package com.example.servingwebcontent.LuXuaU;

import com.example.servingwebcontent.Ray.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LuXuaUGreetingController {

    @GetMapping("/LuXuaU_greeting") //進入此網址 http://localhost:8080/LuXuaU_greeting
    public String greeting(@RequestParam(name="name", required=false, defaultValue="LuXuaU") String name,Model model) {
        model.addAttribute("name", name);
        return "LuXuaU/greeting";   //呼叫此html檔案 在src/main/resources/templates/LuXuaU/greeting.html
    }

    @GetMapping("/LuXuaU_greeting_add_page")
    @ResponseBody
    public Person add_page() {
        Person person = new Person();
        person.setName("LuXuaU");
        person.setAge(30);
        return person;
    }

}

