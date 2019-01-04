package com.leletc.product.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.jeecgframework.core.common.entity.BaseIDEntity;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 功能描述：服务产品表实体类
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
@Table(name = "auto_base_products")
@ApiModel(value = "product", description = "产品信息")
public class BaseProductsEntity extends BaseIDEntity {

    /**
     * 父服务产品
     */
    @Excel(name = "父服务产品", width = 15)
    @ApiModelProperty(value = "父级产品ID", name = "parentProductId", example = "1232der234wff32f")
    private String parentProductId;
    /**
     * 服务产品名称
     */
    @Excel(name = "服务产品名称", width = 15)
    @ApiModelProperty(value = "服务产品名称", name = "productName", required = true, example = "1232der234wff32f")
    private String productName;
    /**
     * 服务产品状态
     */
    @Excel(name = "服务产品状态", width = 15, dicCode = "prostatus")
    @ApiModelProperty(value = "服务产品状态", hidden = true, name = "productStatus", example = "0")
    private String productStatus;
    /**
     * 服务产品介绍
     */
    @Excel(name = "服务产品介绍", width = 15)
    @ApiModelProperty(value = "服务产品介绍", name = "productDesc", example = "介绍")
    private String productDesc;
    /**
     * 创建人名称
     */
    @ApiModelProperty(hidden = true)
    private String createName;
    /**
     * 创建人登录名称
     */
    @ApiModelProperty(hidden = true)
    private String createBy;
    /**
     * 创建日期
     */
    @ApiModelProperty(hidden = true)
    private java.util.Date createDate;
    /**
     * 更新人名称
     */
    @ApiModelProperty(hidden = true)
    private String updateName;
    /**
     * 更新人登录名称
     */
    @ApiModelProperty(hidden = true)
    private String updateBy;
    /**
     * 更新日期
     */
    @ApiModelProperty(hidden = true)
    private java.util.Date updateDate;
    /**
     * 所属部门
     */
    @ApiModelProperty(hidden = true)
    private String sysOrgCode;
    /**
     * 所属公司
     */
    @ApiModelProperty(hidden = true)
    private String sysCompanyCode;

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  父服务产品
     */
    @Column(name = "PARENT_PRODUCT_ID", length = 36)
    public String getParentProductId() {
        return this.parentProductId;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  父服务产品
     */
    public void setParentProductId(String parentProductId) {
        this.parentProductId = parentProductId;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  服务产品名称
     */

    @Column(name = "PRODUCT_NAME", nullable = true, length = 32)
    public String getProductName() {
        return this.productName;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  服务产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  服务产品状态
     */

    @Column(name = "PRODUCT_STATUS", nullable = true, length = 4)
    public String getProductStatus() {
        return this.productStatus;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  服务产品状态
     */
    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    /**
     * 方法: 取得java.lang.String
     *
     * @return: java.lang.String  服务产品介绍
     */

    @Column(name = "PRODUCT_DESC", nullable = true, length = 500)
    public String getProductDesc() {
        return this.productDesc;
    }

    /**
     * 方法: 设置java.lang.String
     *
     * @param: java.lang.String  服务产品介绍
     */
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
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
