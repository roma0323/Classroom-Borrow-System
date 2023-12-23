package com.example.servingwebcontent.LuXuaU.user;

import com.example.servingwebcontent.Daniel.Equipment.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public List<Member> findAll() {return memberRepository.findAll();}

    public void save(Member newMember){ memberRepository.save(newMember); }

    public void deleteById(Long id_member){
        memberRepository.deleteById(id_member);
    }

    public Optional<Member> findById(Long id_member){
        return memberRepository.findById(id_member);
    }

    public Member findByEmail(String email) { return memberRepository.findByEmail(email); }
}
