package com.leletc.reservecfg.service.impl;

import com.leletc.reservecfg.dao.ReserveUserCfgDao;
import com.leletc.reservecfg.entity.ReserveUserCfgEntity;
import com.leletc.reservecfg.service.IReserveUserCfgService;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Map;

/**
 * 功能描述：用户预约配置业务实现类
 * <p>
 *
 * @author Sean
 * <p>
 * @date 2018-12-08 11:32:18
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Service("reserveUserCfgService")
@Transactional
public class ReserveUserCfgServiceImpl extends CommonServiceImpl implements IReserveUserCfgService {

    @Autowired
    private ReserveUserCfgDao reserveUserCfgDao;

    public void delete(ReserveUserCfgEntity entity) throws Exception {
        super.delete(entity);
    }

    @Override
    public Serializable save(ReserveUserCfgEntity entity) throws Exception {
        return super.save(entity);
    }

    @Override
    public void saveOrUpdate(ReserveUserCfgEntity entity) throws Exception {
        super.saveOrUpdate(entity);
    }

    @Override
    public Map<String, Integer> getProductNum(String personLevel, String productId) {
        return reserveUserCfgDao.getProductNum(personLevel, productId);
    }

    @Override
    public Map<String, Integer> getAdvanceDays(String userId, String productId) {
        return reserveUserCfgDao.getAdvanceDays(userId, productId);
    }
}