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
 * @Description: 申请运单_MiniDao
 * @author onlineGenerator
 * @date 2018-10-07 20:24:11
 * @version V1.0   
 *
 */
@Entity
@Table(name = "awb_apply", schema = "")
@SuppressWarnings("serial")
public class AwbApplyEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
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
	/**所属部门*/
	private java.lang.String sysOrgCode;
	/**所属公司*/
	private java.lang.String sysCompanyCode;
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**申请人*/
	@Excel(name="申请人",width=15)
	private java.lang.String appPerson;
	/**申请时间*/
	@Excel(name="申请时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date appTime;
	/**申请备注*/
	@Excel(name="申请备注",width=15)
	private java.lang.String appRemarks;
	/**票证类型*/
	@Excel(name="票证类型",width=15)
	private java.lang.String ticketType;
	/**运单类型*/
	@Excel(name="运单类型",width=15)
	private java.lang.String awbType;
	/**申请数量*/
	@Excel(name="申请数量",width=15)
	private java.lang.Integer appNumber;
	/**审批人*/
	@Excel(name="审批人",width=15)
	private java.lang.String audPerson;
	/**审批时间*/
	@Excel(name="审批时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date audTime;
	/**审批人备注*/
	@Excel(name="审批人备注",width=15)
	private java.lang.String audRemarks;
	/**状态*/
	@Excel(name="状态",width=15)
	private java.lang.String appStatus;
	/**审批数量*/
	@Excel(name="审批数量",width=15)
	private java.lang.Integer audNumbers;
	/**发放人*/
	@Excel(name="发放人",width=15)
	private java.lang.String pPerson;
	/**发放时间*/
	@Excel(name="发放时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date paidTime;
	/**电子单标识*/
	@Excel(name="电子单标识",width=15,dicCode="eawb")
	private java.lang.Integer eawb;
	
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

	@Column(name ="CREATE_DATE",nullable=true,length=20)
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

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
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
	 *@return: java.lang.String  所属部门
	 */

	@Column(name ="SYS_ORG_CODE",nullable=true,length=50)
	public java.lang.String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(java.lang.String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */

	@Column(name ="SYS_COMPANY_CODE",nullable=true,length=50)
	public java.lang.String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(java.lang.String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程状态
	 */

	@Column(name ="BPM_STATUS",nullable=true,length=32)
	public java.lang.String getBpmStatus(){
		return this.bpmStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setBpmStatus(java.lang.String bpmStatus){
		this.bpmStatus = bpmStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请人
	 */

	@Column(name ="APP_PERSON",nullable=true,length=36)
	public java.lang.String getAppPerson(){
		return this.appPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请人
	 */
	public void setAppPerson(java.lang.String appPerson){
		this.appPerson = appPerson;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申请时间
	 */

	@Column(name ="APP_TIME",nullable=true,length=32)
	public java.util.Date getAppTime(){
		return this.appTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申请时间
	 */
	public void setAppTime(java.util.Date appTime){
		this.appTime = appTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请备注
	 */

	@Column(name ="APP_REMARKS",nullable=true,length=1000)
	public java.lang.String getAppRemarks(){
		return this.appRemarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请备注
	 */
	public void setAppRemarks(java.lang.String appRemarks){
		this.appRemarks = appRemarks;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  票证类型
	 */

	@Column(name ="TICKET_TYPE",nullable=true,length=32)
	public java.lang.String getTicketType(){
		return this.ticketType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  票证类型
	 */
	public void setTicketType(java.lang.String ticketType){
		this.ticketType = ticketType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运单类型
	 */

	@Column(name ="AWB_TYPE",nullable=true,length=32)
	public java.lang.String getAwbType(){
		return this.awbType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运单类型
	 */
	public void setAwbType(java.lang.String awbType){
		this.awbType = awbType;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  申请数量
	 */

	@Column(name ="APP_NUMBER",nullable=true,length=32)
	public java.lang.Integer getAppNumber(){
		return this.appNumber;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  申请数量
	 */
	public void setAppNumber(java.lang.Integer appNumber){
		this.appNumber = appNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审批人
	 */

	@Column(name ="AUD_PERSON",nullable=true,length=36)
	public java.lang.String getAudPerson(){
		return this.audPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审批人
	 */
	public void setAudPerson(java.lang.String audPerson){
		this.audPerson = audPerson;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  审批时间
	 */

	@Column(name ="AUD_TIME",nullable=true,length=32)
	public java.util.Date getAudTime(){
		return this.audTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  审批时间
	 */
	public void setAudTime(java.util.Date audTime){
		this.audTime = audTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  审批人备注
	 */

	@Column(name ="AUD_REMARKS",nullable=true,length=1000)
	public java.lang.String getAudRemarks(){
		return this.audRemarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审批人备注
	 */
	public void setAudRemarks(java.lang.String audRemarks){
		this.audRemarks = audRemarks;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */

	@Column(name ="APP_STATUS",nullable=true,length=32)
	public java.lang.String getAppStatus(){
		return this.appStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setAppStatus(java.lang.String appStatus){
		this.appStatus = appStatus;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  审批数量
	 */

	@Column(name ="AUD_NUMBERS",nullable=true,length=32)
	public java.lang.Integer getAudNumbers(){
		return this.audNumbers;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  审批数量
	 */
	public void setAudNumbers(java.lang.Integer audNumbers){
		this.audNumbers = audNumbers;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发放人
	 */

	@Column(name ="P_PERSON",nullable=true,length=36)
	public java.lang.String getPPerson(){
		return this.pPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发放人
	 */
	public void setPPerson(java.lang.String pPerson){
		this.pPerson = pPerson;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发放时间
	 */

	@Column(name ="PAID_TIME",nullable=true,length=32)
	public java.util.Date getPaidTime(){
		return this.paidTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发放时间
	 */
	public void setPaidTime(java.util.Date paidTime){
		this.paidTime = paidTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  电子单标识
	 */

	@Column(name ="EAWB",nullable=true,length=1)
	public java.lang.Integer getEawb(){
		return this.eawb;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  电子单标识
	 */
	public void setEawb(java.lang.Integer eawb){
		this.eawb = eawb;
	}
}
