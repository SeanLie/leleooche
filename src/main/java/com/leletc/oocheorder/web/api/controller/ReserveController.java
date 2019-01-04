package com.leletc.oocheorder.web.api.controller;

import javax.servlet.http.HttpServletRequest;

import com.leletc.oocheorder.web.bo.ReservationBO;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.menu.ResponseMessageCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leletc.oocheorder.web.api.request.ReserveRsp;
import com.leletc.oocheorder.service.IOrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

/**
 * 功能描述：预约权限处理类
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/12/27 01:58
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018/12/27, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Controller
@RequestMapping("/reserveController")
@Api(value = "reserveController", description = "预约权限处理类", tags = "API_ReservePermission")
public class ReserveController extends BaseController {

	@Autowired
	private IOrderService orderService;

	/**
	 * 根据用户ID获取预约权限
	 *
	 * @param userId    用户ID
	 * @param productId 用户产品ID
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "getUserReserve/{userId}/{productId}/{plateNumber}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据用户ID获取预约权限", notes = "根据用户ID获取预约权限", httpMethod = "GET", produces = "application/json")
	public ResponseMessage<ReserveRsp> getUserReservePermissions(
			@ApiParam(value = "用户ID", required = true) @PathVariable("userId") String userId,
			@ApiParam(value = "用户产品ID") @PathVariable("productId") String productId,
			@ApiParam(value = "用户车牌编号") @PathVariable("plateNumber") String plateNumber, HttpServletRequest request)
			throws Exception {
		ResponseMessage<ReserveRsp> response = new ResponseMessage<>();
		ReserveRsp rsp = orderService.isPermitReserve(userId, productId, plateNumber);
		new ResponseMessage<ReserveRsp>().setReturnData(response, rsp, rsp);
		return response;
	}

}
