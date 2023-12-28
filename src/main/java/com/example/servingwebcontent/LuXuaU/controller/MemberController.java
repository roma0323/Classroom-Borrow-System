package com.example.servingwebcontent.LuXuaU.controller;

import com.example.servingwebcontent.LuXuaU.user.Member;
import com.example.servingwebcontent.LuXuaU.user.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/member")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> getMember(){
        return memberService.findAll();
    }

    @GetMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("LuXuaU/member/findAllMember");

        // Retrieve data from MySQL and add it to the model
        Iterable<Member> memberList = memberService.findAll();
        modelAndView.addObject("memberList", memberList);
        return modelAndView;
    }

    @PostMapping("/addNewMember")
    public String addNewMember(Member newMember){
        memberService.save(newMember);
        return "redirect:/member/findAll";
    }

    @GetMapping("/resetPassword")
    public String resetPassword() {
        return "LuXuaU/member/resetPassword";
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestParam String email) {
        memberService.resetPassword(email);
        return "redirect:/login";
    }

    @GetMapping("/findMember")
    public String findMember() {
        return "LuXuaU/member/findMember";
    }

    @PostMapping("/findMember")
    public ModelAndView findMember(@RequestParam String email) {
        ModelAndView modelAndView = new ModelAndView("LuXuaU/member/findMember");

        Member member = memberService.findByEmail(email);
        System.out.println(member);
        modelAndView.addObject("member", member);
        return modelAndView;
    }

    @GetMapping("/editMember")
    public String editMemberForm() {
        return "LuXuaU/member/editMember";
    }

    @PostMapping("/editMember")
    public String editMemberForm(@RequestParam String name, String identity, String password) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String memberEmail = authentication.getName();
        Member member = memberService.findByEmail(memberEmail);
        Member updateMember = new Member(member.getId_member(), name, memberEmail, identity, password);
        memberService.save(updateMember);
        return "redirect:/";
    }

    @PostMapping("/deleteMember")
    public String deleteMember(@RequestParam Long id_member) {
        memberService.deleteById(id_member);
        return "redirect:/member/findAll";
    }
}
