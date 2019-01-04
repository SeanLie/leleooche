package org.jeecgframework.web.system.pojo.base;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * 系统用户表
 *
 * @author 张代浩
 */
@Entity
@Table(name = "t_s_user")
@PrimaryKeyJoinColumn(name = "id")
@ApiModel(value = "user", description = "用户对象")
public class TSUser extends TSBaseUser implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String signatureFile;// 签名文件

    /*
     * private String province;// 用户省份 private String city;// 用户城市 private String
     * country;// 用户国家
     */
    @Excel(name = "手机", width = 20)
    @ApiModelProperty(value = "手机", required = true, name = "mobilePhone", example = "13800138000")
    private String mobilePhone;

    @Excel(name = "办公电话", width = 20)
    private String officePhone;

    @Excel(name = "邮箱", width = 25)
    private String email;
    /**
     * 头像
     */
    @ApiModelProperty(value = "头像", name = "portrait", example = "abc123")
    private java.lang.String portrait;
    /**
     * 开发权限标志
     */
    private java.lang.String devFlag;

    /**
     * 用户类型->1:系统用户,2:接口用户,3:APP
     */
    @Excel(name = "用户类型", dicCode = "pms_usertype")
    @ApiModelProperty(value = "用户类型(1:系统用户,2:接口用户,3:APP)", name = "userType", example = "3")
    private String userType;

    @Excel(name = "人员类型", dicCode = "person_type")
    @ApiModelProperty(value = "人员类型(1.供应商,2.合作商,3.自由群体,4.我司)", name = "person_type", example = "3")
    private String person_type;

    /**
     * 人员级别:部门架构越高，级别越高,目前只有2级,1级，0级，高级低级
     */
    private String personlevel;

    /**
     * 性别：值为1时是男性，值为2时是女性，值为0时是未知
     */
    @ApiModelProperty(value = "性别(1.男,2.女)", name = "sex", example = "2")
    private String sex;

    /**
     * 用户车辆ID
     */
    @ApiModelProperty(value = "用户车辆ID", name = "vehicleId", example = "123aaa")
    @Excel(name="用户车辆ID", dictTable = "user_vehicle", dicCode = "vehicle_id", dicText = "id")
    private String vehicleId;

    private String empNo;// 工号
    private String citizenNo;// 身份证号
    private String fax;// 传真
    private String address;// 联系地址
    private String post;// 邮编
    private String memo;// 备注

    /**
     * 创建时间
     */
    private java.util.Date createDate;
    /**
     * 创建人ID
     */
    private java.lang.String createBy;
    /**
     * 创建人名称
     */
    private java.lang.String createName;
    /**
     * 修改时间
     */
    private java.util.Date updateDate;
    /**
     * 修改人
     */
    private java.lang.String updateBy;
    /**
     * 修改人名称
     */
    private java.lang.String updateName;

    /**
     * 用户是否订阅
     */
    @ApiModelProperty(value = "用户是否订阅(0:否,1:是)", name = "subscribe", example = "0")
    private java.lang.Integer subscribe;
    /**
     * 用户的标识
     */
    @ApiModelProperty(value = "用户的标识", name = "openid", example = "123")
    private java.lang.String openid;
    /**
     * 用户的昵称
     */
    @ApiModelProperty(value = "用户昵称", name = "nickname", example = "123")
    private java.lang.String nickname;

    /**
     * 用户所在城市
     */
    private java.lang.String city;
    /**
     * 用户所在国家：国家，如中国为CN
     */
    private java.lang.String country;
    /**
     * 用户所在省份
     */
    private java.lang.String province;
    /**
     * 用户的语言zh_CN
     */
    private java.lang.String language;
    /**
     * 用户头像：用户头像，最后一个数值代表正方形头像大小 （有0、46、64、96、132数值可选，0代表640*640正方形头像）
     * ，用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     */
    private java.lang.String headimgurl;
    /**
     * 用户关注时间
     */
    private java.lang.String subscribe_time;
    /**
     * 用户粉丝唯一ID：只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    private java.lang.String unionid;
    /**
     * 用户被打上的标签ID列表
     */
    private String tagid_list;
    /**
     * 粉丝备注
     */
    private String remark;
    /**
     * 用户所在的分组ID（兼容旧的用户分组接口）
     */
    private Integer groupid;

    public TSUser() {
        super();
    }

    public TSUser(String signatureFile, String mobilePhone, String officePhone, String email, String portrait,
                  String devFlag, String userType, String person_type, String personLevel, String sex, String empNo,
                  String citizenNo, String fax, String address, String post, String memo, Date createDate, String createBy,
                  String createName, Date updateDate, String updateBy, String updateName, Integer subscribe, String openid,
                  String nickname, String city, String country, String province, String language, String headimgurl,
                  String subscribe_time, String unionid, String tagid_list, String remark, Integer groupid, String vehicleId) {
        super();
        this.signatureFile = signatureFile;
        this.mobilePhone = mobilePhone;
        this.officePhone = officePhone;
        this.email = email;
        this.portrait = portrait;
        this.devFlag = devFlag;
        this.userType = userType;
        this.person_type = person_type;
        this.personlevel = personLevel;
        this.sex = sex;
        this.empNo = empNo;
        this.citizenNo = citizenNo;
        this.fax = fax;
        this.address = address;
        this.post = post;
        this.memo = memo;
        this.createDate = createDate;
        this.createBy = createBy;
        this.createName = createName;
        this.updateDate = updateDate;
        this.updateBy = updateBy;
        this.updateName = updateName;
        this.subscribe = subscribe;
        this.openid = openid;
        this.nickname = nickname;
        this.city = city;
        this.country = country;
        this.province = province;
        this.language = language;
        this.headimgurl = headimgurl;
        this.subscribe_time = subscribe_time;
        this.unionid = unionid;
        this.tagid_list = tagid_list;
        this.remark = remark;
        this.groupid = groupid;
        this.vehicleId = vehicleId;
    }

    /**
     * @return the vehicleId
     */
    @Column(name = "VEHICLE_ID", length = 36)
    public String getVehicleId() {
        return vehicleId;
    }

    /**
     * @param vehicleId the vehicleId to set
     */
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * @return the subscribe
     */
    public java.lang.Integer getSubscribe() {
        return subscribe;
    }

    /**
     * @param subscribe the subscribe to set
     */
    public void setSubscribe(java.lang.Integer subscribe) {
        this.subscribe = subscribe;
    }

    /**
     * @return the openid
     */
    @Column(name = "OPENID", length = 32)
    public java.lang.String getOpenid() {
        return openid;
    }

    /**
     * @param openid the openid to set
     */
    public void setOpenid(java.lang.String openid) {
        this.openid = openid;
    }

    /**
     * @return the nickname
     */
    @Column(name = "NICKNAME")
    public java.lang.String getNickname() throws UnsupportedEncodingException {
        /*try {
            // 对昵称进行解码
            nickname = new String(Base64.decodeBase64(nickname), "UTF-8");
            System.out.println("用户昵称解码：" + nickname);
        } catch (UnsupportedEncodingException e) {
            throw e;
        }*/
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(java.lang.String nickname) throws UnsupportedEncodingException {
        this.nickname = nickname;
        // 对昵称进行编码，目的解决特殊字符
        /*try {
            this.nickname = Base64.encodeBase64String(nickname.getBytes("UTF-8"));
            System.out.println("用户昵称编码：" + this.nickname);
        } catch (UnsupportedEncodingException e) {
            throw e;
        }*/
    }

    /**
     * @return the city
     */
    @Column(name = "CITY")
    public java.lang.String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(java.lang.String city) {
        this.city = city;
    }

    /**
     * @return the country
     */
    @Column(name = "COUNTRY")
    public java.lang.String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(java.lang.String country) {
        this.country = country;
    }

    /**
     * @return the province
     */
    @Column(name = "PROVINCE")
    public java.lang.String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(java.lang.String province) {
        this.province = province;
    }

    /**
     * @return the language
     */
    public java.lang.String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(java.lang.String language) {
        this.language = language;
    }

    /**
     * @return the headimgurl
     */
    @Column(name = "headimgurl")
    public java.lang.String getHeadimgurl() {
        return headimgurl;
    }

    /**
     * @param headimgurl the headimgurl to set
     */
    public void setHeadimgurl(java.lang.String headimgurl) {
        this.headimgurl = headimgurl;
    }

    /**
     * @return the subscribe_time
     */
    @Column(name = "SUBSCRIBE_TIME", length = 30)
    public java.lang.String getSubscribe_time() {
        return subscribe_time;
    }

    /**
     * @param subscribe_time the subscribe_time to set
     */
    public void setSubscribe_time(java.lang.String subscribe_time) {
        this.subscribe_time = subscribe_time;
    }

    /**
     * @return the unionid
     */
    @Column(name = "unionid", length = 32)
    public java.lang.String getUnionid() {
        return unionid;
    }

    /**
     * @param unionid the unionid to set
     */
    public void setUnionid(java.lang.String unionid) {
        this.unionid = unionid;
    }

    /**
     * @return the tagid_list
     */
    public String getTagid_list() {
        return tagid_list;
    }

    /**
     * @param tagIdArray the tagid_list to set
     */
    public void setTagid_list(String[] tagIdArray) {
        String tagIdStr = null;
        if (null != tagIdArray) {
            tagIdStr = JSON.toJSON(tagIdArray).toString();
        }
        this.tagid_list = tagIdStr;
    }

    /**
     * @return the remark
     */
    @Column(name = "remark")
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
    public Integer getGroupid() {
        return groupid;
    }

    /**
     * @param groupid the groupid to set
     */
    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    @Column(name = "dev_flag", length = 2)
    public String getDevFlag() {
        return devFlag;
    }

    public void setDevFlag(String devFlag) {
        this.devFlag = devFlag;
    }

    @Column(name = "signatureFile", length = 100)
    public String getSignatureFile() {
        return this.signatureFile;
    }

    public void setSignatureFile(String signatureFile) {
        this.signatureFile = signatureFile;
    }

    @Column(name = "mobilePhone", length = 30)
    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Column(name = "officePhone", length = 20)
    public String getOfficePhone() {
        return this.officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    @Column(name = "email", length = 50)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date 创建时间
     */
    @Column(name = "create_date", nullable = true)
    public java.util.Date getCreateDate() {
        return this.createDate;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date 创建时间
     */
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String 创建人ID
     */
    @Column(name = "create_by", nullable = true, length = 32)
    public java.lang.String getCreateBy() {
        return this.createBy;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String 创建人ID
     */
    public void setCreateBy(java.lang.String createBy) {
        this.createBy = createBy;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String 创建人名称
     */
    @Column(name = "create_name", nullable = true, length = 32)
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
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date 修改时间
     */
    @Column(name = "update_date", nullable = true)
    public java.util.Date getUpdateDate() {
        return this.updateDate;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date 修改时间
     */
    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String 修改人ID
     */
    @Column(name = "update_by", nullable = true, length = 32)
    public java.lang.String getUpdateBy() {
        return this.updateBy;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String 修改人ID
     */
    public void setUpdateBy(java.lang.String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String 修改人名称
     */
    @Column(name = "update_name", nullable = true, length = 32)
    public java.lang.String getUpdateName() {
        return this.updateName;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String 修改人名称
     */
    public void setUpdateName(java.lang.String updateName) {
        this.updateName = updateName;
    }

    @Column(name = "portrait", length = 100)
    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    @Column(name = "user_type")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Column(name = "person_type")
    public String getPerson_type() {
        return person_type;
    }

    public void setPerson_type(String person_type) {
        this.person_type = person_type;
    }

    /**
     * @return the personlevel
     */
    @Column(name = "PERSONLEVEL")
    public String getPersonLevel() {
        return personlevel;
    }

    /**
     * @param personLevel the personlevel to set
     */
    public void setPersonLevel(String personLevel) {
        this.personlevel = personLevel;
    }

    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name = "emp_no")
    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    @Column(name = "citizen_no")
    public String getCitizenNo() {
        return citizenNo;
    }

    public void setCitizenNo(String citizenNo) {
        this.citizenNo = citizenNo;
    }

    @Column(name = "fax")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "post")
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Column(name = "memo")
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "TSUser{" +
                "signatureFile='" + signatureFile + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", officePhone='" + officePhone + '\'' +
                ", email='" + email + '\'' +
                ", portrait='" + portrait + '\'' +
                ", devFlag='" + devFlag + '\'' +
                ", userType='" + userType + '\'' +
                ", person_type='" + person_type + '\'' +
                ", personlevel='" + personlevel + '\'' +
                ", sex='" + sex + '\'' +
                ", vehicleId='" + vehicleId + '\'' +
                ", empNo='" + empNo + '\'' +
                ", citizenNo='" + citizenNo + '\'' +
                ", fax='" + fax + '\'' +
                ", address='" + address + '\'' +
                ", post='" + post + '\'' +
                ", memo='" + memo + '\'' +
                ", createDate=" + createDate +
                ", createBy='" + createBy + '\'' +
                ", createName='" + createName + '\'' +
                ", updateDate=" + updateDate +
                ", updateBy='" + updateBy + '\'' +
                ", updateName='" + updateName + '\'' +
                ", subscribe=" + subscribe +
                ", openid='" + openid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", language='" + language + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                ", subscribe_time='" + subscribe_time + '\'' +
                ", unionid='" + unionid + '\'' +
                ", tagid_list='" + tagid_list + '\'' +
                ", remark='" + remark + '\'' +
                ", groupid=" + groupid +
                '}';
    }
}