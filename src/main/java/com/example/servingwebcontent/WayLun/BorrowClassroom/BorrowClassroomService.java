package com.example.servingwebcontent.WayLun.BorrowClassroom;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowClassroomService {

    private final BorrowClassroomRepository borrowClassroomRepository;

    @Autowired
    public BorrowClassroomService(BorrowClassroomRepository borrowClassroomRepository) {
        this.borrowClassroomRepository = borrowClassroomRepository;
    }
    public void save(BorrowClassroom borrowClassroom) {
        borrowClassroomRepository.save(borrowClassroom);
    }
    public Optional<BorrowClassroom> findById(Long id) {
        return borrowClassroomRepository.findById(id);
    }
}
