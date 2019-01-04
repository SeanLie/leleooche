package com.leletc.product.web.api.response;

import com.leletc.base.api.response.RspHead;
import com.leletc.product.web.bo.BaseProductsBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 功能描述：产品信息响应体
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/12 00:33
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@ApiModel(value = "productRsp", description = "产品信息响应体")
public class BaseProductsRsp extends RspHead {

    @ApiModelProperty(value = "服务产品列表", name = "products", required = true, example = "[{product:{}}]")
    List<BaseProductsBO> products;

    public List<BaseProductsBO> getProducts() {
        return products;
    }

    public void setProducts(List<BaseProductsBO> products) {
        this.products = products;
    }
}
