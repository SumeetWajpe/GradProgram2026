package com.demo.FinDemy.dto;

import com.demo.FinDemy.beans.Trainer;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponse {
       private int cid;
        private String cname;
        private int duration;
        private LocalDate startdate;
        private String courseImage;
       private String tname;

}
