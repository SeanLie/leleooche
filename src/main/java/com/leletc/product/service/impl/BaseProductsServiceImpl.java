package com.leletc.product.service.impl;

import com.leletc.product.entity.BaseProductsEntity;
import com.leletc.product.service.IBaseProductsService;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * 功能描述：服务产品表业务实现类
 * <p>
 *
 * @author Sean
 * <p>
 * @date 2018-11-11 22:46:09
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Service("baseProductsService")
@Transactional
public class BaseProductsServiceImpl extends CommonServiceImpl implements IBaseProductsService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void delete(BaseProductsEntity entity) throws Exception {
        super.delete(entity);
    }

    public Serializable save(BaseProductsEntity entity) throws Exception {
        Serializable t = super.save(entity);
        return t;
    }

    public void saveOrUpdate(BaseProductsEntity entity) throws Exception {
        super.saveOrUpdate(entity);
    }

}