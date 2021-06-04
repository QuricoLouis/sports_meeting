package com.xhu.service;

import com.xhu.mapper.SportsMapper;
import com.xhu.mapper.StudentMapper;
import com.xhu.pojo.EntryForm;
import com.xhu.pojo.Sports;
import com.xhu.pojo.SportsScore;
import com.xhu.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SportsService {
    @Autowired
    SportsMapper sportsMapper;
    //查询运动项目
    public List querySports(){
        return sportsMapper.querySports();
    }

    public Sports querySportsById(int sportsId){
        return sportsMapper.querySportsById(sportsId);
    }

    //查询项目名字
    public List querySportsName(){
        return sportsMapper.querySportsName();
    }

    //带条件查询项目不带id
    public List querySportsWithCondition(String sportsName,String sportsType){
        return sportsMapper.querySportsWithCondition(sportsName,sportsType);
    }


    //添加赛事
    public void addSports(Sports sports){
        sportsMapper.addSports(sports);
    }
    //修改赛事
    public void updSports(Sports sports) {
       sportsMapper.updSports(sports);
    }

    //单个删除
    public void delSportsById(Integer sportsId) {
        sportsMapper.delSportsById(sportsId);
    }

    //查询项目类型
    public List querySportsType(){
        return sportsMapper.querySportsType();
    }

    //查询运动项目by type
    public List querySportsByType(String sportsType){
        return sportsMapper.querySportsByType(sportsType);
    }

    //查询报名表
    public List entryForm(){
        return sportsMapper.entryForm();
    }

    //查询报名表
    public List entryFormWithCondition(String sportsName,String sportsType){
        return sportsMapper.entryFormWithCondition(sportsName,sportsType);
    }
    //查询学生是否报名该项目
    public EntryForm queryStuAndSports(int stuId, int sportsIdEntry){
        return sportsMapper.queryStuAndSports(stuId,sportsIdEntry);
    }
    //查询学生是否有成绩
    public SportsScore queryStuScore(int stuId, int sportsIdScore){
        return sportsMapper.queryStuScore(stuId,sportsIdScore);
    }
    //录入成绩
    public void addGrade(SportsScore sportsScore){
        sportsMapper.addGrade(sportsScore);
    }

    public void updSportsNumberAdd(Integer sportsId){
        sportsMapper.updSportsNumberAdd(sportsId);
    }

    public void updSportsNumberDes(Integer sportsId){
        sportsMapper.updSportsNumberDes(sportsId);
    }

}
