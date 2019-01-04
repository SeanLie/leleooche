package com.leletc.oocheorder.web.api.response;

import com.leletc.base.api.response.RspHead;
import com.leletc.oocheorder.web.bo.OrderReservationBO;
import com.leletc.oocheorder.web.bo.ReservationBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 功能描述：预约订单响应类
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/11 23:29
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@ApiModel(value = "orderReservationRsp", description = "响应体Header")
public class OrderReservationRsp extends RspHead {

    @ApiModelProperty(value = "预约信息", required = true, name = "reservation", example = "{}")
    private ReservationBO reservation;

    public ReservationBO getReservation() {
        return reservation;
    }

    public void setReservation(ReservationBO reservation) {
        this.reservation = reservation;
    }
}
