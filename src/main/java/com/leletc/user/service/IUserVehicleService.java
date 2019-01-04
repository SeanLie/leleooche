package com.leletc.user.service;

import com.leletc.user.entity.UserVehicleEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

/**
 * 功能描述：用户车辆信息业务接口
 * <p>
 *
 * @author Sean
 * <p>
 * @date 2018-12-15 20:19:04
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public interface IUserVehicleService extends CommonService {

    void delete(UserVehicleEntity entity) throws Exception;

    Serializable save(UserVehicleEntity entity) throws Exception;

    void saveOrUpdate(UserVehicleEntity entity) throws Exception;

}
