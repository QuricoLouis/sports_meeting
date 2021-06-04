package com.xhu.service;

import com.xhu.mapper.AdminMapper;
import com.xhu.mapper.StudentMapper;
import com.xhu.pojo.Admin;
import com.xhu.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    public List queryAdmin() {
        return adminMapper.queryAdmin();
    }

    public Admin queryAdminById(Integer id) {
        return adminMapper.queryAdminById(id);
    }

    public int updAdmin(String adminName, String adminGender, int adminAge, String adminPhone, int adminId) {
        return adminMapper.updAdmin(adminName, adminGender, adminAge, adminPhone, adminId);
    }

    public int updAdminPass(String adminPassword, Integer adminId) {
        return adminMapper.updAdminPass(adminPassword, adminId);
    }

}
