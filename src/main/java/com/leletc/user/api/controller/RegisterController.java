package com.leletc.user.api.controller;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.menu.ResponseMessageCodeEnum;
import org.jeewx.api.wxuser.user.model.Wxuser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeecg.wechat.util.Cache;
import com.jeecg.wechat.util.CacheManager;
import com.jeecg.wechat.util.SMSUtil;
import com.leletc.user.api.request.RegisterReq;
import com.leletc.user.api.response.UserRsp;
import com.leletc.user.service.IRegisterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 功能描述：注册控制器
 * <p>
 * 
 * @author 朱磊
 *         <p>
 * @date 2018/10/22 15:28
 *       <p>
 *       修改记录：修改内容 修改人 修改时间
 *       <ul>
 *       <li></li>
 *       </ul>
 *       <p>
 *       Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 *       <p>
 */
@Controller
@RequestMapping("/registerController")
@Api(value = "用户注册接口", description = "用户注册", tags = "API_Register")
public class RegisterController extends BaseController {

	private static final String TAG = RegisterController.class.getSimpleName() + " - 注册控制器";

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	private IRegisterService registerService;

	@RequestMapping(value = "/postRegister", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "根据电话号码去注册", notes = "根据电话号码去注册", httpMethod = "POST", produces = "application/json")
	public ResponseMessage<UserRsp> postRegister(@RequestBody RegisterReq registerReq) throws Exception {
		// 1.前端进行通过openid从数据库获取用户信息，
		// 2.若有则直接登陆，
		// 3.若没有，则跳转登陆页面，点击获取验证码，通过手机tel+验证码进行登陆；
		// 4.如果tel在库中有，后台绑定，设置用户类型：2服务商，SQL输入，如果tel没有，也进行保存这个用户数据，setPerson_type（3）自由群体
		// 5.订单预约时候，通过这个setPerson_type=2条件之一进行判断是否下单
		// 6.注册接口结束
		// 验证码判断
		ResponseMessage<UserRsp> response = new ResponseMessage<>();
		Wxuser wxuser = registerReq.getWxuser();
		String telNum = registerReq.getTelnum();
		String checkCode = registerReq.getCheckCode();
		// 验证电话号码
		if (StringUtils.isEmpty(telNum)) {
			response.setRespCode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			response.setMessage("手机号不能为空");
			logger.error(TAG + " - {}", "手机号不能为空");
			return response;
		}
		// 验证校验码
		if (StringUtils.isEmpty(checkCode)) {
			response.setRespCode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			response.setMessage("请输入验证码");
			logger.error(TAG + " - {}", "请输入验证码");
			return response;
		}
		// 电话号码校验
		if (telNum.length() != 11) {
			response.setRespCode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			response.setMessage("用户手机号格式不正确");
			logger.error(TAG + " - {}", "用户手机号格式不正确");
			return response;
		}
		// 校验缓存中，有没有这个电话的校验码
		Cache cache = CacheManager.getCacheInfo(telNum);
		Boolean isExpired = CacheManager.cacheExpired(cache);
		if (null == cache || isExpired.equals(true)) {
			// 验证成功之后就进行销毁缓存
			CacheManager.clearOnly(telNum);
			response.setRespCode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			response.setMessage("验证码已经过期，请重新获取验证码");
			logger.error(TAG + " - {}", "验证码已经过期，请重新获取验证码");
			return response;
		}
		if (!checkCode.equals(cache.getValue())) {
			response.setRespCode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			response.setMessage("验证码校验不正确");
			logger.error(TAG + " - {}", "验证码校验不正确");
			return response;
		}
		// 验证
		if (StringUtils.isEmpty(wxuser.getOpenid())) {
			response.setRespCode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			response.setMessage("未获取到用户微信openId");
			logger.error(TAG + " - {}", "未获取到用户微信openId");
			return response;
		}
		// 验证成功之后就进行销毁缓存
		CacheManager.clearOnly(telNum);
		response = this.registerService.registerUserByTel(wxuser, telNum);
		logger.info(TAG + " - 微信用户注册成功:wxuser - {}", wxuser.toString());
		logger.info(TAG + " - 微信用户注册成功:response - {}", response.toString());
		return response;
	}

	/**
	 * 通过手机号获得验证码
	 * 
	 * @param tel 用户手机号码
	 * @throws Exception
	 */
	@RequestMapping(value = "/postRegisterSMS/{tel}", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "通过tel获得验证码", notes = "通过tel获得验证码", httpMethod = "POST", produces = "application/json")
	public ResponseMessage<String> postRegisterSMS(@ApiParam(value = "用户手机号码") @PathVariable("tel") String tel)
			throws Exception {
		ResponseMessage<String> response = new ResponseMessage<>();
		// 验证
		if (StringUtils.isEmpty(tel)) {
			response.setRespCode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			response.setMessage("用户tel不能为空!");
			logger.error(TAG + " - {}", "用户tel不能为空!");
			return response;
		}
		// 电话号码校验
		if (tel.length() != 11) {
			response.setRespCode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			response.setMessage("用户tel格式不能为空!");
			logger.error(TAG + " - {}", "用户tel格式不正确!");
			return response;
		}
		String smsRsp = SMSUtil.getRspCodeByTel(tel);
		response.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
		response.setMessage("验证码返回成功");
		response.setData(smsRsp);
		return response;
	}

}
