package com.liusuizhu.page.controller;

import com.liusuizhu.page.common.ResponseResult;
import com.liusuizhu.page.model.Parking;
import com.liusuizhu.page.model.ParkingInto;
import com.liusuizhu.page.model.ParkingOut;
import com.liusuizhu.page.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/parking/")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @RequestMapping(value = "parkingOutAdd", method = RequestMethod.POST)
    public ResponseResult parkingOutAdd(@RequestBody ParkingOut parkingOut) {
        return parkingService.parkingOutAdd(parkingOut);
    }

    @RequestMapping(value = "parkingIntoAdd", method = RequestMethod.POST)
    public ResponseResult parkingIntoAdd(@RequestBody ParkingInto parkingInto) {
        return parkingService.parkingIntoAdd(parkingInto);
    }

    @RequestMapping(value = "parkingAdd", method = RequestMethod.POST)
    public ResponseResult parkingAdd(@RequestBody Parking parking) {
        return parkingService.parkingAdd(parking);
    }

    @RequestMapping(value = "parkingLotList", method = RequestMethod.GET)
    public ResponseResult parkingLotList(@RequestBody Map<String, Object> map) {
        return parkingService.parkingLotList((int)map.get("page"), (int)map.get("pageSize"));
    }

    @RequestMapping(value = "parkingLot", method = RequestMethod.POST)
    public ResponseResult parkingLot(@RequestBody Map<String, Object> map) {
        return parkingService.parkingLot((Integer) map.get("id"));
    }
}
