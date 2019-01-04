package com.leletc.oocheorder.service;

import com.leletc.oocheorder.entity.OrderDetailEntity;
import com.leletc.oocheorder.entity.OrderReservationEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.util.List;

public interface IOrderReservationService extends CommonService {

    void delete(OrderReservationEntity entity) throws Exception;

    /**
     * 添加一对多
     */
    void addMain(OrderReservationEntity aOReservation,
                 List<OrderDetailEntity> autoOrdersDetailList) throws Exception;

    /**
     * 修改一对多
     */
    void updateMain(OrderReservationEntity aOReservation,
                    List<OrderDetailEntity> autoOrdersDetailList) throws Exception;

    /**
     * 删除一对多
     */
    void delMain(OrderReservationEntity aOReservation) throws Exception;
}
