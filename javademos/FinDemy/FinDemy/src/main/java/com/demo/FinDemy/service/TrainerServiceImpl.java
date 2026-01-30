package com.demo.FinDemy.service;

import com.demo.FinDemy.beans.Trainer;
import com.demo.FinDemy.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService{
    private final TrainerRepository trainerRepository;
    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }
    @Override
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer getById(int tid) {
        return trainerRepository.findById(tid).get();
                //.orElseThrow(new RuntimeException("Trianer not found "+tid));
    }

    @Override
    public Trainer getallCoursesById(int tid) {
        return trainerRepository.findTrainerWithCourses(tid);
    }


}
