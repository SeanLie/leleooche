package com.jeecg.demo.entity;

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
 * @Description: 测试智能柜基础表
 * @author onlineGenerator
 * @date 2018-09-02 20:26:58
 * @version V1.0   
 *
 */
@Entity
@Table(name = "test_Smart_cabinet", schema = "")
@SuppressWarnings("serial")
public class TestSmartCabinetEntity implements java.io.Serializable {
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
	/**智能柜编号*/
	@Excel(name="智能柜编号",width=15)
	private java.lang.String smartCabCode;
	/**智能柜提供商*/
	@Excel(name="智能柜提供商",width=15)
	private java.lang.String smartCabProv;
	/**智能柜箱门数*/
	@Excel(name="智能柜箱门数",width=15)
	private java.lang.Integer smartCabDoors;
	/**智能柜投放地址*/
	@Excel(name="智能柜投放地址",width=15)
	private java.lang.String smartCabAddr;
	/**智能柜状态*/
	@Excel(name="智能柜状态",width=15,dicCode="sc_status")
	private java.lang.String smartCabStatus;
	/**智能柜投放时间*/
	@Excel(name="智能柜投放时间",width=15,format = "yyyy-MM-dd HH:mm:ss")
	private java.util.Date smartCabSetdate;
	/**智能柜租金*/
	@Excel(name="智能柜租金",width=15)
	private java.lang.Double smartCabRent;
	/**智能柜图片*/
	@Excel(name="智能柜图片",width=15)
	private java.lang.String smartCabPic;
	/**智能柜描述*/
	@Excel(name="智能柜描述",width=15)
	private java.lang.String smartCabDesc;
	/**智能柜维护用户*/
	@Excel(name="智能柜维护用户",width=15)
	private java.lang.String smartCabPerson;
	/**智能柜是否在库*/
	@Excel(name="智能柜是否在库",width=15,dicCode="sc_stock")
	private java.lang.String smartCabInstock;
	
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
	 *@return: java.lang.String  智能柜编号
	 */

	@Column(name ="SMART_CAB_CODE",nullable=false,length=32)
	public java.lang.String getSmartCabCode(){
		return this.smartCabCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  智能柜编号
	 */
	public void setSmartCabCode(java.lang.String smartCabCode){
		this.smartCabCode = smartCabCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  智能柜提供商
	 */

	@Column(name ="SMART_CAB_PROV",nullable=true,length=40)
	public java.lang.String getSmartCabProv(){
		return this.smartCabProv;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  智能柜提供商
	 */
	public void setSmartCabProv(java.lang.String smartCabProv){
		this.smartCabProv = smartCabProv;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  智能柜箱门数
	 */

	@Column(name ="SMART_CAB_DOORS",nullable=false,length=32)
	public java.lang.Integer getSmartCabDoors(){
		return this.smartCabDoors;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  智能柜箱门数
	 */
	public void setSmartCabDoors(java.lang.Integer smartCabDoors){
		this.smartCabDoors = smartCabDoors;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  智能柜投放地址
	 */

	@Column(name ="SMART_CAB_ADDR",nullable=true,length=32)
	public java.lang.String getSmartCabAddr(){
		return this.smartCabAddr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  智能柜投放地址
	 */
	public void setSmartCabAddr(java.lang.String smartCabAddr){
		this.smartCabAddr = smartCabAddr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  智能柜状态
	 */

	@Column(name ="SMART_CAB_STATUS",nullable=false,length=4)
	public java.lang.String getSmartCabStatus(){
		return this.smartCabStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  智能柜状态
	 */
	public void setSmartCabStatus(java.lang.String smartCabStatus){
		this.smartCabStatus = smartCabStatus;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  智能柜投放时间
	 */

	@Column(name ="SMART_CAB_SETDATE",nullable=true,length=32)
	public java.util.Date getSmartCabSetdate(){
		return this.smartCabSetdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  智能柜投放时间
	 */
	public void setSmartCabSetdate(java.util.Date smartCabSetdate){
		this.smartCabSetdate = smartCabSetdate;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  智能柜租金
	 */

	@Column(name ="SMART_CAB_RENT",nullable=false,length=20)
	public java.lang.Double getSmartCabRent(){
		return this.smartCabRent;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  智能柜租金
	 */
	public void setSmartCabRent(java.lang.Double smartCabRent){
		this.smartCabRent = smartCabRent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  智能柜图片
	 */

	@Column(name ="SMART_CAB_PIC",nullable=true,length=100)
	public java.lang.String getSmartCabPic(){
		return this.smartCabPic;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  智能柜图片
	 */
	public void setSmartCabPic(java.lang.String smartCabPic){
		this.smartCabPic = smartCabPic;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  智能柜描述
	 */

	@Column(name ="SMART_CAB_DESC",nullable=true,length=500)
	public java.lang.String getSmartCabDesc(){
		return this.smartCabDesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  智能柜描述
	 */
	public void setSmartCabDesc(java.lang.String smartCabDesc){
		this.smartCabDesc = smartCabDesc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  智能柜维护用户
	 */

	@Column(name ="SMART_CAB_PERSON",nullable=true,length=40)
	public java.lang.String getSmartCabPerson(){
		return this.smartCabPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  智能柜维护用户
	 */
	public void setSmartCabPerson(java.lang.String smartCabPerson){
		this.smartCabPerson = smartCabPerson;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  智能柜是否在库
	 */

	@Column(name ="SMART_CAB_INSTOCK",nullable=false,length=4)
	public java.lang.String getSmartCabInstock(){
		return this.smartCabInstock;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  智能柜是否在库
	 */
	public void setSmartCabInstock(java.lang.String smartCabInstock){
		this.smartCabInstock = smartCabInstock;
	}
}