package com.leletc.oocheorder.service;

import com.leletc.oocheorder.entity.OrdersHandleEntity;
import com.leletc.oocheorder.web.api.response.OrderHandleRsp;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

/**
 * 功能描述：订单处理接口
 * <p>
 *
 * @author Sean
 * <p>
 * @date 2018-11-11 11:56:12
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public interface IOrdersHandleService extends CommonService {

    void delete(OrdersHandleEntity entity) throws Exception;

    Serializable save(OrdersHandleEntity entity) throws Exception;

    void saveOrUpdate(OrdersHandleEntity entity) throws Exception;

    /**
     * 根据订单ID获得订单处理详情
     *
     * @param orderId 订单ID
     * @author 李斌
     * @date 2018/12/28 22:11
     * @return null
     */
    OrderHandleRsp getOrderHandleByOrderId(String orderId);

}
