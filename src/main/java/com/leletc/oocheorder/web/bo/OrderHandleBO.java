package com.leletc.oocheorder.web.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 功能描述：订单处理详情业务对象类
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/12/28 17:40
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@ApiModel(value = "orderHandle", description = "订单处理详情业务对象类")
public class OrderHandleBO {

    /**
     * 订单ID
     */
    @ApiModelProperty(value = "订单ID", name = "orderId", required = true, example = "123321")
    private java.lang.String orderId;
    /**
     * 处理人ID
     */
    @ApiModelProperty(value = "处理人ID", name = "dealUserId", required = true, example = "123321")
    private java.lang.String dealUserId;
    /**
     * 订单状态
     */
    @ApiModelProperty(value = "订单状态", name = "orderStatus", required = true, example = "2")
    private java.lang.String orderStatus;
    /**
     * 订单状态名称
     */
    @ApiModelProperty(value = "订单状态名称", name = "statusName", required = true, example = "待接单")
    private java.lang.String statusName;
    /**
     * 处理动作
     */
    @ApiModelProperty(value = "处理动作", name = "dealAct", required = true, example = "接单")
    private java.lang.String dealAct;
    /**
     * 处理时间
     */
    @ApiModelProperty(value = "处理时间", name = "dealTime", required = true, example = "2018-12-12 12:20:20")
    private java.util.Date dealTime;
    /**
     * 处理描述
     */
    @ApiModelProperty(value = "处理描述", name = "dealDesc", required = true, example = "洗车工XXX接单")
    private java.lang.String dealDesc;
    /**
     * 处理人用户名
     */
    @ApiModelProperty(value = "处理人用户名", name = "dealUserName", required = true, example = "小木木")
    private java.lang.String dealUserName;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDealUserId() {
        return dealUserId;
    }

    public void setDealUserId(String dealUserId) {
        this.dealUserId = dealUserId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getDealAct() {
        return dealAct;
    }

    public void setDealAct(String dealAct) {
        this.dealAct = dealAct;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public String getDealDesc() {
        return dealDesc;
    }

    public void setDealDesc(String dealDesc) {
        this.dealDesc = dealDesc;
    }

    public String getDealUserName() {
        return dealUserName;
    }

    public void setDealUserName(String dealUserName) {
        this.dealUserName = dealUserName;
    }

    @Override
    public String toString() {
        return "OrderHandleBO{" +
                "orderId='" + orderId + '\'' +
                ", dealUserId='" + dealUserId + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", statusName='" + statusName + '\'' +
                ", dealAct='" + dealAct + '\'' +
                ", dealTime=" + dealTime +
                ", dealDesc='" + dealDesc + '\'' +
                ", dealUserName='" + dealUserName + '\'' +
                '}';
    }
}
