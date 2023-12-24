package com.example.servingwebcontent.LuXuaU.controller;

import com.example.servingwebcontent.LuXuaU.user.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "LuXuaU/login/login";
    }
}
