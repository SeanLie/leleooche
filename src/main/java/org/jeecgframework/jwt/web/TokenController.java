package org.jeecgframework.jwt.web;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.jwt.model.TokenModel;
import org.jeecgframework.jwt.service.TokenManager;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.menu.ResponseMessageCodeEnum;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 获取和删除token的请求地址， 在Restful设计中其实就对应着登录和退出登录的资源映射
 *
 * @author scott
 * @date 2015/7/30.
 */
@Api(value = "token", description = "鉴权token接口", tags = "API_SystemToken")
@Controller
@RequestMapping("/tokens")
public class TokenController extends BaseController {

	private static final String TAG = TokenController.class.getSimpleName() + " - 鉴权Token";

	private static final Logger logger = LoggerFactory.getLogger(TokenController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private TokenManager tokenManager;

	/**
	 * 获取TOKEN
	 *
	 * @param username 用户账号
	 * @param password 用户密码
	 * @return 响应消息实体-ResponseEntity
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "获取登录Token", notes = "获取Token", httpMethod = "POST")
	public ResponseMessage<String> login(@RequestParam String username, @RequestParam String password) {
		ResponseMessage<String> response = new ResponseMessage<>();
		// 验证
		if (StringUtils.isEmpty(username)) {
			logger.error(TAG + " - {}", "用户账号不能为空");
			response.setRespCode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			response.setMessage("用户账号不能为空");
			return response;
		}
		// 验证
		if (StringUtils.isEmpty(username)) {
			logger.error(TAG + " - {}", "用户密码不能为空");
			response.setRespCode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			response.setMessage("用户密码不能为空");
			return response;
		}
		// 用户是否存在
		TSUser user = userService.checkUserExits(username, password);
		if (user == null) {
			logger.error(TAG + " - {}", "用户账号或密码错误");
			response.setRespCode(ResponseMessageCodeEnum.NULL_ERROR.getCode());
			response.setMessage("用户账号或密码错误");
			return response;
		}
		// 生成一个token，保存用户登录状态
		String token = tokenManager.createToken(user);
		logger.debug(TAG + " - {} - {}", "获取Token", token);
		response.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
		response.setData(token);
		return response;
	}

	/**
	 * 销毁TOKEN
	 *
	 * @param username 用户账号
	 * @return 响应消息对象ResponseMessage
	 */
	@RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "销毁TOKEN", notes = "销毁Token")
	public ResponseMessage<String> logout(
			@ApiParam(name = "username", value = "用户账号", required = true) @PathVariable("username") String username) {
		ResponseMessage<String> response = new ResponseMessage<>();
		// 验证
		if (StringUtils.isEmpty(username)) {
			logger.error(TAG + " - {}", "用户账号不能为空");
			response.setRespCode(ResponseMessageCodeEnum.NULL_ERROR.getCode());
			response.setMessage("用户账号不能为空");
			return response;
		}
		try {
			tokenManager.deleteToken(username);
		} catch (Exception e) {
			logger.error(TAG + " - {} - {}", "销毁TOKEN失败 - ", e.getMessage());
			response.setRespCode(ResponseMessageCodeEnum.ERROR.getCode());
			response.setMessage("销毁TOKEN失败");
		}
		response.setMessage("销毁TOKEN成功");
		response.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
		return response;
	}

	/**
	 * 获取微信网页Token
	 * 
	 * @param mobile 手机号
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "获取微信网页Token")
	@RequestMapping(value = "/wxGetToken", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage<Boolean> wxGetToken(@ApiParam(value = "获取微信网页Token") @RequestParam String mobile)
			throws Exception {
		ResponseMessage<Boolean> response = new ResponseMessage<>();
		TokenModel model = new TokenModel(mobile, "");
		boolean isPass = tokenManager.checkToken(model);
		if (!isPass) {
			logger.error(TAG + " - {}", "登录已过期");
			response.setRespCode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			response.setMessage("登录已过期");
		}
		response.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
		response.setMessage("登录成功");
		response.setData(isPass);
		return response;
	}

}
