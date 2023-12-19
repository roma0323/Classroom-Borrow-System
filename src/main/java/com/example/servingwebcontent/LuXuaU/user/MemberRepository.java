package com.example.servingwebcontent.LuXuaU.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
//    @Query("SELECT m FROM Member m WHERE m.name = :memberName")
//    public Member getMemberByName(@Param("memberName") String memberName);

}
