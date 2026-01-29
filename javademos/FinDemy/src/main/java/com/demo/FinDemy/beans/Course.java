package com.demo.FinDemy.beans;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name="courses"))
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private String cname;
    private int duration;
    private LocalDate startdate;
    @ManyToOne
    @JoinColumn(name="trainer_id")
    @JsonManagedReference
    private Trainer trainer;
}
