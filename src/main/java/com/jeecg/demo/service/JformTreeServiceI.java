package com.jeecg.demo.service;
import com.jeecg.demo.entity.JformTreeEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface JformTreeServiceI extends CommonService{
	
 	public void delete(JformTreeEntity entity) throws Exception;
 	
 	public Serializable save(JformTreeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(JformTreeEntity entity) throws Exception;
 	
}
