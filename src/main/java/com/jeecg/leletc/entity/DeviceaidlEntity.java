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
 * @Description: 智能柜接口_测试Minidao
 * @author onlineGenerator
 * @date 2018-10-04 09:11:33
 * @version V1.0   
 *
 */
@Entity
@Table(name = "deviceaidl", schema = "")
@SuppressWarnings("serial")
public class DeviceaidlEntity implements java.io.Serializable {
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
	@Excel(name="所属部门",width=15)
	private java.lang.String sysOrgCode;
	/**所属公司*/
	@Excel(name="所属公司",width=15)
	private java.lang.String sysCompanyCode;
	/**流程状态*/
	private java.lang.String bpmStatus;
	/**开门板ip*/
	@Excel(name="开门板ip",width=15)
	private java.lang.String ip;
	/**开门板端口号*/
	@Excel(name="开门板端口号",width=15)
	private java.lang.String port;
	/**箱号*/
	@Excel(name="箱号",width=15)
	private java.lang.Integer boxNum;
	/**列号*/
	@Excel(name="列号",width=15)
	private java.lang.Integer columnNum;
	/**等待休眠时间*/
	@Excel(name="等待休眠时间",width=15)
	private java.lang.Integer sleeptime;
	/**箱门总数*/
	@Excel(name="箱门总数",width=15)
	private java.lang.Integer boxTotal;
	/**智能柜类型*/
	@Excel(name="智能柜类型",width=15)
	private java.lang.String boxType;
	/**维护用户*/
	@Excel(name="维护用户",width=15)
	private java.lang.String boxPerson;
	/**所在省*/
	@Excel(name="所在省",width=15)
	private java.lang.String prov;
	/**所在市*/
	@Excel(name="所在市",width=15)
	private java.lang.String city;
	/**所在区*/
	@Excel(name="所在区",width=15)
	private java.lang.String section;
	/**运单号*/
	@Excel(name="运单号",width=15)
	private java.lang.String awb;
	/**是否租用*/
	@Excel(name="是否租用",width=15,dicCode="isrend")
	private java.lang.Integer isrend;
	/**客户类型*/
	@Excel(name="客户类型",width=15,dicCode="paytype")
	private java.lang.Integer custyoe;
	/**上线时间*/
	@Excel(name="上线时间",width=15,format = "yyyy-MM-dd")
	private java.util.Date onlinetime;
	/**描述信息*/
	@Excel(name="描述信息",width=15)
	private java.lang.String desr;
	/**弹出框*/
	@Excel(name="弹出框",width=15)
	private java.lang.String popup;
	
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
	 *@return: java.lang.String  开门板ip
	 */

	@Column(name ="IP",nullable=true,length=36)
	public java.lang.String getIp(){
		return this.ip;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开门板ip
	 */
	public void setIp(java.lang.String ip){
		this.ip = ip;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开门板端口号
	 */

	@Column(name ="PORT",nullable=true,length=10)
	public java.lang.String getPort(){
		return this.port;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开门板端口号
	 */
	public void setPort(java.lang.String port){
		this.port = port;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  箱号
	 */

	@Column(name ="BOX_NUM",nullable=true,length=32)
	public java.lang.Integer getBoxNum(){
		return this.boxNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  箱号
	 */
	public void setBoxNum(java.lang.Integer boxNum){
		this.boxNum = boxNum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  列号
	 */

	@Column(name ="COLUMN_NUM",nullable=true,length=32)
	public java.lang.Integer getColumnNum(){
		return this.columnNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  列号
	 */
	public void setColumnNum(java.lang.Integer columnNum){
		this.columnNum = columnNum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  等待休眠时间
	 */

	@Column(name ="SLEEPTIME",nullable=true,length=32)
	public java.lang.Integer getSleeptime(){
		return this.sleeptime;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  等待休眠时间
	 */
	public void setSleeptime(java.lang.Integer sleeptime){
		this.sleeptime = sleeptime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  箱门总数
	 */

	@Column(name ="BOX_TOTAL",nullable=true,length=32)
	public java.lang.Integer getBoxTotal(){
		return this.boxTotal;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  箱门总数
	 */
	public void setBoxTotal(java.lang.Integer boxTotal){
		this.boxTotal = boxTotal;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  智能柜类型
	 */

	@Column(name ="BOX_TYPE",nullable=true,length=32)
	public java.lang.String getBoxType(){
		return this.boxType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  智能柜类型
	 */
	public void setBoxType(java.lang.String boxType){
		this.boxType = boxType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  维护用户
	 */

	@Column(name ="BOX_PERSON",nullable=true,length=36)
	public java.lang.String getBoxPerson(){
		return this.boxPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  维护用户
	 */
	public void setBoxPerson(java.lang.String boxPerson){
		this.boxPerson = boxPerson;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所在省
	 */

	@Column(name ="PROV",nullable=true,length=36)
	public java.lang.String getProv(){
		return this.prov;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所在省
	 */
	public void setProv(java.lang.String prov){
		this.prov = prov;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所在市
	 */

	@Column(name ="CITY",nullable=true,length=36)
	public java.lang.String getCity(){
		return this.city;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所在市
	 */
	public void setCity(java.lang.String city){
		this.city = city;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所在区
	 */

	@Column(name ="SECTION",nullable=true,length=36)
	public java.lang.String getSection(){
		return this.section;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所在区
	 */
	public void setSection(java.lang.String section){
		this.section = section;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  运单号
	 */

	@Column(name ="AWB",nullable=true,length=8)
	public java.lang.String getAwb(){
		return this.awb;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  运单号
	 */
	public void setAwb(java.lang.String awb){
		this.awb = awb;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否租用
	 */

	@Column(name ="ISREND",nullable=true,length=1)
	public java.lang.Integer getIsrend(){
		return this.isrend;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否租用
	 */
	public void setIsrend(java.lang.Integer isrend){
		this.isrend = isrend;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  客户类型
	 */

	@Column(name ="CUSTYOE",nullable=true,length=2)
	public java.lang.Integer getCustyoe(){
		return this.custyoe;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  客户类型
	 */
	public void setCustyoe(java.lang.Integer custyoe){
		this.custyoe = custyoe;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  上线时间
	 */

	@Column(name ="ONLINETIME",nullable=true,length=32)
	public java.util.Date getOnlinetime(){
		return this.onlinetime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  上线时间
	 */
	public void setOnlinetime(java.util.Date onlinetime){
		this.onlinetime = onlinetime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  描述信息
	 */

	@Column(name ="DESR",nullable=true,length=1000)
	public java.lang.String getDesr(){
		return this.desr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  描述信息
	 */
	public void setDesr(java.lang.String desr){
		this.desr = desr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  弹出框
	 */

	@Column(name ="POPUP",nullable=true,length=36)
	public java.lang.String getPopup(){
		return this.popup;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  弹出框
	 */
	public void setPopup(java.lang.String popup){
		this.popup = popup;
	}
}
