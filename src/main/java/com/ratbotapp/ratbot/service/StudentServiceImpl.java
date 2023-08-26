package com.ratbotapp.ratbot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ratbotapp.ratbot.model.Student;

/**
 * 
 */
public class StudentServiceImpl implements StudentService {

    HashMap<String,Student> students = new HashMap<String,Student>();

    public StudentServiceImpl(String str) {

        this();
    }
    

    /**
     * 
     */
    public StudentServiceImpl() {

        Student student = new Student();

        student.setRollNo("101");
        student.setCourse("BSc");
        student.setName("Suresh");
        student.setStatus("active");
        students.put("101",student);

        student = new Student();
        student.setRollNo("201");
        student.setCourse("BBM");
        student.setName("Kumar");
        student.setStatus("active");
        students.put("201",student);

        student = new Student();
        student.setRollNo("301");
        student.setCourse("BA");
        student.setName("Kannan");
        student.setStatus("active");
        students.put("301",student);
    }

    @Override
    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<Student>();
        students.forEach((key,  value)  -> studentList.add((Student) value));
        return studentList;
    }

    @Override
    public Student getStudent(String rollNo) {
       return students.get(rollNo);
    }

    @Override
    public boolean addStudent(Student student) {
        students.put(student.getRollNo(), student);
        return true;
    }



}
