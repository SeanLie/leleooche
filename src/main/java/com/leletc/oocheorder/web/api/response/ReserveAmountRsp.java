package com.leletc.oocheorder.web.api.response;

import com.leletc.base.api.response.RspHead;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 功能描述：预约数量业务响应对象
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/12/29 02:05
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@ApiModel(value = "reserveAmountRsp", description = "预约数量业务响应对象")
public class ReserveAmountRsp extends RspHead {

    /**
     * 可预约总数
     */
    @ApiModelProperty(value = "可预约总数", name = "totalAmount", required = true, example = "25")
    private Integer totalAmount;
    /**
     * 剩余预约数
     */
    @ApiModelProperty(value = "剩余预约数", name = "remainAmount", required = true, example = "18")
    private Integer remainAmount;
    /**
     * 已预约数
     */
    @ApiModelProperty(value = "已预约数", name = "hasUsedAmount", required = true, example = "7")
    private Integer hasUsedAmount;

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getRemainAmount() {
        return remainAmount;
    }

    public void setRemainAmount(Integer remainAmount) {
        this.remainAmount = remainAmount;
    }

    public Integer getHasUsedAmount() {
        return hasUsedAmount;
    }

    public void setHasUsedAmount(Integer hasUsedAmount) {
        this.hasUsedAmount = hasUsedAmount;
    }
}
