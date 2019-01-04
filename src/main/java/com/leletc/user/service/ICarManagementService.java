package com.leletc.user.service;

import com.leletc.user.api.request.CarManagementReq;
import com.leletc.user.api.response.CarManagementRsp;
import org.jeecgframework.core.common.service.CommonService;

/**
 * 功能描述：车辆信息管理服务类接口
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/12/26 21:55
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018/12/26, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public interface ICarManagementService extends CommonService {

    CarManagementRsp addCar(CarManagementReq carManagementReq);

    CarManagementRsp deleteCar(CarManagementReq carManagementReq);

    /**
     * 删除车辆
     *
     * @param userId 用户ID
     * @param carNum 车牌号
     * @return CarManagementRsp
     */
    CarManagementRsp delCar(String userId, String carNum);

    CarManagementRsp updateCar(CarManagementReq carManagementReq);

    //List<CarManagementRsp> getAllCarMseeage(String userId);

}
