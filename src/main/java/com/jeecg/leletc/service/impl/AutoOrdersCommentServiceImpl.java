package com.jeecg.leletc.service.impl;

import com.jeecg.leletc.service.AutoOrdersCommentServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jeecg.leletc.entity.AutoOrdersCommentEntity;
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
 * 功能描述：订单评论管理业务实现类
 * <p>
 * @author Sean
 * <p>
 * @date 2019-01-01 12:30:32
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Service("autoOrdersCommentService")
@Transactional
public class AutoOrdersCommentServiceImpl extends CommonServiceImpl implements AutoOrdersCommentServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(AutoOrdersCommentEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(AutoOrdersCommentEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(AutoOrdersCommentEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}