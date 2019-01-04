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
 * @Description: 订单评论管理
 * @author onlineGenerator
 * @date 2019-01-01 12:30:32
 * @version V1.0   
 *
 */
@Entity
@Table(name = "auto_orders_comment", schema = "")
@SuppressWarnings("serial")
public class AutoOrdersCommentEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**订单ID*/
	@Excel(name="订单ID",width=15)
	private java.lang.String orderId;
	/**回复评论ID*/
	private java.lang.String parentCommentId;
	/**评论用户ID*/
	private java.lang.String commentUserId;
	/**评论内容*/
	@Excel(name="评论内容",width=15)
	private java.lang.String comments;
	/**服务星级*/
	@Excel(name="服务星级",width=15,dicCode="a_starts")
	private java.lang.String serverStarsLevel;
	/**评论状态*/
	@Excel(name="评论状态",width=15,dicCode="comstatus")
	private java.lang.String commentStatus;
	/**评论时间*/
	@Excel(name="评论时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date commentTime;
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
	/**评论用户*/
	@Excel(name="评论用户",width=15)
	private java.lang.String commentUserName;
	
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
	 *@return: java.lang.String  回复评论ID
	 */

	@Column(name ="PARENT_COMMENT_ID",nullable=true,length=36)
	public java.lang.String getParentCommentId(){
		return this.parentCommentId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  回复评论ID
	 */
	public void setParentCommentId(java.lang.String parentCommentId){
		this.parentCommentId = parentCommentId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  评论用户ID
	 */

	@Column(name ="COMMENT_USER_ID",nullable=false,length=36)
	public java.lang.String getCommentUserId(){
		return this.commentUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  评论用户ID
	 */
	public void setCommentUserId(java.lang.String commentUserId){
		this.commentUserId = commentUserId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  评论内容
	 */

	@Column(name ="COMMENTS",nullable=true,length=255)
	public java.lang.String getComments(){
		return this.comments;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  评论内容
	 */
	public void setComments(java.lang.String comments){
		this.comments = comments;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务星级
	 */

	@Column(name ="SERVER_STARS_LEVEL",nullable=true,length=50)
	public java.lang.String getServerStarsLevel(){
		return this.serverStarsLevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务星级
	 */
	public void setServerStarsLevel(java.lang.String serverStarsLevel){
		this.serverStarsLevel = serverStarsLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  评论状态
	 */

	@Column(name ="COMMENT_STATUS",nullable=true,length=32)
	public java.lang.String getCommentStatus(){
		return this.commentStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  评论状态
	 */
	public void setCommentStatus(java.lang.String commentStatus){
		this.commentStatus = commentStatus;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  评论时间
	 */

	@Column(name ="COMMENT_TIME",nullable=true)
	public java.util.Date getCommentTime(){
		return this.commentTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  评论时间
	 */
	public void setCommentTime(java.util.Date commentTime){
		this.commentTime = commentTime;
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
	 *@return: java.lang.String  评论用户
	 */

	@Column(name ="COMMENT_USER_NAME",nullable=true,length=32)
	public java.lang.String getCommentUserName(){
		return this.commentUserName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  评论用户
	 */
	public void setCommentUserName(java.lang.String commentUserName){
		this.commentUserName = commentUserName;
	}
}
