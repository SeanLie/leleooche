package com.leletc.oocheorder.web.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 功能描述：
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/30 02:15
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@ApiModel(value = "order", description = "订单对象")
public class OrderBO {

    @ApiModelProperty(value = "ID", name = "id", required = true, example = "1232der234wff32f")
    private java.lang.String id;
    /**
     * 服务产品ID
     */
    private java.lang.String productId;
    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号", name = "orderCode", required = true, example = "1232der234wff32f")
    private java.lang.String orderCode;
    /**
     * 预订用户
     */
    private java.lang.String orderUsers;
    /**
     * 订单状态:1:车主已预约,2:待服务商取车,3:服务商已接单,4:服务商服务中,5:服务商已洗好车,6:车主已取车，结束。
     */
    private java.lang.String orderStatus;
    /**
     * 状态名称
     */
    private java.lang.String statusName;
    /**
     * 状态描述
     */
    private java.lang.String statusRemark;
    /**
     * 订单日期
     */
    private java.util.Date orderTime;
    /**
     * 预约排序
     */
    private java.lang.Integer orderLevel;
    /**
     * 用户停车地点
     */
    private java.lang.String parkSpace;
    /**
     * 用户停车位
     */
    private java.lang.String parkNo;
    /**
     * 用户车牌号
     */
    private java.lang.String plateNumber;
    /**
     * 用户停车照片
     */
    private java.lang.String parkPhoto;
    /**
     * 服务商停车位
     */
    private java.lang.String providerParkNo;
    /**
     * 服务商停车照片
     */
    private java.lang.String providerParkPhoto;
    /**
     * 订单描述
     */
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderUsers() {
        return orderUsers;
    }

    public void setOrderUsers(String orderUsers) {
        this.orderUsers = orderUsers;
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

    public String getStatusRemark() {
        return statusRemark;
    }

    public void setStatusRemark(String statusRemark) {
        this.statusRemark = statusRemark;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getOrderLevel() {
        return orderLevel;
    }

    public void setOrderLevel(Integer orderLevel) {
        this.orderLevel = orderLevel;
    }

    public String getParkSpace() {
        return parkSpace;
    }

    public void setParkSpace(String parkSpace) {
        this.parkSpace = parkSpace;
    }

    public String getParkNo() {
        return parkNo;
    }

    public void setParkNo(String parkNo) {
        this.parkNo = parkNo;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getParkPhoto() {
        return parkPhoto;
    }

    public void setParkPhoto(String parkPhoto) {
        this.parkPhoto = parkPhoto;
    }

    public String getProviderParkNo() {
        return providerParkNo;
    }

    public void setProviderParkNo(String providerParkNo) {
        this.providerParkNo = providerParkNo;
    }

    public String getProviderParkPhoto() {
        return providerParkPhoto;
    }

    public void setProviderParkPhoto(String providerParkPhoto) {
        this.providerParkPhoto = providerParkPhoto;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "OrderBO{" +
                "id='" + id + '\'' +
                ", productId='" + productId + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", orderUsers='" + orderUsers + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", statusName='" + statusName + '\'' +
                ", statusRemark='" + statusRemark + '\'' +
                ", orderTime=" + orderTime +
                ", orderLevel=" + orderLevel +
                ", parkSpace='" + parkSpace + '\'' +
                ", parkNo='" + parkNo + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", parkPhoto='" + parkPhoto + '\'' +
                ", providerParkNo='" + providerParkNo + '\'' +
                ", providerParkPhoto='" + providerParkPhoto + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                ", createName='" + createName + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
