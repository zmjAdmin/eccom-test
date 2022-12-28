package com.eccom.starter.entity;

public class RoomType {
    private Integer roomTypeId;

    private String roomTypeName;

    private String roomTypeDescription;

    private Double dayPrice;

    private Double hourPrice;

    private Integer roomTypeDel;

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName == null ? null : roomTypeName.trim();
    }

    public String getRoomTypeDescription() {
        return roomTypeDescription;
    }

    public void setRoomTypeDescription(String roomTypeDescription) {
        this.roomTypeDescription = roomTypeDescription == null ? null : roomTypeDescription.trim();
    }

    public Double getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(Double dayPrice) {
        this.dayPrice = dayPrice;
    }

    public Double getHourPrice() {
        return hourPrice;
    }

    public void setHourPrice(Double hourPrice) {
        this.hourPrice = hourPrice;
    }

    public Integer getRoomTypeDel() {
        return roomTypeDel;
    }

    public void setRoomTypeDel(Integer roomTypeDel) {
        this.roomTypeDel = roomTypeDel;
    }
}