package com.demo.FinDemy.controller;

import com.demo.FinDemy.beans.Trainer;
import com.demo.FinDemy.service.TrainerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

    TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/trainers")
    public ResponseEntity<List<Trainer>> getAllTrainers() {

        List<Trainer> trainers = trainerService.getAllTrainers();
        return ResponseEntity.ok(trainers);

    }

    @GetMapping("/trainers/{tid}")
    public ResponseEntity<Trainer> getById(@PathVariable int tid) {

        Trainer trainer = trainerService.getById(tid);
        return ResponseEntity.ok(trainer);

    }
    @GetMapping("/trainers/{tid}/courses")
    public ResponseEntity<Trainer> getCoursesById(@PathVariable int tid) {

        Trainer trainer = trainerService.getallCoursesById(tid);
        return ResponseEntity.ok(trainer);

    }
}
