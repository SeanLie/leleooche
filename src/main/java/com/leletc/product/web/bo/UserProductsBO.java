package com.leletc.product.web.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 功能描述：用户产品业务对象
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/12 21:34
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@ApiModel(value = "userProductBo", description = "用户产品对象")
public class UserProductsBO {

    /**
     * 产品ID
     */
    @ApiModelProperty(value = "产品ID", required = true, name = "productId", example = "abc12312312661")
    private String productId;
    /**
     * 服务产品名称
     */
    @ApiModelProperty(value = "服务产品名称", name = "productName", required = true, example = "1232der234wff32f")
    private String productName;
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

    public UserProductsBO(String productId, String productName, Integer productLeftNum, Integer productAmount) {
        this.productId = productId;
        this.productName = productName;
        this.productLeftNum = productLeftNum;
        this.productAmount = productAmount;
    }

    public UserProductsBO() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
//@ApiModelProperty(value = "产品对象", required = true, name = "product", example = "{}")
    //BaseProductsEntity product;
}
