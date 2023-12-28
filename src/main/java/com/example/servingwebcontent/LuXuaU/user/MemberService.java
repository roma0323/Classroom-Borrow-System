package com.example.servingwebcontent.LuXuaU.user;

import com.example.servingwebcontent.Daniel.Equipment.Equipment;
import com.example.servingwebcontent.LuXuaU.mail.MailService;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final MailService mailService;

    @Autowired
    public MemberService(MemberRepository memberRepository, MailService mailService){
        this.memberRepository = memberRepository;
        this.mailService = mailService;
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

    public String passwordGenerator(){
        char[][] pairs = {{'a','z'},{'A','Z'},{'0','9'}};
        int length = 16;
        RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange(pairs).build();
        String randomString = generator.generate(length);
        return randomString;
    }

    public void resetPassword(String email){
        String newPassword = passwordGenerator();
        Member member = findByEmail(email);

        if (member == null) {
            throw new UsernameNotFoundException("Could not find member");
        }
        else {
            member.setPassword(newPassword);
            System.out.print(member);
        }

        mailService.sendPlainText(email, "密碼重置通知", mailService.contentGenerator(newPassword));

        memberRepository.save(member);
    }
}
