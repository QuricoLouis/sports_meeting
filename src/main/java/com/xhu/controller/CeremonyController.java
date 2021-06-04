package com.xhu.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xhu.pojo.*;
import com.xhu.service.AdminService;
import com.xhu.service.CeremonyService;
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
public class CeremonyController {

    @Autowired
    CeremonyService ceremonyService;

    @Autowired
    AdminService adminService;

    //打开开幕式页面
    @RequestMapping("/admin/toCeremonyOpen")
    public String toCeremonyOpen(Model model){
        CeremonyOpen ceremonyOpen = ceremonyService.getCeremonyOpen();
        //System.out.println(ceremonyOpen);
        model.addAttribute("ceremonyOpen",ceremonyOpen);
        return "admin/ceremony-open";
    }

    //去添加开幕式页面
    @RequestMapping("/admin/toAddCeremonyOpen")
    public String toAddCeremonyOpen(Model model){
        return "admin/ceremonyOpen-add";
    }

    //添加开幕式
    @RequestMapping("/admin/addCeremonyOpen")
    @ResponseBody
    public Msg addCeremonyOpen(CeremonyOpen ceremonyOpen){
        //System.out.println(ceremonyOpen);
        ceremonyService.addCeremonyOpen(ceremonyOpen);
        return Msg.success().add("msg","添加成功");
    }


    //去修改开幕式页面
    @RequestMapping("/admin/toUpdCeremonyOpen/{ceremonyId}")
    public String toUpdCeremonyOpen(@PathVariable("ceremonyId")String ceremonyId, Model model){
        //System.out.println(ceremonyId);
        CeremonyOpen ceremonyOpenById = ceremonyService.getCeremonyOpenById(ceremonyId);
        model.addAttribute("ceremonyOpenById",ceremonyOpenById);
        return "admin/ceremonyOpen-upd";
    }

    //修改开幕式
    @RequestMapping("/admin/updCeremonyOpen")
    @ResponseBody
    public Msg updCeremonyOpen(CeremonyOpen ceremonyOpen){
        //System.out.println(ceremonyOpen);
        ceremonyService.updCeremonyOpen(ceremonyOpen);
        return Msg.success().add("msg","修改成功");
    }
    //删除开幕式
    @RequestMapping(value = "/admin/delCeremony/{ceremonyId}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg delCeremony(@PathVariable("ceremonyId")String ceremonyId){
        ceremonyService.delCeremonyOpen(ceremonyId);
        return Msg.success().add("msg","删除成功!");
    }


    //打开闭幕式页面
    @RequestMapping("/admin/toCeremonyClose")
    public String toCeremonyClose(Model model){
        CeremonyClose ceremonyClose = ceremonyService.getCeremonyClose();
        //System.out.println(ceremonyOpen);
        model.addAttribute("ceremonyClose",ceremonyClose);
        return "admin/ceremony-close";
    }

    //去添加闭幕式页面
    @RequestMapping("/admin/toAddCeremonyClose")
    public String toAddCeremonyClose(Model model){
        return "admin/ceremonyClose-add";
    }

    //添加闭幕式
    @RequestMapping("/admin/addCeremonyClose")
    @ResponseBody
    public Msg addCeremonyClose(CeremonyClose ceremonyClose){
        //System.out.println(ceremonyOpen);
        ceremonyService.addCeremonyClose(ceremonyClose);
        return Msg.success().add("msg","添加成功");
    }


    //去修改闭幕式页面
    @RequestMapping("/admin/toUpdCeremonyClose/{ceremonyId}")
    public String toUpdCeremonyClose(@PathVariable("ceremonyId")String ceremonyId, Model model){
        //System.out.println(ceremonyId);
        CeremonyClose ceremonyCloseById = ceremonyService.getCeremonyCloseById(ceremonyId);
        model.addAttribute("ceremonyCloseById",ceremonyCloseById);
        return "admin/ceremonyClose-upd";
    }

    //修改闭幕式
    @RequestMapping("/admin/updCeremonyClose")
    @ResponseBody
    public Msg updCeremonyOpen(CeremonyClose ceremonyClose){
        //System.out.println(ceremonyOpen);
        ceremonyService.updCeremonyClose(ceremonyClose);
        return Msg.success().add("msg","修改成功");
    }
    //删除闭幕式
    @RequestMapping(value = "/admin/delCeremonyClose/{ceremonyId}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg delCeremonyClose(@PathVariable("ceremonyId")String ceremonyId){
        ceremonyService.delCeremonyClose(ceremonyId);
        return Msg.success().add("msg","删除成功!");
    }

    //查看管理员资料
    @RequestMapping("/admin/toGetAdmin/{adminId}")
    public String toGetAdmin(@PathVariable("adminId")Integer adminId,Model model){
        //System.out.println(adminId);
        Admin admin = adminService.queryAdminById(adminId);
        model.addAttribute("admin",admin);
        return "admin/admin-data";
    }

    //修改管理员资料
    @RequestMapping("/admin/updAdmin")
    @ResponseBody
    public Msg toGetAdmin(   @RequestParam("adminId")Integer adminId,
                             @RequestParam("adminName")String adminName,
                             @RequestParam("adminGender")String adminGender,
                             @RequestParam("adminAge")Integer adminAge,
                             @RequestParam("adminPhone")String adminPhone,
                             Model model){
        //System.out.println(adminId);
        //System.out.println(adminName+"--"+adminGender+"--"+adminAge+"--"+adminPhone);
        adminService.updAdmin(adminName,adminGender,adminAge,adminPhone,adminId);
        return Msg.success().add("msg","修改成功！");
    }

    //去修改管理员密码界面
    @RequestMapping("/admin/toUpdAdminPass/{adminId}")
    public String toUpdAdminPass(@PathVariable("adminId")Integer adminId,Model model){
        //System.out.println(adminId);
        model.addAttribute("adminId",adminId);
        return "admin/admin-pass-upd";
    }

    //修改管理员密码
    @RequestMapping("/admin/updAdminPass")
    @ResponseBody
    public Msg updAdminPass( @RequestParam("adminId")Integer adminId,
                             @RequestParam("adminPassword")String adminPassword,
                             @RequestParam("adminPassword2")String adminPassword2){
//        System.out.println(adminId+"--"+adminPassword+"--"+adminPassword2);
        adminService.updAdminPass(adminPassword,adminId);
        return Msg.success().add("msg","修改成功！请重新登录");
    }


}
