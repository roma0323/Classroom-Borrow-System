package com.example.servingwebcontent.WayLun.Borrow;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Borrow")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "borrow_sequence")
    @SequenceGenerator(name = "borrow_sequence", sequenceName = "borrow_sequence", allocationSize = 1)
    @Column(name = "id_borrow")
    private long id_borrow;

    @Column(name = "timestamp")
    private Date timestamp;

    private String name;

    private String identity;

    @Column(name = "departmentGrade")
    private String departmentGrade;

    private String phone;

    @Column(name = "identitycard")
    private String identitycard;

    private String status;

    // Constructors
    public Borrow() {
        // Default constructor
    }

    public Borrow(long id_borrow, Date timestamp, String name, String identity, String departmentGrade,
                  String phone, String identitycard, String status) {
        this.id_borrow = id_borrow;
        this.timestamp = timestamp;
        this.name = name;
        this.identity = identity;
        this.departmentGrade = departmentGrade;
        this.phone = phone;
        this.identitycard = identitycard;
        this.status = status;
    }

    // Getters and Setters
    public long getId_borrow() {
        return id_borrow;
    }

    public void setId_borrow(long id_borrow) {
        this.id_borrow = id_borrow;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getDepartmentGrade() {
        return departmentGrade;
    }

    public void setDepartmentGrade(String departmentGrade) {
        this.departmentGrade = departmentGrade;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentitycard() {
        return identitycard;
    }

    public void setIdentitycard(String identitycard) {
        this.identitycard = identitycard;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString method
    @Override
    public String toString() {
        return "Borrow{" +
                "id_borrow=" + id_borrow +
                ", timestamp=" + timestamp +
                ", name='" + name + '\'' +
                ", identity='" + identity + '\'' +
                ", departmentGrade='" + departmentGrade + '\'' +
                ", phone='" + phone + '\'' +
                ", identitycard='" + identitycard + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
