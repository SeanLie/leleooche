package com.jeecg.wechat.dbtable;

import java.util.Date;

/**
 * 系统用户表
 * 
 * @author 张代浩
 */

public class TsUserDb implements java.io.Serializable {
	private String id;// 系统表ID
	public String email;
	public String mobilePhone;
	public String officePhone;
	public String signatureFile;
	public String update_name;
	public Date update_date;
	public String update_by;
	public String create_name;
	public Date create_date;
	public String create_by;
	public String portrait;
	public String imsign;
	public String dev_flag;
	public String user_type;
	public String person_type;
	public String sex;
	public String emp_no;
	public String citizen_no;
	public String fax;
	public String address;
	public String post;
	public String memo;
	public String openid;
	public String unionid;
	public String nickname;
	public String city;
	public String country;
	public String province;
	public String language;
	public String headimgurl;
	public String subscribe_time;
	public String tagid_list;
	public String remark;
	public int groupid;
	public int subscribe;
	public String personlevel;
	public String vehicles;

	public TsUserDb(String id, String email, String mobilePhone, String officePhone, String signatureFile,
			String update_name, Date update_date, String update_by, String create_name, Date create_date,
			String create_by, String portrait, String imsign, String dev_flag, String user_type, String person_type,
			String sex, String emp_no, String citizen_no, String fax, String address, String post, String memo,
			String openid, String unionid, String nickname, String city, String country, String province,
			String language, String headimgurl, String subscribe_time, String tagid_list, String remark, int groupid,
			int subscribe, String personlevel, String vehicles) {
		super();
		this.id = id;
		this.email = email;
		this.mobilePhone = mobilePhone;
		this.officePhone = officePhone;
		this.signatureFile = signatureFile;
		this.update_name = update_name;
		this.update_date = update_date;
		this.update_by = update_by;
		this.create_name = create_name;
		this.create_date = create_date;
		this.create_by = create_by;
		this.portrait = portrait;
		this.imsign = imsign;
		this.dev_flag = dev_flag;
		this.user_type = user_type;
		this.person_type = person_type;
		this.sex = sex;
		this.emp_no = emp_no;
		this.citizen_no = citizen_no;
		this.fax = fax;
		this.address = address;
		this.post = post;
		this.memo = memo;
		this.openid = openid;
		this.unionid = unionid;
		this.nickname = nickname;
		this.city = city;
		this.country = country;
		this.province = province;
		this.language = language;
		this.headimgurl = headimgurl;
		this.subscribe_time = subscribe_time;
		this.tagid_list = tagid_list;
		this.remark = remark;
		this.groupid = groupid;
		this.subscribe = subscribe;
		this.personlevel = personlevel;
		this.vehicles = vehicles;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * @param mobilePhone the mobilePhone to set
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * @return the officePhone
	 */
	public String getOfficePhone() {
		return officePhone;
	}

	/**
	 * @param officePhone the officePhone to set
	 */
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	/**
	 * @return the signatureFile
	 */
	public String getSignatureFile() {
		return signatureFile;
	}

	/**
	 * @param signatureFile the signatureFile to set
	 */
	public void setSignatureFile(String signatureFile) {
		this.signatureFile = signatureFile;
	}

	/**
	 * @return the update_name
	 */
	public String getUpdate_name() {
		return update_name;
	}

	/**
	 * @param update_name the update_name to set
	 */
	public void setUpdate_name(String update_name) {
		this.update_name = update_name;
	}

	/**
	 * @return the update_date
	 */
	public Date getUpdate_date() {
		return update_date;
	}

	/**
	 * @param update_date the update_date to set
	 */
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	/**
	 * @return the update_by
	 */
	public String getUpdate_by() {
		return update_by;
	}

	/**
	 * @param update_by the update_by to set
	 */
	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	/**
	 * @return the create_name
	 */
	public String getCreate_name() {
		return create_name;
	}

	/**
	 * @param create_name the create_name to set
	 */
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}

	/**
	 * @return the create_date
	 */
	public Date getCreate_date() {
		return create_date;
	}

	/**
	 * @param create_date the create_date to set
	 */
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	/**
	 * @return the create_by
	 */
	public String getCreate_by() {
		return create_by;
	}

	/**
	 * @param create_by the create_by to set
	 */
	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	/**
	 * @return the portrait
	 */
	public String getPortrait() {
		return portrait;
	}

