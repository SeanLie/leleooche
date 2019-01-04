package com.leletc.oocheorder.service.impl;
import com.leletc.oocheorder.service.IOrdersQueueService;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.leletc.oocheorder.entity.OrdersQueueEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

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
@Service("ordersQueueService")
@Transactional
public class OrdersQueueServiceImpl extends CommonServiceImpl implements IOrdersQueueService {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(OrdersQueueEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(OrdersQueueEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(OrdersQueueEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}