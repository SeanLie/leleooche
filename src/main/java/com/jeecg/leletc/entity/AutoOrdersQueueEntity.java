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
 * @Description: 预约队列
 * @author onlineGenerator
 * @date 2019-01-01 13:01:31
 * @version V1.0   
 *
 */
@Entity
@Table(name = "auto_orders_queue", schema = "")
@SuppressWarnings("serial")
public class AutoOrdersQueueEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**订单ID*/
	@Excel(name="订单ID",width=15,dictTable ="auto_orders_reservation",dicCode ="id",dicText ="order_code")
	private java.lang.String orderId;
	/**队列日期*/
	@Excel(name="队列日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date queueDate;
	/**排队编号*/
	@Excel(name="排队编号",width=15)
	private java.lang.String queueNo;
	/**排队用户*/
	@Excel(name="排队用户",width=15,dictTable ="t_s_base_user",dicCode ="id",dicText ="realname")
	private java.lang.String queueUser;
	/**排队状态*/
	@Excel(name="排队状态",width=15)
	private java.lang.String queueStatus;
	/**创建人名称*/
	@Excel(name="创建人名称",width=15)
	private java.lang.String createName;
	/**创建人登录名称*/
	private java.lang.String createBy;
	/**创建日期*/
	@Excel(name="创建日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date createDate;
	/**更新人名称*/
	@Excel(name="更新人名称",width=15)
	private java.lang.String updateName;
	/**更新人登录名称*/
	private java.lang.String updateBy;
	/**更新日期*/
	@Excel(name="更新日期",width=15,format = "yyyy-MM-dd")
	private java.util.Date updateDate;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订单ID
	 */

	@Column(name ="ORDER_ID",nullable=true,length=35)
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
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  队列日期
	 */

	@Column(name ="QUEUE_DATE",nullable=true)
	public java.util.Date getQueueDate(){
		return this.queueDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  队列日期
	 */
	public void setQueueDate(java.util.Date queueDate){
		this.queueDate = queueDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  排队编号
	 */

	@Column(name ="QUEUE_NO",nullable=true,length=32)
	public java.lang.String getQueueNo(){
		return this.queueNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  排队编号
	 */
	public void setQueueNo(java.lang.String queueNo){
		this.queueNo = queueNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  排队用户
	 */

	@Column(name ="QUEUE_USER",nullable=true,length=32)
	public java.lang.String getQueueUser(){
		return this.queueUser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  排队用户
	 */
	public void setQueueUser(java.lang.String queueUser){
		this.queueUser = queueUser;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  排队状态
	 */

	@Column(name ="QUEUE_STATUS",nullable=true,length=32)
	public java.lang.String getQueueStatus(){
		return this.queueStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  排队状态
	 */
	public void setQueueStatus(java.lang.String queueStatus){
		this.queueStatus = queueStatus;
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
