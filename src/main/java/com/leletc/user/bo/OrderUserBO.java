package com.leletc.user.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 功能描述：订单用户的业务对象类
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/14 12:47
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@ApiModel(value = "orderUser", description = "订单用户的业务对象")
public class OrderUserBO {

    /**
     * 用户的昵称
     */
    @ApiModelProperty(value = "用户昵称", name = "nickname", example = "小小")
    private java.lang.String nickname;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "a123", name = "userName", example = "aaa")
    private String userName;

    /**
     * 手机
     */
    @ApiModelProperty(value = "手机", required = true, name = "mobilePhone", example = "13800138000")
    private String mobilePhone;

    /**
     * 办公电话
     */
    @ApiModelProperty(value = "办公电话", required = true, name = "officePhone", example = "13800138000")
    private String officePhone;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱", required = true, name = "email", example = "123@163.com")
    private String email;
    /**
     * 用户头像：用户头像，最后一个数值代表正方形头像大小 （有0、46、64、96、132数值可选，0代表640*640正方形头像）
     * ，用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     */
    @ApiModelProperty(value = "用户头像", required = true, name = "portrait", example = "http://...")
    private java.lang.String headimgurl;

    /**
     * 用户类型->1:系统用户,2:接口用户,3:APP
     */
    @ApiModelProperty(value = "用户类型(1:系统用户,2:接口用户,3:APP)", name = "userType", example = "3")
    private String userType;

    @ApiModelProperty(value = "人员类型(1.供应商,2.合作商,3.自由群体,4.我司)", name = "personType", example = "3")
    private String personType;

    /**
     * 人员级别:部门架构越高，级别越高
     */
    @ApiModelProperty(value = "人员级别:部门架构越高，级别越高", required = true, name = "personlevel", example = "http://...")
    private String personlevel;

    /**
     * 性别：值为1时是男性，值为2时是女性，值为0时是未知
     */
    @ApiModelProperty(value = "性别(1.男,2.女)", name = "sex", example = "2")
    private String sex;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getPersonlevel() {
        return personlevel;
    }

    public void setPersonlevel(String personlevel) {
        this.personlevel = personlevel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
