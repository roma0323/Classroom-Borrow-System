package com.example.servingwebcontent.WayLun.Borrow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {

    private final BorrowRepository borrowRepository;

    @Autowired
    public BorrowService(BorrowRepository borrowRepository){
        this.borrowRepository = borrowRepository;
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

    public List<Borrow> getReviewBorrow(){
        return borrowRepository.findByStatus("審核中");
    }
}
