package com.jeecg.leletc.service;
import com.jeecg.leletc.entity.AwbApplyEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface AwbApplyServiceI extends CommonService{
	
 	public void delete(AwbApplyEntity entity) throws Exception;
 	
 	public Serializable save(AwbApplyEntity entity) throws Exception;
 	
 	public void saveOrUpdate(AwbApplyEntity entity) throws Exception;
 	
}
