package com.demo.FinDemy.service;

import com.demo.FinDemy.beans.Course;
import com.demo.FinDemy.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;

    //constructor injection
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
