package com.xhu.mapper;

import com.xhu.pojo.Admin;
import com.xhu.pojo.CeremonyClose;
import com.xhu.pojo.CeremonyOpen;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


//这个注解表示了这是mybatis的mapper类；dao
@Mapper
@Repository
public interface CeremonyMapper {
    //查询是否存在开幕式
    CeremonyOpen getCeremonyOpen();

    CeremonyOpen getCeremonyOpenById(String ceremonyId);

    //添加开幕式
    int addCeremonyOpen(CeremonyOpen ceremonyOpen);
    //修改开幕式
    int updCeremonyOpen(CeremonyOpen ceremonyOpen);
    //删除开幕式
    int delCeremonyOpen(String ceremonyId);


    //查询是否存在闭幕式
    CeremonyClose getCeremonyClose();

    CeremonyClose getCeremonyCloseById(String ceremonyId);
    //添加闭幕式
    int addCeremonyClose(CeremonyClose ceremonyClose);
    //修改闭幕式
    int updCeremonyClose(CeremonyClose ceremonyClose);
    //删除闭幕式
    int delCeremonyClose(String ceremonyId);


}
