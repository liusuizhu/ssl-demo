package com.liusuizhu.page.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class Parking {
    /**
     * 停车场id
     */
    private Integer id;

    /**
     * 停车场名称
     */
    private String parking;

    /**
     * 总车位数
     */
    private Integer parkingLotNumber;

    /**
     * 占用车位
     */
    private Integer occupyParkingLot;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后一次更新时间
     */
    private Date updateTime;

    /**
     * 删除状态：0删除；1正常
     */
    @JsonIgnore
    private Integer colStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public Integer getParkingLotNumber() {
        return parkingLotNumber;
    }

    public void setParkingLotNumber(Integer parkingLotNumber) {
        this.parkingLotNumber = parkingLotNumber;
    }

    public Integer getOccupyParkingLot() {
        return occupyParkingLot;
    }

    public void setOccupyParkingLot(Integer occupyParkingLot) {
        this.occupyParkingLot = occupyParkingLot;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getColStatus() {
        return colStatus;
    }

    public void setColStatus(Integer colStatus) {
        this.colStatus = colStatus;
    }
}