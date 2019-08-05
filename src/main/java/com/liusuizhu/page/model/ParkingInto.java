package com.liusuizhu.page.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ParkingInto implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7462599238103627118L;

	/**
     * 进场id
     */
    private Integer id;

    /**
     * 车牌
     */
    private String carNumber;

    /**
     * 停车场id
     */
    private Integer parkingId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最后一次修改时间
     */
    private Date updateTime;

    /**
     * 删除状态：0删除；1正常
     */
    @JsonIgnore
    private Integer colStatus;

    private List<ParkingImg> parkingImgs;

    /**
     * 占用车位
     */
    private Integer occupyParkingLot;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
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

    public List<ParkingImg> getParkingImgs() {
        return parkingImgs;
    }

    public void setParkingImgs(List<ParkingImg> parkingImgs) {
        this.parkingImgs = parkingImgs;
    }

    public Integer getOccupyParkingLot() {
        return occupyParkingLot;
    }

    public void setOccupyParkingLot(Integer occupyParkingLot) {
        this.occupyParkingLot = occupyParkingLot;
    }
}