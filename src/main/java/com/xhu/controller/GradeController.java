package com.xhu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.xhu.pojo.*;
import com.xhu.service.AdminService;
import com.xhu.service.GradeService;
import com.xhu.service.SportsService;
import com.xhu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;


@Controller
public class GradeController {

    @Autowired
    GradeService gradeService;
    @Autowired
    SportsService sportsService;
    @Autowired
    StudentService studentService;

    //去显示成绩页面
    @RequestMapping("/admin/toGetScore")
    public String toGetScore(Model model){
        //将项目名称返回
        List list = sportsService.querySports();
        model.addAttribute("list",list);
        //一加载页面默认查出一个项目的成绩
        List scoreDefault = gradeService.selectWithStuAndSportsDefault();
        //System.out.println(scoreDefault);
        model.addAttribute("scoreDefault",scoreDefault);
        return "admin/scorelist-byOne";
    }

    //显示单项目成绩
    @RequestMapping("/admin/getScoreBySportsName")
    public String getScoreBySportsName(@RequestParam("sportsId") Integer sportsId,Model model ){
        //将项目名称返回
        List list = sportsService.querySports();
        model.addAttribute("list",list);
        //将sportsId返回
        model.addAttribute("sportsId",sportsId);
        //System.out.println(sportsId);
        List scoreList = gradeService.selectWithStuAndSports(sportsId);
        model.addAttribute("scoreDefault",scoreList);
        return "admin/scorelist-byOne";
    }

    //去修改成绩页面
    @RequestMapping("/admin/toUpdGrade/{idAndsportsId}")
    public String toUpdGrade(@PathVariable("idAndsportsId") String idAndsportsId,Model model){
        //System.out.println(idAndsportsId);
        String[] split = idAndsportsId.split("-");
        int stuId=Integer.parseInt(split[0]);
        int sportsId=Integer.parseInt(split[1]);
        //System.out.println(stuId+",,>"+sportsId);
        SportsScore sportsScore = sportsService.queryStuScore(stuId, sportsId);
        //System.out.println(sportsScore);
        model.addAttribute("sportsScore",sportsScore);
        return "admin/grade-upd";
    }

    //修改成绩
    @RequestMapping("/admin/updScore")
    @ResponseBody
    public Msg updScore(SportsScore sportsScore,Model model){
        //System.out.println(sportsScore);
        gradeService.updScore(sportsScore);
        return Msg.success().add("msg","修改成功");
    }

    //查询总项目情况
    @RequestMapping("/admin/toGetScoreAll/{pn}")
    public String toGetScoreAll(@PathVariable(value = "pn") Integer pn,Model model){
        List schoolName = studentService.querySchool();
        model.addAttribute("schoolName",schoolName);

        PageHelper.startPage(pn,5);
        List scoreAll = gradeService.getScoreAll();
        PageInfo page=new PageInfo(scoreAll,5);
        model.addAttribute("pageInfo",page);
        model.addAttribute("sign","toGetScoreAll");
        model.addAttribute("signTable","toGetScoreAll");
        //System.out.println(page);
        return "admin/score-all";
    }

    String gender;
    String school;
    //查询总项目情况--带条件
    @RequestMapping("/admin/getScoreAllWithCondition/{pn}")
    public String getScoreAllWithCondition(@RequestParam(value = "school",required = false)String school,
                                   @RequestParam(value = "gender",required = false)String gender,
                                   @PathVariable(value = "pn") Integer pn,
                                   Model model){

        if(school!=null||gender!=null) {
            this.school = school;
            this.gender = gender;
        }
//        System.out.println(this.id+"-->"+this.gender+"-->"+this.school);
        List schoolName = studentService.querySchool();
        model.addAttribute("schoolName",schoolName);

        model.addAttribute("school",this.school);
        model.addAttribute("gender",this.gender);

        PageHelper.startPage(pn,5);
        List scoreAllWithCondition = gradeService.getScoreAllWithCondition(this.school, this.gender);

        PageInfo page=new PageInfo(scoreAllWithCondition,5);
        model.addAttribute("pageInfo",page);
        model.addAttribute("sign","scoreAllWithCondition");
        model.addAttribute("signTable","toGetScoreAll");
        return "admin/score-all";
    }

    //查询学校总分情况
    String sportsType;
    @RequestMapping("/admin/scoreAll/{pn}")
    public String scoreAll(@RequestParam(value = "sportsType",required = false)String sportsType,
                           @PathVariable(value = "pn") Integer pn,
                           Model model){
        //System.out.println(this.sportsType);
        if(sportsType!=null)
        this.sportsType=sportsType;

        List schoolName = studentService.querySchool();
        model.addAttribute("schoolName",schoolName);

        if(this.sportsType==""||this.sportsType==null){
            PageHelper.startPage(pn,5);
            List scoreBySchoolAll = gradeService.getScoreBySchoolAll();
            PageInfo page=new PageInfo(scoreBySchoolAll,5);
            //System.out.println(page);
            model.addAttribute("pageInfo",page);
            model.addAttribute("sign","scoreAll");
            model.addAttribute("signTable","scoreAll");
            return "admin/score-all";
        }
        else {
            model.addAttribute("sportsType",this.sportsType);
            PageHelper.startPage(pn,5);
            List scoreBySchoolTypeAll = gradeService.getScoreBySchoolTypeAll(this.sportsType);
            PageInfo page=new PageInfo(scoreBySchoolTypeAll,5);
            //System.out.println(page);
            model.addAttribute("pageInfo",page);
            model.addAttribute("sign","scoreAll");//分页
            model.addAttribute("signTable","scoreAllBySportsType");//表格
            return "admin/score-all";
        }
    }
}
