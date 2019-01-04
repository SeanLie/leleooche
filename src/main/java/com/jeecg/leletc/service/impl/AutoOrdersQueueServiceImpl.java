package com.jeecg.leletc.service.impl;

import com.jeecg.leletc.service.AutoOrdersQueueServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.leletc.entity.AutoOrdersQueueEntity;
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
 * 功能描述：预约队列业务实现类
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
@Service("autoOrdersQueueService")
@Transactional
public class AutoOrdersQueueServiceImpl extends CommonServiceImpl implements AutoOrdersQueueServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(AutoOrdersQueueEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(AutoOrdersQueueEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(AutoOrdersQueueEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}