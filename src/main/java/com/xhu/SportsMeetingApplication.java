package com.xhu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//配置要扫描的mapper
@MapperScan("com.xhu.mapper")
@SpringBootApplication
@ImportResource(locations={"classpath:kaptchaConfig.xml"})
public class SportsMeetingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportsMeetingApplication.class, args);
    }

}
