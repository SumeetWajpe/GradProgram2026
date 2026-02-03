package com.demo.FinDemy.service;

import com.demo.FinDemy.beans.Trainer;

import java.util.List;

public interface TrainerService {
    List<Trainer> getAllTrainers();

    Trainer getById(int tid);

    Trainer getallCoursesById(int tid);
}
