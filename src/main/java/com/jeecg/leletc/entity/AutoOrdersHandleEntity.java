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
 * @Description: 订单处理
 * @author onlineGenerator
 * @date 2019-01-01 10:53:13
 * @version V1.0   
 *
 */
@Entity
@Table(name = "auto_orders_handle", schema = "")
@SuppressWarnings("serial")
public class AutoOrdersHandleEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**订单ID*/
	@Excel(name="订单ID",width=15)
	private java.lang.String orderId;
	/**处理人ID*/
	@Excel(name="处理人ID",width=15)
	private java.lang.String dealUserId;
	/**处理动作*/
	@Excel(name="处理动作",width=15)
	private java.lang.String dealAct;
	/**处理时间*/
	@Excel(name="处理时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date dealTime;
	/**处理描述*/
	@Excel(name="处理描述",width=15)
	private java.lang.String dealDesc;
	/**创建人名称*/
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	private java.util.Date createDate;
	/**更新人名称*/
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	private java.util.Date updateDate;
	/**处理人名字*/
	@Excel(name="处理人名字",width=15)
	private java.lang.String dealUserName;
	
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
	 *@return: java.lang.String  订单ID
	 */

	@Column(name ="ORDER_ID",nullable=false,length=36)
	public java.lang.String getOrderId(){
		return this.orderId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单ID
	 */
	public void setOrderId(java.lang.String orderId){
		this.orderId = orderId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  处理人ID
	 */

	@Column(name ="DEAL_USER_ID",nullable=false,length=32)
	public java.lang.String getDealUserId(){
		return this.dealUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  处理人ID
	 */
	public void setDealUserId(java.lang.String dealUserId){
		this.dealUserId = dealUserId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  处理动作
	 */

	@Column(name ="DEAL_ACT",nullable=true,length=32)
	public java.lang.String getDealAct(){
		return this.dealAct;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  处理动作
	 */
	public void setDealAct(java.lang.String dealAct){
		this.dealAct = dealAct;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  处理时间
	 */

	@Column(name ="DEAL_TIME",nullable=true)
	public java.util.Date getDealTime(){
		return this.dealTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  处理时间
	 */
	public void setDealTime(java.util.Date dealTime){
		this.dealTime = dealTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  处理描述
	 */

	@Column(name ="DEAL_DESC",nullable=true,length=255)
	public java.lang.String getDealDesc(){
		return this.dealDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  处理描述
	 */
	public void setDealDesc(java.lang.String dealDesc){
		this.dealDesc = dealDesc;
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  处理人名字
	 */

	@Column(name ="DEAL_USER_NAME",nullable=true,length=32)
	public java.lang.String getDealUserName(){
		return this.dealUserName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  处理人名字
	 */
	public void setDealUserName(java.lang.String dealUserName){
		this.dealUserName = dealUserName;
	}
}
