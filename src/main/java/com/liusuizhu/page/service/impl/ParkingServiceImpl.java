package com.liusuizhu.page.service.impl;

import com.liusuizhu.page.common.Const;
import com.liusuizhu.page.common.ResponseCode;
import com.liusuizhu.page.common.ResponseResult;
import com.liusuizhu.page.dao.ParkingImgMapper;
import com.liusuizhu.page.dao.ParkingIntoMapper;
import com.liusuizhu.page.dao.ParkingMapper;
import com.liusuizhu.page.dao.ParkingOutMapper;
import com.liusuizhu.page.model.Parking;
import com.liusuizhu.page.model.ParkingImg;
import com.liusuizhu.page.model.ParkingInto;
import com.liusuizhu.page.model.ParkingOut;
import com.liusuizhu.page.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    private ParkingMapper parkingMapper;

    @Autowired
    private ParkingImgMapper parkingImgMapper;

    @Autowired
    private ParkingIntoMapper parkingIntoMapper;

    @Autowired
    private ParkingOutMapper parkingOutMapper;


    @Override
    @Transactional
    public ResponseResult parkingOutAdd(ParkingOut parkingOut) {
        if (StringUtils.isEmpty(parkingOut.getCost()) || StringUtils.isEmpty(parkingOut.getParkingId())
                || parkingOut.getParkingImgs() == null) {
            return ResponseResult.createByError(ResponseCode.PARAM_IS_NULL);
        }

        int rowCount = parkingOutMapper.insertSelective(parkingOut);

        if (rowCount > 0) {
            List <ParkingImg> imgs = parkingOut.getParkingImgs();
            for (ParkingImg img : imgs) {
                img.setParkingId(parkingOut.getId());
                img.setParkingType(Const.PARKING_TYPE_OUT);
            }
            int row = parkingImgMapper.batchInsert(imgs);
            if (row > 0) {
                parkingMapper.updateByOccupyParkingLot(parkingOut.getOccupyParkingLot(),parkingOut.getParkingId());
                return ResponseResult.createBySuccessMsg();
            }
        } else {
            throw new RuntimeException(Const.string.MSG_EXCEPTION_PARKING_ADD);
        }

        return ResponseResult.createByError(Const.string.MSG_ERROR_PARKING_OUT_ADD);
    }

    @Override
    public ResponseResult parkingIntoAdd(ParkingInto parkingInto) {
        if (StringUtils.isEmpty(parkingInto.getParkingId()) || parkingInto.getParkingImgs() == null) {
            return ResponseResult.createByError(ResponseCode.PARAM_IS_NULL);
        }

        int rowCount = parkingIntoMapper.insertSelective(parkingInto);

        if (rowCount > 0) {
            List <ParkingImg> imgs = parkingInto.getParkingImgs();
            for (ParkingImg img : imgs) {
                img.setParkingId(parkingInto.getId());
                img.setParkingType(Const.PARKING_TYPE_INTO);
            }
            int row = parkingImgMapper.batchInsert(imgs);
            if (row > 0) {
                parkingMapper.updateByOccupyParkingLot(parkingInto.getOccupyParkingLot(),parkingInto.getParkingId());
                return ResponseResult.createBySuccessMsg();
            }
        } else {
            throw new RuntimeException(Const.string.MSG_EXCEPTION_PARKING_ADD);
        }

        return ResponseResult.createByError(Const.string.MSG_ERROR_PARKING_INTO_ADD);
    }

    @Override
    public ResponseResult parkingAdd(Parking parking) {
        if (StringUtils.isEmpty(parking.getParking()) || StringUtils.isEmpty(parking.getParkingLotNumber())) {
            return ResponseResult.createByError(ResponseCode.PARAM_IS_NULL);
        }
        int rowCount = parkingMapper.insertSelective(parking);
        if (rowCount > 0) {
            return ResponseResult.createBySuccessMsg(parking.getId());
        }
        return ResponseResult.createByError(Const.string.MSG_ERROR_PARKING_ADD);
    }

    @Override
    public ResponseResult parkingLotList(int page, int pageSize) {
        int startPage = (page - 1) * pageSize;
        List<Parking> list = parkingMapper.parkingLotList(startPage, pageSize);
        return ResponseResult.createBySuccessMsg(list);
    }

    @Override
    public ResponseResult parkingLot(Integer id) {
        Parking parking = parkingMapper.selectByPrimaryKey(id);
        return ResponseResult.createBySuccessMsg(parking);
    }
}
