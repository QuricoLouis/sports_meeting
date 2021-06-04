package com.xhu.mapper;

import com.xhu.pojo.Admin;
import com.xhu.pojo.EntryForm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


//这个注解表示了这是mybatis的mapper类；dao
@Mapper
@Repository
public interface EntryFormMapper {

    EntryForm getEntryFormById(Integer stuId,Integer sportsIdEntry);

    int toEntrySports(Integer stuId,Integer sportsIdEntry);

    List getEntryFormByStuId(Integer stuId);

    int delEntryFormById(Integer stuId,Integer sportsIdEntry);
}
