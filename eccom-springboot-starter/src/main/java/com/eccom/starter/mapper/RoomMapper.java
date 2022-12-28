package com.eccom.starter.mapper;

import com.eccom.starter.entity.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {

    int deleteByPrimaryKey(Integer roomId);

    int insert(Room row);

    Room selectByPrimaryKey(Integer roomId);

    List<Room> selectAll();

    int updateByPrimaryKey(Room row);

}