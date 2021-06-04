package com.xhu.mapper;

import com.xhu.pojo.Admin;
import com.xhu.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


//这个注解表示了这是mybatis的mapper类；dao
@Mapper
@Repository
public interface AdminMapper {

    List<Admin> queryAdmin();

    Admin queryAdminById(int id);

    int updAdmin(String adminName,String adminGender,int adminAge,String adminPhone,int adminId);

    int updAdminPass(String adminPassword,Integer adminId);


}
