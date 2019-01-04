package com.leletc.product.service;

import com.leletc.product.entity.BaseProductsEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

/**
 * 功能描述：服务产品表业务接口
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
public interface IBaseProductsService extends CommonService {

    void delete(BaseProductsEntity entity) throws Exception;

    Serializable save(BaseProductsEntity entity) throws Exception;

    void saveOrUpdate(BaseProductsEntity entity) throws Exception;

}
