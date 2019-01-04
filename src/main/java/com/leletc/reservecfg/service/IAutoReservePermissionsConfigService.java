package com.leletc.reservecfg.service;

import com.leletc.reservecfg.entity.AutoReservePermissionsConfigEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

/**
 * 功能描述：auto_reserve_permissions_config业务接口
 * <p>
 * @author Sean
 * <p>
 * @date 2018-11-12 00:51:17
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public interface IAutoReservePermissionsConfigService extends CommonService {
	
 	void delete(AutoReservePermissionsConfigEntity entity) throws Exception;
 	
 	Serializable save(AutoReservePermissionsConfigEntity entity) throws Exception;
 	
 	void saveOrUpdate(AutoReservePermissionsConfigEntity entity) throws Exception;
 	

}
