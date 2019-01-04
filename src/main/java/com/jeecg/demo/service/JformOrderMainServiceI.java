package com.jeecg.demo.service;
import com.jeecg.demo.entity.JformOrderMainEntity;
import com.jeecg.demo.page.JformOrderMainPage;
import com.jeecg.demo.entity.JformOrderCustomerEntity;
import com.jeecg.demo.entity.JformOrderTicketEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface JformOrderMainServiceI extends CommonService{
 	public void delete(JformOrderMainEntity entity) throws Exception;
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(JformOrderMainPage jformOrderMainPage) throws Exception;
	        
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(JformOrderMainPage jformOrderMainPage) throws Exception;
	
	/**
	 * 删除一对多
	 * 
	 */
	public void delMain (JformOrderMainEntity jformOrderMain) throws Exception;
}
