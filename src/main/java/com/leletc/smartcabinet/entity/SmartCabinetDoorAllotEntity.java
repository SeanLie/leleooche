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
 * @Description: 智能柜门分配
 * @date 2018-09-06 21:24:40
 */
@Entity
@Table(name = "auto_smart_cabinet_door_allot")
public class SmartCabinetDoorAllotEntity extends BaseIDEntity {

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
     * 箱门ID
     */
    @Excel(name = "箱门ID", width = 15)
    private java.lang.String arkdoorId;
    /**
     * 分配用户
     */
    @Excel(name = "分配用户", width = 15)
    private java.lang.String arrangeUser;
    /**
     * 分配时间
     */
    @Excel(name = "分配时间", width = 15, format = "yyyy-MM-dd")
    private java.util.Date arrangeTime;
    /**
     * 分配状态
     */
    @Excel(name = "分配状态", width = 15, dicCode = "a_Arra")
    private java.lang.String arrangeStatus;

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

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  箱门ID
     */

    @Column(name = "ARKDOOR_ID", nullable = true, length = 36)
    public java.lang.String getArkdoorId() {
        return this.arkdoorId;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  箱门ID
     */
    public void setArkdoorId(java.lang.String arkdoorId) {
        this.arkdoorId = arkdoorId;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  分配用户
     */

    @Column(name = "ARRANGE_USER", nullable = true, length = 36)
    public java.lang.String getArrangeUser() {
        return this.arrangeUser;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  分配用户
     */
    public void setArrangeUser(java.lang.String arrangeUser) {
        this.arrangeUser = arrangeUser;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date  分配时间
     */

    @Column(name = "ARRANGE_TIME", nullable = true, length = 32)
    public java.util.Date getArrangeTime() {
        return this.arrangeTime;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date  分配时间
     */
    public void setArrangeTime(java.util.Date arrangeTime) {
        this.arrangeTime = arrangeTime;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  分配状态
     */

    @Column(name = "ARRANGE_STATUS", nullable = true, length = 32)
    public java.lang.String getArrangeStatus() {
        return this.arrangeStatus;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  分配状态
     */
    public void setArrangeStatus(java.lang.String arrangeStatus) {
        this.arrangeStatus = arrangeStatus;
    }

    @Override
    public String toString() {
        return "SmartCabinetDoorAllotEntity{" +
                "createName='" + createName + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate=" + createDate +
                ", updateName='" + updateName + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateDate=" + updateDate +
                ", sysOrgCode='" + sysOrgCode + '\'' +
                ", sysCompanyCode='" + sysCompanyCode + '\'' +
                ", bpmStatus='" + bpmStatus + '\'' +
                ", arkdoorId='" + arkdoorId + '\'' +
                ", arrangeUser='" + arrangeUser + '\'' +
                ", arrangeTime=" + arrangeTime +
                ", arrangeStatus='" + arrangeStatus + '\'' +
                '}';
    }
}
