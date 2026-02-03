package com.demo.FinDemy.mapper;

import com.demo.FinDemy.beans.Course;
import com.demo.FinDemy.beans.Trainer;
import com.demo.FinDemy.dto.CourseRequest;
import com.demo.FinDemy.dto.CourseResponse;

public class CourseMapper {
    public static Course convertRequestToBean(CourseRequest cr){
        if(cr.getTname()!=null){
            return new Course(cr.getCid(),cr.getCname(),cr.getDuration(),cr.getStartdate(),cr.getCourseImage(),new Trainer(cr.getTid(),cr.getTname(),cr.getExperience()));
        }
        return new Course(cr.getCid(),cr.getCname(),cr.getDuration(),cr.getStartdate(),cr.getCourseImage(),null);

    }

    public static CourseResponse convertBeanToResponse(Course c) {
        if(c.getTrainer()!=null){
            return new CourseResponse(c.getCid(),c.getCname(),c.getDuration(),c.getStartdate(),c.getCourseImage(),c.getTrainer().getTname());
        }
        return new CourseResponse(c.getCid(),c.getCname(),c.getDuration(),c.getStartdate(),c.getCourseImage(),"to be assigned");
    }
}
