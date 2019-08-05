package com.liusuizhu.page.dao;

import com.liusuizhu.page.model.Parking;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParkingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Parking record);

    int insertSelective(Parking record);

    Parking selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Parking record);

    int updateByPrimaryKey(Parking record);

    List<Parking> parkingLotList(@Param("startPage") int startPage, @Param("pageSize") int pageSize);

    int updateByOccupyParkingLot(@Param("occupyParkingLot") Integer occupyParkingLot, @Param("id") Integer id);// 更新占用车位
}