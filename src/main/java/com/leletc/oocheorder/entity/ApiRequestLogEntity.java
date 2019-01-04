package com.leletc.oocheorder.entity;

import org.jeecgframework.core.common.entity.BaseIDEntity;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 功能描述：外部接口请求记录表实体类
 * <p>
 *
 * @author 李斌
 * @date 2018/11/10 22:26
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Entity
//@Table(name = "auto_jiekou_detail")
@Table(name = "auto_api_request_log")
public class ApiRequestLogEntity extends BaseIDEntity {

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
    /**请求内容*/
    @Excel(name = "请求内容", width = 15)
    private java.lang.String requestContent;
    /**响应内容*/
    @Excel(name = "响应内容", width = 15)
    private java.lang.String responseContent;
    /**请求时间*/
    @Excel(name = "请求时间", width = 15, format = "yyyy-MM-dd")
    private java.util.Date requestTime;
    /**响应时间*/
    @Excel(name = "响应时间", width = 15, format = "yyyy-MM-dd")
    private java.util.Date responseTime;

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  创建人名称
     */

    @Column(name = "CREATE_NAME", nullable = true, length = 50)
    public java.lang.String getCreateName() {
        return this.createName;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  创建人名称
     */
    public void setCreateName(java.lang.String createName) {
        this.createName = createName;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  创建人登录名称
     */

    @Column(name = "CREATE_BY", nullable = true, length = 50)
    public java.lang.String getCreateBy() {
        return this.createBy;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  创建人登录名称
     */
    public void setCreateBy(java.lang.String createBy) {
        this.createBy = createBy;
    }

    /**
     *方法: 取得java.util.Date
     *@return: java.util.Date  创建日期
     */

    @Column(name = "CREATE_DATE", nullable = true, length = 20)
    public java.util.Date getCreateDate() {
        return this.createDate;
    }

    /**
     *方法: 设置java.util.Date
     *@param: java.util.Date  创建日期
     */
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  更新人名称
     */

    @Column(name = "UPDATE_NAME", nullable = true, length = 50)
    public java.lang.String getUpdateName() {
        return this.updateName;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  更新人名称
     */
    public void setUpdateName(java.lang.String updateName) {
        this.updateName = updateName;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  更新人登录名称
     */

    @Column(name = "UPDATE_BY", nullable = true, length = 50)
    public java.lang.String getUpdateBy() {
        return this.updateBy;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  更新人登录名称
     */
    public void setUpdateBy(java.lang.String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     *方法: 取得java.util.Date
     *@return: java.util.Date  更新日期
     */

    @Column(name = "UPDATE_DATE", nullable = true, length = 20)
    public java.util.Date getUpdateDate() {
        return this.updateDate;
    }

    /**
     *方法: 设置java.util.Date
     *@param: java.util.Date  更新日期
     */
    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  所属部门
     */

    @Column(name = "SYS_ORG_CODE", nullable = true, length = 50)
    public java.lang.String getSysOrgCode() {
        return this.sysOrgCode;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  所属部门
     */
    public void setSysOrgCode(java.lang.String sysOrgCode) {
        this.sysOrgCode = sysOrgCode;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  所属公司
     */

    @Column(name = "SYS_COMPANY_CODE", nullable = true, length = 50)
    public java.lang.String getSysCompanyCode() {
        return this.sysCompanyCode;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  所属公司
     */
    public void setSysCompanyCode(java.lang.String sysCompanyCode) {
        this.sysCompanyCode = sysCompanyCode;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  流程状态
     */

    @Column(name = "BPM_STATUS", nullable = true, length = 32)
    public java.lang.String getBpmStatus() {
        return this.bpmStatus;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  流程状态
     */
    public void setBpmStatus(java.lang.String bpmStatus) {
        this.bpmStatus = bpmStatus;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  请求内容
     */

    @Column(name = "REQUEST_CONTENT", nullable = true, length = 500)
    public java.lang.String getRequestContent() {
        return this.requestContent;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  请求内容
     */
    public void setRequestContent(java.lang.String requestContent) {
        this.requestContent = requestContent;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  响应内容
     */

    @Column(name = "RESPONSE_CONTENT", nullable = true, length = 2000)
    public java.lang.String getResponseContent() {
        return this.responseContent;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  响应内容
     */
    public void setResponseContent(java.lang.String responseContent) {
        this.responseContent = responseContent;
    }

    /**
     *方法: 取得java.util.Date
     *@return: java.util.Date  请求时间
     */

    @Column(name = "REQUEST_TIME", nullable = true, length = 32)
    public java.util.Date getRequestTime() {
        return this.requestTime;
    }

    /**
     *方法: 设置java.util.Date
     *@param: java.util.Date  请求时间
     */
    public void setRequestTime(java.util.Date requestTime) {
        this.requestTime = requestTime;
    }

    /**
     *方法: 取得java.util.Date
     *@return: java.util.Date  响应时间
     */

    @Column(name = "RESPONSE_TIME", nullable = true, length = 32)
    public java.util.Date getResponseTime() {
        return this.responseTime;
    }

    /**
     *方法: 设置java.util.Date
     *@param: java.util.Date  响应时间
     */
    public void setResponseTime(java.util.Date responseTime) {
        this.responseTime = responseTime;
    }
}
