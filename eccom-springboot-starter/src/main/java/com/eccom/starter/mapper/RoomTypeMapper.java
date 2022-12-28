package com.eccom.starter.mapper;

import com.eccom.starter.entity.RoomType;
import java.util.List;

public interface RoomTypeMapper {
    int deleteByPrimaryKey(Integer roomTypeId);

    int insert(RoomType row);

    RoomType selectByPrimaryKey(Integer roomTypeId);

    List<RoomType> selectAll();

    int updateByPrimaryKey(RoomType row);
}