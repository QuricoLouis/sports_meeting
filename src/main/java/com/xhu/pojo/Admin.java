package com.xhu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin {

    private Integer adminId;
    private String adminName;
    private String adminGender;
    private Integer adminAge;
    private String adminPhone;
    private String adminPassword;
}
