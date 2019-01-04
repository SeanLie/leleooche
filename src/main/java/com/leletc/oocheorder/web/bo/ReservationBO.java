package com.leletc.oocheorder.web.bo;

import com.leletc.product.web.bo.BaseProductsBO;
import com.leletc.user.bo.OrderUserBO;
import com.leletc.user.pojo.Vehicle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 功能描述：预约业务对象
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
@ApiModel(value = "reservationBo", description = "预约对象")
public class ReservationBO {

    @ApiModelProperty(value = "用户ID", required = true, name = "userId", example = "12312321")
    private String userId;

    @ApiModelProperty(value = "订单ID", required = true, name = "orderId", example = "12312321")
    private String orderId;

    @ApiModelProperty(value = "订单编号", required = true, name = "orderCode", example = "12312321")
    private String orderCode;

    @ApiModelProperty(value = "用户昵称", required = true, name = "userName", example = "小明")
    private String userName;

    @ApiModelProperty(value = "用户头像", required = true, name = "headImgUrl", example = "http://www.123123123.com")
    private String headImgUrl;

    @ApiModelProperty(value = "车型号", required = true, name = "vehicleModel", example = "奔驰 AMG 350")
    private String vehicleModel;

    @ApiModelProperty(value = "车牌号", required = true, name = "plateNumber", example = "粤B28886")
    private String plateNumber;

    @ApiModelProperty(value = "停车编号", required = true, name = "parkNo", example = "A1001")
    private String parkNo;

    @ApiModelProperty(value = "订单日期", required = true, name = "orderTime", example = "2018-11-11 17:37:28")
    private String orderTime;

    @ApiModelProperty(value = "状态名称", required = true, name = "statusName", example = "已预约")
    private String statusName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getParkNo() {
        return parkNo;
    }

    public void setParkNo(String parkNo) {
        this.parkNo = parkNo;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "OrderReservationRsp{" +
                "orderId='" + orderId + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", userName='" + userName + '\'' +
                ", headImgUrl='" + headImgUrl + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                ", parkNo='" + parkNo + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", statusName='" + statusName + '\'' +
                '}';
    }

}
