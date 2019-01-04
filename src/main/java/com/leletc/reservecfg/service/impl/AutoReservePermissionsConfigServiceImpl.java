package com.leletc.reservecfg.service.impl;

import com.leletc.reservecfg.entity.AutoReservePermissionsConfigEntity;
import com.leletc.reservecfg.service.IAutoReservePermissionsConfigService;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * 功能描述：auto_reserve_permissions_config业务实现类
 * <p>
 * @author Sean
 * <p>
 * @date 2018-11-12 00:51:17
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Service("autoReservePermissionsConfigService")
@Transactional
public class AutoReservePermissionsConfigServiceImpl extends CommonServiceImpl implements IAutoReservePermissionsConfigService {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(AutoReservePermissionsConfigEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(AutoReservePermissionsConfigEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(AutoReservePermissionsConfigEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}