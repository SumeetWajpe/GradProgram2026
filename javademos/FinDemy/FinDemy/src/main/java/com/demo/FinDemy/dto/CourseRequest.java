package com.demo.FinDemy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {
    private int cid;
    private String cname;
    private int duration;
    private LocalDate startdate;
    private int tid;
    private String tname;
    private int experience;

}
