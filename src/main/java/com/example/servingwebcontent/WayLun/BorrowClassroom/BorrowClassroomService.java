package com.example.servingwebcontent.WayLun.BorrowClassroom;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class BorrowClassroomService {
    
    private final BorrowClassroomRepository borrowClassroomRepository;

    @Autowired
    public BorrowClassroomService(BorrowClassroomRepository borrowClassroomRepository) {
        this.borrowClassroomRepository = borrowClassroomRepository;
    }

    public List<BorrowClassroom> getBorrowClassroom() {
        return borrowClassroomRepository.findAll();
    }

    public void save(BorrowClassroom borrowClassroom) {
        borrowClassroomRepository.save(borrowClassroom);
    }
}
