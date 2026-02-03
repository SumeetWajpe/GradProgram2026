package com.demo.FinDemy.service;


import com.demo.FinDemy.beans.Course;
import com.demo.FinDemy.dto.CourseRequest;
import com.demo.FinDemy.dto.CourseResponse;

import java.util.List;

public interface CourseService {
    List<CourseResponse> getAllCourses();

    CourseResponse getById(int cid);

    Course addCourse(CourseRequest course);

    void updateCourse(CourseRequest course);

    void removeById(int cid);
}
