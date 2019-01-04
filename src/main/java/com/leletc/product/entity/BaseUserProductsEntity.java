package com.leletc.product.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.jeecgframework.core.common.entity.BaseIDEntity;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 功能描述：用户与服务产品配置信息表
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/13 22:50
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
@Table(name = "auto_base_user_products")
@ApiModel(value = "userProduct", description = "用户与服务产品配置信息表")
public class BaseUserProductsEntity extends BaseIDEntity {

    /**
     * userId
     */
    @Excel(name = "用户ID", width = 15)
    @ApiModelProperty(value = "用户ID", required = true, name = "userId", example = "abc12312312661")
    private String userId;

    @Excel(name = "用户等级", width = 15)
    @ApiModelProperty(value = "用户等级", required = true, name = "userPersonLevel", example = "1")
    private String userPersonLevel;
    /**
     * 用户名称（昵称）
     */
    @Excel(name = "用户名称", width = 15)
    @ApiModelProperty(value = "用户名称", required = true, name = "userName", example = "小五")
    private String userName;
    /**
     * 产品ID
     */
    @Excel(name = "产品ID", width = 15)
    @ApiModelProperty(value = "产品ID", required = true, name = "productId", example = "abc12312312661")
    private String productId;
    /**
     * 产品名称
     */
    @Excel(name = "产品名称", width = 15)
    @ApiModelProperty(value = "产品名称", required = true, name = "productName", example = "普洗")
    private String productName;
    /**
     * 产品剩余次数
     */
    @Excel(name = "产品剩余次数", width = 15)
    @ApiModelProperty(value = "产品剩余次数", required = true, name = "productLeftNum", example = "5")
    private Integer productLeftNum;
    /**
     * 产品总次数
     */
    @ApiModelProperty(value = "产品总次数", required = true, name = "productAmount", example = "1")
    @Excel(name = "productAmount", width = 15)
    private Integer productAmount;
    /**
     * 创建人名称
     */
    @Excel(name = "创建人名称", width = 15)
    @ApiModelProperty(hidden = true)
    private String createName;
    /**
     * 创建人登录名称
     */
    @Excel(name = "创建人登录名称", width = 15)
    @ApiModelProperty(hidden = true)
    private String createBy;
    /**
     * 创建日期
     */
    @Excel(name = "创建日期", width = 15, format = "yyyy-MM-dd")
    @ApiModelProperty(hidden = true)
    private java.util.Date createDate;
    /**
     * 更新人名称
     */
    @Excel(name = "更新人名称", width = 15)
    @ApiModelProperty(hidden = true)
    private String updateName;
    /**
     * 更新人登录名称
     */
    @Excel(name = "更新人登录名称", width = 15)
    @ApiModelProperty(hidden = true)
    private String updateBy;
    /**
     * 更新日期
     */
    @Excel(name = "更新日期", width = 15, format = "yyyy-MM-dd")
    @ApiModelProperty(hidden = true)
    private java.util.Date updateDate;
    /**
     * 所属部门
     */
    @Excel(name = "所属部门", width = 15)
    @ApiModelProperty(hidden = true)
    private String sysOrgCode;
    /**
     * 所属公司
     */
    @Excel(name = "所属公司", width = 15)
    @ApiModelProperty(hidden = true)
    private String sysCompanyCode;

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  userId
     */
    @Column(name = "USER_ID", nullable = false, length = 36)
    public String getUserId() {
        return this.userId;
    }

    @Column(name = "USER_PERSON_LEVEL", nullable = false, length = 3)
    public String getUserPersonLevel() {
        return userPersonLevel;
    }

    public void setUserPersonLevel(String userPersonLevel) {
        this.userPersonLevel = userPersonLevel;
    }

    @Column(name = "USER_NAME", length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "PRODUCT_NAME", length = 50)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  产品ID
     */

    @Column(name = "PRODUCT_ID", nullable = false, length = 36)
    public String getProductId() {
        return this.productId;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  产品ID
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer  产品剩余次数
     */

    @Column(name = "PRODUCT_LEFT_NUM", nullable = false, length = 10)
    public Integer getProductLeftNum() {
        return this.productLeftNum;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer  产品剩余次数
     */
    public void setProductLeftNum(Integer productLeftNum) {
        this.productLeftNum = productLeftNum;
    }

    /**
     * 方法: 取得java.lang.Integer
     *
     * @return: java.lang.Integer  productAmount
     */

    @Column(name = "PRODUCT_AMOUNT", nullable = false, length = 10)
    public Integer getProductAmount() {
        return this.productAmount;
    }

    /**
     * 方法: 设置java.lang.Integer
     *
     * @param: java.lang.Integer  productAmount
     */
    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  创建人名称
     */

    @Column(name = "CREATE_NAME", nullable = false, length = 50)
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

    @Column(name = "CREATE_BY", nullable = false, length = 50)
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
}
