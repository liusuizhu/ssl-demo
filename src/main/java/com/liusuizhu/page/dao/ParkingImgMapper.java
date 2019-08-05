package com.liusuizhu.page.dao;


import com.liusuizhu.page.model.ParkingImg;

import java.util.List;

public interface ParkingImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ParkingImg record);

    int insertSelective(ParkingImg record);

    ParkingImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ParkingImg record);

    int updateByPrimaryKey(ParkingImg record);

    int batchInsert(List<ParkingImg> list);
}