	/**
	 * @param portrait the portrait to set
	 */
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	/**
	 * @return the imsign
	 */
	public String getImsign() {
		return imsign;
	}

	/**
	 * @param imsign the imsign to set
	 */
	public void setImsign(String imsign) {
		this.imsign = imsign;
	}

	/**
	 * @return the dev_flag
	 */
	public String getDev_flag() {
		return dev_flag;
	}

	/**
	 * @param dev_flag the dev_flag to set
	 */
	public void setDev_flag(String dev_flag) {
		this.dev_flag = dev_flag;
	}

	/**
	 * @return the user_type
	 */
	public String getUser_type() {
		return user_type;
	}

	/**
	 * @param user_type the user_type to set
	 */
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	/**
	 * @return the person_type
	 */
	public String getPerson_type() {
		return person_type;
	}

	/**
	 * @param person_type the person_type to set
	 */
	public void setPerson_type(String person_type) {
		this.person_type = person_type;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the emp_no
	 */
	public String getEmp_no() {
		return emp_no;
	}

	/**
	 * @param emp_no the emp_no to set
	 */
	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}

	/**
	 * @return the citizen_no
	 */
	public String getCitizen_no() {
		return citizen_no;
	}

	/**
	 * @param citizen_no the citizen_no to set
	 */
	public void setCitizen_no(String citizen_no) {
		this.citizen_no = citizen_no;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the post
	 */
	public String getPost() {
		return post;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(String post) {
		this.post = post;
	}

	/**
	 * @return the memo
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param memo the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @return the openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @param openid the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * @return the unionid
	 */
	public String getUnionid() {
		return unionid;
	}

	/**
	 * @param unionid the unionid to set
	 */
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the headimgurl
	 */
	public String getHeadimgurl() {
		return headimgurl;
	}

	/**
	 * @param headimgurl the headimgurl to set
	 */
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	/**
	 * @return the subscribe_time
	 */
	public String getSubscribe_time() {
		return subscribe_time;
	}

	/**
	 * @param subscribe_time the subscribe_time to set
	 */
	public void setSubscribe_time(String subscribe_time) {
		this.subscribe_time = subscribe_time;
	}

	/**
	 * @return the tagid_list
	 */
	public String getTagid_list() {
		return tagid_list;
	}

	/**
	 * @param tagid_list the tagid_list to set
	 */
	public void setTagid_list(String tagid_list) {
		this.tagid_list = tagid_list;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the groupid
	 */
	public int getGroupid() {
		return groupid;
	}

	/**
	 * @param groupid the groupid to set
	 */
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}

	/**
	 * @return the subscribe
	 */
	public int getSubscribe() {
		return subscribe;
	}

	/**
	 * @param subscribe the subscribe to set
	 */
	public void setSubscribe(int subscribe) {
		this.subscribe = subscribe;
	}

	/**
	 * @return the personlevel
	 */
	public String getPersonlevel() {
		return personlevel;
	}

	/**
	 * @param personlevel the personlevel to set
	 */
	public void setPersonlevel(String personlevel) {
		this.personlevel = personlevel;
	}

	/**
	 * @return the vehicles
	 */
	public String getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(String vehicles) {
		this.vehicles = vehicles;
	}

	/**
	 * 
	 */
	public TsUserDb() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TsUserDb [id=" + id + ", email=" + email + ", mobilePhone=" + mobilePhone + ", officePhone="
				+ officePhone + ", signatureFile=" + signatureFile + ", update_name=" + update_name + ", update_date="
				+ update_date + ", update_by=" + update_by + ", create_name=" + create_name + ", create_date="
				+ create_date + ", create_by=" + create_by + ", portrait=" + portrait + ", imsign=" + imsign
				+ ", dev_flag=" + dev_flag + ", user_type=" + user_type + ", person_type=" + person_type + ", sex="
				+ sex + ", emp_no=" + emp_no + ", citizen_no=" + citizen_no + ", fax=" + fax + ", address=" + address
				+ ", post=" + post + ", memo=" + memo + ", openid=" + openid + ", unionid=" + unionid + ", nickname="
				+ nickname + ", city=" + city + ", country=" + country + ", province=" + province + ", language="
				+ language + ", headimgurl=" + headimgurl + ", subscribe_time=" + subscribe_time + ", tagid_list="
				+ tagid_list + ", remark=" + remark + ", groupid=" + groupid + ", subscribe=" + subscribe
				+ ", personlevel=" + personlevel + ", vehicles=" + vehicles + "]";
	}

}