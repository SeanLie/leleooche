package com.jeecg.wechat.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.jwt.service.TokenManager;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.menu.ResponseMessageCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeecg.wechat.entity.Code2Session;
import com.jeecg.wechat.util.WeixinUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 获取和删除token的请求地址， 在Restful设计中其实就对应着登录和退出登录的资源映射
 *
 * @author scott
 * @date 2015/7/30.
 */
@Controller
@RequestMapping("/loginTokenController")
@Api(value = "微信登陆", description = "微信登陆鉴权接口", tags = "XCX_API_LoginToken")
public class LoginTokenController extends BaseController {

	private static final String TAG = LoginTokenController.class.getSimpleName() + " - 注册控制器";

	private static final Logger logger = LoggerFactory.getLogger(LoginTokenController.class);

	@Autowired
	private TokenManager tokenManager;

	@ApiOperation(value = "用户登陆响应Code2Session", notes = "code换取这个用户登陆Code2Session ", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getLoginCode2Session/{code}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseMessage<String> getLoginCode2Session(@ApiParam(value = "微信授权码") @PathVariable("code") String code,
			HttpServletRequest request) throws Exception {
		ResponseMessage<String> response = new ResponseMessage<>();
		// 验证
		if (StringUtils.isEmpty(code)) {
			logger.error(TAG + " - {}", "微信Code不能为空!");
			response.setRespCode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			response.setMessage("用户tel不能为空!");
			return response;
		}
		// 生成一个token，保存用户登录状态
		Code2Session code2Session = WeixinUtil.getCode2Session(code);
		String openid = code2Session.getOpenid();
		String token = tokenManager.createOpenIdToken(openid);
		logger.info(TAG + " - {}", "生成token=" + token);
		response.setData(token);
		response.setMessage("返回成功");
		response.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
		return response;
	}

	/**
	 * 销毁TOKEN
	 *
	 * @param openId 用户账号
	 * @return 响应消息对象ResponseMessage
	 */
	@ApiOperation(value = "销毁TOKEN")
	@RequestMapping(value = "/{openid}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseMessage<String> loginOut(
			@ApiParam(name = "openid", value = "用户账号", required = true) @PathVariable("openid") String openId) {
		logger.info("deleteToken[{}]", openId);
		ResponseMessage<String> response = new ResponseMessage<>();
		// 验证
		if (StringUtils.isEmpty(openId)) {
			logger.error(TAG + " - {}", "微信OpenId不能为空！");
			response.setRespCode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			response.setMessage("微信OpenId不能为空！");
			return response;
		}
		try {
			tokenManager.deleteOpenIdToken(openId);
		} catch (Exception e) {
			logger.error(TAG + " - {}", "销毁Token失败！");
			response.setRespCode(ResponseMessageCodeEnum.ERROR.getCode());
			response.setMessage("销毁Token失败！");
			return response;
		}
		response.setMessage("返回成功");
		response.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
		return response;
	}

}
