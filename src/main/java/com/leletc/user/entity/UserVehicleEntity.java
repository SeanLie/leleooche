/**
 * 实体Entity层
 */
package com.leletc.user.entity;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.*;
import java.util.Date;

/**
 * 功能描述：用户车辆信息表实体类
 * <p>
 *
 * @author Sean
 * <p>
 * @date 2018-12-15 20:19:04
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
@Table(name = "auto_user_carpark")
public class UserVehicleEntity implements java.io.Serializable {

    /**
     * 主键
     */
    private String id;
    /**
     * 用户ID
     */
    @Excel(name = "用户ID", width = 15, dictTable = "t_s_user", dicCode = "user_id", dicText = "id")
    private String userId;
    /**
     * 车牌号
     */
    @Excel(name = "车牌号", width = 15)
    private String carNum;
    /**
     * 车型号
     */
    @Excel(name = "车型号", width = 15)
    private String carModel;
    /**
     * 购车日期
     */
    @Excel(name = "购车日期", width = 15)
    private String carBuyDate;
    /**
     * 车辆描述
     */
    @Excel(name = "车辆描述", width = 15)
    private String carDesc;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 创建人登录名称
     */
    private String createBy;
    /**
     * 创建日期
     */
    private Date createDate;
    /**
     * 更新人名称
     */
    private String updateName;
    /**
     * 更新人登录名称
     */
    private String updateBy;
    /**
     * 更新日期
     */
    private Date updateDate;
    /**
     * 所属部门
     */
    private String sysOrgCode;
    /**
     * 所属公司
     */
    private String sysCompanyCode;
    /**
     * 流程状态
     */
    private String bpmStatus;

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  主键
     */
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Column(name = "ID", nullable = false, length = 36)
    public String getId() {
        return this.id;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  用户ID
     */

    @Column(name = "USER_ID", nullable = true, length = 36)
    public String getUserId() {
        return this.userId;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  车牌号
     */

    @Column(name = "CAR_NUM", nullable = false, length = 32)
    public String getCarNum() {
        return this.carNum;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  车牌号
     */
    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  车型号
     */

    @Column(name = "CAR_MODEL", nullable = true, length = 32)
    public String getCarModel() {
        return this.carModel;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  车型号
     */
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  购车日期
     */

    @Column(name = "CAR_BUY_DATE", nullable = true, length = 10)
    public String getCarBuyDate() {
        return this.carBuyDate;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  购车日期
     */
    public void setCarBuyDate(String carBuyDate) {
        this.carBuyDate = carBuyDate;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  车辆描述
     */

    @Column(name = "CAR_DESC", nullable = true, length = 255)
    public String getCarDesc() {
        return this.carDesc;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  车辆描述
     */
    public void setCarDesc(String carDesc) {
        this.carDesc = carDesc;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  创建人名称
     */

    @Column(name = "CREATE_NAME", nullable = true, length = 50)
    public String getCreateName() {
        return this.createName;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  创建人名称
     */
    public void setCreateName(String createName) {
        this.createName = createName;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  创建人登录名称
     */

    @Column(name = "CREATE_BY", nullable = true, length = 50)
    public String getCreateBy() {
        return this.createBy;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  创建人登录名称
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date  创建日期
     */

    @Column(name = "CREATE_DATE", nullable = true, length = 20)
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date  创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  更新人名称
     */

    @Column(name = "UPDATE_NAME", nullable = true, length = 50)
    public String getUpdateName() {
        return this.updateName;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  更新人名称
     */
    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  更新人登录名称
     */

    @Column(name = "UPDATE_BY", nullable = true, length = 50)
    public String getUpdateBy() {
        return this.updateBy;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  更新人登录名称
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 方法: 取得java.util.Date
     *
     * @return: java.util.Date  更新日期
     */

    @Column(name = "UPDATE_DATE", nullable = true, length = 20)
    public Date getUpdateDate() {
        return this.updateDate;
    }

    /**
     * 方法: 设置java.util.Date
     *
     * @param: java.util.Date  更新日期
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  所属部门
     */

    @Column(name = "SYS_ORG_CODE", nullable = true, length = 50)
    public String getSysOrgCode() {
        return this.sysOrgCode;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  所属部门
     */
    public void setSysOrgCode(String sysOrgCode) {
        this.sysOrgCode = sysOrgCode;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  所属公司
     */

    @Column(name = "SYS_COMPANY_CODE", nullable = true, length = 50)
    public String getSysCompanyCode() {
        return this.sysCompanyCode;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  所属公司
     */
    public void setSysCompanyCode(String sysCompanyCode) {
        this.sysCompanyCode = sysCompanyCode;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  流程状态
     */

    @Column(name = "BPM_STATUS", nullable = true, length = 32)
    public String getBpmStatus() {
        return this.bpmStatus;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  流程状态
     */
    public void setBpmStatus(String bpmStatus) {
        this.bpmStatus = bpmStatus;
    }

    @Override
    public String toString() {
        return "UserVehicleEntity{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", carNum='" + carNum + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carBuyDate='" + carBuyDate + '\'' +
                ", carDesc='" + carDesc + '\'' +
                ", createName='" + createName + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createDate=" + createDate +
                ", updateName='" + updateName + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateDate=" + updateDate +
                ", sysOrgCode='" + sysOrgCode + '\'' +
                ", sysCompanyCode='" + sysCompanyCode + '\'' +
                ", bpmStatus='" + bpmStatus + '\'' +
                '}';
    }
}