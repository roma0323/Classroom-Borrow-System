package com.example.servingwebcontent.WayLun.BorrowEquipment;

import com.example.servingwebcontent.WayLun.Borrow.Borrow;
import com.example.servingwebcontent.WayLun.BorrowClassroom.BorrowClassroom;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowEquipmentService {

    private final BorrowEquipmentRepository borrowEquipmentRepository;

    @Autowired
    public BorrowEquipmentService(BorrowEquipmentRepository borrowEquipmentRepository) {
        this.borrowEquipmentRepository = borrowEquipmentRepository;
    }
    public List<BorrowEquipment> getBorrowEquipment() {
        return borrowEquipmentRepository.findAll();
    }
    public void save(BorrowEquipment borrowEquipment) {
        borrowEquipmentRepository.save(borrowEquipment);
    }
    public Optional<BorrowEquipment> findById(Long id) {
        return borrowEquipmentRepository.findById(id);
    }

    public void approveBorrow(Long borrowId) {
        Optional<BorrowEquipment> optionalBorrowEquipment = borrowEquipmentRepository.findById(borrowId);
        if (optionalBorrowEquipment.isPresent()) {
            BorrowEquipment borrowEquipment = optionalBorrowEquipment.get();
            borrowEquipment.setStatus("租借中"); // 根據實際情況設置狀態
            borrowEquipmentRepository.save(borrowEquipment);
        }
    }
}
