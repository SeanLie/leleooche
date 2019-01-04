package com.jeecg.leletc.service;
import com.jeecg.leletc.entity.AutoUserVehicleEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

/**
 * 功能描述：用户车辆信息业务接口
 * <p>
 * @author Sean
 * <p>
 * @date 2019-01-01 17:36:18
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public interface AutoUserVehicleServiceI extends CommonService {
	
 	void delete(AutoUserVehicleEntity entity) throws Exception;
 	
 	Serializable save(AutoUserVehicleEntity entity) throws Exception;
 	
 	void saveOrUpdate(AutoUserVehicleEntity entity) throws Exception;
 	

}
