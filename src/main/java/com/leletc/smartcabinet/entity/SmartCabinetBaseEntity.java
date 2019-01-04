package com.leletc.smartcabinet.entity;

import org.jeecgframework.core.common.entity.BaseIDEntity;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 智能柜基础信息表
 *
 * @author onlineGenerator
 * @version V1.0
 * @Title: Entity
 * @Description: 智能柜设置
 * @date 2018-09-06 10:53:41
 */
@Entity
@Table(name = "auto_smart_cabinet_base")
public class SmartCabinetBaseEntity extends BaseIDEntity {

    /**
     * 智能柜编码
     */
    @Excel(name = "智能柜编码", width = 15)
    private java.lang.String cabCode;
    /**
     * 智能柜token
     */
    @Excel(name = "智能柜token", width = 15)
    private java.lang.String cabToken;
    /**
     * 智能柜SIM卡
     */
    @Excel(name = "智能柜SIM卡", width = 15)
    private java.lang.String cabSim;
    /**
     * 智能柜箱门数
     */
    @Excel(name = "智能柜箱门数", width = 15)
    private java.lang.Integer cabDoorNum;
    /**
     * 投放地点
     */
    @Excel(name = "投放地点", width = 15)
    private java.lang.String cabAddress;
    /**
     * 投放时间
     */
    @Excel(name = "投放时间", width = 15, format = "yyyy-MM-dd")
    private java.util.Date cabStartTime;
    /**
     * 服务状态
     */
    @Excel(name = "服务状态", width = 15, dicCode = "cab_status")
    private java.lang.Integer cabStatus;
    /**
     * 智能柜维护人
     */
    @Excel(name = "智能柜维护人", width = 15)
    private java.lang.String cabMaintainer;
    /**
     * 维护人电话
     */
    @Excel(name = "维护人电话", width = 15)
    private java.lang.String cabMaintainerTel;
    /**
     * 维护人email
     */
    @Excel(name = "维护人email", width = 15)
    private java.lang.String cabMaintainerEmail;
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
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  智能柜编码
     */

    @Column(name = "CAB_CODE", nullable = true, length = 32)
    public java.lang.String getCabCode() {
        return this.cabCode;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  智能柜编码
     */
    public void setCabCode(java.lang.String cabCode) {
        this.cabCode = cabCode;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  智能柜token
     */

    @Column(name = "CAB_TOKEN", nullable = true, length = 36)
    public java.lang.String getCabToken() {
        return this.cabToken;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  智能柜token
     */
    public void setCabToken(java.lang.String cabToken) {
        this.cabToken = cabToken;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  智能柜SIM卡
     */

    @Column(name = "CAB_SIM", nullable = true, length = 32)
    public java.lang.String getCabSim() {
        return this.cabSim;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  智能柜SIM卡
     */
    public void setCabSim(java.lang.String cabSim) {
        this.cabSim = cabSim;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer  智能柜箱门数
     */

    @Column(name = "CAB_DOOR_NUM", nullable = true, length = 32)
    public java.lang.Integer getCabDoorNum() {
        return this.cabDoorNum;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer  智能柜箱门数
     */
    public void setCabDoorNum(java.lang.Integer cabDoorNum) {
        this.cabDoorNum = cabDoorNum;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  投放地点
     */

    @Column(name = "CAB_ADDRESS", nullable = true, length = 100)
    public java.lang.String getCabAddress() {
        return this.cabAddress;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  投放地点
     */
    public void setCabAddress(java.lang.String cabAddress) {
        this.cabAddress = cabAddress;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date  投放时间
     */

    @Column(name = "CAB_START_TIME", nullable = true)
    public java.util.Date getCabStartTime() {
        return this.cabStartTime;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date  投放时间
     */
    public void setCabStartTime(java.util.Date cabStartTime) {
        this.cabStartTime = cabStartTime;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer  服务状态
     */

    @Column(name = "CAB_STATUS", nullable = true, length = 4)
    public java.lang.Integer getCabStatus() {
        return this.cabStatus;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer  服务状态
     */
    public void setCabStatus(java.lang.Integer cabStatus) {
        this.cabStatus = cabStatus;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  创建人名称
     */

    @Column(name = "CREATE_NAME", nullable = true, length = 50)
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

    @Column(name = "CREATE_BY", nullable = true, length = 50)
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

    @Column(name = "CREATE_DATE", nullable = true)
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
    @Column(name = "UPDATE_NAME", nullable = true, length = 50)
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

    @Column(name = "UPDATE_BY", nullable = true, length = 50)
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

    @Column(name = "UPDATE_DATE", nullable = true)
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

    @Column(name = "CAB_MAINTAINER", nullable = true, length = 32)
    public java.lang.String getCabMaintainer() {
        return this.cabMaintainer;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  智能柜维护人
     */
    public void setCabMaintainer(java.lang.String cabMaintainer) {
        this.cabMaintainer = cabMaintainer;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  维护人电话
     */

    @Column(name = "CAB_MAINTAINER_TEL", nullable = true, length = 32)
    public java.lang.String getCabMaintainerTel() {
        return this.cabMaintainerTel;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  维护人电话
     */
    public void setCabMaintainerTel(java.lang.String cabMaintainerTel) {
        this.cabMaintainerTel = cabMaintainerTel;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  维护人email
     */

    @Column(name = "CAB_MAINTAINER_EMAIL", nullable = true, length = 32)
    public java.lang.String getCabMaintainerEmail() {
        return this.cabMaintainerEmail;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  维护人email
     */
    public void setCabMaintainerEmail(java.lang.String cabMaintainerEmail) {
        this.cabMaintainerEmail = cabMaintainerEmail;
    }

    @Override
    public String toString() {
        return "SmartCabinetBaseEntity{" +
                "cabCode='" + cabCode + '\'' +
                ", cabToken='" + cabToken + '\'' +
                ", cabSim='" + cabSim + '\'' +
                ", cabDoorNum=" + cabDoorNum +
                ", cabAddress='" + cabAddress + '\'' +
                ", cabStartTime=" + cabStartTime +
                ", cabStatus=" + cabStatus +
                ", createName='" + createName + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate=" + createDate +
                ", updateName='" + updateName + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateDate=" + updateDate +
                ", cabMaintainer='" + cabMaintainer + '\'' +
                ", cabMaintainerTel='" + cabMaintainerTel + '\'' +
                ", cabMaintainerEmail='" + cabMaintainerEmail + '\'' +
                '}';
    }
}
