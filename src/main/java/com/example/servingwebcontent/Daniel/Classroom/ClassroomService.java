package com.example.servingwebcontent.Daniel.Classroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService {

    private final ClassroomRepository classroomRepository;

    @Autowired
    public ClassroomService(ClassroomRepository classroomRepository){
        this.classroomRepository = classroomRepository;
    }


    public List<Classroom> findAll() {return classroomRepository.findAll();}

    public void save(Classroom newClassroom){
        classroomRepository.save(newClassroom);
    }

    public void deleteById(Long classroomId){
        classroomRepository.deleteById(classroomId);
    }

    public Optional<Classroom> findById(Long classroomId){
        return classroomRepository.findById(classroomId);
    }

}
