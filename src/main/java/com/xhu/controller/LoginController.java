package com.xhu.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xhu.pojo.Admin;
import com.xhu.pojo.Msg;
import com.xhu.pojo.Student;
import com.xhu.service.AdminService;
import com.xhu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


@Controller
public class LoginController {

    @Autowired
    DefaultKaptcha defaultKaptcha;

    @Autowired
    StudentService studentService;

    @Autowired
    AdminService adminService;


//    @RequestMapping("/login.html")
//    public String login(){
//        return "login";
//    }


    //获取验证码
    @RequestMapping("/getCode")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    //验证码验证
    @RequestMapping("/login")
    public String login(@RequestParam("id")Integer id,
                        @RequestParam("password") String password,
                        @RequestParam("userType") String userType,
                        HttpServletRequest request,
                        HttpServletResponse response,
                        HttpSession session,
                        Model model) {
        //获取session域中验证码
        String captchaId = (String) request.getSession().getAttribute("vrifyCode");
//        System.out.println(captchaId.toLowerCase());
        //获取用户填写的验证码
        String parameter = request.getParameter("code");
//        System.out.println(parameter.toLowerCase());

//        String value1="";
//        String value2="";
//        Cookie cookie1=new Cookie("id",id+"");
//        Cookie cookie2=new Cookie("password",password);
//        cookie1.setMaxAge(60*60*24);
//        cookie2.setMaxAge(60*60*24);
//        response.addCookie(cookie1);
//        response.addCookie(cookie2);

        if ("1".equals(userType)) {
            Admin admin = adminService.queryAdminById(id);
            if (captchaId.toLowerCase().equals(parameter.toLowerCase())) {
                if (admin != null && password.equals(admin.getAdminPassword())) {
                    //用户存在,登录成功
                    session.setAttribute("admin", admin);
                    return "redirect:admin/index.html";
                } else {
                    model.addAttribute("msg", "用户名或者密码错误！");
                    model.addAttribute("id",id);
                    model.addAttribute("userType",userType);
                    return "login.html";
                }
            }
            else {
                //验证码错误
                model.addAttribute("msg", "验证码错误！");
//                Cookie[] cookies=request.getCookies();
//                for(Cookie cookie:cookies){
//                    if("id".equals(cookie.getName())){
//                         value1 = cookie.getValue();
//                    }
//                    if("password".equals(cookie.getName())){
//                        value2 = cookie.getValue();
//                    }
//                }
//                model.addAttribute("id",value1);
//                model.addAttribute("password",value2);
                model.addAttribute("id",id);
                model.addAttribute("password",password);
                model.addAttribute("userType",userType);

                return "login.html";
            }

        }
        else {
            Student student = studentService.queryStuById(id);

            if (captchaId.toLowerCase().equals(parameter.toLowerCase())) {
                if (student != null && password.equals(student.getPassword())) {
                    //用户存在,登录成功
                    session.setAttribute("student", student);
                    Cookie cookie1=new Cookie("id",student.getId()+"");
                    cookie1.setMaxAge(60*60*24);
                    response.addCookie(cookie1);
                    return "redirect:student/index-stu.html";
                } else {
                    model.addAttribute("msg", "用户名或者密码错误！");
                    model.addAttribute("id",id);
                    model.addAttribute("userType",userType);
                    return "login.html";
                }
            } else {
                //验证码错误
                model.addAttribute("msg", "验证码错误！");
                model.addAttribute("id",id);
                model.addAttribute("password",password);
                model.addAttribute("userType",userType);
                return "login.html";
            }

        }
    }

    @RequestMapping("/admin/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:login";
    }

    @RequestMapping("/student/logout")
    public String stuLogout(HttpSession session){
        session.invalidate();
        return "redirect:login";
    }
}
