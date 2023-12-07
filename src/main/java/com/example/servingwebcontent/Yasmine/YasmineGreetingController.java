package com.example.servingwebcontent.Yasmine;

import com.example.servingwebcontent.Ray.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class YasmineGreetingController {

    @GetMapping("/Yasmine_greeting")//進入此網址 http://localhost:8080/Yasmine_greeting
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Yasmine") String name,Model model) {
        model.addAttribute("name", name);
        return "Yasmine/greeting";   //呼叫此html檔案 在src/main/resources/templates/Yasmine/greeting.html
    }

    @GetMapping("/Yasmine_greeting_add_page")
    @ResponseBody
    public Person add_page() {
        Person person = new Person();
        person.setName("Yasmine");
        person.setAge(30);
        return person;
    }

}

