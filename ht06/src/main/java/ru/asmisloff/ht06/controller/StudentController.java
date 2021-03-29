package ru.asmisloff.ht06.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.asmisloff.ht06.model.Student;
import ru.asmisloff.ht06.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/students/")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping("all")
    public String showAllStudents(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students.stream().limit(25).collect(Collectors.toList()));
        model.addAttribute("new_student", new Student());
        return "students_all";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        studentRepository.deleteById(id);
        return "redirect:/students/all";
    }

    @PostMapping("add")
    public String addStudent(Student student) {
        studentRepository.save(student);
        return "redirect:/students/all";
    }

    @GetMapping("edit/{id}")
    public String editStudent(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("student", studentRepository.findById(id).orElseThrow());
        return "student_edit";
    }

    @PostMapping("edit/{id}")
    public String editStudent(Student student) {
        studentRepository.save(student);
        return "redirect:/students/all";
    }

}
