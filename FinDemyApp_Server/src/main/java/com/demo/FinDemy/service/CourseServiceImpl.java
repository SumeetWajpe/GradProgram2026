package com.demo.FinDemy.service;

import com.demo.FinDemy.beans.Course;
import com.demo.FinDemy.dto.CourseRequest;
import com.demo.FinDemy.dto.CourseResponse;
import com.demo.FinDemy.exceptions.CourseNotFoundException;
import com.demo.FinDemy.mapper.CourseMapper;
import com.demo.FinDemy.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;

    //constructor injection
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @Override
    public List<CourseResponse> getAllCourses() {

        List<Course> clist= courseRepository.findAll();
        return clist.stream().map(c->CourseMapper.convertBeanToResponse(c))
        .collect(Collectors.toList());
    }

    @Override
    public CourseResponse getById(int cid) {
        //Optional<Course> ob=courseRepository.findById(cid);
        // return ob.orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + cid));
        Optional<Course> ob=courseRepository.findById(cid);
        if(ob.isPresent()){
            return CourseMapper.convertBeanToResponse(ob.get());
        }
        throw new CourseNotFoundException("Course not found with id: " + cid);
    }

    @Override
    public Course addCourse(CourseRequest course) {
        Course c= CourseMapper.convertRequestToBean(course);
        courseRepository.save(c);
        return c;
    }

    @Override
    @Transactional
    public void updateCourse(CourseRequest course) {
        Course c=courseRepository.findById(course.getCid())
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id: " +course.getCid()));
        c.setCname(course.getCname());
        c.setDuration(course.getDuration());
        c.setStartdate(course.getStartdate());

        courseRepository.save(c);
    }

    @Override
    public void removeById(int cid) {
        courseRepository.deleteById(cid);
    }

}
