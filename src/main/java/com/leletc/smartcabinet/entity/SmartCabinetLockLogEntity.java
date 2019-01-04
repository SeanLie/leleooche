package com.leletc.smartcabinet.entity;

import org.jeecgframework.core.common.entity.BaseIDEntity;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author onlineGenerator
 * @version V1.0
 * @Title: Entity
 * @Description: 开关锁清单
 * @date 2018-09-06 21:41:13
 */
@Entity
@Table(name = "auto_smart_cabinet_lock_log")
public class SmartCabinetLockLogEntity extends BaseIDEntity {

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
     * 所属部门
     */
    private java.lang.String sysOrgCode;
    /**
     * 所属公司
     */
    private java.lang.String sysCompanyCode;
    /**
     * 流程状态
     */
    private java.lang.String bpmStatus;

    /**
     * 订单ID
     */
    private java.lang.String orderId;

    /**
     * 订单状态:订单的瞬时状态，并非订单目前最新状态
     */
    private java.lang.String orderStatus;

    /**
     * 箱门ID
     */
    @Excel(name = "箱门ID", width = 36)
    private java.lang.String doorId;
    /**
     * 箱门编号
     */
    @Excel(name = "箱门编号", width = 32)
    private java.lang.String boxNo;
    /**
     * 开关锁业务类型
     */
    @Excel(name = "开关锁业务类型（1：存钥匙，2：取钥匙）", width = 2)
    private java.lang.Integer bizType;
    /**
     * 开关锁指令
     */
    @Excel(name = "开关锁指令（1：开，2：关）", width = 15)
    private java.lang.String lockInstruct;
    /**
     * 开关锁动作
     */
    @Excel(name = "开关锁动作(1：开，2：关)", width = 15, dicCode = "a_lock")
    private java.lang.Integer lockAct;
    /**
     * 开关锁时间
     */
    @Excel(name = "开关锁时间", width = 15, format = "yyyy-MM-dd")
    private java.util.Date lockTime;
    /**
     * 开关锁动作结果
     */
    @Excel(name = "开关锁动作结果", width = 15)
    private java.lang.String lockResult;
    /**
     * 开关锁用户
     */
    @Excel(name = "开关锁用户", width = 15)
    private java.lang.String lockUser;

    @Excel(name = "微信用户Token")
    private java.lang.String wxUserToken;

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

    @Column(name = "CREATE_DATE", nullable = true, length = 20)
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

    @Column(name = "UPDATE_DATE", nullable = true, length = 20)
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
     * @return: java.lang.String  所属部门
     */

    @Column(name = "SYS_ORG_CODE", nullable = true, length = 50)
    public java.lang.String getSysOrgCode() {
        return this.sysOrgCode;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  所属部门
     */
    public void setSysOrgCode(java.lang.String sysOrgCode) {
        this.sysOrgCode = sysOrgCode;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  所属公司
     */

    @Column(name = "SYS_COMPANY_CODE", nullable = true, length = 50)
    public java.lang.String getSysCompanyCode() {
        return this.sysCompanyCode;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  所属公司
     */
    public void setSysCompanyCode(java.lang.String sysCompanyCode) {
        this.sysCompanyCode = sysCompanyCode;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  流程状态
     */

    @Column(name = "BPM_STATUS", nullable = true, length = 32)
    public java.lang.String getBpmStatus() {
        return this.bpmStatus;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  流程状态
     */
    public void setBpmStatus(java.lang.String bpmStatus) {
        this.bpmStatus = bpmStatus;
    }

    @Column(name = "ORDER_ID", length = 36)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Column(name = "ORDER_STATUS", nullable = false, length = 32)
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  箱门ID
     */
    @Column(name = "DOOR_ID", nullable = false, length = 36)
    public java.lang.String getDoorId() {
        return this.doorId;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  箱门ID
     */
    public void setDoorId(java.lang.String doorId) {
        this.doorId = doorId;
    }

    @Column(name = "BOX_NO", length = 36)
    public String getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }

    @Column(name = "BIZ_TYPE", length = 2)
    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  开关锁指令
     */
    @Column(name = "LOCK_INSTRUCT", nullable = true, length = 32)
    public java.lang.String getLockInstruct() {
        return this.lockInstruct;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  开关锁指令
     */
    public void setLockInstruct(java.lang.String lockInstruct) {
        this.lockInstruct = lockInstruct;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer  开关锁动作
     */

    @Column(name = "LOCK_ACT", nullable = true, length = 4)
    public java.lang.Integer getLockAct() {
        return this.lockAct;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer  开关锁动作
     */
    public void setLockAct(java.lang.Integer lockAct) {
        this.lockAct = lockAct;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date  开关锁时间
     */

    @Column(name = "LOCK_TIME", nullable = true, length = 32)
    public java.util.Date getLockTime() {
        return this.lockTime;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date  开关锁时间
     */
    public void setLockTime(java.util.Date lockTime) {
        this.lockTime = lockTime;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  开关锁动作结果
     */

    @Column(name = "LOCK_RESULT", nullable = true, length = 32)
    public java.lang.String getLockResult() {
        return this.lockResult;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  开关锁动作结果
     */
    public void setLockResult(java.lang.String lockResult) {
        this.lockResult = lockResult;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  开关锁用户
     */
    @Column(name = "LOCK_USER", length = 32)
    public java.lang.String getLockUser() {
        return this.lockUser;
    }

    @Column(name = "WX_USER_TOKEN", length = 500)
    public String getWxUserToken() {
        return wxUserToken;
    }

    public void setWxUserToken(String wxUserToken) {
        this.wxUserToken = wxUserToken;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  开关锁用户
     */
    public void setLockUser(java.lang.String lockUser) {
        this.lockUser = lockUser;
    }

    @Override
    public String toString() {
        return "SmartCabinetLockLogEntity{" +
                "createName='" + createName + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate=" + createDate +
                ", updateName='" + updateName + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateDate=" + updateDate +
                ", sysOrgCode='" + sysOrgCode + '\'' +
                ", sysCompanyCode='" + sysCompanyCode + '\'' +
                ", bpmStatus='" + bpmStatus + '\'' +
                ", orderId='" + orderId + '\'' +
                ", doorId='" + doorId + '\'' +
                ", boxNo='" + boxNo + '\'' +
                ", bizType=" + bizType +
                ", lockInstruct='" + lockInstruct + '\'' +
                ", lockAct=" + lockAct +
                ", lockTime=" + lockTime +
                ", lockResult='" + lockResult + '\'' +
                ", lockUser='" + lockUser + '\'' +
                '}';
    }

}
