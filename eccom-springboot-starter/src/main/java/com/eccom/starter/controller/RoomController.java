package com.eccom.starter.controller;

import com.eccom.starter.common.JsonData;
import com.eccom.starter.mapper.RoomMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomMapper roomMapper;

    /**
     * 分页查询房间
     *
     * @param page 页码
     * @param pageSize 每页数据数
     * @return 查询结果
     */
    @GetMapping("/list")
    public JsonData list(Integer page, Integer pageSize) {
        if (0 == page) page = 1;
        if (0 == pageSize) pageSize = 10;
        PageHelper.startPage(page, pageSize);
        return JsonData.ok(roomMapper.selectAll());
    }

}
