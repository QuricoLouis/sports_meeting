package com.xhu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class SportsScoreDetails {

    private Integer stuId;
//    private String stuName;
//    private String stuschool;
//    private String stuGender;
    private Student student;

    private Integer sportsIdScore;
//    private String sportsName;
//    private String sportsType;
    private Sports sports;

    private String grade;
    private Integer score;

}
