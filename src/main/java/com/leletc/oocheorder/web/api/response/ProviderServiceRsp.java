package com.leletc.oocheorder.web.api.response;

import com.leletc.base.api.response.RspHead;
import com.leletc.oocheorder.entity.OrderReservationEntity;

/**
 * 功能描述：服务商服务响应类
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/11 16:00
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public class ProviderServiceRsp extends RspHead {

    private OrderReservationEntity order;

    public OrderReservationEntity getOrder() {
        return order;
    }

    public void setOrder(OrderReservationEntity order) {
        this.order = order;
    }
}
