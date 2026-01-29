package com.demo.FinDemy.controller;

import com.demo.FinDemy.beans.Course;
import com.demo.FinDemy.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/courses/{cid}")
    public ResponseEntity<Course> getCourseById(@PathVariable int cid) {
        Course course = courseService.getById(cid);
        return ResponseEntity.ok(course);
    }

    @PostMapping("/courses/{cid}")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        courseService.addCourse(course);
        return ResponseEntity.status(201).body(course);

    }

    @PutMapping("/courses/{cid}")
    public ResponseEntity<String> updateCourse(@RequestBody Course course) {
        courseService.updateCourse(course);
        return ResponseEntity.status(201).body("course updated succesfully");

    }

    @DeleteMapping("/courses/{cid}")
    public ResponseEntity<String> deleteById(@PathVariable int cid) {
       courseService.removeById(cid);
        return ResponseEntity.ok("Deleted successfully "+cid);
    }


}
