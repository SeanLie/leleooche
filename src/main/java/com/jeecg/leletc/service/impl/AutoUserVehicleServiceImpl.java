package com.jeecg.leletc.service.impl;

import com.jeecg.leletc.service.AutoUserVehicleServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.leletc.entity.AutoUserVehicleEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

import org.jeecgframework.minidao.util.FreemarkerParseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.jeecgframework.core.util.ResourceUtil;

/**
 * 功能描述：用户车辆信息业务实现类
 * <p>
 * @author Sean
 * <p>
 * @date 2019-01-01 17:36:18
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Service("autoUserVehicleService")
@Transactional
public class AutoUserVehicleServiceImpl extends CommonServiceImpl implements AutoUserVehicleServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(AutoUserVehicleEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(AutoUserVehicleEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(AutoUserVehicleEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}