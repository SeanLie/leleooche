package com.leletc.smartcabinet.service;
import com.leletc.smartcabinet.entity.SmartCabinetPartnerEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ISmartCabinetPartnerService extends CommonService{
	
 	void delete(SmartCabinetPartnerEntity entity) throws Exception;
 	
 	Serializable save(SmartCabinetPartnerEntity entity) throws Exception;
 	
 	void saveOrUpdate(SmartCabinetPartnerEntity entity) throws Exception;
 	
}
