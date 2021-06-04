package com.xhu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonalScore {

    private Integer stuId;
    private Student student;
    private Integer personalScore;
}
