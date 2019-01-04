package com.jeecg.leletc.service;
import com.jeecg.leletc.entity.AutoOrdersQueueEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

/**
 * 功能描述：预约队列业务接口
 * <p>
 * @author Sean
 * <p>
 * @date 2019-01-01 13:01:31
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public interface AutoOrdersQueueServiceI extends CommonService {
	
 	void delete(AutoOrdersQueueEntity entity) throws Exception;
 	
 	Serializable save(AutoOrdersQueueEntity entity) throws Exception;
 	
 	void saveOrUpdate(AutoOrdersQueueEntity entity) throws Exception;
 	

}
