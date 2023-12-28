package com.example.servingwebcontent.LuXuaU.user;

import com.example.servingwebcontent.Daniel.Equipment.Equipment;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {


    @Query("SELECT m FROM Member m WHERE m.email = :memberEmail")
    public Member findByEmail(@Param("memberEmail") String memberEmail);


}
