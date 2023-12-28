package com.example.servingwebcontent.LuXuaU.controller;

import com.example.servingwebcontent.LuXuaU.user.Member;
import com.example.servingwebcontent.LuXuaU.user.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;


@Controller
public class HomeController {

    private final MemberService memberService;

    @Autowired
    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public ModelAndView greeting() {
        ModelAndView modelAndView = new ModelAndView("/index");
        // Get distinct category

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String memberEmail = authentication.getName();

        if(memberEmail.equals("anonymousUser")){
            modelAndView.addObject("identity", "");
            return modelAndView;
        }
        Member member = memberService.findByEmail(memberEmail);
        modelAndView.addObject("identity", member.getIdentity());
        return modelAndView;
    }

//    @GetMapping("/")
//    public String greeting() {
//        return "/index";
//    }
}
