package com.example.servingwebcontent.WayLun.Borrow;

import com.example.servingwebcontent.WayLun.BorrowClassroom.BorrowClassroom;
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

    @Column(name = "department_grade")
    private String department_grade;

    private String phone;

    @Column(name = "identitycard")
    private String identitycard;

    private String status;

    private String classroomname;

    private String category;

    private String label;

    // Constructors
    public Borrow() {
        // Default constructor
        this.timestamp = new Date();
        this.status = "審核中";
    }

    public Borrow(long id_borrow, Date timestamp, String name, String identity, String department_grade,
                  String phone, String identitycard, String status, String classroomname, String category, String label) {
        this.id_borrow = id_borrow;
        this.timestamp = timestamp;
        this.name = name;
        this.identity = identity;
        this.department_grade = department_grade;
        this.phone = phone;
        this.identitycard = identitycard;
        this.status = status;
        this.classroomname = classroomname;
        this.category = category;
        this.label = label;
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

    public String getDepartment_grade() {
        return department_grade;
    }

    public void setDepartment_grade(String department_grade) {
        this.department_grade = department_grade;
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

    public String getClassroomname(){
        return classroomname;
    }

    public void setClassroomname(String classroomname){
        this.classroomname = classroomname;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getLabel(){
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    // toString method
    @Override
    public String toString() {
        return "Borrow{" +
                "id_borrow=" + id_borrow +
                ", timestamp=" + timestamp +
                ", name='" + name + '\'' +
                ", identity='" + identity + '\'' +
                ", department_grade='" + department_grade + '\'' +
                ", phone='" + phone + '\'' +
                ", identitycard='" + identitycard + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
