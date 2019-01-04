package com.leletc.smartcabinet.web.vo;

import com.leletc.smartcabinet.entity.SmartCabinetDoorEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：智能柜基础信息视图类
 * <p>
 * @author 李斌
 * <p>
 * @date 2018/11/01 11:17
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public class SmartCabinetBaseVO implements java.io.Serializable {

    /**
     * id
     */
    private java.lang.String id;
    /**
     * 智能柜编码
     */
    private java.lang.String arkCode;
    /**
     * 智能柜token
     */
    private java.lang.String arkToken;
    /**
     * 智能柜SIM卡
     */
    private java.lang.String arkSim;
    /**
     * 智能柜箱门数
     */
    private java.lang.Integer arkDootnums;
    /**
     * 投放地点
     */
    private java.lang.String arkAddres;
    /**
     * 投放时间
     */
    private java.util.Date arkStarttime;
    /**
     * 服务状态
     */
    private java.lang.Integer arkStatus;
    /**
     * 创建人名称
     */
    private java.lang.String createName;
    /**
     * 创建人登录名称
     */
    private java.lang.String createBy;
    /**
     * 创建日期
     */
    private java.util.Date createDate;
    /**
     * 更新人名称
     */
    private java.lang.String updateName;
    /**
     * 更新人登录名称
     */
    private java.lang.String updateBy;
    /**
     * 更新日期
     */
    private java.util.Date updateDate;
    /**
     * 智能柜维护人
     */
    private java.lang.String arkMaintainer;
    /**
     * 维护人电话
     */
    private java.lang.String arkLinktel;
    /**
     * 维护人email
     */
    private java.lang.String arkLinkemail;

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  id
     */
    public java.lang.String getId() {
        return this.id;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  智能柜编码
     */
    public java.lang.String getArkCode() {
        return this.arkCode;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  智能柜编码
     */
    public void setArkCode(java.lang.String arkCode) {
        this.arkCode = arkCode;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  智能柜token
     */
    public java.lang.String getArkToken() {
        return this.arkToken;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  智能柜token
     */
    public void setArkToken(java.lang.String arkToken) {
        this.arkToken = arkToken;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  智能柜SIM卡
     */
    public java.lang.String getArkSim() {
        return this.arkSim;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  智能柜SIM卡
     */
    public void setArkSim(java.lang.String arkSim) {
        this.arkSim = arkSim;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer  智能柜箱门数
     */
    public java.lang.Integer getArkDootnums() {
        return this.arkDootnums;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer  智能柜箱门数
     */
    public void setArkDootnums(java.lang.Integer arkDootnums) {
        this.arkDootnums = arkDootnums;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  投放地点
     */
    public java.lang.String getArkAddres() {
        return this.arkAddres;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  投放地点
     */
    public void setArkAddres(java.lang.String arkAddres) {
        this.arkAddres = arkAddres;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date  投放时间
     */
    public java.util.Date getArkStarttime() {
        return this.arkStarttime;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date  投放时间
     */
    public void setArkStarttime(java.util.Date arkStarttime) {
        this.arkStarttime = arkStarttime;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer  服务状态
     */
    public java.lang.Integer getArkStatus() {
        return this.arkStatus;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer  服务状态
     */
    public void setArkStatus(java.lang.Integer arkStatus) {
        this.arkStatus = arkStatus;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  创建人名称
     */
    public java.lang.String getCreateName() {
        return this.createName;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  创建人名称
     */
    public void setCreateName(java.lang.String createName) {
        this.createName = createName;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  创建人登录名称
     */
    public java.lang.String getCreateBy() {
        return this.createBy;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  创建人登录名称
     */
    public void setCreateBy(java.lang.String createBy) {
        this.createBy = createBy;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date  创建日期
     */
    public java.util.Date getCreateDate() {
        return this.createDate;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date  创建日期
     */
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  更新人名称
     */
    public java.lang.String getUpdateName() {
        return this.updateName;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  更新人名称
     */
    public void setUpdateName(java.lang.String updateName) {
        this.updateName = updateName;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  更新人登录名称
     */
    public java.lang.String getUpdateBy() {
        return this.updateBy;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  更新人登录名称
     */
    public void setUpdateBy(java.lang.String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date  更新日期
     */
    public java.util.Date getUpdateDate() {
        return this.updateDate;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date  更新日期
     */
    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  智能柜维护人
     */
    public java.lang.String getArkMaintainer() {
        return this.arkMaintainer;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  智能柜维护人
     */
    public void setArkMaintainer(java.lang.String arkMaintainer) {
        this.arkMaintainer = arkMaintainer;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  维护人电话
     */
    public java.lang.String getArkLinktel() {
        return this.arkLinktel;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  维护人电话
     */
    public void setArkLinktel(java.lang.String arkLinktel) {
        this.arkLinktel = arkLinktel;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  维护人email
     */
    public java.lang.String getArkLinkemail() {
        return this.arkLinkemail;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  维护人email
     */
    public void setArkLinkemail(java.lang.String arkLinkemail) {
        this.arkLinkemail = arkLinkemail;
    }

    /**
     * 保存-智能柜门设置
     */
    private List<SmartCabinetDoorEntity> smartCabinetDoorEntityList = new ArrayList<>();

    public List<SmartCabinetDoorEntity> getSmartCabinetDoorEntityList() {
        return smartCabinetDoorEntityList;
    }

    public void setSmartCabinetDoorEntityList(List<SmartCabinetDoorEntity> smartCabinetDoorEntityList) {
        this.smartCabinetDoorEntityList = smartCabinetDoorEntityList;
    }

    @Override
    public String toString() {
        return "SmartCabinetBaseVO{" +
                "id='" + id + '\'' +
                ", arkCode='" + arkCode + '\'' +
                ", arkToken='" + arkToken + '\'' +
                ", arkSim='" + arkSim + '\'' +
                ", arkDootnums=" + arkDootnums +
                ", arkAddres='" + arkAddres + '\'' +
                ", arkStarttime=" + arkStarttime +
                ", arkStatus=" + arkStatus +
                ", createName='" + createName + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate=" + createDate +
                ", updateName='" + updateName + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateDate=" + updateDate +
                ", arkMaintainer='" + arkMaintainer + '\'' +
                ", arkLinktel='" + arkLinktel + '\'' +
                ", arkLinkemail='" + arkLinkemail + '\'' +
                ", smartCabinetDoorEntityList=" + smartCabinetDoorEntityList +
                '}';
    }
}
