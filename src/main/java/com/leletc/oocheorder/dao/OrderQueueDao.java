package com.leletc.oocheorder.dao;

import com.leletc.oocheorder.entity.OrdersQueueEntity;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能描述：订单队列Dao接口
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/11 14:44
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
public interface OrderQueueDao {

    /**
     * 查询队列列表
     *
     * @return List
     */
    @Sql("SELECT * FROM auto_orders_queue ORDER BY queue_date")
    List<OrdersQueueEntity> getList();

    /**
     * 查询最大的排队编号
     *
     * @param currentDate 日期
     *
     * @return 编号
     */
    @Arguments("currentDate")
    @Sql("SELECT MAX(CONVERT(Q.queue_no, SIGNED)) QUEUE_NO FROM auto_orders_queue Q " +
            "WHERE DATE_FORMAT(queue_date,'%Y-%m-%d') = :currentDate")
    String getMaxQueueNo(String currentDate);

    /**
     * 根据订单ID获取队列信息
     *
     * @param orderId 订单ID
     * @return OrdersQueueEntity
     */
    @Arguments("orderId")
    @Sql("SELECT * FROM auto_orders_queue WHERE order_id = :orderId")
    OrdersQueueEntity getByOrderId(String orderId);

    /**
     * 根据订单ID删除队列信息
     *
     * @param orderId 订单ID
     */
    @Arguments("orderId")
    @Sql("DELETE FROM auto_orders_queue WHERE order_id = :orderId")
    void deleteByOrderId(String orderId);

    /**
     * 获得当天的记录数
     *
     * @param currentDate 当前日期年-月-日
     * @return int
     */
    @Arguments("currentDate")
    @Sql("SELECT COUNT(1) num FROM auto_orders_queue WHERE DATE_FORMAT(queue_date,'%Y-%m-%d') = :currentDate")
    int getCurrentCount(String currentDate);
}
