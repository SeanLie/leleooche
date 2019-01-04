package com.leletc.oocheorder.web.api.response;

import com.leletc.base.api.response.RspHead;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 功能描述：预约队列业务响应对象
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/12/29 01:14
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@ApiModel(value = "queueLocationRsp", description = "预约队列业务响应对象")
public class QueueLocationRsp extends RspHead {

    /**
     * 订单ID
     */
    @ApiModelProperty(value = "订单ID", name = "orderId", required = true, example = "123321")
    private String orderId;

    /**
     * 当前排号
     */
    @ApiModelProperty(value = "当前排号", name = "rankingNo", required = true, example = "2")
    private Integer rankingNo;

    /**
     * 订单用户名称
     */
    @ApiModelProperty(value = "订单用户名称", name = "orderUserName", required = true, example = "小白")
    private String orderUserName;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getRankingNo() {
        return rankingNo;
    }

    public void setRankingNo(Integer rankingNo) {
        this.rankingNo = rankingNo;
    }

    public String getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName;
    }

    @Override
    public String toString() {
        return "QueueLocationRsp{" +
                "orderId='" + orderId + '\'' +
                ", rankingNo=" + rankingNo +
                ", orderUserName='" + orderUserName + '\'' +
                '}';
    }

}
