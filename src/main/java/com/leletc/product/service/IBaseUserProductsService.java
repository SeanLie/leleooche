package com.leletc.product.service;

import com.leletc.product.entity.BaseUserProductsEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

/**
 * 功能描述：auto_base_user_products业务接口
 * <p>
 *
 * @author Sean
 * <p>
 * @date 2018-11-11 22:39:47
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public interface IBaseUserProductsService extends CommonService {

    void delete(BaseUserProductsEntity entity) throws Exception;

    Serializable save(BaseUserProductsEntity entity) throws Exception;

    void saveOrUpdate(BaseUserProductsEntity entity) throws Exception;

    /**
     * 更新用户产品次数
     *
     * @param userPersonLevel 用户等级
     * @param productId       产品ID
     * @param num             次数
     */
    void updateProductLeftNum(String userPersonLevel, String productId, Integer num);

}
