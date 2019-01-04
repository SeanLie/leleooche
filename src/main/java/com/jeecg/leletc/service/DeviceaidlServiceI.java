package com.jeecg.leletc.service;
import com.jeecg.leletc.entity.DeviceaidlEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface DeviceaidlServiceI extends CommonService{
	
 	public void delete(DeviceaidlEntity entity) throws Exception;
 	
 	public Serializable save(DeviceaidlEntity entity) throws Exception;
 	
 	public void saveOrUpdate(DeviceaidlEntity entity) throws Exception;
 	
 	/**
	 * 自定义按钮-[我的添加]业务处理
	 * @param id
	 * @return
	 */
	 public void doMyAddBus(DeviceaidlEntity t) throws Exception;
}
