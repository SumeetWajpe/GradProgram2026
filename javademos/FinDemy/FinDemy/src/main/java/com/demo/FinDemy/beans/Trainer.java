package com.demo.FinDemy.beans;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
   // @JsonBackReference
    @JsonIgnoreProperties("trainer")
    private List<Course> clist;

    public Trainer(int tid, String tname, int experience) {
        this.tid = tid;
        this.tname = tname;
        this.experience = experience;
    }
}
