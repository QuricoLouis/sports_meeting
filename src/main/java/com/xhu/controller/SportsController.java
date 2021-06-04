package com.xhu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xhu.mapper.RefereeMapper;
import com.xhu.pojo.*;
import com.xhu.service.RefereeService;
import com.xhu.service.SportsService;
import com.xhu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@Controller
public class SportsController {

    @Autowired
    private SportsService sportsService;
    @Autowired
    private RefereeService refereeService;
    @Autowired
    private StudentService studentService;

    //分页显示运动项目
    @RequestMapping("/admin/getSports/{pn}")
    public String getStuWithJson(@PathVariable(value = "pn") Integer pn,Model model){
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
        return "admin/sports-list";
    }

    String sportsName;
    String sportsType;
    //分页显示运动项目----带条件
    @RequestMapping("/admin/querySportsWithCondition/{pn}")
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
        return "admin/sports-list";

    }

    //去添加运动项目页面,展示裁判姓名
    @RequestMapping("/admin/toAddSports")
    public String toAdd(Model model) {
        List referee = refereeService.queryReferee();
        model.addAttribute("referee",referee);
        return "admin/sports-add";
    }
    //添加运动项目
    @RequestMapping("/admin/addSports")
    @ResponseBody
    public Msg addStu(Sports sports) {
        //System.out.println(sports);
        sportsService.addSports(sports);
        return Msg.success();
    }

    //去运动项目修改页面
    @RequestMapping("/admin/toUpdSports/{sportsId}")
    public String toUpdSports(@PathVariable("sportsId")Integer sportsId , Model model) {
        Sports sports = sportsService.querySportsById(sportsId);
        model.addAttribute("sports",sports);

        List referee = refereeService.queryReferee();
        model.addAttribute("referee",referee);

        return "admin/sports-update";
    }

    //修改运动项目
    @RequestMapping("/admin/updSports")
    @ResponseBody
    public Msg updSports(Sports sports, Model model) {
        //System.out.println(sports);
        sportsService.updSports(sports);
        return Msg.success().add("msg","修改成功！");
    }

    //删除运动项目
    @RequestMapping(value = "/admin/toDelSports/{sportsId}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg toDelSports(@PathVariable("sportsId") String sportsId){
        int sportsId2=Integer.parseInt(sportsId);
        sportsService.delSportsById(sportsId2);
        return Msg.success().add("msg","删除成功！");
    }



//     根据类型查询运动项目
//    @RequestMapping(value = "/admin/querySportsByType",method = RequestMethod.GET)
//    @ResponseBody
//    public Msg querySportsByType(@RequestParam("sportsType") String sportsType,
//            Model model) {
//        List list = sportsService.querySportsByType(sportsType);
//        System.out.println(list);
//        model.addAttribute("sports",list);
//        return Msg.success().add("sports",list);
//    }



    //分页显示报名信息
    @RequestMapping("/admin/toEntryForm/{pn}")
    public String toEntryForm(@PathVariable(value = "pn") Integer pn,Model model){
        PageHelper.startPage(pn,5);
        List list = sportsService.entryForm();
        List sportsName = sportsService.querySportsName();
        //System.out.println(list);
        model.addAttribute("list",list);
        model.addAttribute("sportsName",sportsName);
        PageInfo page=new PageInfo(list,5);
        //System.out.println(page);
        model.addAttribute("pageInfo",page);
        model.addAttribute("sign","getSports");
        return "admin/entry-form";
    }

    //分页显示报名信息----带条件
    @RequestMapping("/admin/toEntryFormWithCondition/{pn}")
    public String toEntryFormWithCondition(@RequestParam(value = "sportsName",required = false)String sportsName,
                                           @RequestParam(value = "sportsType",required = false)String sportsType,
                                           @PathVariable(value = "pn") Integer pn,
                                           Model model){
        if(sportsName!=null||sportsType!=null) {
            this.sportsName = sportsName;
            this.sportsType = sportsType;
        }

        List sportsName1 = sportsService.querySportsName();
        model.addAttribute("sportsName",sportsName1);

        model.addAttribute("sports",this.sportsName);
        model.addAttribute("sportsType",this.sportsType);

        PageHelper.startPage(pn,5);
        List<EntryForm> entryForm=sportsService.entryFormWithCondition(this.sportsName,this.sportsType);
        PageInfo page=new PageInfo(entryForm,5);
        model.addAttribute("pageInfo",page);
        model.addAttribute("sign","querySportsWithCondition");
        return "admin/entry-form";

    }

    //去录入成绩页面
    @RequestMapping("/admin/toAddGrade/{idAndsportsId}")
    public String toAddGrade(@PathVariable("idAndsportsId")String idAndsportsId, Model model) {
        //System.out.println(idAndsportsId);
        String[] split = idAndsportsId.split("-");
        int stuId=Integer.parseInt(split[0]);
        int sportsId=Integer.parseInt(split[1]);
        String sportsType=split[2];
        model.addAttribute("stuId",stuId);
        model.addAttribute("sportsIdScore",sportsId);
        model.addAttribute("sportsType",sportsType);
//        List list = sportsService.querySports();
//        model.addAttribute("sports",list);
        return "admin/grade-add";
    }

    //添加成绩
    @RequestMapping("/admin/addGrade")
    @ResponseBody
    public Msg addGrade(SportsScore sportsScore){
        //System.out.println(sportsScore);
        SportsScore stuScore = sportsService.queryStuScore(sportsScore.getStuId(), sportsScore.getSportsIdScore());
        if(stuScore==null) {//没有成绩，可以录入
            sportsService.addGrade(sportsScore);
            return Msg.success().add("msg", "录入成功！");
        }else{
            return Msg.fail().add("msg","该学生已存在成绩，请不要重复录入！");
        }
    }



}
