package com.leletc.oocheorder.web.bo;

import com.leletc.product.web.bo.BaseProductsBO;
import com.leletc.user.bo.OrderUserBO;
import com.leletc.user.pojo.Vehicle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 功能描述：预约订单业务对象
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/13 00:44
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@ApiModel(value = "orderReservationBo", description = "预约订单对象")
public class OrderReservationBO {

    @ApiModelProperty(value = "订单对象", required = true, name = "order", example = "{}")
    private OrderBO order;

    @ApiModelProperty(value = "用户产品", required = true, name = "product", example = "{}")
    private BaseProductsBO product;

    @ApiModelProperty(value = "订单用户", required = true, name = "user", example = "{}")
    private OrderUserBO user;

    @ApiModelProperty(value = "用户车辆", required = true, name = "vehicle", example = "{}")
    private Vehicle vehicle;

    public OrderBO getOrder() {
        return order;
    }

    public void setOrder(OrderBO order) {
        this.order = order;
    }

    public BaseProductsBO getProduct() {
        return product;
    }

    public void setProduct(BaseProductsBO product) {
        this.product = product;
    }

    public OrderUserBO getUser() {
        return user;
    }

    public void setUser(OrderUserBO user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
