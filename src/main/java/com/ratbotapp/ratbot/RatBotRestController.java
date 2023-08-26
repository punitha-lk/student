package com.ratbotapp.ratbot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ratbotapp.ratbot.model.Student;
import com.ratbotapp.ratbot.service.StudentService;
import com.ratbotapp.ratbot.service.StudentServiceImpl;


@RestController
public class RatBotRestController {

    StudentService studentService = new StudentServiceImpl();

    /**
     * 
     * @return
     */
    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello Punitha";
    }


    /**
     * 
     * @param rollNo
     * @return
     */
    @RequestMapping(value="/students/rollNo/{rollNo}",method = RequestMethod.GET)
    public ResponseEntity<Object> getStudent(@PathVariable String rollNo) {

        Student student = studentService.getStudent(rollNo);

        if(student == null)
            throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"
            );

        return new ResponseEntity<>(studentService.getStudent(rollNo), HttpStatus.OK);
    }


    /**
     * 
     * @return
     */
    @RequestMapping(value="/students",method = RequestMethod.GET)
    public ResponseEntity<Object> getAllStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    /**
     * 
     * @param rollNo
     * @return
     */
    @PostMapping(value="/student",  consumes = "application/json")
    public boolean  adddata(@RequestBody Student student  ) {
        return studentService.addStudent(student);

    }
}
