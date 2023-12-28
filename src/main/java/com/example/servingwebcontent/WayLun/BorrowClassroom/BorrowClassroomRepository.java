package com.example.servingwebcontent.WayLun.BorrowClassroom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowClassroomRepository extends JpaRepository<BorrowClassroom, Long>{
    List<BorrowClassroom> findByBorrowStatus(String status);
}
