package com.leletc.product.service.impl;

import com.leletc.product.dao.UserProductsDao;
import com.leletc.product.entity.BaseUserProductsEntity;
import com.leletc.product.service.IBaseUserProductsService;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * 功能描述：auto_base_user_products业务实现类
 * <p>
 *
 * @author Sean
 * <p>
 * @date 2018-11-11 22:46:37
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Service("autoBaseUserProductsService")
@Transactional
public class BaseUserProductsServiceImpl extends CommonServiceImpl implements IBaseUserProductsService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private UserProductsDao userProductsDao;

    public void delete(BaseUserProductsEntity entity) throws Exception {
        super.delete(entity);
    }

    public Serializable save(BaseUserProductsEntity entity) throws Exception {
        Serializable t = super.save(entity);
        return t;
    }

    @Override
    public void updateProductLeftNum(String userPersonLevel, String productId, Integer num) {
        userProductsDao.updateProductLeftNum(userPersonLevel, productId, num);
    }

    public void saveOrUpdate(BaseUserProductsEntity entity) throws Exception {
        super.saveOrUpdate(entity);
    }

}