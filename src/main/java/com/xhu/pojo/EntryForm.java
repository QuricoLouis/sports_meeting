package com.xhu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntryForm {
    private Integer stuId;
    private String name;
    private String school;
    private Integer sportsIdEntry;
    private String sportsName;
    private String sportsType;

}
