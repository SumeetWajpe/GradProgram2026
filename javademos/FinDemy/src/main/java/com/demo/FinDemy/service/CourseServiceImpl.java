package com.demo.FinDemy.service;

import com.demo.FinDemy.beans.Course;
import com.demo.FinDemy.exceptions.CourseNotFoundException;
import com.demo.FinDemy.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Course getById(int cid) {
        Optional<Course> ob=courseRepository.findById(cid);
         return ob.orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + cid));

    }

    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void updateCourse(Course course) {
        Course c=courseRepository.findById(course.getCid())
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + cid));
        c.setCname(course.getCname());
        c.setDuration(course.getDuration());
        courseRepository.save(c);
    }

    @Override
    public void removeById(int cid) {
        courseRepository.deleteById(cid);
    }

}
