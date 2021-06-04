package com.xhu.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功后，应该有用户的session
        Object student = request.getSession().getAttribute("student");
        Object admin = request.getSession().getAttribute("admin");
        if(student==null&&admin==null){
            request.setAttribute("msg","没有权限，请先登录！");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }
        else{
            return true;
        }
    }


}
