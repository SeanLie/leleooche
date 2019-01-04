package com.leletc.user.service.impl;

import com.leletc.user.service.IUserBoxCfgService;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.leletc.user.entity.UserBoxCfgEntity;
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
 * 功能描述：用户格口配置业务实现类
 * <p>
 * @author Sean
 * <p>
 * @date 2018-12-20 08:12:28
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Service("userBoxCfgService")
@Transactional
public class UserBoxCfgServiceImpl extends CommonServiceImpl implements IUserBoxCfgService {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(UserBoxCfgEntity entity) throws Exception{
 		super.delete(entity);
 	}

 	@Override
 	public Serializable save(UserBoxCfgEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}

 	@Override
 	public void saveOrUpdate(UserBoxCfgEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}