package com.leletc.smartcabinet.service.impl;

import com.leletc.smartcabinet.entity.SmartCabinetDoorAllotEntity;
import com.leletc.smartcabinet.service.ISmartCabinetDoorAllotService;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @author Sean
 */
@Service("askdoorargService")
@Transactional(rollbackFor = Exception.class)
public class SmartCabinetDoorAllotServiceImpl extends CommonServiceImpl implements ISmartCabinetDoorAllotService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void delete(SmartCabinetDoorAllotEntity entity) throws Exception {
        super.delete(entity);
    }

    @Override
    public Serializable save(SmartCabinetDoorAllotEntity entity) throws Exception {
        Serializable t = super.save(entity);
        return t;
    }

    @Override
    public void saveOrUpdate(SmartCabinetDoorAllotEntity entity) throws Exception {
        super.saveOrUpdate(entity);
    }

}