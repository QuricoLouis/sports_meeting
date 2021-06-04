package com.xhu.mapper;

import com.github.pagehelper.Page;
import com.xhu.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


//这个注解表示了这是mybatis的mapper类；dao
@Mapper
@Repository
public interface StudentMapper {
    //查询所有学生
    List<Student> queryStu();

    //根据id查询学生
    Student queryStuById(int id);

    //查询学校种类
    List querySchool();

    //带条件查询学生不带id
    List<Student> queryStuWithCondition(String gender,String school);
    //带条件查询学生带id
    List<Student> queryStuWithCondition2(int id,String gender,String school);
    //添加学生
    public int addStu(Student student);
    //修改学生
    int updStu(Student student);
    //单个删除
    int delStuById(Integer id);

    //修改学生--不带密码
    int updStuWithoutPassword(String name,String gender,String school,
                              String phone,String email,Integer id);

    //修改密码
    int updStuWithPassword(String password,Integer id);

}
