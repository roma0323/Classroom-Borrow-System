package com.example.servingwebcontent.WayLun.Borrow;

import com.example.servingwebcontent.WayLun.BorrowEquipment.BorrowEquipment;
import com.example.servingwebcontent.WayLun.BorrowEquipment.BorrowEquipmentRepository;
import com.example.servingwebcontent.WayLun.BorrowEquipment.BorrowEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {

    private final BorrowRepository borrowRepository;
    private final BorrowEquipmentRepository borrowEquipmentRepository;

    @Autowired
    public BorrowService(BorrowRepository borrowRepository, BorrowEquipmentRepository borrowEquipmentRepository){
        this.borrowRepository = borrowRepository;
        this.borrowEquipmentRepository = borrowEquipmentRepository;
    }

    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }

    public void save(Borrow newBorrow){
        borrowRepository.save(newBorrow);
    }

    public void deleteById(Long borrowId){
        borrowRepository.deleteById(borrowId);
    }

    public Optional<Borrow> findById(Long borrowId){
        return borrowRepository.findById(borrowId);
    }

    public List<Borrow> getBorrowing(){
        return borrowRepository.findByStatus("租借中");
    }

    public List<Borrow> getReviewBorrow(){
        return borrowRepository.findByStatus("審核中");
    }

    public List<Borrow> getReturned(){ return borrowRepository.findByStatus("已歸還"); }

    public void approveBorrow(Long borrowId) {
        Optional<Borrow> optionalBorrow = borrowRepository.findById(borrowId);
        if (optionalBorrow.isPresent()) {
            Borrow borrow = optionalBorrow.get();
            borrow.setStatus("租借中"); // 根據實際情況設置狀態
            borrowRepository.save(borrow);
        }
    }

    public void returnBorrow(Long borrowId) {
        Optional<Borrow> optionalBorrow = borrowRepository.findById(borrowId);
        if (optionalBorrow.isPresent()) {
            Borrow borrow = optionalBorrow.get();
            borrow.setStatus("已歸還"); // 根據實際情況設置狀態
            borrowRepository.save(borrow);
        }
        Optional<BorrowEquipment> optionalBorrowEquipment = borrowEquipmentRepository.findById(borrowId);
        if (optionalBorrowEquipment.isPresent()) {
            BorrowEquipment borrowEquipment = optionalBorrowEquipment.get();
            borrowEquipment.setStatus("已歸還"); // 根據實際情況設置狀態
            borrowEquipmentRepository.save(borrowEquipment);
        }
    }
}
