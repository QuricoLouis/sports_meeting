package com.xhu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xhu.pojo.Msg;
import com.xhu.pojo.Student;
import com.xhu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.PublicKey;
import java.util.*;


@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

   // @RequestMapping("/admin/getStu")
    public String getStu(Model model){
        Collection<Student> list = studentService.queryStu();
        model.addAttribute("students",list);
        return "admin/student-list";
    }

    //分页显示学生
    @RequestMapping("/admin/getStu/{pn}")
    public String getStuWithJson(@PathVariable(value = "pn") Integer pn,Model model){
        //这不是分页查询
        //引入PageHelper分页插件
        //在查询之前只需要调用,传入页码，以及每页的大小
        PageHelper.startPage(pn,5);
        //startPage后面紧跟的这个查询就是一个分页查询
        List<Student> students=studentService.queryStu();
        List schooltype = studentService.querySchool();
//        System.out.println(school);
        model.addAttribute("schooltype",schooltype);
        //使用PageInfo包装查询后的结果，只需要将page交给页面就行了
        //封装了详细的分页信息，包括我们查询出来的数据,传入连续显示的页数
        PageInfo page=new PageInfo(students,5);
        //System.out.println(page);
        model.addAttribute("pageInfo",page);
        model.addAttribute("sign","getStu");
        return "admin/student-list";
    }

    Integer id;
    String gender;
    String school;
    //分页显示学生----带条件
    @RequestMapping("/admin/queryStuWithCondition/{pn}")
    public String queryStuWithCondition(@RequestParam(value = "school",required = false)String school,
                                        @RequestParam(value = "gender",required = false)String gender,
                                        @RequestParam(value = "id",required = false)Integer id,
                                        @PathVariable(value = "pn") Integer pn,
                                        Model model){
        //System.out.println(id+"-->"+gender+"-->"+school);
        if(id!=null||gender!=null||school!=null) {
            this.id = id;
            this.gender = gender;
            this.school = school;
        }
//        System.out.println(this.id+"-->"+this.gender+"-->"+this.school);
        List schooltype = studentService.querySchool();
//        System.out.println(school);
        model.addAttribute("schooltype",schooltype);
        model.addAttribute("id",this.id);
        model.addAttribute("school",this.school);
        model.addAttribute("gender",this.gender);

        if(this.id==null){
            PageHelper.startPage(pn,5);
            List<Student> students=studentService.queryStuWithCondition(this.gender,this.school);
            PageInfo page=new PageInfo(students,5);
            model.addAttribute("pageInfo",page);
            model.addAttribute("sign","getStuWithCondition");
            return "admin/student-list";
        }
        else {
            PageHelper.startPage(pn,5);
            List<Student> students=studentService.queryStuWithCondition2(this.id,this.gender,this.school);
            PageInfo page=new PageInfo(students,5);
            model.addAttribute("pageInfo",page);
            model.addAttribute("sign","getStuWithCondition");
            return "admin/student-list";
        }

    }

    //去添加学生页面
    @RequestMapping("/admin/toAdd")
    public String toAdd(){
        return "admin/student-add";
    }


    @PostMapping("/admin/addStu")
    public String addStu(Student student) {
       // System.out.println(student);
        studentService.addStu(student);
        return "redirect:admin/getStu/100";
    }

    //去修改学生页面
    @RequestMapping("/admin/toUpd/{stuId}")
    public String toUpd(@PathVariable("stuId")String stuId,Model model){
        int id=Integer.parseInt(stuId);
        Student student = studentService.queryStuById(id);
        model.addAttribute("student",student);
        return "admin/student-update";
    }

    //修改学生信息
    @RequestMapping("/admin/updStu")
    @ResponseBody
    public Msg updStu(Student student){
       // System.out.println(student);
        studentService.updStu(student);
        return Msg.success();
    }


    @RequestMapping(value = "/admin/delStuById/{stuId}",method = RequestMethod.DELETE)
    public String delStuById(@PathVariable("stuId") String stuId){
        int id=Integer.parseInt(stuId);
        studentService.delStuById(id);
        return "redirect:admin/getStu/1";
    }


}
