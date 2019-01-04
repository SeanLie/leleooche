package com.leletc.user.service.impl;

import com.leletc.base.util.LeletcConstants;
import com.leletc.user.api.request.CarManagementReq;
import com.leletc.user.api.response.CarManagementRsp;
import com.leletc.user.dao.UserVehicleDao;
import com.leletc.user.service.ICarManagementService;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.jwt.util.menu.ResponseMessageCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("carManagementService")
@Transactional
public class CarManagementServiceImpl extends CommonServiceImpl implements ICarManagementService {


    @Autowired
    private UserVehicleDao userVehicleDao;

    @Override
    public CarManagementRsp addCar(CarManagementReq carManagementReq) {
        return null;
    }

    @Override
    public CarManagementRsp deleteCar(CarManagementReq carManagementReq) {
        return null;
    }

    @Override
    public CarManagementRsp delCar(String userId, String carNum) {
        CarManagementRsp rsp = new CarManagementRsp();
        rsp.setMsg("删除成功");
        rsp.setRspcode(ResponseMessageCodeEnum.SUCCESS.getCode());
        rsp.setChannel(LeletcConstants.PLATFORM_WX);
        int result = userVehicleDao.delVehicle(userId, carNum);
        if (result == 0) {
            rsp.setMsg("删除失败");
            rsp.setRspcode(ResponseMessageCodeEnum.ERROR.getCode());
            return rsp;
        }
        return rsp;
    }

    @Override
    public CarManagementRsp updateCar(CarManagementReq carManagementReq) {
        return null;
    }

    /*@Override
    public List<CarManagementRsp> getAllCarMseeage(String userId) {
        List<CarManagementRsp> carManagementRsp = CarManagementDaoExe.getAllCarMseeage(userId);
        return (List<CarManagementRsp>) carManagementRsp;
    }*/

}
