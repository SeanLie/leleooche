package com.leletc.oocheorder.entity;

import org.jeecgframework.core.common.entity.BaseIDEntity;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 功能描述：订单处理表实体类
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/10 22:23
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Entity
@Table(name = "auto_orders_handle")
public class OrdersHandleEntity extends BaseIDEntity {

    /**
     * 订单ID
     */
    @Excel(name = "订单ID", width = 15)
    private java.lang.String orderId;
    /**
     * 处理人ID
     */
    @Excel(name = "处理人ID", width = 15)
    private java.lang.String dealUserId;
    /**
     * 处理人ID
     */
    @Excel(name = "订单状态", width = 15)
    private java.lang.String orderStatus;
    /**
     * 处理人ID
     */
    @Excel(name = "状态名称", width = 15)
    private java.lang.String statusName;
    /**
     * 处理动作
     */
    @Excel(name = "处理动作", width = 15)
    private java.lang.String dealAct;
    /**
     * 处理时间
     */
    @Excel(name = "处理时间", width = 15, format = "yyyy-MM-dd")
    private java.util.Date dealTime;
    /**
     * 处理描述
     */
    @Excel(name = "处理描述", width = 15)
    private java.lang.String dealDesc;
    /**
     * 创建人名称
     */
    private java.lang.String createName;
    /**
     * 创建人登录名称
     */
    private java.lang.String createBy;
    /**
     * 创建日期
     */
    private java.util.Date createDate;
    /**
     * 更新人名称
     */
    private java.lang.String updateName;
    /**
     * 更新人登录名称
     */
    private java.lang.String updateBy;
    /**
     * 更新日期
     */
    private java.util.Date updateDate;
    /**
     * 处理人名字
     */
    @Excel(name = "处理人名字", width = 15)
    private java.lang.String dealUserName;

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  订单ID
     */

    @Column(name = "ORDER_ID", nullable = false, length = 36)
    public java.lang.String getOrderId() {
        return this.orderId;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  订单ID
     */
    public void setOrderId(java.lang.String orderId) {
        this.orderId = orderId;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  处理人ID
     */
    @Column(name = "DEAL_USER_ID", nullable = false, length = 32)
    public java.lang.String getDealUserId() {
        return this.dealUserId;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  处理人ID
     */
    public void setDealUserId(java.lang.String dealUserId) {
        this.dealUserId = dealUserId;
    }

    @Column(name = "ORDER_STATUS", length = 2)
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Column(name = "STATUS_NAME")
    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  处理动作
     */

    @Column(name = "DEAL_ACT", nullable = true, length = 32)
    public java.lang.String getDealAct() {
        return this.dealAct;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  处理动作
     */
    public void setDealAct(java.lang.String dealAct) {
        this.dealAct = dealAct;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date  处理时间
     */

    @Column(name = "DEAL_TIME", nullable = true)
    public java.util.Date getDealTime() {
        return this.dealTime;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date  处理时间
     */
    public void setDealTime(java.util.Date dealTime) {
        this.dealTime = dealTime;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  处理描述
     */

    @Column(name = "DEAL_DESC", nullable = true, length = 255)
    public java.lang.String getDealDesc() {
        return this.dealDesc;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  处理描述
     */
    public void setDealDesc(java.lang.String dealDesc) {
        this.dealDesc = dealDesc;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  创建人名称
     */

    @Column(name = "CREATE_NAME", nullable = true, length = 50)
    public java.lang.String getCreateName() {
        return this.createName;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  创建人名称
     */
    public void setCreateName(java.lang.String createName) {
        this.createName = createName;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  创建人登录名称
     */

    @Column(name = "CREATE_BY", nullable = true, length = 50)
    public java.lang.String getCreateBy() {
        return this.createBy;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  创建人登录名称
     */
    public void setCreateBy(java.lang.String createBy) {
        this.createBy = createBy;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date  创建日期
     */

    @Column(name = "CREATE_DATE", nullable = true)
    public java.util.Date getCreateDate() {
        return this.createDate;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date  创建日期
     */
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  更新人名称
     */

    @Column(name = "UPDATE_NAME", nullable = true, length = 50)
    public java.lang.String getUpdateName() {
        return this.updateName;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  更新人名称
     */
    public void setUpdateName(java.lang.String updateName) {
        this.updateName = updateName;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  更新人登录名称
     */

    @Column(name = "UPDATE_BY", nullable = true, length = 50)
    public java.lang.String getUpdateBy() {
        return this.updateBy;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  更新人登录名称
     */
    public void setUpdateBy(java.lang.String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date  更新日期
     */

    @Column(name = "UPDATE_DATE", nullable = true)
    public java.util.Date getUpdateDate() {
        return this.updateDate;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date  更新日期
     */
    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  处理人名字
     */

    @Column(name = "DEAL_USER_NAME", nullable = true, length = 32)
    public java.lang.String getDealUserName() {
        return this.dealUserName;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  处理人名字
     */
    public void setDealUserName(java.lang.String dealUserName) {
        this.dealUserName = dealUserName;
    }
}
