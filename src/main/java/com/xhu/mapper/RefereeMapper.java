package com.xhu.mapper;

import com.xhu.pojo.Admin;
import com.xhu.pojo.Referee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


//这个注解表示了这是mybatis的mapper类；dao
@Mapper
@Repository
public interface RefereeMapper {

    List<Referee> queryReferee();

}
