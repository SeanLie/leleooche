package com.leletc.product.web.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 功能描述：产品业务对象
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/13 22:44
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@ApiModel(value = "productBo", description = "产品业务对象")
public class BaseProductsBO {

    @ApiModelProperty(value = "ID", name = "id", required = true, example = "1232der234wff32f")
    private String id;

    /**
     * 父服务产品
     */
    @ApiModelProperty(value = "父级产品ID", name = "parentProductId", example = "1232der234wff32f")
    private String parentProductId;
    /**
     * 服务产品名称
     */
    @ApiModelProperty(value = "服务产品名称", name = "productName", required = true, example = "1232der234wff32f")
    private String productName;
    /**
     * 服务产品状态
     */
    @ApiModelProperty(value = "父级产品ID", hidden = true, name = "productStatus", example = "0")
    private String productStatus;
    /**
     * 服务产品介绍
     */
    @ApiModelProperty(value = "服务产品介绍", name = "productDesc", example = "介绍")
    private String productDesc;

    /**
     * userId
     */
    @ApiModelProperty(value = "用户ID", required = true, name = "userId", example = "abc12312312661")
    private String userId;
    /**
     * 产品ID
     */
    @ApiModelProperty(value = "产品ID", required = true, name = "productId", example = "abc12312312661")
    private String productId;
    /**
     * 产品剩余次数
     */
    @ApiModelProperty(value = "产品剩余次数", required = true, name = "productLeftNum", example = "5")
    private Integer productLeftNum;
    /**
     * 产品总次数
     */
    @ApiModelProperty(value = "产品总次数", required = true, name = "productAmount", example = "1")
    private Integer productAmount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentProductId() {
        return parentProductId;
    }

    public void setParentProductId(String parentProductId) {
        this.parentProductId = parentProductId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getProductLeftNum() {
        return productLeftNum;
    }

    public void setProductLeftNum(Integer productLeftNum) {
        this.productLeftNum = productLeftNum;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }
}
