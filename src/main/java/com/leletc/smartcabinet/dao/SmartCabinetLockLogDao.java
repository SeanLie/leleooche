package com.leletc.smartcabinet.dao;

import com.leletc.smartcabinet.entity.SmartCabinetLockLogEntity;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.IdAutoGenerator;
import org.jeecgframework.minidao.annotation.Param;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能描述：智能柜开关锁日志处理DAO
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/01 22:18
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
public interface SmartCabinetLockLogDao {

    /**
     * 查询单条数据
     *
     * @param boxNo 格口编号
     * @param orderId 订单ID
     * @return
     */
    @Arguments({ "orderId", "boxNo" })
    @Sql("SELECT * FROM auto_smart_cabinet_lock_log WHERE order_id = :orderId" +
            " AND box_no = :boxNo ORDER BY create_date desc LIMIT 1")
    SmartCabinetLockLogEntity get(String orderId, String boxNo);

    /**
     * 根据订单ID获得最新的一条数据
     * @param orderId 订单ID
     * @return
     */
    @Arguments({ "orderId" })
    @Sql("SELECT * FROM auto_smart_cabinet_lock_log WHERE order_id = :orderId ORDER BY create_date desc LIMIT 1")
    SmartCabinetLockLogEntity getLatestOne(String orderId);

    /**
     * 查询集合
     * @param smartCabinetLockLog
     * @return
     */
    @Arguments({ "smartCabinetLockLog" })
    @Sql("SELECT * FROM auto_smart_cabinet_lock_log")
    List<SmartCabinetLockLogEntity> getList(SmartCabinetLockLogEntity smartCabinetLockLog);

    /**
     * 插入一条数据
     *
     * @param smartCabinetLockLog
     * @return
     */
    @IdAutoGenerator
    int insert(@Param("smartCabinetLockLog") SmartCabinetLockLogEntity smartCabinetLockLog);

    /**
     * 更新数据
     *
     * @param smartCabinetLockLog
     * @return
     */
    int update(@Param("smartCabinetLockLog") SmartCabinetLockLogEntity smartCabinetLockLog);

}
