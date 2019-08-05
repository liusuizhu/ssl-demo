package com.liusuizhu.page.service;

import com.liusuizhu.page.common.ResponseResult;
import com.liusuizhu.page.model.Parking;
import com.liusuizhu.page.model.ParkingInto;
import com.liusuizhu.page.model.ParkingOut;

public interface ParkingService {

    ResponseResult parkingOutAdd(ParkingOut parkingOut); // 出场

    ResponseResult parkingIntoAdd(ParkingInto parkingInto); // 进场

    ResponseResult parkingAdd(Parking parking); // 录入停车场信息

    ResponseResult parkingLotList(int page, int pageSize); // 所有停车场信息

    ResponseResult parkingLot(Integer id); // 本停车场车位情况
}
