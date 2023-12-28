package com.example.servingwebcontent.Daniel.Equipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long>{
    List<Equipment> findByCategory(String category);


    @Query("SELECT DISTINCT e.category FROM Equipment e")
    List<String> findDistinctCategories();

    @Query("SELECT e.label FROM Equipment e WHERE e.category = ?1")
    List<String> findLabelsByCategory(String category);

}
