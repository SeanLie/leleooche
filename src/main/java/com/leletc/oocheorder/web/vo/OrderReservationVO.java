
package com.leletc.oocheorder.web.vo;

import com.leletc.oocheorder.entity.OrderDetailEntity;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：预约订单视图
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/30 02:04
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public class OrderReservationVO implements java.io.Serializable {
    /**
     * 主键
     */
    private java.lang.String id;
    /**
     * 服务产品ID
     */
    @Excel(name = "服务产品ID")
    private java.lang.String productId;
    /**
     * 订单编号
     */
    @Excel(name = "订单编号")
    private java.lang.String orderCode;
    /**
     * 预约排序
     */
    @Excel(name = "预约排序")
    private java.lang.Integer orderSort;
    /**
     * 预订用户
     */
    @Excel(name = "预订用户", width = 15)
    private java.lang.String orderUsers;
    /**
     * 订单状态:1:车主已预约,2:待服务商取车,3:服务商已接单,4:服务商服务中,5:服务商已洗好车,6:车主已取车，结束。
     */
    @Excel(name = "订单状态", width = 15, dicCode = "ord_status")
    private java.lang.String orderStatus;

    @Excel(name = "状态名称", width = 15, dicCode = "status_name")
    private java.lang.String statusName;
    /**
     * 状态描述
     */
    @Excel(name = "状态描述", width = 15, dicCode = "status_remark")
    private java.lang.String statusRemark;
    /**
     * 订单日期
     */
    @Excel(name = "订单日期", width = 15, format = "yyyy-MM-dd")
    private java.util.Date orderTime;
    /**
     * 预约排序
     */
    @Excel(name = "预约排序", width = 15)
    private java.lang.Integer orderLevel;
    /**
     * 用户停车地点
     */
    @Excel(name = "用户停车地点", width = 15)
    private java.lang.String parkSpace;
    /**
     * 用户停车位
     */
    @Excel(name = "用户停车位", width = 50)
    private java.lang.String parkNo;
    /**
     * 用户车牌号
     */
    @Excel(name = "用户车牌号", width = 15)
    private java.lang.String plateNumber;
    /**
     * 用户停车照片
     */
    @Excel(name = "用户停车照片", width = 15)
    private java.lang.String parkPhoto;
    /**
     * 服务商停车位
     */
    @Excel(name = "服务商停车位", width = 15)
    private java.lang.String providerParkNo;
    /**
     * 服务商停车照片
     */
    @Excel(name = "服务商停车照片", width = 15)
    private java.lang.String providerParkPhoto;
    /**
     * 订单描述
     */
    @Excel(name = "订单描述", width = 15)
    private java.lang.String orderDesc;
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
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  主键
     */
    public java.lang.String getId() {
        return this.id;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  主键
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  服务产品ID
     */
    public java.lang.String getProductId() {
        return this.productId;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  服务产品ID
     */
    public void setProductId(java.lang.String productId) {
        this.productId = productId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusRemark() {
        return statusRemark;
    }

    public void setStatusRemark(String statusRemark) {
        this.statusRemark = statusRemark;
    }

    public Integer getOrderLevel() {
        return orderLevel;
    }

    public void setOrderLevel(Integer orderLevel) {
        this.orderLevel = orderLevel;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  订单编号
     */
    public java.lang.String getOrderCode() {
        return this.orderCode;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  订单编号
     */
    public void setOrderCode(java.lang.String orderCode) {
        this.orderCode = orderCode;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  预订用户
     */
    public java.lang.String getOrderUsers() {
        return this.orderUsers;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  预订用户
     */
    public void setOrderUsers(java.lang.String orderUsers) {
        this.orderUsers = orderUsers;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  订单状态
     */
    public java.lang.String getOrderStatus() {
        return this.orderStatus;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  订单状态
     */
    public void setOrderStatus(java.lang.String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date  订单日期
     */
    public java.util.Date getOrderTime() {
        return this.orderTime;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date  订单日期
     */
    public void setOrderTime(java.util.Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer  预约排序
     */
    public java.lang.Integer getOrderSort() {
        return this.orderSort;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer  预约排序
     */
    public void setOrderSort(java.lang.Integer orderSort) {
        this.orderSort = orderSort;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  用户停车地点
     */
    public java.lang.String getParkSpace() {
        return this.parkSpace;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  用户停车地点
     */
    public void setParkSpace(java.lang.String parkSpace) {
        this.parkSpace = parkSpace;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  用户停车位
     */
    public java.lang.String getParkNo() {
        return this.parkNo;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  用户停车位
     */
    public void setParkNo(java.lang.String parkNo) {
        this.parkNo = parkNo;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  用户停车照片
     */
    public java.lang.String getParkPhoto() {
        return this.parkPhoto;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  用户停车照片
     */
    public void setParkPhoto(java.lang.String parkPhoto) {
        this.parkPhoto = parkPhoto;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  服务商停车位
     */
    public java.lang.String getProviderParkNo() {
        return this.providerParkNo;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  服务商停车位
     */
    public void setProviderParkNo(java.lang.String providerParkNo) {
        this.providerParkNo = providerParkNo;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  服务商停车照片
     */
    public java.lang.String getProviderParkPhoto() {
        return this.providerParkPhoto;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  服务商停车照片
     */
    public void setProviderParkPhoto(java.lang.String providerParkPhoto) {
        this.providerParkPhoto = providerParkPhoto;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  订单描述
     */
    public java.lang.String getOrderDesc() {
        return this.orderDesc;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  订单描述
     */
    public void setOrderDesc(java.lang.String orderDesc) {
        this.orderDesc = orderDesc;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  创建人名称
     */
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
     * 保存-预约订单明细
     */
    @ExcelCollection(name = "预约订单明细")
    private List<OrderDetailEntity> autoOrdersDetailList = new ArrayList<OrderDetailEntity>();

    public List<OrderDetailEntity> getAutoOrdersDetailList() {
        return autoOrdersDetailList;
    }

    public void setAutoOrdersDetailList(List<OrderDetailEntity> autoOrdersDetailList) {
        this.autoOrdersDetailList = autoOrdersDetailList;
    }

    @Override
    public String toString() {
        return "OrderReservationVO{" +
                "id='" + id + '\'' +
                ", productId='" + productId + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", orderUsers='" + orderUsers + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderTime=" + orderTime +
                ", orderSort=" + orderSort +
                ", parkSpace='" + parkSpace + '\'' +
                ", parkNo='" + parkNo + '\'' +
                ", parkPhoto='" + parkPhoto + '\'' +
                ", providerParkNo='" + providerParkNo + '\'' +
                ", providerParkPhoto='" + providerParkPhoto + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                ", createName='" + createName + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate=" + createDate +
                ", updateName='" + updateName + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateDate=" + updateDate +
                ", autoOrdersDetailList=" + autoOrdersDetailList +
                '}';
    }

}
