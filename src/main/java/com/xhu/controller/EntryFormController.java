package com.xhu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xhu.pojo.EntryForm;
import com.xhu.pojo.Msg;
import com.xhu.pojo.Sports;
import com.xhu.pojo.Student;
import com.xhu.service.EntryFormService;
import com.xhu.service.SportsService;
import com.xhu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class EntryFormController {

    @Autowired
    EntryFormService entryFormService;
    @Autowired
    StudentService studentService;
    @Autowired
    SportsService sportsService;

    //学生报名项目
    @RequestMapping(value = "/student/toEntrySports/{sportsId}",method = RequestMethod.POST)
    @ResponseBody
    public Msg toEntrySports(@PathVariable("sportsId")String sportsId,
                             HttpServletRequest request) {

        String id = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("id".equals(cookie.getName())) {
                id = cookie.getValue();
            }
        }
        int stuId=Integer.parseInt(id);
        int sportsIdEntry=Integer.parseInt(sportsId);
        //System.out.println(stuId+"--"+sportsId);
        //查出学生信息
        Student student = studentService.queryStuById(stuId);
        //查出项目信息
        Sports sports = sportsService.querySportsById(sportsIdEntry);
        EntryForm entryFormById = entryFormService.getEntryFormById(stuId, sportsIdEntry);
        if(entryFormById==null){
            //没有该项目,并且男子不能报名女子项目
            if("M".equals(student.getGender())&&"M_sports".equals(sports.getSportsType())){
                sportsService.updSportsNumberAdd(sportsIdEntry);
                entryFormService.toEntrySports(stuId,sportsIdEntry);
                return Msg.success().add("msg","报名成功!");
            }
            else if("F".equals(student.getGender())&&"F_sports".equals(sports.getSportsType())){
                sportsService.updSportsNumberAdd(sportsIdEntry);
                entryFormService.toEntrySports(stuId,sportsIdEntry);
                return Msg.success().add("msg","报名成功!");
            }
            else {
                return Msg.fail().add("msg","你不能报名此类型的项目！");
            }

        }
        else {
            return Msg.fail().add("msg","你已经报名此项目，无需再次报名");
        }

    }

    //查看已报名项目
    @RequestMapping("/student/getEntryFromByStuId/{pn}")
    public String getStuWithJson(@PathVariable(value = "pn") Integer pn, Model model,HttpServletRequest request){
        String id = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("id".equals(cookie.getName())) {
                id = cookie.getValue();
            }
        }
        int stuId=Integer.parseInt(id);//得到学生id

        PageHelper.startPage(pn,5);
        //startPage后面紧跟的这个查询就是一个分页查询
        List entryFormByStuId = entryFormService.getEntryFormByStuId(stuId);
        PageInfo page=new PageInfo(entryFormByStuId,5);
        //System.out.println(page);
        model.addAttribute("pageInfo",page);
        return "student/entry-form-stu";
    }

    @RequestMapping("/student/delEntryFormById/{sportsId}")
    @ResponseBody
    public Msg delEntryFormById(@PathVariable("sportsId")Integer sportsId,HttpServletRequest request){
        String id = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("id".equals(cookie.getName())) {
                id = cookie.getValue();
            }
        }
        int stuId=Integer.parseInt(id);//得到学生id
        sportsService.updSportsNumberDes(sportsId);
        entryFormService.delEntryFormById(stuId,sportsId);
        return Msg.success().add("msg","退赛成功！");
    }

    @RequestMapping("/student/toGetStudent/{id}")
    public String toGetStudent(@PathVariable("id")Integer id,Model model){
        Student student = studentService.queryStuById(id);
        model.addAttribute("student",student);
        return "student/student-data";
    }

    @RequestMapping("/student/updStuWithoutPassword")
    @ResponseBody
    public Msg updStuWithoutPassword(@RequestParam("id")Integer id,
                                     @RequestParam("name")String name,
                                     @RequestParam("gender")String gender,
                                     @RequestParam("school")String school,
                                     @RequestParam("phone")String phone,
                                     @RequestParam("email")String email){
        //System.out.println(id+"--"+name+"--"+gender+"--"+school+"--"+phone+"--"+email);
        studentService.updStuWithoutPassword(name,gender,school,phone,email,id);
        return Msg.success().add("msg","修改成功！");

    }
    //去修改学生密码页面
    @RequestMapping("student/toUpdStudentPass/{id}")
    public String toUpdStudentPass(@PathVariable("id")Integer id,Model model){
        model.addAttribute("id",id);
        return "student/student-pass-upd";
    }

    //修改密码
    @RequestMapping("/student/updStudentPass")
    @ResponseBody
    public Msg updStudentPass( @RequestParam("id")Integer id,
                             @RequestParam("studentPassword")String studentPassword,
                             @RequestParam("studentPassword2")String studentPassword2){
//        System.out.println(adminId+"--"+adminPassword+"--"+adminPassword2);
        studentService.updStuWithPassword(studentPassword,id);
        return Msg.success().add("msg","修改成功！请重新登录");
    }

}
