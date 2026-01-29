package com.demo.FinDemy.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trainer {
    @Id
    private int tid;
    private String tname;
    private int experience;
    @OneToMany(mappedBy = "trainer")
    @JsonBackReference
    private List<Course> clist;


}
