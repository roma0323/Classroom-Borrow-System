package com.example.servingwebcontent.LuXuaU.controller;

import com.example.servingwebcontent.LuXuaU.user.Member;
import com.example.servingwebcontent.LuXuaU.user.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/editMember")
    public ModelAndView editMemberForm(@RequestParam Long id_member) {
        ModelAndView modelAndView = new ModelAndView("LuXuaU/member/editMember");
        Optional<Member> optionalMember = memberService.findById(id_member);
        Member member = optionalMember.orElse(null); // or handle it in a way that suits your logic
        modelAndView.addObject("member", member);
        return modelAndView;
    }

    @PostMapping("/editMember")
    public String editMemberForm(@ModelAttribute Member updatedMember) {
        memberService.save(updatedMember);
        return "redirect:/member/findAll";
    }

    @PostMapping("/deleteMember")
    public String deleteMember(@RequestParam Long id_member) {
        memberService.deleteById(id_member);
        return "redirect:/member/findAll";
    }
}
