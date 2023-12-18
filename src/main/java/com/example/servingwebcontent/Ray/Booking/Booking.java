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

    private String idStudent;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "bookingReason")
    private String bookingReason;

    @Column(name = "idClassroom")
    private Integer idClassroom;

    @Column(name = "bookingDate")
    private Date bookingDate;

    @Column(name = "startTime")
    private String startTime;

    @Column(name = "endTime")
    private String endTime;

    @Column(name = "status")
    private String status;

    @Column(name = "id_borrow")
    private Integer idBorrow;

    // Constructors
    public Booking() {
        // Default constructor
    }

    public Booking(long id_booking, String name, String identity, String idStudent, String email,
                   String phone, String bookingReason, Integer idClassroom, Date bookingDate,
                   String startTime, String endTime, String status, Integer idBorrow) {
        this.id_booking = id_booking;
        this.name = name;
        this.identity = identity;
        this.idStudent = idStudent;
        this.email = email;
        this.phone = phone;
        this.bookingReason = bookingReason;
        this.idClassroom = idClassroom;
        this.bookingDate = bookingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.idBorrow = idBorrow;
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

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
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

    public String getBookingReason() {
        return bookingReason;
    }

    public void setBookingReason(String bookingReason) {
        this.bookingReason = bookingReason;
    }

    public Integer getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(Integer idClassroom) {
        this.idClassroom = idClassroom;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIdBorrow() {
        return idBorrow;
    }

    public void setIdBorrow(Integer idBorrow) {
        this.idBorrow = idBorrow;
    }

// toString() method remains unchanged

    // toString method
    @Override
    public String toString() {
        return "Booking{" +
                "id_booking=" + id_booking +
                ", name='" + name + '\'' +
                ", identity='" + identity + '\'' +
                ", idStudent='" + idStudent + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", bookingReason='" + bookingReason + '\'' +
                ", idClassroom=" + idClassroom +
                ", bookingDate=" + bookingDate +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", status='" + status + '\'' +
                ", idBorrow=" + idBorrow +
                '}';
    }
}
