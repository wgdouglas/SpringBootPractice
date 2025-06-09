package com.wggdcode.SpringBootPractice.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/version1/student")
@CrossOrigin // This annotation allows cross-origin requests, enabling the API to be accessed from different domains.
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("students/index")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/register")
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudentId(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
}
