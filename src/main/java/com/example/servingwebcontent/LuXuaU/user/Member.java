package com.example.servingwebcontent.LuXuaU.user;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "Member")
public class Member {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    @Column(name = "id_member")
    private long id_member;
    private String name;
    private String email;
    private String identity;
    private String password;

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @PrePersist
    public void prePersist() {
        this.password = passwordEncoder.encode(this.password);
    }

    public Member(long id_member, String name, String email, String identity, String password) {
        this.id_member = id_member;
        this.name = name;
        this.email = email;
        this.identity = identity;
        this.password = password;
    }

    public Member(){

    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getIdentity(){
        return identity;
    }

    public String getPassword() {
        return password;
    }

    public long getId_member() {
        return id_member;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId_member(long id_member) {
        this.id_member = id_member;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id_member=" + id_member +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", identity='" + identity + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
