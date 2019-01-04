package com.leletc.oocheorder.web.api.request;

import com.leletc.base.api.request.ReqHead;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 功能描述：预约订单请求类
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/11 23:10
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@ApiModel(value = "orderReservationReq", description = "预约订单请求对象")
public class OrderReservationReq extends ReqHead implements Serializable {

    // 用户ID
    @ApiModelProperty(value = "用户ID", required = true, name = "userId", example = "58840f4059874ed78a2a1185f37e08b8")
    private String userId;
    // 服务产品ID
    @ApiModelProperty(value = "服务产品ID", required = true, name = "productId", example = "402881e765aa06530165aa0b6eb10007")
    private String productId;
    // 用户停车位编号
    @ApiModelProperty(value = "用户停车位编号", required = true, name = "productId", example = "负一楼B区520号")
    private String parkNo;
    // 用户停车照片ID
    @ApiModelProperty(value = "用户停车照片ID", required = true, name = "parkPhoto", example = "18f4d746fa534789981c3f93fc216146")
    private String parkPhoto;
    // 用户车牌号
    @ApiModelProperty(value = "用户车牌号", required = true, name = "plateNumber", example = "粤B0666B")
    private String plateNumber;
    // 用户预约时间
    @ApiModelProperty(value = "用户预约时间", required = true, name = "orderTime", example = "2018-11-11T17:37:28.333Z")
    private Date orderTime;
    // 订单描述
    @ApiModelProperty(value = "订单描述", name = "orderDesc", example = "描述内容")
    private String orderDesc;

    public OrderReservationReq() {
        super();
    }

    public OrderReservationReq(String userId, String productId, String parkNo, String parkPhoto, String plateNumber,
                               String orderDesc) {
        this.userId = userId;
        this.productId = productId;
        this.parkNo = parkNo;
        this.parkPhoto = parkPhoto;
        this.plateNumber = plateNumber;
        this.orderDesc = orderDesc;
    }

    /**
     * @param userId
     * @param productId
     * @param parkNo
     * @param parkPhoto
     * @param plateNumber
     * @param orderTime
     * @param orderDesc
     */
    public OrderReservationReq(String userId, String productId, String parkNo, String parkPhoto, String plateNumber,
                               Date orderTime, String orderDesc) {
        super();
        this.userId = userId;
        this.productId = productId;
        this.parkNo = parkNo;
        this.parkPhoto = parkPhoto;
        this.plateNumber = plateNumber;
        this.orderTime = orderTime;
        this.orderDesc = orderDesc;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * @return the parkNo
     */
    public String getParkNo() {
        return parkNo;
    }

    /**
     * @param parkNo the parkNo to set
     */
    public void setParkNo(String parkNo) {
        this.parkNo = parkNo;
    }

    /**
     * @return the parkPhoto
     */
    public String getParkPhoto() {
        return parkPhoto;
    }

    /**
     * @param parkPhoto the parkPhoto to set
     */
    public void setParkPhoto(String parkPhoto) {
        this.parkPhoto = parkPhoto;
    }

    /**
     * @return the plateNumber
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * @param plateNumber the plateNumber to set
     */
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    /**
     * @return the orderDesc
     */
    public String getOrderDesc() {
        return orderDesc;
    }

    /**
     * @param orderDesc the orderDesc to set
     */
    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    /**
     * @return the orderTime
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * @param orderTime the orderTime to set
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "OrderReservationReq [userId=" + userId + ", productId=" + productId + ", parkNo=" + parkNo + ", parkPhoto="
                + parkPhoto + ", plateNumber=" + plateNumber + ", orderTime=" + orderTime + ", orderDesc=" + orderDesc
                + "]";
    }

}
