package com.xhu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xhu.pojo.*;
import com.xhu.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class StuSportsController {

    @Autowired
    private SportsService sportsService;
    @Autowired
    private RefereeService refereeService;
    @Autowired
    private StudentService studentService;
    @Autowired
    GradeService gradeService;
    @Autowired
    CeremonyService ceremonyService;

    //分页显示运动项目
    @RequestMapping("/student/getSports/{pn}")
    public String getStuWithJson(@PathVariable(value = "pn") Integer pn, Model model, HttpServletRequest request){
        PageHelper.startPage(pn,5);
        //startPage后面紧跟的这个查询就是一个分页查询
        List<Sports> sports=sportsService.querySports();
        List sportsName = sportsService.querySportsName();

        model.addAttribute("sports",sports);
        model.addAttribute("sportsName",sportsName);

        PageInfo page=new PageInfo(sports,5);
        //System.out.println(page);
        model.addAttribute("pageInfo",page);
        model.addAttribute("sign","getSports");
        return "student/sports-list-stu";
    }

    String sportsName;
    String sportsType;
    //分页显示运动项目----带条件
    @RequestMapping("/student/querySportsWithCondition/{pn}")
    public String querySportsWithCondition(@RequestParam(value = "sportsName",required = false)String sportsName,
                                        @RequestParam(value = "sportsType",required = false)String sportsType,
                                        @PathVariable(value = "pn") Integer pn,
                                        Model model){
        if(sportsName!=null||sportsType!=null) {
            this.sportsName = sportsName;
            this.sportsType = sportsType;
        }
//        System.out.println(this.id+"-->"+this.gender+"-->"+this.school);
        List sportsName1 = sportsService.querySportsName();
        model.addAttribute("sportsName",sportsName1);

        model.addAttribute("sports",this.sportsName);
        model.addAttribute("sportsType",this.sportsType);

        PageHelper.startPage(pn,5);
        List<Sports> sports=sportsService.querySportsWithCondition(this.sportsName,this.sportsType);
        PageInfo page=new PageInfo(sports,5);
        model.addAttribute("pageInfo",page);
        model.addAttribute("sign","querySportsWithCondition");
        return "student/sports-list-stu";

    }

    //去显示成绩页面
    @RequestMapping("/student/toGetScore")
    public String toGetScore(Model model){
        //将项目名称返回
        List list = sportsService.querySports();
        model.addAttribute("list",list);
        //一加载页面默认查出一个项目的成绩
        List scoreDefault = gradeService.selectWithStuAndSportsDefault();
        //System.out.println(scoreDefault);
        model.addAttribute("scoreDefault",scoreDefault);
        return "student/scorelist-byOne";
    }

    //显示单项目成绩
    @RequestMapping("/student/getScoreBySportsName")
    public String getScoreBySportsName(@RequestParam("sportsId") Integer sportsId,Model model ){
        //将项目名称返回
        List list = sportsService.querySports();
        model.addAttribute("list",list);
        //将sportsId返回
        model.addAttribute("sportsId",sportsId);
        //System.out.println(sportsId);
        List scoreList = gradeService.selectWithStuAndSports(sportsId);
        model.addAttribute("scoreDefault",scoreList);
        return "student/scorelist-byOne";
    }

    //打开开幕式页面
    @RequestMapping("/student/toCeremonyOpen")
    public String toCeremonyOpen(Model model){
        CeremonyOpen ceremonyOpen = ceremonyService.getCeremonyOpen();
        //System.out.println(ceremonyOpen);
        model.addAttribute("ceremonyOpen",ceremonyOpen);
        return "student/ceremony-open";
    }

    //打开闭幕式页面
    @RequestMapping("/student/toCeremonyClose")
    public String toCeremonyClose(Model model){
        CeremonyClose ceremonyClose = ceremonyService.getCeremonyClose();
        //System.out.println(ceremonyOpen);
        model.addAttribute("ceremonyClose",ceremonyClose);
        return "student/ceremony-close";
    }

    //分页显示个人成绩
    @RequestMapping("/student/toPersonalScore/{pn}")
    public String getScoreBySchool(@PathVariable(value = "pn") Integer pn, Model model, HttpServletRequest request){

        //startPage后面紧跟的这个查询就是一个分页查询
        List school1 = studentService.querySchool();
        model.addAttribute("schoolName",school1);

        PageHelper.startPage(pn,5);
        List scoreBySchool = gradeService.getScoreBySchool();
        //System.out.println(scoreBySchool);
        PageInfo page=new PageInfo(scoreBySchool,5);
        //System.out.println(page);
        model.addAttribute("pageInfo",page);
        model.addAttribute("sign","getSports");
        return "admin/scoreAllBySchool";
    }

    String school;
    String gender;
    //分页显示个人成绩----带条件
    @RequestMapping("/student/getScoreBySchoolWithCondition/{pn}")
    public String getScoreBySchoolWithCondition(@RequestParam(value = "school",required = false)String school,
                                           @RequestParam(value = "gender",required = false)String gender,
                                           @PathVariable(value = "pn") Integer pn,
                                           Model model){
        if(school!=null||gender!=null) {
            this.school = school;
            this.gender = gender;
        }
//        System.out.println(this.id+"-->"+this.gender+"-->"+this.school);
        List school1 = studentService.querySchool();
        model.addAttribute("schoolName",school1);

        model.addAttribute("school",this.school);
        model.addAttribute("gender",this.gender);

        PageHelper.startPage(pn,5);
        List score = gradeService.getScoreBySchoolWithCondition(this.school, this.gender);
        PageInfo page=new PageInfo(score,5);
        model.addAttribute("pageInfo",page);
        model.addAttribute("sign","querySportsWithCondition");
        return "admin/scoreAllBySchool";

    }
}
