package com.example.servingwebcontent.Ray.Booking;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Booking")
public class Booking {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_sequence")
    @SequenceGenerator(name = "booking_sequence", sequenceName = "booking_sequence",            allocationSize = 1
    )
    @Column(name = "id_Booking")
    private long id_booking;

    private String name;

    private String identity;

    private String id_student;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "booking_reason")
    private String booking_reason;

    @Column(name = "id_classroom")
    private Integer id_classroom;

    @Column(name = "booking_date")
    private Date booking_date;

    @Column(name = "start_time")
    private String start_time;

    @Column(name = "end_time")
    private String end_time;

    @Column(name = "status")
    private String status;
    @PrePersist
    protected void onCreate() {
        this.status = "未通過"; // Set the default status before persisting
    }

    @Column(name = "id_borrow")
    private Integer id_borrow;

    // Constructors
    public Booking() {
        // Default constructor
    }

    public Booking(long id_booking, String name, String identity, String id_student, String email,
                   String phone, String booking_reason, Integer id_classroom, Date booking_date,
                   String start_time, String end_time, String status, Integer id_borrow) {
        this.id_booking = id_booking;
        this.name = name;
        this.identity = identity;
        this.id_student = id_student;
        this.email = email;
        this.phone = phone;
        this.booking_reason = booking_reason;
        this.id_classroom = id_classroom;
        this.booking_date = booking_date;
        this.start_time = start_time;
        this.end_time = end_time;
        this.status = status;
        this.id_borrow = id_borrow;
    }

    // Getters and Setters
    public long getId_booking() {
        return id_booking;
    }

    public void setId_booking(long id_booking) {
        this.id_booking = id_booking;
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

    public String getId_student() {
        return id_student;
    }

    public void setId_student(String id_student) {
        this.id_student = id_student;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBooking_reason() {
        return booking_reason;
    }

    public void setBooking_reason(String booking_reason) {
        this.booking_reason = booking_reason;
    }

    public Integer getId_classroom() {
        return id_classroom;
    }

    public void setId_classroom(Integer id_classroom) {
        this.id_classroom = id_classroom;
    }

    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId_borrow() {
        return id_borrow;
    }

    public void setId_borrow(Integer id_borrow) {
        this.id_borrow = id_borrow;
    }

// toString() method remains unchanged

    // toString method
    @Override
    public String toString() {
        return "Booking{" +
                "id_booking=" + id_booking +
                ", name='" + name + '\'' +
                ", identity='" + identity + '\'' +
                ", id_student='" + id_student + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", booking_reason='" + booking_reason + '\'' +
                ", id_classroom=" + id_classroom +
                ", booking_date=" + booking_date +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", status='" + status + '\'' +
                ", id_borrow=" + id_borrow +
                '}';
    }
}
