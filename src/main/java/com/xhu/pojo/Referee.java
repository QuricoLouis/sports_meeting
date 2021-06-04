package com.xhu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Referee {

    private Integer refereeId;
    private String refereeName;
    private Integer refereeAge;
    private String refereeGender;
    private String refereePhone;

}
