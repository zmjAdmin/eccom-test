package com.eccom.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eccom.plus.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
