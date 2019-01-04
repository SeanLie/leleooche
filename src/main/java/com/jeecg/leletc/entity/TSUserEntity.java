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
 * @Description: 用户信息
 * @author onlineGenerator
 * @date 2019-01-01 17:35:13
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_s_user", schema = "")
@SuppressWarnings("serial")
public class TSUserEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**手机号*/
	@Excel(name="手机号",width=15)
	private java.lang.String mobilephone;
	/**用户昵称*/
	@Excel(name="用户昵称",width=15)
	private java.lang.String nickname;
	/**性别*/
	@Excel(name="性别",width=15,dicCode="sex")
	private java.lang.String sex;
	/**邮箱*/
	@Excel(name="邮箱",width=15)
	private java.lang.String email;
	/**办公座机*/
	@Excel(name="办公座机",width=15)
	private java.lang.String officephone;
	/**portrait*/
	@Excel(name="portrait",width=15)
	private java.lang.String portrait;
	/**imsign*/
	@Excel(name="imsign",width=15)
	private java.lang.String imsign;
	/**用户类型*/
	@Excel(name="用户类型",width=15,dicCode="user_type")
	private java.lang.String userType;
	/**人员类型*/
	@Excel(name="人员类型",width=15,dicCode="personType")
	private java.lang.String personType;
	/**人员级别*/
	@Excel(name="人员级别",width=15)
	private java.lang.String personlevel;
	/**用户车辆ID*/
	@Excel(name="用户车辆ID",width=15)
	private java.lang.String vehicleId;
	/**用户头像*/
	@Excel(name="用户头像",width=15)
	private java.lang.String headimgurl;
	/**用户是否关注*/
	@Excel(name="用户是否关注",width=15)
	private java.lang.Integer subscribe;
	/**用户关注时间*/
	@Excel(name="用户关注时间",width=15)
	private java.lang.String subscribeTime;
	/**工号*/
	@Excel(name="工号",width=15)
	private java.lang.String empNo;
	/**身份证号*/
	@Excel(name="身份证号",width=15)
	private java.lang.String citizenNo;
	/**传真*/
	@Excel(name="传真",width=15)
	private java.lang.String fax;
	/**开发权限标志*/
	@Excel(name="开发权限标志",width=15)
	private java.lang.String devFlag;
	/**用户分组ID*/
	private java.lang.String groupid;
	/**签名文件*/
	@Excel(name="签名文件",width=15)
	private java.lang.String signaturefile;
	/**联系地址*/
	@Excel(name="联系地址",width=15)
	private java.lang.String address;
	/**邮编*/
	@Excel(name="邮编",width=15)
	private java.lang.String post;
	/**备注*/
	@Excel(name="备注",width=15)
	private java.lang.String memo;
	/**微信OpenId*/
	@Excel(name="微信OpenId",width=15)
	private java.lang.String openid;
	/**微信用户唯一标识*/
	@Excel(name="微信用户唯一标识",width=15)
	private java.lang.String unionid;
	/**所在城市*/
	@Excel(name="所在城市",width=15)
	private java.lang.String city;
	/**国家*/
	@Excel(name="国家",width=15)
	private java.lang.String country;
	/**所在省份*/
	@Excel(name="所在省份",width=15)
	private java.lang.String province;
	/**用户的语言*/
	@Excel(name="用户的语言",width=15)
	private java.lang.String language;
	/**用户标签*/
	@Excel(name="用户标签",width=15)
	private java.lang.String tagidList;
	/**粉丝备注*/
	@Excel(name="粉丝备注",width=15)
	private java.lang.String remark;
	/**创建人id*/
	private java.lang.String createBy;
	/**创建人*/
	private java.lang.String createName;
	/**创建时间*/
	private java.util.Date createDate;
	/**修改人id*/
	private java.lang.String updateBy;
	/**修改人*/
	private java.lang.String updateName;
	/**修改时间*/
	private java.util.Date updateDate;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=32)
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
	 *@return: java.lang.String  手机号
	 */

	@Column(name ="MOBILEPHONE",nullable=true,length=30)
	public java.lang.String getMobilephone(){
		return this.mobilephone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机号
	 */
	public void setMobilephone(java.lang.String mobilephone){
		this.mobilephone = mobilephone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户昵称
	 */

	@Column(name ="NICKNAME",nullable=true,length=36)
	public java.lang.String getNickname(){
		return this.nickname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户昵称
	 */
	public void setNickname(java.lang.String nickname){
		this.nickname = nickname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */

	@Column(name ="SEX",nullable=true,length=2)
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邮箱
	 */

	@Column(name ="EMAIL",nullable=true,length=50)
	public java.lang.String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邮箱
	 */
	public void setEmail(java.lang.String email){
		this.email = email;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  办公座机
	 */

	@Column(name ="OFFICEPHONE",nullable=true,length=20)
	public java.lang.String getOfficephone(){
		return this.officephone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  办公座机
	 */
	public void setOfficephone(java.lang.String officephone){
		this.officephone = officephone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  portrait
	 */

	@Column(name ="PORTRAIT",nullable=true,length=100)
	public java.lang.String getPortrait(){
		return this.portrait;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  portrait
	 */
	public void setPortrait(java.lang.String portrait){
		this.portrait = portrait;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  imsign
	 */

	@Column(name ="IMSIGN",nullable=true,length=255)
	public java.lang.String getImsign(){
		return this.imsign;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  imsign
	 */
	public void setImsign(java.lang.String imsign){
		this.imsign = imsign;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户类型
	 */

	@Column(name ="USER_TYPE",nullable=true,length=2)
	public java.lang.String getUserType(){
		return this.userType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户类型
	 */
	public void setUserType(java.lang.String userType){
		this.userType = userType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  人员类型
	 */

	@Column(name ="PERSON_TYPE",nullable=true,length=2)
	public java.lang.String getPersonType(){
		return this.personType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人员类型
	 */
	public void setPersonType(java.lang.String personType){
		this.personType = personType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  人员级别
	 */

	@Column(name ="PERSONLEVEL",nullable=true,length=3)
	public java.lang.String getPersonlevel(){
		return this.personlevel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  人员级别
	 */
	public void setPersonlevel(java.lang.String personlevel){
		this.personlevel = personlevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户车辆ID
	 */

	@Column(name ="VEHICLE_ID",nullable=true,length=36)
	public java.lang.String getVehicleId(){
		return this.vehicleId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户车辆ID
	 */
	public void setVehicleId(java.lang.String vehicleId){
		this.vehicleId = vehicleId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户头像
	 */

	@Column(name ="HEADIMGURL",nullable=true,length=255)
	public java.lang.String getHeadimgurl(){
		return this.headimgurl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户头像
	 */
	public void setHeadimgurl(java.lang.String headimgurl){
		this.headimgurl = headimgurl;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  用户是否关注
	 */

	@Column(name ="SUBSCRIBE",nullable=true,length=10)
	public java.lang.Integer getSubscribe(){
		return this.subscribe;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  用户是否关注
	 */
	public void setSubscribe(java.lang.Integer subscribe){
		this.subscribe = subscribe;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户关注时间
	 */

	@Column(name ="SUBSCRIBE_TIME",nullable=true,length=32)
	public java.lang.String getSubscribeTime(){
		return this.subscribeTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户关注时间
	 */
	public void setSubscribeTime(java.lang.String subscribeTime){
		this.subscribeTime = subscribeTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工号
	 */

	@Column(name ="EMP_NO",nullable=true,length=36)
	public java.lang.String getEmpNo(){
		return this.empNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工号
	 */
	public void setEmpNo(java.lang.String empNo){
		this.empNo = empNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */

	@Column(name ="CITIZEN_NO",nullable=true,length=20)
	public java.lang.String getCitizenNo(){
		return this.citizenNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setCitizenNo(java.lang.String citizenNo){
		this.citizenNo = citizenNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  传真
	 */

	@Column(name ="FAX",nullable=true,length=50)
	public java.lang.String getFax(){
		return this.fax;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  传真
	 */
	public void setFax(java.lang.String fax){
		this.fax = fax;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开发权限标志
	 */

	@Column(name ="DEV_FLAG",nullable=false,length=2)
	public java.lang.String getDevFlag(){
		return this.devFlag;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开发权限标志
	 */
	public void setDevFlag(java.lang.String devFlag){
		this.devFlag = devFlag;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户分组ID
	 */

	@Column(name ="GROUPID",nullable=true,length=36)
	public java.lang.String getGroupid(){
		return this.groupid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户分组ID
	 */
	public void setGroupid(java.lang.String groupid){
		this.groupid = groupid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  签名文件
	 */

	@Column(name ="SIGNATUREFILE",nullable=true,length=100)
	public java.lang.String getSignaturefile(){
		return this.signaturefile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  签名文件
	 */
	public void setSignaturefile(java.lang.String signaturefile){
		this.signaturefile = signaturefile;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系地址
	 */

	@Column(name ="ADDRESS",nullable=true,length=1000)
	public java.lang.String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系地址
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邮编
	 */

	@Column(name ="POST",nullable=true,length=10)
	public java.lang.String getPost(){
		return this.post;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邮编
	 */
	public void setPost(java.lang.String post){
		this.post = post;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */

	@Column(name ="MEMO",nullable=true,length=255)
	public java.lang.String getMemo(){
		return this.memo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setMemo(java.lang.String memo){
		this.memo = memo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微信OpenId
	 */

	@Column(name ="OPENID",nullable=true,length=255)
	public java.lang.String getOpenid(){
		return this.openid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微信OpenId
	 */
	public void setOpenid(java.lang.String openid){
		this.openid = openid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微信用户唯一标识
	 */

	@Column(name ="UNIONID",nullable=true,length=255)
	public java.lang.String getUnionid(){
		return this.unionid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微信用户唯一标识
	 */
	public void setUnionid(java.lang.String unionid){
		this.unionid = unionid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所在城市
	 */

	@Column(name ="CITY",nullable=true,length=32)
	public java.lang.String getCity(){
		return this.city;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所在城市
	 */
	public void setCity(java.lang.String city){
		this.city = city;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  国家
	 */

	@Column(name ="COUNTRY",nullable=true,length=32)
	public java.lang.String getCountry(){
		return this.country;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  国家
	 */
	public void setCountry(java.lang.String country){
		this.country = country;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所在省份
	 */

	@Column(name ="PROVINCE",nullable=true,length=32)
	public java.lang.String getProvince(){
		return this.province;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所在省份
	 */
	public void setProvince(java.lang.String province){
		this.province = province;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户的语言
	 */

	@Column(name ="LANGUAGE",nullable=true,length=32)
	public java.lang.String getLanguage(){
		return this.language;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户的语言
	 */
	public void setLanguage(java.lang.String language){
		this.language = language;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户标签
	 */

	@Column(name ="TAGID_LIST",nullable=true,length=255)
	public java.lang.String getTagidList(){
		return this.tagidList;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户标签
	 */
	public void setTagidList(java.lang.String tagidList){
		this.tagidList = tagidList;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  粉丝备注
	 */

	@Column(name ="REMARK",nullable=true,length=255)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  粉丝备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人id
	 */

	@Column(name ="CREATE_BY",nullable=true,length=36)
	public java.lang.String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人id
	 */
	public void setCreateBy(java.lang.String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=32)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */

	@Column(name ="CREATE_DATE",nullable=true)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人id
	 */

	@Column(name ="UPDATE_BY",nullable=true,length=36)
	public java.lang.String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改人id
	 */
	public void setUpdateBy(java.lang.String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  修改人
	 */

	@Column(name ="UPDATE_NAME",nullable=true,length=32)
	public java.lang.String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  修改人
	 */
	public void setUpdateName(java.lang.String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  修改时间
	 */

	@Column(name ="UPDATE_DATE",nullable=true)
	public java.util.Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改时间
	 */
	public void setUpdateDate(java.util.Date updateDate){
		this.updateDate = updateDate;
	}
}
