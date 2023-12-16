package com.example.servingwebcontent.Daniel.Equipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentService(EquipmentRepository equipmentRepository){
        this.equipmentRepository = equipmentRepository;
    }


    public List<Equipment> findAll() {return equipmentRepository.findAll();}

    public void save(Equipment newEquipment){
        equipmentRepository.save(newEquipment);
    }

    public void deleteById(Long equipmentId){
        equipmentRepository.deleteById(equipmentId);
    }

    public Optional<Equipment> findById(Long equipmentId){
        return equipmentRepository.findById(equipmentId);
    }

    public List<Equipment> findByCategory(String category) {
        return equipmentRepository.findByCategory(category);
    }

    public List<String> findDistinctCategories() {
        return equipmentRepository.findDistinctCategories();
    }

}
