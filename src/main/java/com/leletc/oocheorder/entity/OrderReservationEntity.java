package com.leletc.oocheorder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.jeecgframework.core.common.entity.BaseIDEntity;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * 订单信息表实体类
 *
 * @author onlineGenerator
 * @version V1.0
 * @Title: Entity
 * @Description: 预约订单
 * @date 2018-09-06 22:15:49
 */
@Entity
@Table(name = "auto_orders_reservation")
public class OrderReservationEntity extends BaseIDEntity {

	/**
	 * 服务产品ID
	 */
	@Excel(name = "服务产品ID", width = 15)
	private java.lang.String productId;
	/**
	 * 订单编号
	 */
	@Excel(name = "订单编号", width = 15)
	private java.lang.String orderCode;
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
	 * 处理人名称
	 */
	// private java.lang.String handleUserID;

	/**
	 * @return the handleUserID
	 */
//	@Column(name = "HANDLE_USER_ID", length = 36)
//	public java.lang.String getHandleUserID() {
//		return handleUserID;
//	}
//
//	/**
//	 * @param handleUserID the handleUserID to set
//	 */
//	public void setHandleUserID(java.lang.String handleUserID) {
//		this.handleUserID = handleUserID;
//	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 服务产品ID
	 */
	@Column(name = "PRODUCT_ID", length = 36)
	public java.lang.String getProductId() {
		return this.productId;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 服务产品ID
	 */
	public void setProductId(java.lang.String productId) {
		this.productId = productId;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 订单编号
	 */

	@Column(name = "ORDER_CODE", nullable = true, length = 36)
	public java.lang.String getOrderCode() {
		return this.orderCode;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 订单编号
	 */
	public void setOrderCode(java.lang.String orderCode) {
		this.orderCode = orderCode;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 预订用户
	 */
	@Column(name = "ORDER_USERS", nullable = true, length = 36)
	public java.lang.String getOrderUsers() {
		return this.orderUsers;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 预订用户
	 */
	public void setOrderUsers(java.lang.String orderUsers) {
		this.orderUsers = orderUsers;
	}

	/**
	 * 方法: 取得订单状态:1:车主已预约,2:待服务商取车,3:服务商已接单,4:服务商服务中,5:服务商已洗好车,6:车主已取车，结束。
	 *
	 * @return: java.lang.String
	 */
	@Column(name = "ORDER_STATUS", nullable = false, length = 32)
	public java.lang.String getOrderStatus() {
		return this.orderStatus;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 订单状态
	 */
	public void setOrderStatus(java.lang.String orderStatus) {
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
	 * 获得状态描述
	 *
	 * @return
	 */
	@Column(name = "STATUS_REMARK", length = 32)
	public String getStatusRemark() {
		return statusRemark;
	}

	public void setStatusRemark(String statusRemark) {
		this.statusRemark = statusRemark;
	}

	/**
	 * 方法: 取得java.util.Date
	 *
	 * @return: java.util.Date 订单日期
	 */

	@Column(name = "ORDER_TIME", nullable = false)
	public java.util.Date getOrderTime() {
		return this.orderTime;
	}

	/**
	 * 方法: 设置java.util.Date
	 *
	 * @param: java.util.Date 订单日期
	 */
	public void setOrderTime(java.util.Date orderTime) {
		this.orderTime = orderTime;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 *
	 * @return: java.lang.Integer 预约排序
	 */

	@Column(name = "ORDER_LEVEL", nullable = false, length = 32)
	public java.lang.Integer getOrderLevel() {
		return this.orderLevel;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 *
	 * @param: java.lang.Integer 预约排序
	 */
	public void setOrderLevel(java.lang.Integer orderLevel) {
		this.orderLevel = orderLevel;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 用户停车地点
	 */

	@Column(name = "PARK_SPACE", nullable = true, length = 255)
	public java.lang.String getParkSpace() {
		return this.parkSpace;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 用户停车地点
	 */
	public void setParkSpace(java.lang.String parkSpace) {
		this.parkSpace = parkSpace;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 用户停车位
	 */
	@Column(name = "PARK_NO", nullable = true, length = 10)
	public java.lang.String getParkNo() {
		return this.parkNo;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 用户停车位
	 */
	public void setParkNo(java.lang.String parkNo) {
		this.parkNo = parkNo;
	}

	/**
	 * 获得车处牌号
	 *
	 * @return
	 */
	@Column(name = "PLATE_NUMBER", nullable = false, length = 20)
	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 用户停车照片
	 */
	@Column(name = "PARK_PHOTO", nullable = false, length = 32)
	public java.lang.String getParkPhoto() {
		return this.parkPhoto;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 用户停车照片
	 */
	public void setParkPhoto(java.lang.String parkPhoto) {
		this.parkPhoto = parkPhoto;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 服务商停车位
	 */

	@Column(name = "PROVIDER_PARK_NO", nullable = true, length = 10)
	public java.lang.String getProviderParkNo() {
		return this.providerParkNo;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 服务商停车位
	 */
	public void setProviderParkNo(java.lang.String providerParkNo) {
		this.providerParkNo = providerParkNo;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 服务商停车照片
	 */

	@Column(name = "PROVIDER_PARK_PHOTO", nullable = true, length = 255)
	public java.lang.String getProviderParkPhoto() {
		return this.providerParkPhoto;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 服务商停车照片
	 */
	public void setProviderParkPhoto(java.lang.String providerParkPhoto) {
		this.providerParkPhoto = providerParkPhoto;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 订单描述
	 */

	@Column(name = "ORDER_DESC", nullable = true, length = 255)
	public java.lang.String getOrderDesc() {
		return this.orderDesc;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 订单描述
	 */
	public void setOrderDesc(java.lang.String orderDesc) {
		this.orderDesc = orderDesc;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 创建人名称
	 */

	@Column(name = "CREATE_NAME", nullable = true, length = 50)
	public java.lang.String getCreateName() {
		return this.createName;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 创建人名称
	 */
	public void setCreateName(java.lang.String createName) {
		this.createName = createName;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 创建人登录名称
	 */

	@Column(name = "CREATE_BY", nullable = true, length = 50)
	public java.lang.String getCreateBy() {
		return this.createBy;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy) {
		this.createBy = createBy;
	}

	/**
	 * 方法: 取得java.util.Date
	 *
	 * @return: java.util.Date 创建日期
	 */

	@Column(name = "CREATE_DATE", nullable = true)
	public java.util.Date getCreateDate() {
		return this.createDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 *
	 * @param: java.util.Date 创建日期
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 更新人名称
	 */

	@Column(name = "UPDATE_NAME", nullable = true, length = 50)
	public java.lang.String getUpdateName() {
		return this.updateName;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 更新人名称
	 */
	public void setUpdateName(java.lang.String updateName) {
		this.updateName = updateName;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 更新人登录名称
	 */

	@Column(name = "UPDATE_BY", nullable = true, length = 50)
	public java.lang.String getUpdateBy() {
		return this.updateBy;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * 方法: 取得java.util.Date
	 *
	 * @return: java.util.Date 更新日期
	 */

	@Column(name = "UPDATE_DATE", nullable = true)
	public java.util.Date getUpdateDate() {
		return this.updateDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 *
	 * @param: java.util.Date 更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderReservationEntity [productId=" + productId + ", orderCode=" + orderCode + ", orderUsers="
				+ orderUsers + ", orderStatus=" + orderStatus + ", statusName=" + statusName + ", statusRemark="
				+ statusRemark + ", orderTime=" + orderTime + ", orderLevel=" + orderLevel + ", parkSpace=" + parkSpace
				+ ", parkNo=" + parkNo + ", plateNumber=" + plateNumber + ", parkPhoto=" + parkPhoto
				+ ", providerParkNo=" + providerParkNo + ", providerParkPhoto=" + providerParkPhoto + ", orderDesc="
				+ orderDesc + ", createName=" + createName + ", createBy=" + createBy + ", createDate=" + createDate
				+ ", updateName=" + updateName + ", updateBy=" + updateBy + ", updateDate=" + updateDate + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
//	@Override
//	public String toString() {
//		return "OrderReservationEntity [productId=" + productId + ", orderCode=" + orderCode + ", orderUsers="
//				+ orderUsers + ", orderStatus=" + orderStatus + ", statusName=" + statusName + ", statusRemark="
//				+ statusRemark + ", orderTime=" + orderTime + ", orderLevel=" + orderLevel + ", parkSpace=" + parkSpace
//				+ ", parkNo=" + parkNo + ", plateNumber=" + plateNumber + ", parkPhoto=" + parkPhoto
//				+ ", providerParkNo=" + providerParkNo + ", providerParkPhoto=" + providerParkPhoto + ", orderDesc="
//				+ orderDesc + ", createName=" + createName + ", createBy=" + createBy + ", createDate=" + createDate
//				+ ", updateName=" + updateName + ", updateBy=" + updateBy + ", updateDate=" + updateDate
//				+ ", handleUserID=" + handleUserID + "]";
//	}

}
