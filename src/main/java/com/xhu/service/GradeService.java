package com.xhu.service;

import com.xhu.mapper.AdminMapper;
import com.xhu.mapper.GradeMapper;
import com.xhu.pojo.Admin;
import com.xhu.pojo.SportsScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GradeService {
    @Autowired
    GradeMapper gradeMapper;

    public List selectWithStuAndSportsDefault(){
        return gradeMapper.selectWithStuAndSportsDefault();
    }

    public List selectWithStuAndSports( int sportsId){
        return gradeMapper.selectWithStuAndSports(sportsId);
    }

    public int updScore(SportsScore sportsScore){
        return gradeMapper.updScore(sportsScore);
    }

    public List getScoreAll( ){
        return gradeMapper.getScoreAll();
    }

    public List getScoreAllWithCondition(String school,String gender ){
        return gradeMapper.getScoreAllWithCondition(school,gender);
    }

    public List getScoreBySchoolAll(){
        return gradeMapper.getScoreBySchoolAll();
    }

    public List getScoreBySchoolTypeAll(String sportsType){
        return gradeMapper.getScoreBySchoolTypeAll(sportsType);
    }

    public List getScoreBySchool(){
        return gradeMapper.getScoreBySchool();
    }

    public List getScoreBySchoolWithCondition(String school,String gender){
        return gradeMapper.getScoreBySchoolWithCondition(school,gender);
    }
}
