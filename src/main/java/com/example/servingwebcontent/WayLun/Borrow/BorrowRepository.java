package com.example.servingwebcontent.WayLun.Borrow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long>{

    List<Borrow> findByStatus(String status);
}
