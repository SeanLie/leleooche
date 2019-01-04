package com.leletc.smartcabinet.service;

import com.leletc.smartcabinet.entity.SmartCabinetDoorEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

/**
 * 功能描述：智能柜箱门业务接口
 * <p>
 * @author Sean
 * <p>
 * @date 2018-11-21 11:55:18
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public interface ISmartCabinetDoorService extends CommonService {
	
 	void delete(SmartCabinetDoorEntity entity) throws Exception;
 	
 	Serializable save(SmartCabinetDoorEntity entity) throws Exception;
 	
 	void saveOrUpdate(SmartCabinetDoorEntity entity) throws Exception;
 	
}
