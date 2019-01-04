package com.leletc.oocheorder.service;

import com.leletc.oocheorder.entity.OrdersQueueEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

/**
 * 功能描述：订单预约队列
 * <p>
 * @author Sean
 * <p>
 * @date 2018-11-11 14:06:54
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public interface IOrdersQueueService extends CommonService{
	
 	void delete(OrdersQueueEntity entity) throws Exception;
 	
 	Serializable save(OrdersQueueEntity entity) throws Exception;
 	
 	void saveOrUpdate(OrdersQueueEntity entity) throws Exception;
 	
}
