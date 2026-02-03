package com.demo.FinDemy.controller;

import com.demo.FinDemy.beans.Course;
import com.demo.FinDemy.dto.CourseRequest;
import com.demo.FinDemy.dto.CourseResponse;
import com.demo.FinDemy.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/course")
public class CourseController {
    //@Autowired
    private final CourseService courseService;

    //constructor injection best practice
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<CourseResponse>> getAllCourses() {
        List<CourseResponse> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/courses/{cid}")
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable int cid) {
        CourseResponse course = courseService.getById(cid);
        return ResponseEntity.ok(course);
    }

    //RequestBody
    // {
    //        "cname": "database",
    //        "duration": 60,
    //        "startdate": "2021-11-11",
    //        "tid": 1,
    //        "tname": "Ashu",
    //        "experience": 23
    //
    //    }
    @PostMapping("/courses")
    public ResponseEntity<String> createCourse(@RequestBody CourseRequest course) {
        System.out.println(course);
        Course c=courseService.addCourse(course);
       // return ResponseEntity.status(201).body(c);
        return ResponseEntity.status(201).body("course created succesfully");
    }

    @PutMapping("/courses/{cid}")    public ResponseEntity<String> updateCourse(@RequestBody CourseRequest course) {
        courseService.updateCourse(course);
        return ResponseEntity.status(201).body("course updated succesfully");

    }

    @DeleteMapping("/courses/{cid}")
    public ResponseEntity<String> deleteById(@PathVariable int cid) {
       courseService.removeById(cid);
        return ResponseEntity.ok("Deleted successfully "+cid);
    }


}
