/**
 *2018年8月27日
 *WxTools.java
 *朱磊
 *
 */
package com.jeecg.wechat.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jeecgframework.web.system.service.CacheServiceI;
import org.jeewx.api.coupon.qrcode.model.GetticketRtn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.jeecg.wechat.entity.AccessToken;

/**
 * @author 朱磊
 *
 */
public class WxTools {

	private static final Logger logger = LoggerFactory.getLogger(WxTools.class);

	public static String accessUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

	public static String auserInfoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&&lang=zh_CN";

	public static String wxapi = "wxb3c62b26f2d93948";

	public static String wxSecret = "07e2fd71ed57fecc95dae539b2aee7d8";

	@Autowired
	private static CacheServiceI cacheService;

	/*
	 * String类型转json形式，之后获取某一个key值
	 */
	public static String getJsonToKey(String jsonStr, String key) {

		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		// 获取到key为access_token的值
		String strJsonObj = jsonObject.getString(key);
		return strJsonObj;
	}

	public static String httpget(String uri) {
		HttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(uri);
		HttpResponse response;
		try {
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			String content = EntityUtils.toString(entity, "utf-8");

			return content;
		} catch (Exception e) {
			logger.error("get请求异常2：" + e);
		}
		return "error";
	}

	public static String sendGet(String url) {
		String result = "";
		BufferedReader in = null;
		try {

			URL realUrl = new URL(url);

			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段

			for (String key : map.keySet()) {
				System.out.println("key:" + key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}

		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	public static String getAccessTokenOrTicket() {
		String access_token = null;
		AccessToken accessToken = new AccessToken();
		// 取出缓存
		// 先从缓存数据中获取access_token, 因为一般有效期是7200s
		Cache cache = new Cache();
		cache = CacheManager.getCacheInfo(CacheConfig.WEIXIN_ACCESS_TOKEN);
		// Object act = cache.getValue();
		// 通过这个cache 去获取相应时间是否过期，如果返回false说明需要重新获取
		Boolean isExpired = CacheManager.cacheExpired(cache);
		if (null == cache || isExpired.equals(false)) {
			accessToken = WeixinUtil.getAccessToken(Constrants.WeChat.APP_ID, Constrants.WeChat.APP_SECRET);
			access_token = accessToken.getToken();
			// long expiresIn = accessToken.getExpiresIn();
			cache = new Cache();
			cache.setKey(CacheConfig.WEIXIN_BASE_ACCESS_TOKEN);
			cache.setValue(access_token);
			cache.setTimeOut(7000);
			CacheManager.putCache(CacheConfig.WEIXIN_ACCESS_TOKEN, cache);
		} else {
			Object act = cache.getValue();
			access_token = (String) act;
		}

		return access_token;
	}

	public static String getAccessToken() {
		String access_token = null;
		// 取出缓存
		// 先从缓存数据中获取access_token, 因为一般有效期是7200s
		Cache cache = new Cache();
		cache = CacheManager.getCacheInfo(CacheConfig.WEIXIN_ACCESS_TOKEN);
		// Object act = cache.getValue();
		// 通过这个cache 去获取相应时间是否过期，如果返回true说明需要重新获取
		Boolean isExpired = CacheManager.cacheExpired(cache);
		if (null == cache || isExpired.equals(true)) {
			AccessToken accessToken = WeixinUtil.getAccessToken(Constrants.WeChat.APP_ID, Constrants.WeChat.APP_SECRET);
			access_token = accessToken.getToken();
			// long expiresIn = accessToken.getExpiresIn();
			cache = new Cache();
			cache.setKey(CacheConfig.WEIXIN_BASE_ACCESS_TOKEN);
			cache.setValue(access_token);
			long nowDt = System.currentTimeMillis(); // 系统当前的毫秒数
			long isExpiredTime = 7000 * 1000 + nowDt;
			cache.setTimeOut(isExpiredTime);
			CacheManager.putCache(CacheConfig.WEIXIN_ACCESS_TOKEN, cache);
		} else {
			Object act = cache.getValue();
			access_token = (String) act;
		}

		return access_token;
	}

	public static String getTicketByToken(String access_token) {
		String ticket = null;
		// 取出缓存
		// 先从缓存数据中获取ticket, 因为一般有效期是7200s
		Cache cache = new Cache();
		cache = CacheManager.getCacheInfo(CacheConfig.WEIXIN_ACCESS_TICKET);
		// Object act = cache.getValue();
		// 通过这个cache 去获取相应时间是否过期，如果返回true说明需要重新获取
		Boolean isExpired = CacheManager.cacheExpired(cache);
		if (null == cache || isExpired.equals(true)) {
			GetticketRtn getticketRtn = WeixinUtil.getJsApiTicketByToken(access_token);
			ticket = getticketRtn.getTicket();
			cache = new Cache();
			cache.setKey(CacheConfig.WEIXIN_BASE_JSAPI_TICKET);
			cache.setValue(ticket);
			long nowDt = System.currentTimeMillis(); // 系统当前的毫秒数
			long isExpiredTime = 7000 * 1000 + nowDt;
			cache.setTimeOut(isExpiredTime);
			CacheManager.putCache(CacheConfig.WEIXIN_ACCESS_TICKET, cache);
		} else {
			Object act = cache.getValue();
			ticket = (String) act;
		}

		return ticket;
	}

	public static String getWxInfoByCode(String code) {
		String access_token = null;
		AccessToken accessToken = new AccessToken();
		// 取出缓存
		// 先从缓存数据中获取access_token, 因为一般有效期是7200s
		Cache cache = new Cache();
		cache = CacheManager.getCacheInfo(CacheConfig.WEIXIN_ACCESS_CODE);
		// Object act = cache.getValue();
		// 通过这个cache 去获取相应时间是否过期，如果返回false说明需要重新获取
		Boolean isExpired = CacheManager.cacheExpired(cache);
		if (null == cache || isExpired.equals(false)) {
			accessToken = WeixinUtil.getAccessToken(Constrants.WeChat.APP_ID, Constrants.WeChat.APP_SECRET);
			access_token = accessToken.getToken();
			// long expiresIn = accessToken.getExpiresIn();
			cache = new Cache();
			cache.setKey(CacheConfig.WEIXIN_BASE_ACCESS_TOKEN);
			cache.setValue(access_token);
			cache.setTimeOut(7000);
			CacheManager.putCache(CacheConfig.WEIXIN_ACCESS_TOKEN, cache);
		} else {
			Object act = cache.getValue();
			access_token = (String) act;
		}

		return access_token;
	}

}
