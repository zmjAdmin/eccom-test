package com.eccom.starter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    private Integer roomId;

    private String roomNo;

    private Integer roomTypeId;

    private String roomPicture;

    private String roomStatus;

    private Integer roomDel;

}