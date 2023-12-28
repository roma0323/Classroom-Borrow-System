package com.example.servingwebcontent.WayLun.BorrowEquipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowEquipmentRepository extends JpaRepository<BorrowEquipment, Long>{
    List<BorrowEquipment> findByBorrowStatus(String status);
}
