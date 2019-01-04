package com.leletc.smartcabinet.service.impl;

import com.leletc.smartcabinet.service.ISmartCabinetDoorService;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.leletc.smartcabinet.entity.SmartCabinetDoorEntity;
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
 * 功能描述：智能柜箱门业务实现类
 * <p>
 *
 * @author Sean
 * <p>
 * @date 2018-11-21 11:55:18
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Service("smartCabinetDoorService")
@Transactional
public class SmartCabinetDoorServiceImpl extends CommonServiceImpl implements ISmartCabinetDoorService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void delete(SmartCabinetDoorEntity entity) throws Exception {
        super.delete(entity);
    }

    @Override
    public Serializable save(SmartCabinetDoorEntity entity) throws Exception {
        Serializable t = super.save(entity);
        return t;
    }

    @Override
    public void saveOrUpdate(SmartCabinetDoorEntity entity) throws Exception {
        super.saveOrUpdate(entity);
    }

}