package com.jeecg.leletc.service.impl;
import com.jeecg.leletc.service.AutoJiekouDetailServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.leletc.oocheorder.entity.ApiRequestLogEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Service("autoJiekouDetailService")
@Transactional
public class AutoJiekouDetailServiceImpl extends CommonServiceImpl implements AutoJiekouDetailServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
 	public void delete(ApiRequestLogEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(ApiRequestLogEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(ApiRequestLogEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}