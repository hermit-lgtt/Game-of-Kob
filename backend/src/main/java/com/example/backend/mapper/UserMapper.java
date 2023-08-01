package com.example.backend.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 一个表对应一个pojo,对应一个mapper
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {



}
