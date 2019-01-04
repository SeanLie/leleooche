/**
 * 实体Entity层
 */
package com.leletc.reservecfg.entity;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.*;

/**
 * 功能描述：auto_reserve_permissions_config表实体类
 * <p>
 *
 * @author Sean
 * <p>
 * @date 2018-11-12 00:51:17
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
@Table(name = "auto_reserve_permissions_config")
public class AutoReservePermissionsConfigEntity implements java.io.Serializable {
    /**
     * id
     */
    private java.lang.String id;
    /**
     * 机构是否开通预约
     */
    @Excel(name = "机构是否开通预约", width = 15)
    private java.lang.String flag;
    /**
     * 预约时间开始时间(hh:mm:ss)
     */
    @Excel(name = "预约时间开始时间", width = 10)
    private java.lang.String resStartTime;
    /**
     * 预约时间结束时间(hh:mm:ss)
     */
    @Excel(name = "预约时间结束时间", width = 10)
    private java.lang.String resEndTime;
    /**
     * 机构预约当天订单数量
     */
    @Excel(name = "机构预约当天订单数量", width = 15)
    private java.lang.String resOrderNum;
    /**
     * 所属部门ID
     */
    @Excel(name = "所属部门ID", width = 15)
    private java.lang.String departCode;
    /**
     * 所属公司ID
     */
    @Excel(name = "所属公司ID", width = 15)
    private java.lang.String companyCode;
    /**
     * 创建人名称
     */
    @Excel(name = "创建人名称", width = 15)
    private java.lang.String createName;
    /**
     * 创建人登录名称
     */
    @Excel(name = "创建人登录名称", width = 15)
    private java.lang.String createBy;
    /**
     * 创建日期
     */
    @Excel(name = "创建日期", width = 15, format = "yyyy-MM-dd")
    private java.util.Date createDate;
    /**
     * 更新人名称
     */
    @Excel(name = "更新人名称", width = 15)
    private java.lang.String updateName;
    /**
     * 更新人登录名称
     */
    @Excel(name = "更新人登录名称", width = 15)
    private java.lang.String updateBy;
    /**
     * 更新日期
     */
    @Excel(name = "更新日期", width = 15, format = "yyyy-MM-dd")
    private java.util.Date updateDate;

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  id
     */
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

    @Column(name = "ID", nullable = false, length = 36)
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
     * @return: java.lang.String  机构是否开通预约
     */

    @Column(name = "FLAG", nullable = true, length = 2)
    public java.lang.String getFlag() {
        return this.flag;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  机构是否开通预约
     */
    public void setFlag(java.lang.String flag) {
        this.flag = flag;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  预约时间开始时间
     */

    @Column(name = "RES_START_TIME", length = 10)
    public java.lang.String getResStartTime() {
        return this.resStartTime;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  预约时间开始时间
     */
    public void setResStartTime(java.lang.String resStartTime) {
        this.resStartTime = resStartTime;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  预约时间结束时间
     */
    @Column(name = "RES_END_TIME", length = 10)
    public java.lang.String getResEndTime() {
        return this.resEndTime;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  预约时间结束时间
     */
    public void setResEndTime(java.lang.String resEndTime) {
        this.resEndTime = resEndTime;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  机构预约当天订单数量
     */

    @Column(name = "RES_ORDER_NUM", nullable = true, length = 50)
    public java.lang.String getResOrderNum() {
        return this.resOrderNum;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  机构预约当天订单数量
     */
    public void setResOrderNum(java.lang.String resOrderNum) {
        this.resOrderNum = resOrderNum;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  所属部门ID
     */

    @Column(name = "DEPART_CODE", nullable = true, length = 50)
    public java.lang.String getDepartCode() {
        return this.departCode;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  所属部门ID
     */
    public void setDepartCode(java.lang.String departCode) {
        this.departCode = departCode;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  所属公司ID
     */

    @Column(name = "COMPANY_CODE", nullable = true, length = 50)
    public java.lang.String getCompanyCode() {
        return this.companyCode;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  所属公司ID
     */
    public void setCompanyCode(java.lang.String companyCode) {
        this.companyCode = companyCode;
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
}