package com.leletc.oocheorder.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import com.leletc.oocheorder.entity.OrdersHandleEntity;

/**
 * 功能描述：订单处理业务接口
 * <p>
 *
 * @author 李斌
 *         <p>
 * @date 2018/11/11 12:47
 *       <p>
 *       修改记录：修改内容 修改人 修改时间
 *       <ul>
 *       <li></li>
 *       </ul>
 *       <p>
 *       Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 *       <p>
 */
@Repository
public interface OrderHandleDao {

	/**
	 * 根据订单ID获得订单处理数据集合
	 *
	 * @param orderId 订单ID
	 * @return List-OrdersHandleEntity
	 */
	@Arguments({ "orderId" })
	@Sql("SELECT * FROM auto_orders_handle WHERE order_id = :orderId")
	List<OrdersHandleEntity> getListByOrderId(String orderId);

//    /**
//     * 获得当天的记录数
//     *
//     * @param currentDate 当前日期年-月-日
//     * @return int
//     */
//    @Sql("SELECT COUNT(1) num FROM (SELECT 1 FROM auto_orders_handle " +
//            "WHERE DATE_FORMAT(deal_time,'%Y-%m-%d') = :currentDate GROUP BY order_id) t")
//    int getCount(String currentDate);

	/**
	 * 获得正在处理中的订单列表
	 *
	 * @param userId               用户ID
	 * @param orderStatusAccepted  状态已接单
	 * @param orderStatusInService 状态服务中
	 * @return
	 */
	@Arguments({ "userId", "orderStatusAccepted", "orderStatusInService" })
	@Sql("SELECT * FROM auto_orders_handle h, auto_orders_reservation r WHERE h.order_id = r.id"
			+ " AND h.deal_user_id = :userId"
			+ " AND (r.ORDER_STATUS = :orderStatusAccepted OR r.ORDER_STATUS = :orderStatusInService)"
			+ " GROUP BY h.order_id ")
	List<OrdersHandleEntity> getProcessingOrdersByUserId(String userId, String orderStatusAccepted,
			String orderStatusInService);

}
