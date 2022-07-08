package com.example.labs.service;

import com.example.labs.domain.Student;
import com.example.labs.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> listAll() {
        return repository.findAll();
    }

    public void save(Student student) {
        repository.save(student);
    }

    public Student get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
