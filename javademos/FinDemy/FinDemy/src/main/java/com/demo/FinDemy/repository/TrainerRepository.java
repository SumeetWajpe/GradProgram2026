package com.demo.FinDemy.repository;

import com.demo.FinDemy.beans.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Integer> {
    @Query("select t from Trainer t left join fetch t.clist where t.tid=:tid")
    Trainer findTrainerWithCourses(int tid);
}
