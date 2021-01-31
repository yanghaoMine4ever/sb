package com.github.sb.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    @Select("select * from user")
    List<Map<String, Object>> selectList();

    Map<String, Object> selectById(int id);

}
