
package com.jeecg.wechat.controller;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeecg.wechat.entity.AccessToken;
import com.jeecg.wechat.service.WxApiBaseServiceI;
import com.jeecg.wechat.util.Constrants;
import com.jeecg.wechat.util.WeixinUtil;
import com.leletc.user.api.response.UserRsp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author 朱磊
 */
@Controller
@RequestMapping("/wxApiBaseController")
@Api(value = "微信基础信息", description = "微信基础信息接口", tags = "API_WxApiBase")
public class WxApiBaseController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(WxApiBaseController.class);

	@Autowired
	private WxApiBaseServiceI wxApiBaseService;

	/**
	 * 功能描述：拉取用户信息(需scope为 snsapi_userinfo)
	 * 
	 * @param code
	 */
	@ApiOperation(value = "OAuth2.0鉴权获取用户信息", notes = "code换取网页授权用户信息", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getOauthUserInfoByCode/{code}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseMessage<Wxuser> getOauthUserInfoByCode(
			@ApiParam(value = "网页授权code") @PathVariable("code") String code, HttpServletRequest request)
			throws Exception {
		ResponseMessage<Wxuser> response = new ResponseMessage<>();
		logger.debug("【request报文】微信网页授权code:" + code);
		// 验证
		if (StringUtils.isEmpty(code)) {
			logger.error("微信授权code不能为空!");
			response.setMessage("微信授权code不能为空!");
			response.setRespCode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			return response;
		}
		Wxuser wxUserInfo = wxApiBaseService.getOauthUserInfoByCode(code);
		logger.debug("【response报文】wxUserInfo:" + wxUserInfo.toString());
		response.setData(wxUserInfo);
		response.setMessage("返回成功");
		response.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
		return response;
	}

	@ApiOperation(value = "通过微信Openid获取用户信息", notes = "通过微信Openid获取用户信息", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getUserInfoByOpenId/{openId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseMessage<UserRsp> getUserInfoByOpenId(
			@ApiParam(value = "微信OpenId") @PathVariable("openId") String openId, HttpServletRequest request)
			throws Exception {
		ResponseMessage<UserRsp> response = new ResponseMessage<>();
		// 验证
		if (StringUtils.isEmpty(openId)) {
			logger.error("微信openId不能为空!");
			response.setMessage("微信openId不能为空!");
			response.setRespCode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			return response;
		}
		UserRsp user = null;
		try {
			user = wxApiBaseService.getUserInfoByOpenId(openId);
			response.setMessage("返回成功");
			response.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
		} catch (Exception e) {
			response.setMessage("该用户不存在！");
			response.setRespCode(ResponseMessageCodeEnum.NULL_ERROR.getCode());
		}
		response.setData(user);
		return response;
	}

//	@ApiOperation(value = "通过微信Openid获取微信用户信息", notes = "通过微信Openid获取微信信息", httpMethod = "GET", produces = "application/json")
//	// @RequestMapping(value = "/getWxUserInfoByOpenId/{openId}", method =
//	// RequestMethod.GET)
//	@ResponseBody
//	public ResponseMessage<Wxuser> getWxUserInfoByOpenId(
//			@ApiParam(value = "微信OpenId") @PathVariable("openId") String openId, HttpServletRequest request)
//			throws Exception {
//		ResponseMessage<Wxuser> response = new ResponseMessage<>();
//		// 验证
//		if (StringUtils.isEmpty(openId)) {
//			logger.error("微信openId不能为空!");
//			response.setMessage("微信openId不能为空!");
//			response.setRespCode(ResponseMessageCodeEnum.ERROR.getCode());
//			return response;
//		}
//		String access_token = WxTools.getAccessToken();
//		// 通过网页授权access_token和openid获取用户基本信息（支持UnionID机制）
////		String requestUrl = GET_USER_URL.replace("ACCESS_TOKEN", access_token).replace("OPENID", openid);
////		JSONObject httpRequest = httpRequest(requestUrl, "GET", null);
////		log.info("httpRequest:" + httpRequest);\
//
//		Wxuser wxuser = WeixinUtil.getWxuserbyOpenId(access_token, openId);
//		String id = "is" + wxuser.getOpenid();
//		if (id.equals("isnull")) {
//			response.setData(wxuser);
//			response.setMessage("返回成功");
//			response.setRespCode(ResponseMessageCodeEnum.ERROR.getCode());
//			return response;
//		} else {
//			response.setData(wxuser);
//			response.setMessage("返回成功");
//			response.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
//			return response;
//		}
//	}

//	// 第二步，通过code换取网页授权access_token
//	@ApiOperation(value = "OAuth2.0鉴权", notes = "code换取网页授权access_token", httpMethod = "GET", produces = "application/json")
//	@RequestMapping(value = "/getOauthAccessTokenByCode/{code}", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseMessage<AccessToken> getOauthAccessTokenByCode(
//			@ApiParam(value = "weixin授权码") @PathVariable("code") String code, HttpServletRequest request)
//			throws Exception {
//		ResponseMessage<AccessToken> response = new ResponseMessage<>();
//		// 验证
//		if (StringUtils.isEmpty(code)) {
//			logger.error("微信Code不能为空!");
//			response.setMessage("微信授权code不能为空!");
//			response.setRespCode(ResponseMessageCodeEnum.ERROR.getCode());
//			return response;
//		}
//		AccessToken auth2toAccess_token = wxApiBaseService.getOauthAccessTokenByCode(code);
//		response.setData(auth2toAccess_token);
//		response.setMessage("返回成功");
//		response.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
//		return response;
//
//	}

	// 第五步：拉取用户OpenId(需scope为 snsapi_userinfo)
//	@ApiOperation(value = "OAuth2.0鉴权获取用户信息openid", notes = "code换取网页授权用户信息openid", httpMethod = "GET", produces = "application/json")
//	@RequestMapping(value = "/getUserOpenIdByCode/{code}", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseMessage<String> getUserOpenIdByCode(@ApiParam(value = "网页授权code") @PathVariable("code") String code,
//			HttpServletRequest request) throws Exception {
//		ResponseMessage<String> response = new ResponseMessage<>();
//		// 验证
//		if (StringUtils.isEmpty(code)) {
//			logger.error("微信授权code不能为空!");
//			response.setMessage("微信授权code不能为空!");
//			response.setRespCode(ResponseMessageCodeEnum.ERROR.getCode());
//			return response;
//		}
//		String UserOpenId = wxApiBaseService.getUserOpenIdByCode(code);
//		response.setData(UserOpenId);
//		response.setMessage("返回成功");
//		response.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
//		return response;
////		ajaxJson.setObj(UserOpenId);
////
////		return Result.success(ajaxJson);
//	}

//	// 第三步：拉取用户信息(需scope为 snsapi_userinfo)
//	@ApiOperation(value = "OAuth2.0鉴权获取用户信息", notes = "token换取网页授权用户信息", httpMethod = "GET", produces = "application/json")
//	@RequestMapping(value = "/getOauthUserInfoByToken/{oauth2token}", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseMessage<?> getOauthUserInfoByToken(
//			@ApiParam(value = "网页授权OauthToken") @PathVariable("oauth2token") String oauth2token,
//			HttpServletRequest request) throws Exception {
//
//		// 获取token
//		AjaxJson ajaxJson = new AjaxJson();
//		// 验证
//		if (StringUtils.isEmpty(oauth2token)) {
//			logger.error("微信授权oauth2token不能为空!");
//		}
//		Assert.notNull(oauth2token, "oauth2token can not be empty");
//
//		Wxuser wxUserInfo = wxApiBaseService.getOauthUserInfo(oauth2token);
//
//		ajaxJson.setObj(wxUserInfo);
//
//		return Result.success(ajaxJson);
//	}

//	@ApiOperation(value = "微信授权登录", notes = "微信授权登录", httpMethod = "POST", produces = "application/json")
//	@RequestMapping(value = "/wxLogin/{code}", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseMessage<?> wxlogin(@ApiParam(value = "weixin授权码") @PathVariable("code") String code,
//			HttpServletRequest request) throws Exception {
//
//		/*
//		 * InterfaceRuleDto interfaceRuleDto =
//		 * InterfaceUtil.getInterfaceRuleDto(request, InterfaceEnum.blacklist_list); if
//		 * (interfaceRuleDto == null) { return Result.error("您没有该接口的权限！"); }
//		 */
//
//		AjaxJson ajaxJson = new AjaxJson();
//		// 验证
//		if (StringUtils.isEmpty(code)) {
//			logger.error("微信Code不能为空!");
//		}
//		Assert.notNull(code, "code_ can not be empty");
//
//		WxUserInfo wxUserInfo = wxApiBaseService.wxLogin(code);
//
//		ajaxJson.setObj(wxUserInfo);
//		return Result.success(ajaxJson);
//	}

//	@ApiOperation(value = "销毁TOKEN")
//	@RequestMapping(value = "/{openid}", method = RequestMethod.DELETE)
//	@ResponseBody
//	public ResponseMessage<?> logout(
//			@ApiParam(name = "openid", value = "微信公众号ID", required = true) @PathVariable("openid") String openid) {
//		logger.info("deleteToken[{}]", openid);
//		// 验证
//		if (StringUtils.isEmpty(openid)) {
//			return Result.error("微信ID账号，不能为空!");
//		}
//		try {
//			RedisTokenUtil.deleteToken(openid);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return Result.error("销毁TOKEN失败");
//		}
//		return Result.success();
//	}

	// 第二步，获取普通access_token
	@ApiOperation(value = "微信普通接口Token", notes = "微信普通接口Token", httpMethod = "GET", produces = "application/json")
	@RequestMapping(value = "/getWeChatAccessToken", method = RequestMethod.GET)
	@ResponseBody
	public ResponseMessage<AccessToken> getWeChatAccessToken(HttpServletRequest request) throws Exception {
		ResponseMessage<AccessToken> responseMessage = new ResponseMessage<>();
		AccessToken weChatInterfaceAccess_token = WeixinUtil.getAccessToken(Constrants.WeChat.APP_ID,
				Constrants.WeChat.APP_SECRET);
		responseMessage.setData(weChatInterfaceAccess_token);
		responseMessage.setMessage("返回成功");
		responseMessage.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
		return responseMessage;
	}

//	// 第四步：拉取用户信息(需scope为 snsapi_userinfo)
//	@ApiOperation(value = "OAuth2.0鉴权获取用户信息", notes = "code换取网页授权用户信息", httpMethod = "GET", produces = "application/json")
//	@RequestMapping(value = "/ceshi/", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseMessage<?> ceshi(HttpServletRequest request) throws Exception {
//
//		// 获取token
//		AjaxJson ajaxJson = new AjaxJson();
//
//		Wxuser w_x_user = new Wxuser();
//		// w_x_user.setSex("1");
//		w_x_user.setNickname("刘勤");
//		w_x_user.setUnionid("BZKxt1oksNJvzP2JPiRIIt5w4UcM");
//		w_x_user.setProvince("广东");
//		w_x_user.setOpenid("BCwBj0QB5z-aI6yhAfvgMW65lACE");
//		// w_x_user.setLanguage("zh_CN");
//		// w_x_user.setCountry("中国");
//		// w_x_user.setCity("深圳");
//		logger.debug("开始插入");
//
//		/*
//		 * JSONObject jsonObject = JSONObject.fromObject(w_x_user); String json =
//		 * jsonObject.toString(); logger.info("json" + json);
//		 */
//
//		// String k = WxUserDaoExe.find_wxUser_OpenId(w_x_user.getOpenid());
//
//		TsUserDaoExe.getSaveUserInfo(w_x_user);
//
//		logger.debug("插入结束");
//
//		// ajaxJson.setObj(wxuser);
//
//		return Result.success(ajaxJson);
//	}
}