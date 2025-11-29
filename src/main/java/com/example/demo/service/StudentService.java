package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student newStudent) {
        return repository.findById(id).map(student -> {
            student.setName(newStudent.getName());
            student.setAge(newStudent.getAge());
            return repository.save(student);
        }).orElse(null);
    }

    public String deleteStudent(Long id) {
        repository.deleteById(id);
        return "Student removed with id " + id;
    }
}
