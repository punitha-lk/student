package com.ratbotapp.ratbot.service;

import java.util.List;

import com.ratbotapp.ratbot.model.Student;

public interface StudentService {

    List<Student> getStudents();
    Student getStudent(String rollNo);
    public boolean addStudent(Student student);


}