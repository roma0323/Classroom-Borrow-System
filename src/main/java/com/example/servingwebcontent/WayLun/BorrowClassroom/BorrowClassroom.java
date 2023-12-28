package com.example.servingwebcontent.WayLun.BorrowClassroom;

import com.example.servingwebcontent.Daniel.Classroom.Classroom;
import jakarta.persistence.*;
import java.util.Date;

import com.example.servingwebcontent.WayLun.Borrow.Borrow;

@Entity
public class BorrowClassroom {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "borrowclassroom_sequence")
    @SequenceGenerator(name = "borrowclassroom_sequence", sequenceName = "borrowclassroom_sequence", allocationSize = 1)
    @Column(name = "id_borrow_classroom")
    private long id_borrow_classroom;

    @ManyToOne
    @JoinColumn(name = "id_borrow")
    private Borrow borrow;

    @ManyToOne
    @JoinColumn(name = "id_classroom")
    private Classroom classroom;

    @Column(name = "timestamp")
    private Date timestamp;

    private String teacher;

    private String note;

    private String purpose;

    // Constructors
    public BorrowClassroom() {
        this.timestamp = new Date();

    }

    public BorrowClassroom(long id_borrow_classroom, Borrow borrow, Classroom classroom,Date timestamp, String teacher, String note, String purpose) {
        this.id_borrow_classroom = id_borrow_classroom;
        this.borrow = borrow;
        this.classroom = classroom;
        this.timestamp = timestamp;
        this.teacher = teacher;
        this.note = note;
        this.purpose = purpose;
    }

    // Getters and Setters
    public long getId_borrow_classroom() {
        return id_borrow_classroom;
    }

    public void setId_borrow_classroom(long id_borrow_classroom) {
        this.id_borrow_classroom = id_borrow_classroom;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getTeacher(){
        return teacher;
    }

    public void setTeacher(String teacher){
        this.teacher = teacher;
    }

    public String getNote(){
        return note;
    }

    public void setNote(String note){
        this.note = note;
    }

    public String getPurpose(){
        return purpose;
    }

    public void setPurpose(String purpose){
        this.purpose = purpose;
    }
}
