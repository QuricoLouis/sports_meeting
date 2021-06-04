package com.xhu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class SportsScore {

    private Integer stuId;
    private Integer sportsIdScore;
    private String grade;
    private Integer score;

}
