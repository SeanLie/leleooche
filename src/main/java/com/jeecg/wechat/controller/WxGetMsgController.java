package com.jeecg.wechat.controller;

import javax.servlet.http.HttpServletRequest;

import com.leletc.oocheorder.web.api.controller.OrderController;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/*
 * 接受消息
 */
@Controller
@RequestMapping("/wxGetMsgController")
@Api(value = "消息控制器", description = "消息控制器", tags = "API_WxGetMsg")
public class WxGetMsgController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@RequestMapping(value = "/getReservationOrderList/{user_id}/", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "消息ID", notes = "消息ID", httpMethod = "GET", produces = "application/json")
	public ResponseMessage<?> getReservationOrderList(@ApiParam(value = "用户ID") @PathVariable("user_id") String user_id,
			HttpServletRequest request) throws Exception {
		AjaxJson ajaxJson = new AjaxJson();
		logger.info("user_id" + user_id);
		return Result.success(ajaxJson);

	}
	// 验证消息真实性

	// 接受普通消息

	// 接受事件推送

	// 接受语音识别结果

}
