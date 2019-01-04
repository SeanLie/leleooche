/**
 *2018年8月29日
 *RemoteWeixinServiceI.java
 *朱磊
 *
 */
package com.jeecg.wechat.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jeecgframework.core.common.service.CommonService;

import com.jeecg.wechat.page.Oauth2CodePage;
import com.jeecg.wechat.page.TemplateMsgPage;

/**
 * @author 朱磊
 *
 */
public interface RemoteWeixinServiceI extends CommonService {

	/**
	 * 调用微信消息模板
	 * 
	 * @param url
	 * @param pojo
	 * @return
	 */
	public Map<String, Object> callWeixinTemplateMsg(String url, TemplateMsgPage pojo);

	/**
	 * 方法描述: 获取授权信息 作 者： Administrator 日 期： 2015年1月12日-下午11:27:16
	 * 
	 * @param oauth2CodePojo
	 * @return 返回类型： Map<String,Object>
	 */
	public Map<String, Object> getOauth2AccessToken(Oauth2CodePage oauth2CodePage);

	/**
	 * 调用微信author2.0 通用方法
	 * 
	 * @param request   前台请求
	 * @param paramsMap 请求页面带的参数
	 * @param account   微信公众账号信息
	 * @return
	 */
	public String callWeixinAuthor2(HttpServletRequest request, String accountId, String tagetUrl);

	// 获取用户地理位置
	// 高级群发接口
	// 将消息转发到多客服

}
