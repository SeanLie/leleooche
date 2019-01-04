package org.jeecgframework.test.demo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.jeecgframework.jwt.util.JwtHttpUtil;

import com.alibaba.fastjson.JSONObject;

public class OocheWxApiTest {

	public static void main(String[] args) {

		// 接口角色授权的用户账号密码

		// String key = "26F72780372E84B6CFAED6F7B19139CC47B1912B6CAED753";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", "40281381537e969401537eb9902d0006");
		String body = jsonObject.toJSONString();
		Map param = new HashMap();
		param.put("body", body);

		// String sign = SignatureUtil.sign(param, key);
		String token = getToken("interfaceuser", "interfaceuser123");
		//sign=22E60FB6957DDF3CEC2DF16C5FF8082C
		System.out.println(token);

		// curl -X POST --header 'Content-Type: application/json'
		// --header 'Accept: application/json'
		// --header
		// 'X-AUTH-TOKEN: 22E60FB6957DDF3CEC2DF16C5FF8082C'
		// 'http://localhost:8080/jeecg/rest/api/interTestController/40281381537e969401537eb9902d0006'

		/*JSONObject resp = OocheWxApiTest.httpRequest("http://localhost:8080/jeecg/rest/interTestController",
				// JSONObject resp =
				// OocheWxApiTest.httpRequest("http://localhost:8080/jeecg/rest/cgFormDataController/add",
				"POST", "body=" + body, token);*/
		//System.out.println(resp.toJSONString());

		/*
		 * String AccessToken=JwTokenAPI.getAccessToken(appid, appscret); String
		 * WxIp=JwServiceIpAPI.getServiceIpList(accessToke); String useMsg=JwUserAPI.
		 */

		// 获取code接口地址为:
		// https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect

		// 获取用户信息
		// https://api.weixin.qq.com/sns/userinfo?access_token={0}&openid={1}&lang=zh_CN

		// 获取全局access_token接口地址为：
		// https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET

		// 获取用户OpenID接口地址
		// https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN

	}

	// 获取token
	public static String getToken(String userName, String password) {
		String url = "http://localhost:8080/jeecg/rest/tokens?username=" + userName + "&password=" + password;
		String token = JwtHttpUtil.httpRequest(url, "POST", null);
		return token;
	}

	// 获取code tOKEN 信息
	public static JSONObject getCodeToken(String token, String code) {
		String url = "http://localhost:8080/jeecg/rest/wxConfigController/wxLogin/" + code;
		JSONObject resp = JwtHttpUtil.httpRequest(url, "GET", null, token);
		return resp;
	}

	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl    请求地址
	 * @param requestMethod 请求方式（GET、POST）
	 * @param outputStr     提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr, String sign) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		HttpURLConnection httpUrlConn = null;
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			URL url = new URL(requestUrl);
			httpUrlConn = (HttpURLConnection) url.openConnection();
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			httpUrlConn.setRequestProperty("X-JEECG-SIGN", sign);
//	       httpUrlConn.setRequestProperty("content-type", "text/html");
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);
			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.parseObject(buffer.toString());
			// jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			org.jeecgframework.core.util.LogUtil.info("Weixin server connection timed out.");
		} catch (Exception e) {
			// e.printStackTrace();
			org.jeecgframework.core.util.LogUtil.info("https request error:{}" + e.getMessage());
		} finally {
			try {
				httpUrlConn.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
				org.jeecgframework.core.util.LogUtil.info("http close error:{}" + e.getMessage());
			}
		}
		return jsonObject;
	}

}
