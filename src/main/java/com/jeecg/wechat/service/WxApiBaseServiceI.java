/**
 * 2018年8月27日
 * WxApiServiceI.java
 * 朱磊
 */
package com.jeecg.wechat.service;

import java.io.Serializable;

import org.jeecgframework.core.common.service.CommonService;
import org.jeewx.api.wxuser.user.model.Wxuser;

import com.leletc.user.api.response.UserRsp;

/**
 * @author 朱磊
 *
 */
public interface WxApiBaseServiceI extends CommonService {

	// AccessToken getOauthAccessTokenByCode(String code);

	// String getUserOpenIdByCode(String code);

	Wxuser getOauthUserInfoByCode(String code);

	Serializable save(Wxuser wxuser) throws Exception;

	UserRsp getUserInfoByOpenId(String openId);

}
