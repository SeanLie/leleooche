package com.leletc.oocheorder.service;

import com.leletc.oocheorder.entity.OrdersHandleEntity;
import com.leletc.oocheorder.web.api.request.OrderReservationReq;
import com.leletc.oocheorder.web.api.request.ReserveRsp;
import com.leletc.oocheorder.web.api.response.*;
import org.jeecgframework.core.common.service.CommonService;

import java.util.List;

/**
 * 功能描述：订单业务接口
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/11 01:08
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public interface IOrderService extends CommonService {

    /**
     * 预约
     *
     * @param orderReq 请求对象
     * @return OrderReservationRsp
     * @throws Exception 异常
     */
    OrderReservationRsp reserve(OrderReservationReq orderReq) throws Exception;

    /**
     * 是否允许预约
     *
     * @param userId      用户ID
     * @param productId   产品ID
     * @param plateNumber 车牌号
     * @return ReserveRsp
     * @throws Exception 异常
     */
    ReserveRsp isPermitReserve(String userId, String productId, String plateNumber) throws Exception;

    /**
     * 取消预约订单
     *
     * @param orderId 订单ID
     * @return OrderReservationRsp
     * @throws Exception 异常
     */
    OrderReservationRsp cancelReservationOrder(String orderId) throws Exception;

    /**
     * 获得正在处理的订单集合List
     *
     * @param orderId 订单ID
     * @return List
     */
    List<OrdersHandleEntity> getOrdersHandleListByOrderId(String orderId);

    /**
     * 服务商接订单
     *
     * @param userId  用户ID
     * @param orderId 订单ID
     * @return ProviderServiceRsp
     * @throws Exception 异常
     */
    ProviderServiceRsp acceptReservationOrder(String userId, String orderId) throws Exception;

    /**
     * 获得订单集合
     *
     * @param orderStatus 订单状态
     * @return OrderReservationListRsp
     * @throws Exception 异常
     */
    OrderReservationListRsp getOrderListByStatus(String orderStatus) throws Exception;

    /**
     * 根据用户ID获得订单集合
     *
     * @param userId 用户ID
     * @param currentDate 日期
     * @return OrderReservationListRsp
     * @throws Exception 异常
     */
    OrderReservationListRsp getOrderListByUserId(String userId, String currentDate) throws Exception;

    /**
     * 根据订单ID获取预约订单的排名
     *
     * @param orderId 订单ID
     * @return QueueLocationRsp
     */
    QueueLocationRsp getOrderLocation(String orderId);

    /**
     * 获取当前剩余可预约数量
     *
     * @param userId 用户ID
     * @return Integer 数量
     */
    ReserveAmountRsp getRemainAmount(String userId);
}
