package com.jeecg.leletc.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 预约订单
 * @author onlineGenerator
 * @date 2018-12-31 18:24:02
 * @version V1.0   
 *
 */
@Entity
@Table(name = "auto_orders_reservation", schema = "")
@SuppressWarnings("serial")
public class AutoOrdersReservationEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**服务产品ID*/
	private java.lang.String productId;
	/**订单编号*/
	@Excel(name="订单编号",width=15)
	private java.lang.String orderCode;
	/**预订用户*/
	private java.lang.String orderUsers;
	/**订单状态*/
	@Excel(name="订单状态",width=15)
	private java.lang.String orderStatus;
	/**状态名称*/
	@Excel(name="状态名称",width=15)
	private java.lang.String statusName;
	/**状态备注*/
	@Excel(name="状态备注",width=15)
	private java.lang.String statusRemark;
	/**订单日期*/
	@Excel(name="订单日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date orderTime;
	/**预约排序*/
	@Excel(name="预约排序",width=15)
	private java.lang.Integer orderLevel;
	/**用户停车地点*/
	@Excel(name="用户停车地点",width=15)
	private java.lang.String parkSpace;
	/**用户停车位*/
	@Excel(name="用户停车位",width=15)
	private java.lang.String parkNo;
	/**车牌号*/
	@Excel(name="车牌号",width=15)
	private java.lang.String plateNumber;
	/**用户停车照片*/
	@Excel(name="用户停车照片",width=15)
	private java.lang.String parkPhoto;
	/**服务商停车位*/
	@Excel(name="服务商停车位",width=15)
	private java.lang.String providerParkNo;
	/**服务商停车照片*/
	@Excel(name="服务商停车照片",width=15)
	private java.lang.String providerParkPhoto;
	/**订单描述*/
	@Excel(name="订单描述",width=15)
	private java.lang.String orderDesc;
	/**创建人名称*/
	@Excel(name="创建人名称",width=15)
	private java.lang.String createName;
	/**创建人登录名称*/
	@Excel(name="创建人登录名称",width=15)
	private java.lang.String createBy;
	/**创建日期*/
	@Excel(name="创建日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date createDate;
	/**更新人名称*/
	@Excel(name="更新人名称",width=15)
	private java.lang.String updateName;
	/**更新人登录名称*/
	@Excel(name="更新人登录名称",width=15)
	private java.lang.String updateBy;
	/**更新日期*/
	@Excel(name="更新日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date updateDate;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务产品ID
	 */

	@Column(name ="PRODUCT_ID",nullable=true,length=36)
	public java.lang.String getProductId(){
		return this.productId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务产品ID
	 */
	public void setProductId(java.lang.String productId){
		this.productId = productId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订单编号
	 */

	@Column(name ="ORDER_CODE",nullable=true,length=36)
	public java.lang.String getOrderCode(){
		return this.orderCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单编号
	 */
	public void setOrderCode(java.lang.String orderCode){
		this.orderCode = orderCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  预订用户
	 */

	@Column(name ="ORDER_USERS",nullable=true,length=36)
	public java.lang.String getOrderUsers(){
		return this.orderUsers;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  预订用户
	 */
	public void setOrderUsers(java.lang.String orderUsers){
		this.orderUsers = orderUsers;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订单状态
	 */

	@Column(name ="ORDER_STATUS",nullable=true,length=32)
	public java.lang.String getOrderStatus(){
		return this.orderStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单状态
	 */
	public void setOrderStatus(java.lang.String orderStatus){
		this.orderStatus = orderStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态名称
	 */

	@Column(name ="STATUS_NAME",nullable=true,length=255)
	public java.lang.String getStatusName(){
		return this.statusName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态名称
	 */
	public void setStatusName(java.lang.String statusName){
		this.statusName = statusName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态备注
	 */

	@Column(name ="STATUS_REMARK",nullable=true,length=255)
	public java.lang.String getStatusRemark(){
		return this.statusRemark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态备注
	 */
	public void setStatusRemark(java.lang.String statusRemark){
		this.statusRemark = statusRemark;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  订单日期
	 */

	@Column(name ="ORDER_TIME",nullable=false)
	public java.util.Date getOrderTime(){
		return this.orderTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  订单日期
	 */
	public void setOrderTime(java.util.Date orderTime){
		this.orderTime = orderTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  预约排序
	 */

	@Column(name ="ORDER_LEVEL",nullable=false,length=10)
	public java.lang.Integer getOrderLevel(){
		return this.orderLevel;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  预约排序
	 */
	public void setOrderLevel(java.lang.Integer orderLevel){
		this.orderLevel = orderLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户停车地点
	 */

	@Column(name ="PARK_SPACE",nullable=true,length=255)
	public java.lang.String getParkSpace(){
		return this.parkSpace;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户停车地点
	 */
	public void setParkSpace(java.lang.String parkSpace){
		this.parkSpace = parkSpace;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户停车位
	 */

	@Column(name ="PARK_NO",nullable=true,length=10)
	public java.lang.String getParkNo(){
		return this.parkNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户停车位
	 */
	public void setParkNo(java.lang.String parkNo){
		this.parkNo = parkNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  车牌号
	 */

	@Column(name ="PLATE_NUMBER",nullable=false,length=255)
	public java.lang.String getPlateNumber(){
		return this.plateNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  车牌号
	 */
	public void setPlateNumber(java.lang.String plateNumber){
		this.plateNumber = plateNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户停车照片
	 */

	@Column(name ="PARK_PHOTO",nullable=true,length=32)
	public java.lang.String getParkPhoto(){
		return this.parkPhoto;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户停车照片
	 */
	public void setParkPhoto(java.lang.String parkPhoto){
		this.parkPhoto = parkPhoto;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务商停车位
	 */

	@Column(name ="PROVIDER_PARK_NO",nullable=true,length=10)
	public java.lang.String getProviderParkNo(){
		return this.providerParkNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务商停车位
	 */
	public void setProviderParkNo(java.lang.String providerParkNo){
		this.providerParkNo = providerParkNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务商停车照片
	 */

	@Column(name ="PROVIDER_PARK_PHOTO",nullable=true,length=32)
	public java.lang.String getProviderParkPhoto(){
		return this.providerParkPhoto;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务商停车照片
	 */
	public void setProviderParkPhoto(java.lang.String providerParkPhoto){
		this.providerParkPhoto = providerParkPhoto;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订单描述
	 */

	@Column(name ="ORDER_DESC",nullable=true,length=255)
	public java.lang.String getOrderDesc(){
		return this.orderDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单描述
	 */
	public void setOrderDesc(java.lang.String orderDesc){
		this.orderDesc = orderDesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */

	@Column(name ="CREATE_BY",nullable=true,length=50)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */

	@Column(name ="CREATE_DATE",nullable=true)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */

	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */

	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */

	@Column(name ="UPDATE_DATE",nullable=true)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
}
