package com.example.servingwebcontent.WayLun;

import com.example.servingwebcontent.WayLun.BorrowClassroom.BorrowClassroom;
import com.example.servingwebcontent.WayLun.Borrow.Borrow;
import com.example.servingwebcontent.Daniel.Classroom.Classroom;

public class BorrowCForm {

    private BorrowClassroom borrowClassroom;
    private Borrow borrow;
    private Classroom classroom;

    public BorrowCForm() {
        // Default constructor
    }

    public BorrowCForm(BorrowClassroom borrowClassroom, Borrow borrow, Classroom classroom) {
        this.borrowClassroom = borrowClassroom;
        this.borrow = borrow;
        this.classroom = classroom;
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
}
