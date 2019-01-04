package com.jeecg.wechat.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.menu.ResponseMessageCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeecg.wechat.entity.WxSdkSign;
import com.jeecg.wechat.service.WxSdkSignServiceI;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * ClassName: WxSignController
 *
 * @author zhulei
 * @Description: 用户微信前端页面的jssdk配置使用
 * @date 2018年8月14日 下午14:18
 */
@Controller
@RequestMapping("/wxSignController")
@Api(value = "微信登录认证接口", description = "微信登录认证接口", tags = "API_WxSign")
public class WxSignController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(WxSignController.class);

	@Autowired
	private WxSdkSignServiceI wxSdkSignService;

	/**
	 * 微信网页授权签名
	 *
	 * @param @param response
	 * @param @param request
	 * @param @param url
	 * @param @throws Exception
	 * @Description: 前端获取微信JSSDK的配置参数
	 * @author zhulei
	 * @date 2016年3月19日 下午5:57:52
	 */
	@ApiOperation(value = "微信网页授权签名", notes = "微信网页授权签名", httpMethod = "POST", produces = "application/json")
	@ResponseBody
	@RequestMapping(value = "/wxSign", method = RequestMethod.POST)
	public ResponseMessage<WxSdkSign> wxGetSign(@ApiParam(value = "跳转网页授权URL") @RequestParam String url_,
			HttpServletRequest request) throws Exception {
		ResponseMessage<WxSdkSign> response = new ResponseMessage<>();
		response.setMessage("返回成功");
		response.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
		url_ = request.getParameter("url_");
		// 验证
		if (StringUtils.isEmpty(url_)) {
			logger.error("微信url_不能为空!");
			response.setRespCode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			return response;
		}
		WxSdkSign wxSdkSign = wxSdkSignService.getJsSdkSignByUrl(url_);
		response.setData(wxSdkSign);
		return response;
	}

}
