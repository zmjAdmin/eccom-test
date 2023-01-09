package com.eccom.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eccom.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
