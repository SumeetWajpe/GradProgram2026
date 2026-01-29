package com.demo.FinDemy.service;


import com.demo.FinDemy.beans.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course getById(int cid);

    void addCourse(Course course);

    void updateCourse(Course course);

    void removeById(int cid);
}
