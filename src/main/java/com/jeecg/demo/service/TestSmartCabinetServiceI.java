package com.jeecg.demo.service;
import com.jeecg.demo.entity.TestSmartCabinetEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface TestSmartCabinetServiceI extends CommonService{
	
 	public void delete(TestSmartCabinetEntity entity) throws Exception;
 	
 	public Serializable save(TestSmartCabinetEntity entity) throws Exception;
 	
 	public void saveOrUpdate(TestSmartCabinetEntity entity) throws Exception;
 	
}
