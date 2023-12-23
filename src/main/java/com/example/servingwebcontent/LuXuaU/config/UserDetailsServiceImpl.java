package com.example.servingwebcontent.LuXuaU.config;

import com.example.servingwebcontent.LuXuaU.user.Member;
import com.example.servingwebcontent.LuXuaU.user.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String memberEmail) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(memberEmail);

        if (member == null) {
            throw new UsernameNotFoundException("Could not find member");
        }
        else System.out.print(member);

        return new MyUserDetails(member);
    }
}
