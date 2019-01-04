package com.leletc.product.service;

import com.leletc.product.entity.BaseProductsEntity;
import com.leletc.product.web.api.response.BaseProductsRsp;
import org.jeecgframework.core.common.service.CommonService;

import java.util.List;

public interface IOOcheProductService extends CommonService {

    /**
     * 获得产品服务列表
     *
     * @param userId
     * @param parentProductId
     * @return
     * @throws Exception
     */
    List<BaseProductsEntity> getBaseProducts(String userId, String parentProductId) throws Exception;

    /**
     * 根据用户ID获得用户产品列表
     *
     * @param userId 用户ID
     * @return
     * @throws Exception
     */
    BaseProductsRsp getUserProductByUserId(String userId) throws Exception;

}
