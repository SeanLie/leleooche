package com.leletc.oocheorder.service.impl;

import com.leletc.base.util.LeletcConstants;
import com.leletc.oocheorder.dao.OrderHandleDao;
import com.leletc.oocheorder.entity.OrderReservationEntity;
import com.leletc.oocheorder.entity.OrdersHandleEntity;
import com.leletc.oocheorder.service.IOrdersHandleService;
import com.leletc.oocheorder.web.api.response.OrderHandleRsp;
import com.leletc.oocheorder.web.bo.OrderBO;
import com.leletc.oocheorder.web.bo.OrderHandleBO;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.jwt.util.menu.ResponseMessageCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：订单处理业务实现类
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
@Service("ordersHandleService")
@Transactional
public class OrdersHandleServiceImpl extends CommonServiceImpl implements IOrdersHandleService {

    @Autowired
    private OrderHandleDao orderHandleDao;

    @Override
    public OrderHandleRsp getOrderHandleByOrderId(String orderId) {
        OrderHandleRsp rsp = new OrderHandleRsp();
        rsp.setMsg("查询订单处理信息成功");
        rsp.setRspcode(ResponseMessageCodeEnum.SUCCESS.getCode());
        rsp.setChannel(LeletcConstants.PLATFORM_WX);
        // 1.查询订单详情
        OrderReservationEntity order = this.get(OrderReservationEntity.class, orderId);
        if (null == order) {
            rsp.setMsg("订单不存在");
            rsp.setRspcode(ResponseMessageCodeEnum.NULL_ERROR.getCode());
            return rsp;
        }
        OrderBO orderBO = new OrderBO();
        try {
            MyBeanUtils.copyBeanNotNull2Bean(order, orderBO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 2.查询订单处理详情
        List<OrderHandleBO> orderHandleBOList = new ArrayList<>();
        List<OrdersHandleEntity> orderHandleList = orderHandleDao.getListByOrderId(orderId);
        if (!CollectionUtils.isEmpty(orderHandleList)) {
            orderHandleList.forEach(orderHandle -> {
                OrderHandleBO orderHandleBO = new OrderHandleBO();
                try {
                    MyBeanUtils.copyBeanNotNull2Bean(orderHandle, orderHandleBO);
                    orderHandleBOList.add(orderHandleBO);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        rsp.setOrder(orderBO);
        rsp.setOrderHandleList(orderHandleBOList);
        return rsp;
    }

    @Override
    public void delete(OrdersHandleEntity entity) throws Exception {
        super.delete(entity);
    }

    @Override
    public Serializable save(OrdersHandleEntity entity) throws Exception {
        Serializable t = super.save(entity);
        return t;
    }

    @Override
    public void saveOrUpdate(OrdersHandleEntity entity) throws Exception {
        super.saveOrUpdate(entity);
    }

}