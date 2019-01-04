package com.leletc.oocheorder.web.api.controller;

import com.leletc.oocheorder.service.IOrdersHandleService;
import com.leletc.oocheorder.web.api.response.OrderHandleRsp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 功能描述：订单处理业务Rest控制器
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018-12-28 01:23:22
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Controller
@RequestMapping(value = "/orderHandleRestController")
@Api(value = "OrderHandleRestController", description = "订单处理业务", tags = "API_OrderHandle")
public class OrderHandleRestController extends BaseController {

    @Autowired
    private IOrdersHandleService ordersHandleService;

    /**
     * 根据ID获取订单处理信息
     * @param orderId 订单ID
     * @return ResponseMessage
     */
    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据ID获取订单处理信息", notes = "订单处理", httpMethod = "GET", produces = "application/json")
    public ResponseMessage<OrderHandleRsp> getByOrderId(
            @ApiParam(required = true, name = "orderId", value = "订单ID") @PathVariable("orderId") String orderId) {
        ResponseMessage<OrderHandleRsp> response = new ResponseMessage<>();
        OrderHandleRsp rsp = ordersHandleService.getOrderHandleByOrderId(orderId);
        new ResponseMessage<OrderHandleRsp>().setReturnData(response, rsp, rsp);
        return response;
    }

}
