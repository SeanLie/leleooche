package com.leletc.oocheorder.web.api.response;

import com.leletc.base.api.response.RspHead;
import com.leletc.oocheorder.web.bo.OrderBO;
import com.leletc.oocheorder.web.bo.OrderHandleBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 功能描述：订单处理对象响应类
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/13 02:28
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@ApiModel(value = "orderHandleRsp", description = "处理中的订单对象")
public class OrderHandleRsp extends RspHead {

    @ApiModelProperty(value = "订单处理信息", required = true, name = "orderHandleList", example = "[{},{}]")
    private List<OrderHandleBO> orderHandleList;

    @ApiModelProperty(value = "订单信息", required = true, name = "order", example = "{}")
    private OrderBO order;

    public List<OrderHandleBO> getOrderHandleList() {
        return orderHandleList;
    }

    public void setOrderHandleList(List<OrderHandleBO> orderHandleList) {
        this.orderHandleList = orderHandleList;
    }

    public OrderBO getOrder() {
        return order;
    }

    public void setOrder(OrderBO order) {
        this.order = order;
    }

}
