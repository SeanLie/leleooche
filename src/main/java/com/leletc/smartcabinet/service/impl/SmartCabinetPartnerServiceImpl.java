package com.leletc.smartcabinet.service.impl;

import com.leletc.smartcabinet.entity.SmartCabinetPartnerEntity;
import com.leletc.smartcabinet.service.ISmartCabinetPartnerService;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * @author Sean
 */
@Service("asapartnerService")
@Transactional(rollbackFor = Exception.class)
public class SmartCabinetPartnerServiceImpl extends CommonServiceImpl implements ISmartCabinetPartnerService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Serializable save(SmartCabinetPartnerEntity entity) throws Exception {
        Serializable t = super.save(entity);
        return t;
    }

    @Override
    public void delete(SmartCabinetPartnerEntity entity) throws Exception {
        super.delete(entity);
    }

    @Override
    public void saveOrUpdate(SmartCabinetPartnerEntity entity) throws Exception {
        super.saveOrUpdate(entity);
    }

}