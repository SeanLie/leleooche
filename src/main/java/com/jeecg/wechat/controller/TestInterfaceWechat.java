package com.jeecg.wechat.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import org.jeecgframework.web.system.enums.InterfaceEnum;
import org.jeecgframework.web.system.pojo.base.InterfaceRuleDto;
import org.jeecgframework.web.system.util.InterfaceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/TestInterfaceWechat")
@Api(value = "Wechat", description = "微信测试接口", tags = "API_testInterface")
public class TestInterfaceWechat {

	@ApiOperation(value = "测试", notes = "微信测试测试信息", httpMethod = "POST", produces = "application/json")
	// @RequestMapping(value = "/getCode/{code}", method = RequestMethod.POST)
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
}
