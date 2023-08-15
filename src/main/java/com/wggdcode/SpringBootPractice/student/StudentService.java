package com.wggdcode.SpringBootPractice.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> findStudentByEmail = studentRepository
                .findStudentByEmail(student.getEmail());
        if (findStudentByEmail.isPresent()){
            throw new IllegalStateException("Email already exists please try again with different email");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists){
            throw new IllegalStateException("Student with Id" + studentId + "does not exist");
        }
        
        studentRepository.deleteById(studentId);
    }
}