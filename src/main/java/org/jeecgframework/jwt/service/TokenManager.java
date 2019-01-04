package org.jeecgframework.jwt.service;

import org.jeecgframework.jwt.model.TokenModel;
import org.jeecgframework.web.system.pojo.base.TSUser;

import com.jeecg.wechat.entity.OpenIdTokenModel;

/**
 * 对token进行操作的接口
 *
 * @author ScienJus
 * @date 2015/7/31.
 */
public interface TokenManager {

	/**
	 * 创建一个token关联上指定用户
	 *
	 * @param user 用户信息
	 * @return 生成的token
	 */
	String createToken(TSUser user);

	/**
	 * 检查token是否有效
	 *
	 * @param model token
	 * @return 是否有效
	 */
	boolean checkToken(TokenModel model);

	/**
	 * 根据用户名获取Token
	 *
	 * @param userName 用户名
	 * @return
	 */
	String getTokenByUser(String userName);

	/**
	 * 从字符串中解析token
	 *
	 * @param token  加密后的字符串
	 * @param userId 用户ID
	 * @return
	 */
	TokenModel getToken(String token, String userId);

	/**
	 * 清除token
	 *
	 * @param username 登录用户账号
	 */
	void deleteToken(String username);

	/**
	 * 创建一个token关联上指定用户
	 *
	 * @param user 用户信息
	 * @return 生成的token
	 */
	String createOpenIdToken(String openid);

	/**
	 * 检查token是否有效
	 *
	 * @param model token
	 * @return 是否有效
	 */
	boolean checkOpenIdToken(OpenIdTokenModel model);

	/**
	 * 根据用户名获取Token
	 *
	 * @param openid 用户名
	 * @return
	 */
	String getTokenByOpenId(String openid);

	/**
	 * 从字符串中解析token
	 *
	 * @param token  加密后的字符串
	 * @param openid 用户微信ID
	 * @return
	 */
	OpenIdTokenModel getOpenIdToken(String token, String openid);

	/**
	 * 清除token
	 *
	 * @param OpenId 登录用户openid
	 */
	void deleteOpenIdToken(String openid);

}
