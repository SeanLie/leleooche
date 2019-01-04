package com.jeecg.leletc.service;
import com.leletc.oocheorder.entity.ApiRequestLogEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AutoJiekouDetailServiceI extends CommonService{
	
 	public void delete(ApiRequestLogEntity entity) throws Exception;
 	
 	public Serializable save(ApiRequestLogEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ApiRequestLogEntity entity) throws Exception;
 	
}
