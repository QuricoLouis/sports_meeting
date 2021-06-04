package com.xhu.mapper;

import com.xhu.pojo.EntryForm;
import com.xhu.pojo.Sports;
import com.xhu.pojo.SportsScore;
import com.xhu.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface SportsMapper {
    //查询运动项目
    List<Sports> querySports();
    //查询运动项目by id
    Sports querySportsById(int sportsId);
    //查询项目名字
    List querySportsName();

    //带条件查询项目不带id
    List<Sports> querySportsWithCondition(String sportsName,String sportsType);

    //添加赛事
    public int addSports(Sports sports);

    //修改赛事
    int updSports(Sports sports);

    //单个删除
    int delSportsById(Integer sportsId);

    //查询项目类型
    List querySportsType();
    //查询运动项目by type
    List<Sports> querySportsByType(String sportsType);
    //查询报名表
    List<EntryForm> entryForm();
    //查询报名表 带条件
    List<Sports> entryFormWithCondition(String sportsName,String sportsType);
    //查询学生是否报名该项目
    EntryForm queryStuAndSports(int stuId,int sportsIdEntry);
    //查询学生是否有该项目成绩
    SportsScore queryStuScore(int stuId,int sportsIdScore);
    //录入成绩
    public int addGrade(SportsScore sportsScore);

    public int updSportsNumberAdd(Integer sportsId);
    public int updSportsNumberDes(Integer sportsId);
}
