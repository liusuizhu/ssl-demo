package com.liusuizhu.page.model;

import java.util.Date;

public class ParkingImg {
    /**
     * 停车场车辆照片id
     */
    private Integer id;

    /**
     * 车辆照片
     */
    private String carImg;

    /**
     * 驶入驶出类型：0进场；1出场
     */
    private Integer parkingType;

    /**
     * 进场或出场id
     */
    private Integer parkingId;

    /**
     * 创建时间
     */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarImg() {
        return carImg;
    }

    public void setCarImg(String carImg) {
        this.carImg = carImg;
    }

    public Integer getParkingType() {
        return parkingType;
    }

    public void setParkingType(Integer parkingType) {
        this.parkingType = parkingType;
    }

    public Integer getParkingId() {
        return parkingId;
    }

    public void setParkingId(Integer parkingId) {
        this.parkingId = parkingId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}