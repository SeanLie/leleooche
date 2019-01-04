package com.leletc.smartcabinet.service.impl;

import com.leletc.smartcabinet.entity.SmartCabinetLockLogEntity;
import com.leletc.smartcabinet.service.ISmartCabinetLockLogService;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * 功能描述：
 * <p>
 * @author 李斌
 * <p>
 * @date 2018/10/31
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Service("smartCabinetLockLogService")
@Transactional(rollbackFor = Exception.class)
public class SmartCabinetLockLogServiceImpl extends CommonServiceImpl implements ISmartCabinetLockLogService {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
 	public void delete(SmartCabinetLockLogEntity entity) throws Exception{
 		super.delete(entity);
 	}

	@Override
 	public Serializable save(SmartCabinetLockLogEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}

 	@Override
 	public void saveOrUpdate(SmartCabinetLockLogEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}