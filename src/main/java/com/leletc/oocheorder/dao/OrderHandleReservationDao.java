package com.leletc.oocheorder.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import com.leletc.oocheorder.entity.OrdersHandleReservationEntity;

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
public interface OrderHandleReservationDao {

	/**
	 * 获得当天的记录数
	 *
	 * @param currentDate 当前日期年-月-日
	 * @return int
	 */
	@Sql("SELECT COUNT(1) num FROM (SELECT 1 FROM auto_orders_handle "
			+ "WHERE DATE_FORMAT(deal_time,'%Y-%m-%d') = :currentDate GROUP BY order_id) t")
	int getCount(String currentDate);

	@Arguments({ "userId", "orderStatusAccepted", "orderStatusInService" })
	@Sql("SELECT * FROM auto_orders_handle WHERE deal_user_id = :userId "
			+ "AND (ORDER_STATUS = :orderStatusAccepted OR ORDER_STATUS = :orderStatusInService)")
	List<OrdersHandleReservationEntity> getProcessingOrdersByUserId(String userId, String orderStatusAccepted,
			String orderStatusInService);

	/**
	 * 根据ID获得订单对象
	 *
	 * @param id 订单ID
	 * @return OrderReservationEntity
	 */
	@Arguments({ "id", "deal_user_id" })
	@Sql("select * from auto_orders_handle_reservation  where id=:id  and deal_user_id=:deal_user_id")
	OrdersHandleReservationEntity getHandleReservation(String id, String deal_user_id);

}
