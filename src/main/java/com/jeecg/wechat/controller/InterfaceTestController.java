package com.jeecg.wechat.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import org.jeecgframework.web.system.enums.InterfaceEnum;
import org.jeecgframework.web.system.pojo.base.InterfaceRuleDto;
import org.jeecgframework.web.system.util.InterfaceUtil;
import org.jeewx.api.core.req.WeiXinReqService;
import org.jeewx.api.core.req.model.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/interfaceTestController")
@Api(value = "测试微信", description = "测试微信接口", tags = "API_infaceWechatTest")
public class InterfaceTestController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(InterfaceTestController.class);

	@ApiOperation(value = "微信测试信息", notes = "微信测试信息", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage<?> get(@PathVariable("id") String id, HttpServletRequest request) {
		System.out.println("===============开始进入接口测试类============");
		System.out.println("===============开始验证接口权限测试类============");
		InterfaceRuleDto interfaceRuleDto = InterfaceUtil.getInterfaceRuleDto(request, InterfaceEnum.intertest_get);
		if (interfaceRuleDto == null) {
			return Result.error("您没有该接口的权限！");
		}

		System.out.println("===============结束验证接口权限测试类============");
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		System.out.println("===============接口测试类测试成功============");
		System.out.println("===============message=接口调用成功============");
		return Result.success("接口成功");
	}

	@ApiOperation(value = "微信", notes = "测试信息", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/getCode/{code}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage<?> getcode(@PathVariable("code") String code, HttpServletRequest request) {
		System.out.println("===============开始进入接口getCode测试类============");
		System.out.println("===============开始验证接口权限getCode测试类============");
		InterfaceRuleDto interfaceRuleDto = InterfaceUtil.getInterfaceRuleDto(request, InterfaceEnum.intertest_get);
		if (interfaceRuleDto == null) {
			return Result.error("您没有该接口的权限！");
		}

		System.out.println("===============结束验证接口权限getCode测试类============");
		// 验证
		if (StringUtils.isEmpty(code)) {
			return Result.error("ID不能为空");
		}
		System.out.println("===============接口getCode测试类测试成功============");
		System.out.println("===============message=getCode接口调用成功============");
		return Result.success("接口成功");
	}

	@ApiOperation(value = "获取Token", notes = "获取Token", httpMethod = "POST", produces = "application/json")
	@RequestMapping(value = "/getToken", method = RequestMethod.POST)
	@ResponseBody
	public String getToken(HttpServletRequest request) throws Exception {

		String appId = "wxb3c62b26f2d93948";
		String appSecret = "07e2fd71ed57fecc95dae539b2aee7d8";
		AccessToken token = new AccessToken();
		token.setAppid(appId);
		token.setSecret(appSecret);
		String strtoken = WeiXinReqService.getInstance().doWeinxinReq(token);
		System.out.println(strtoken);
		return strtoken;

	}

}
