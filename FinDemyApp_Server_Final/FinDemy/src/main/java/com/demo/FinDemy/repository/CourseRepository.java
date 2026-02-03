package com.demo.FinDemy.repository;

import com.demo.FinDemy.beans.Course;
import com.demo.FinDemy.beans.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.beans.JavaBean;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
   // public Trainer findByTrainer(int tid);
}
