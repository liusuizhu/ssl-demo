package com.liusuizhu.page.dao;

import com.liusuizhu.page.model.ParkingInto;

public interface ParkingIntoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ParkingInto record);

    int insertSelective(ParkingInto record);

    ParkingInto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ParkingInto record);

    int updateByPrimaryKey(ParkingInto record);
}