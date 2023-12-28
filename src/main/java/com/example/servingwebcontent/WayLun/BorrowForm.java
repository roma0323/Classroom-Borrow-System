package com.example.servingwebcontent.WayLun;

import com.example.servingwebcontent.Daniel.Equipment.Equipment;
import com.example.servingwebcontent.WayLun.BorrowClassroom.BorrowClassroom;
import com.example.servingwebcontent.WayLun.Borrow.Borrow;
import com.example.servingwebcontent.Daniel.Classroom.Classroom;
import com.example.servingwebcontent.WayLun.BorrowEquipment.BorrowEquipment;

public class BorrowForm {

    private BorrowClassroom borrowClassroom;
    private Borrow borrow;
    private Classroom classroom;
    private Equipment equipment;
    private BorrowEquipment borrowEquipment;

    public BorrowForm() {
        // Default constructor
    }

    public BorrowForm(BorrowClassroom borrowClassroom, Borrow borrow, Classroom classroom, Equipment equipment, BorrowEquipment borrowEquipment) {
        this.borrowClassroom = borrowClassroom;
        this.borrow = borrow;
        this.classroom = classroom;
        this.equipment = equipment;
        this.borrowEquipment = borrowEquipment;
    }

    //Getters and Setters
    public BorrowClassroom getBorrowClassroom() {
        return borrowClassroom;
    }

    public void setBorrowClassroom(BorrowClassroom borrowClassroom) {
        this.borrowClassroom = borrowClassroom;
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
        this.classroom= classroom;
    }

    public Equipment getEquipment(){ return  equipment; }

    public void setEquipment(Equipment equipment){ this.equipment = equipment; }

    public BorrowEquipment getBorrowEquipment(){
        return borrowEquipment;
    }

    public void setBorrowEquipment(BorrowEquipment borrowEquipment){
        this.borrowEquipment = borrowEquipment;
    }
}
