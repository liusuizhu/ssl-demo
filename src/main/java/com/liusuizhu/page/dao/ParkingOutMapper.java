package com.liusuizhu.page.dao;

import com.liusuizhu.page.model.ParkingOut;

public interface ParkingOutMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ParkingOut record);

    int insertSelective(ParkingOut record);

    ParkingOut selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ParkingOut record);

    int updateByPrimaryKey(ParkingOut record);
}