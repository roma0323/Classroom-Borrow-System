package com.example.servingwebcontent.WayLun.BorrowEquipment;

import com.example.servingwebcontent.Daniel.Equipment.Equipment;
import com.example.servingwebcontent.WayLun.Borrow.Borrow;
import com.example.servingwebcontent.LuXuaU.user.Member;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class BorrowEquipment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "borrowequipment_sequence")
    @SequenceGenerator(name = "borrowequipment_sequence", sequenceName = "borrowequipment_sequence", allocationSize = 1)
    @Column(name = "id_borrow_equipment")
    private long id_borrow_equipment;

    @ManyToOne
    @JoinColumn(name = "id_borrow")
    private Borrow borrow;

    @ManyToOne
    @JoinColumn(name = "id_equipment")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "id_lendby")
    private Member lendby;

    @ManyToOne
    @JoinColumn(name = "id_returnby")
    private Member returnby;

    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "returnTime")
    private Date returnTime;

    private String teacher;
    private String status;
    private String purpose;
    private String note;
    private String category;
    private String label;

    // Constructors
    public BorrowEquipment() {
        this.timestamp = new Date();
        this.status = "審核中";
    }

    public BorrowEquipment(long id_borrow_equipment, Borrow borrow, Equipment equipment, Member lendby,
                           Member returnby, Date timestamp, Date returnTime, String teacher,
                           String status, String purpose, String note, String category, String label) {
        this.id_borrow_equipment = id_borrow_equipment;
        this.borrow = borrow;
        this.equipment = equipment;
        this.lendby = lendby;
        this.returnby = returnby;
        this.timestamp = timestamp;
        this.returnTime = returnTime;
        this.teacher = teacher;
        this.status = status;
        this.purpose = purpose;
        this.note = note;
    }

    // Getters and Setters
    public long getId_borrow_equipment() {
        return id_borrow_equipment;
    }

    public void setId_borrow_equipment(long id_borrow_equipment) {
        this.id_borrow_equipment = id_borrow_equipment;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow= borrow;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment= equipment;
    }

    public Member getLendby() {
        return lendby;
    }

    public void setLendby(Member lendby) {
        this.lendby= lendby;
    }

    public Member getReturnby() {
        return returnby;
    }

    public void setReturnby(Member returnby) {
        this.returnby= returnby;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp= timestamp;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime= returnTime;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher= teacher;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status= status;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose= purpose;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note= note;
    }



    // toString method

    @Override
    public String toString() {
        return "BorrowEquipment{" +
                "id_borrow_equipment=" + id_borrow_equipment +
                ", borrow=" + borrow +
                ", equipment=" + equipment +
                ", lendby=" + lendby +
                ", returnby=" + returnby +
                ", timestamp=" + timestamp +
                ", returnTime=" + returnTime +
                ", teacher='" + teacher + '\'' +
                ", status='" + status + '\'' +
                ", purpose='" + purpose + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

}
