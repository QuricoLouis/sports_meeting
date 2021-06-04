package com.xhu.mapper;

import com.xhu.pojo.Admin;
import com.xhu.pojo.Sports;
import com.xhu.pojo.SportsScore;
import com.xhu.pojo.SportsScoreDetails;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


//这个注解表示了这是mybatis的mapper类；dao
@Mapper
@Repository
public interface GradeMapper {
    //  默认查出30001
    List<SportsScoreDetails> selectWithStuAndSportsDefault();

    //根据项目名称查询
    List<SportsScoreDetails> selectWithStuAndSports(int sportsId);

    //修改某个项目成绩
    int updScore(SportsScore sportsScore);

    //查询得分情况
    List<SportsScoreDetails> getScoreAll();

    //查询得分情况
    List<SportsScoreDetails> getScoreAllWithCondition(String school,String gender);

    //查询每个学校总分
    List getScoreBySchoolAll();

    //查询每个学校按运动类型排名的总分
    List getScoreBySchoolTypeAll(String sportsType);

    //查询学生个人总成绩
    List getScoreBySchool();

    //查询学生个人总成绩--带条件
    List getScoreBySchoolWithCondition(String school,String gender);

}
