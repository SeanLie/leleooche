package com.leletc.oocheorder.dao;

import com.leletc.oocheorder.entity.OrderReservationEntity;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能描述：预约订单业务DAO
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/01 22:40
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Repository
public interface OrderReservationDao {

    /**
     * 根据ID获得订单对象
     *
     * @param id 订单ID
     * @return OrderReservationEntity
     */
    @Arguments({"id"})
    @Sql("SELECT * FROM AUTO_ORDERS_RESERVATION WHERE id = :id")
    OrderReservationEntity get(String id);

    /**
     * 根据用户ID获得订单对象
     *
     * @param userId              用户ID
     * @param orderStatusReserved 已预约状态
     * @return OrderReservationEntity
     */
    @Arguments({"userId", "orderStatusReserved"})
    @Sql("SELECT * FROM AUTO_ORDERS_RESERVATION WHERE order_users = :userId and order_status = :orderStatusReserved")
    OrderReservationEntity getOrderByUserIdStatus(String userId, String orderStatusReserved);

    /**
     * 根据用户ID和车牌号查询未结束的订单
     *
     * @param userId 用户ID
     * @return List&lt;OrderReservationEntity&gt;
     */
    @Arguments({"userId", "plateNumber", "finishedStatusList"})
    List<OrderReservationEntity> getNotFinishList(String userId, String plateNumber, List<String> finishedStatusList);

    /**
     * 根据用户ID获得订单集合
     *
     * @param userId 用户ID
     * @param currentDate 当前日期年-月-日
     * @return List
     */
    @Arguments({"userId", "currentDate"})
    List<OrderReservationEntity> getListByUserId(String userId, String currentDate);

    /**
     * 根据订单状态获得当天订单列表
     *
     * @param orderStatus 订单状态String
     * @param currentDate 当前日期年-月-日
     * @return List
     */
    @Arguments({"orderStatus", "currentDate"})
    @Sql("SELECT * FROM auto_orders_reservation WHERE order_status = :orderStatus " +
            "AND DATE_FORMAT(order_time,'%Y-%m-%d') = :currentDate ORDER BY order_level,order_time desc")
    List<OrderReservationEntity> getListByStatus(String orderStatus, String currentDate);

    /**
     * 获得当天可接的订单
     *
     * @param orderId     订单ID
     * @param orderStatus 订单状态
     * @param currentDate 当前日期年-月-日
     * @return OrdersQueueEntity
     */
    @Arguments({"orderId", "orderStatus", "currentDate"})
    OrderReservationEntity getAcceptableOrder(String orderId, String orderStatus, String currentDate);

    /**
     * 根据用户ID查询其已处理历史订单
     *
     * @param userId 用户ID
     * @param currentDate 当前日期年-月-日
     * @return List
     */
    @Arguments({"userId", "currentDate"})
    List<OrderReservationEntity> getHandleOrdersByUserId(String userId, String currentDate);

    /**
     * 获得当天的订单数
     *
     * @param currentDate 当前日期年-月-日
     * @return int 订单数
     */
    @Arguments({"currentDate"})
    @Sql("SELECT COUNT(1) FROM auto_orders_reservation WHERE DATE_FORMAT(order_time,'%Y-%m-%d') = :currentDate")
    int getTodayCounts(String currentDate);

    /**
     * 获得已使用的预约数
     *
     * @param userPersonLevel 用户等级
     * @param currentDate 当前日期年-月-日
     * @author 李斌
     * @date 2018/12/29 02:16
     * @return int 订单数
     */
    @Arguments({"userPersonLevel", "currentDate"})
    @Sql("SELECT COUNT(1) FROM auto_orders_reservation WHERE order_level = :userPersonLevel"
            + " AND DATE_FORMAT(order_time,'%Y-%m-%d') = :currentDate")
    int getHasUsedCounts(String userPersonLevel, String currentDate);

    /**
     * 获得今日未完成的订单数
     *
     * @param userPersonLevel 用户科级
     * @param orderStatusCanceled 已取消
     * @param orderStatusFinished 已完成
     * @param formatDate 当前日期年-月-日
     * @return int 订单数
     */
    @Arguments({"userPersonLevel", "orderStatusCanceled", "orderStatusFinished", "currentDate"})
    @Sql("SELECT COUNT(1) FROM auto_orders_reservation WHERE order_level = :userPersonLevel"
            + " AND DATE_FORMAT(order_time,'%Y-%m-%d') = :currentDate"
            + " AND order_status <> :orderStatusCanceled AND order_status <> :orderStatusFinished")
    int getNotFinishCounts(String userPersonLevel, String orderStatusCanceled, String orderStatusFinished, String formatDate);

    /*
     * 更新
     *
     * @param orderEntity OrderReservationEntity
     * @return int
     */
    /*@Arguments({"orderEntity"})
    @Sql("UPDATE auto_orders_reservation" +
            "  SET order_status = :orderEntity.orderStatus" +
            "    , update_by = :orderEntity.updateBy" +
            "    , update_date = :orderEntity.updateDate" +
            "    , update_name = :orderEntity.updateName" +
            "    , status_remark = :orderEntity.statusRemark" +
            "    WHERE id = :orderEntity.id")
    int update(OrderReservationEntity orderEntity);*/

}
