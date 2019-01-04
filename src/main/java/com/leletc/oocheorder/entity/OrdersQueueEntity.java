/**
 * 实体Entity层
 */
package com.leletc.oocheorder.entity;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.core.common.entity.BaseIDEntity;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.*;
import java.util.Date;

/**
 * 功能描述：订单预约队列表实体类
 * <p>
 *
 * @author Sean
 * <p>
 * @date 2018-11-11 14:06:54
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
@Table(name = "auto_orders_queue")
public class OrdersQueueEntity extends BaseIDEntity {

    @Excel(name = "订单ID", width = 15)
    private String orderId;

    /**
     * 队列日期
     */
    @Excel(name = "队列日期", width = 15, format = "yyyy-MM-dd")
    private Date queueDate;
    /**
     * 排队编号
     */
    @Excel(name = "排队编号", width = 15)
    private String queueNo;
    /**
     * 排队用户
     */
    @Excel(name = "排队用户", width = 15)
    private String queueUser;
    /**
     * 排队状态：0：排队结束，1：排队中
     */
    @Excel(name = "排队状态", width = 15)
    private String queueStatus;
    /**
     * 创建人名称
     */
    @Excel(name = "创建人名称", width = 15)
    private String createName;
    /**
     * 创建人登录名称
     */
    @Excel(name = "创建人登录名称", width = 15)
    private String createBy;
    /**
     * 创建日期
     */
    @Excel(name = "创建日期", width = 15, format = "yyyy-MM-dd")
    private Date createDate;
    /**
     * 更新人名称
     */
    @Excel(name = "更新人名称", width = 15)
    private String updateName;
    /**
     * 更新人登录名称
     */
    @Excel(name = "更新人登录名称", width = 15)
    private String updateBy;
    /**
     * 更新日期
     */
    @Excel(name = "更新日期", width = 15, format = "yyyy-MM-dd")
    private Date updateDate;

    @Column(name = "ORDER_ID")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date  队列日期
     */

    @Column(name = "QUEUE_DATE")
    public Date getQueueDate() {
        return this.queueDate;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date  队列日期
     */
    public void setQueueDate(Date queueDate) {
        this.queueDate = queueDate;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  排队编号
     */

    @Column(name = "QUEUE_NO", nullable = true, length = 32)
    public String getQueueNo() {
        return this.queueNo;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  排队编号
     */
    public void setQueueNo(String queueNo) {
        this.queueNo = queueNo;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  排队用户
     */

    @Column(name = "QUEUE_USER", nullable = true, length = 32)
    public String getQueueUser() {
        return this.queueUser;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  排队用户
     */
    public void setQueueUser(String queueUser) {
        this.queueUser = queueUser;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  排队状态
     */

    @Column(name = "QUEUE_STATUS", nullable = true, length = 32)
    public String getQueueStatus() {
        return this.queueStatus;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  排队状态
     */
    public void setQueueStatus(String queueStatus) {
        this.queueStatus = queueStatus;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  创建人名称
     */

    @Column(name = "CREATE_NAME", nullable = true, length = 50)
    public String getCreateName() {
        return this.createName;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  创建人名称
     */
    public void setCreateName(String createName) {
        this.createName = createName;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  创建人登录名称
     */

    @Column(name = "CREATE_BY", nullable = true, length = 50)
    public String getCreateBy() {
        return this.createBy;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  创建人登录名称
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date  创建日期
     */

    @Column(name = "CREATE_DATE", nullable = true)
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date  创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  更新人名称
     */

    @Column(name = "UPDATE_NAME", nullable = true, length = 50)
    public String getUpdateName() {
        return this.updateName;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  更新人名称
     */
    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  更新人登录名称
     */

    @Column(name = "UPDATE_BY", nullable = true, length = 50)
    public String getUpdateBy() {
        return this.updateBy;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  更新人登录名称
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date  更新日期
     */

    @Column(name = "UPDATE_DATE", nullable = true)
    public Date getUpdateDate() {
        return this.updateDate;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date  更新日期
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}