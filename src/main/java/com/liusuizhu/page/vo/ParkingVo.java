package com.liusuizhu.page.vo;

import com.liusuizhu.page.model.ParkingImg;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ParkingVo {

    /**
     * 车牌
     */
    private String carNumber;

    /**
     * 停车场id
     */
    private String parkingId;

    /**
     * 费用
     */
    private BigDecimal cost;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 车辆照片
     */
    private List<ParkingImg> parkingImgs;

    /**
     * 停车场名称
     */
    private String parking;

    /**
     * 剩余车位
     */
    private Integer remainingParkingLot;

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getParkingId() {
        return parkingId;
    }

    public void setParkingId(String parkingId) {
        this.parkingId = parkingId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<ParkingImg> getParkingImgs() {
        return parkingImgs;
    }

    public void setParkingImgs(List<ParkingImg> parkingImgs) {
        this.parkingImgs = parkingImgs;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public Integer getRemainingParkingLot() {
        return remainingParkingLot;
    }

    public void setRemainingParkingLot(Integer remainingParkingLot) {
        this.remainingParkingLot = remainingParkingLot;
    }
}
