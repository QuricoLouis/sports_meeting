package com.xhu.service;

import com.xhu.mapper.StudentMapper;
import com.xhu.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    public List queryStu(){
        return studentMapper.queryStu();
    }

    public Student queryStuById(Integer id){
        return studentMapper.queryStuById(id);
    }

    //查询学校种类
    public List querySchool(){
        return studentMapper.querySchool();
    }

    //带条件查询学生不带id
    public List queryStuWithCondition(String gender,String school){
        return studentMapper.queryStuWithCondition(gender,school);
    }
    //带条件查询学生 带id
    public List queryStuWithCondition2(int id,String gender,String school){
        return studentMapper.queryStuWithCondition2(id,gender,school);
    }
    //添加学生
    public void addStu(Student student){
        studentMapper.addStu(student);
    }
    //修改学生
    public void updStu(Student student) {
        studentMapper.updStu(student);

    }
    //单个删除
    public void delStuById(Integer id) {
        studentMapper.delStuById(id);
    }

    public int updStuWithoutPassword(String name,String gender,String school,
                                     String phone,String email,Integer id){
        return studentMapper.updStuWithoutPassword(name,gender,school, phone,email,id);
    }

    public int updStuWithPassword(String password,Integer id){
        return studentMapper.updStuWithPassword(password,id);
    }
}
