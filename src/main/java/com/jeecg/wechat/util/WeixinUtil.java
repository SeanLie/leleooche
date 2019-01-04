package com.jeecg.wechat.util;

import com.jeecg.wechat.entity.AccessToken;
import com.jeecg.wechat.entity.Code2Session;
import com.jeecg.wechat.entity.Menu;
import com.jeecg.wechat.entity.OpenAccessToken;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.jeewx.api.core.common.WxstoreUtils;
import org.jeewx.api.core.exception.WexinReqException;
import org.jeewx.api.core.req.WeiXinReqService;
import org.jeewx.api.core.req.model.user.UserInfoListGet;
import org.jeewx.api.coupon.qrcode.model.GetticketRtn;
import org.jeewx.api.wxuser.user.model.Wxuser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WeixinUtil {

	private static Logger logger = LoggerFactory.getLogger(WeixinUtil.class);

	public static String get_code2Session = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
	// 微信网页授权获取CODE
	public static String web_oauth_url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";
	// 基础服务接口 静默授权使用 获取接口access_token的接口地址（GET） 限200（次/天）
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	// 非静默授权 获取网页授权access_token的Url，和基础服务access_token不同，记得区分
	private static String web_oauth_accesstoken_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code";

	// 获取第二步的refresh_token后，请求以下链接获取access_token：
	// 刷新网页授权access_token的Url，和基础服务access_token不同，记得区分
	private static String getRefreshAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
	// 检验授权凭证access_token是否有效,和基础服务access_token不同，记得区分
	private static String checkAccessTokenUrl = "https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID";
	// 微信通过授权码获取微信用户信息auto机制token,从而获取微信用户信息
	private static String get_OauthUserInfo_ByCode_Url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

	// 获取用户基本信息（包括UnionID机制）,普通TOKEN
	private static String GET_USER_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	// 微信网页授权获取用户信息
	public static String web_oauth_userinfo_url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";

	// 创建菜单的方法限100(次/天)
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	// 删除菜单的方法限100(次/天)
	public static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	// 客服接口地址
	public static String send_message_url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";

	// 创建二维码ticket请求
	public static String qrcode_ticket_url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
	// jsapi调用接口临时凭证的接口地址（GET） 限200（次/天）
	public final static String jsapi_ticket_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

	// 通过ticket换取二维码
	public static String get_qrcode_url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
	// 获取微信服务器IP地址
	public static String get_callbackip_url = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";

	/**
	 * 拉微信用户信息接口
	 */
	private static String getUserInfoUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
	/**
	 * 主动推送信息接口
	 */
	private static String sendMsgUrl = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN";

	/**
	 * 下载微信图片地址
	 */
	public static String downMediaUrl = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESSTOKEN&media_id=MEDIAID";

	/**
	 * 下载微信图片地址
	 */
	public static String downMediaFileUrl = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESSTOKEN&media_id=MEDIAID";

	/**
	 * 上传微信图片地址
	 */
	public static String uploadMediaFileUrl = "https://qyapi.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";

	/**
	 * 创建菜单
	 * 
	 * @param menu        菜单实例
	 * @param accessToken 有效的access_token
	 * @return 0表示成功，其他值表示失败
	 */
	public static int createMenu(Menu menu, String accessToken) {
		int result = 0;

		// 拼装创建菜单的url
		String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		System.out.println(jsonMenu);
		// 调用接口创建菜单
		JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);

		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				logger.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
			}
		}

		return result;
	}

	/**
	 * 删除菜单
	 * 
	 * @param menu
	 * @param accessToken
	 * @return
	 */
	public static int deleteMenu(Menu menu, String accessToken) {
		int result = 0;
		String url = menu_delete_url.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = JSONObject.fromObject(menu).toString();
		// 调用接口创建菜单
		JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);

		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				logger.error("删除菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
			}
		}

		return result;
	}

	/**
	 * 获取平常接口access_token，此接口与网页授权access_token不同
	 * 
	 * @param appid     凭证
	 * @param appsecret 密钥
	 * @return
	 */

	public static AccessToken getAccessToken(String appid, String appsecret) {
		AccessToken accessToken = null;

		String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);

		// 如果请求成功
		if (null != jsonObject) {
			try {
				accessToken = new AccessToken();
				accessToken.setToken(jsonObject.getString("access_token"));
				accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
			} catch (Exception e) {
				accessToken = null;
				// 获取token失败
				logger.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
			}
		}
		return accessToken;
	}

	/**
	 * 获取平常接口jsapi_ticket
	 * 
	 * @param accesstoken 调用接口普通accesstoken
	 * @return
	 */

	public static GetticketRtn getJsApiTicketByToken(String accesstoken) {
		// jsapi调用接口临时凭证的接口地址（GET） 限200（次/天）
		// jsapi_ticket_url =
		// "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
		GetticketRtn getticketRtn = null;
		String requestUrl = jsapi_ticket_url.replace("ACCESS_TOKEN", accesstoken);
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		// 如果请求成功
		if (null != jsonObject) {
			try {
				// System.out.println(jsonObject.toString());
				getticketRtn = new GetticketRtn();
				getticketRtn.setTicket(jsonObject.getString("ticket"));
				getticketRtn.setExpires_in(jsonObject.getString("expires_in"));
			} catch (Exception e) {
				getticketRtn = null;
				// 获取token失败
				logger.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
			}
		}
		return getticketRtn;
	}

	/**
	 * 发起https请求并获取结果
	 * 
	 * @param requestUrl    请求地址
	 * @param requestMethod 请求方式（GET、POST）
	 * @param outputStr     提交的数据
	 * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
	 */
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
		logger.info("WeixinUtil.httpRequest 【入口参数】requestUrl= " + requestUrl + ";requestMethod=" + requestMethod
				+ ";outputStr=" + outputStr);
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new X509TrustManagers() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
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
			jsonObject = JSONObject.fromObject(buffer.toString());
			logger.info("WeixinUtil.httpResponse 【出口报文】:" + jsonObject);
		} catch (ConnectException ce) {
			logger.error("Weixin server connection timed out.");
		} catch (Exception e) {
			logger.error("https request error:{}", e);
		}
		return jsonObject;
	}

	// 通过code获取网页授权access_token
	public static OpenAccessToken getOpenAccessToken(String code) {
		OpenAccessToken openAccessToken = null;
		String requestUrl = web_oauth_accesstoken_url.replace("APPID", Constrants.WeChat.APP_ID)
				.replace("APPSECRET", Constrants.WeChat.APP_SECRET).replace("CODE", code);
		// 发起GET请求获取凭证
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			try {
				openAccessToken = new OpenAccessToken();
				openAccessToken.setAccess_token(jsonObject.getString("access_token"));
				openAccessToken.setExpires_in(jsonObject.getString("expires_in"));
				openAccessToken.setRefresh_token(jsonObject.getString("refresh_token"));
				openAccessToken.setOpenid(jsonObject.getString("openid"));
				openAccessToken.setScope(jsonObject.getString("scope"));
				// openAccessToken.setUnionid(jsonObject.getString("unionid"));

			} catch (JSONException e) {
				// openid = null;
				// 获取openid失败
				logger.error("获取openAccessToken失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
						jsonObject.getString("errmsg"));
			}
		}

		// 由于access_token拥有较短的有效期，当access_token超时后，可以使用refresh_token进行刷新，refresh_token有效期为30天，当refresh_token失效之后，需要用户重新授权。
		// 如果access_token失效，那么就需要通过
		// 获取第二步的refresh_token后，请求以下链接获取access_token：
		// https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN

		return openAccessToken;
	}

	// 通过code获取openid
	public static Code2Session getCode2Session(String code) {
		Code2Session code2Session = null;
		// appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
		String requestUrl = get_code2Session.replace("APPID", Constrants.WeChat.XCX_APPID)
				.replace("SECRET", Constrants.WeChat.XCX_APP_SECRET).replace("JSCODE", code);
		// 发起GET请求获取凭证
		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
		logger.info("jsonObject为:" + jsonObject);
		try {
			code2Session = new Code2Session();
			code2Session.setOpenid(jsonObject.getString("openid"));
			code2Session.setSession_key(jsonObject.getString("session_key"));
		} catch (JSONException e) {

			code2Session = new Code2Session();
			code2Session.setErrcode(jsonObject.getInt("errcode"));
			code2Session.setErrMsg(jsonObject.getString("errmsg"));
			logger.error("获取openAccessToken失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
					jsonObject.getString("errmsg"));
		}
		logger.info("code2Session为:" + code2Session.toString());
		return code2Session;
	}

//	// 通过code获取openid
//	public static String getOpenid(String code) {
//
//		String openid = null;
//		String requestUrl = web_oauth_accesstoken_url.replace("APPID", Constrants.WeChat.APP_ID)
//				.replace("APPSECRET", Constrants.WeChat.APP_SECRET).replace("CODE", code);
//		// 发起GET请求获取凭证
//		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
//
//		if (null != jsonObject) {
//			try {
//
//				openid = jsonObject.getString("openid");
//
//			} catch (JSONException e) {
//				openid = null;
//				// 获取openid失败
//				logger.error("获取openid失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
//						jsonObject.getString("errmsg"));
//			}
//		}
//		logger.info("openid为:" + openid);
//		return openid;
//	}

//	// 第二步 通过code换取网页授权access_token
//	public static AccessToken getOauthAccessTokenByCode(String code) {
//		AccessToken auth2toAccess_token = null;
//
//		// 先去数据库或者本地缓存查找这个token，如果有就可以不用进行网页获取，如果没有，就需要进行重新获取
//
//		String requestUrl = web_oauth_accesstoken_url.replace("APPID", Constrants.WeChat.APP_ID)
//				.replace("APPSECRET", Constrants.WeChat.APP_SECRET).replace("CODE", code);
//		// 发起GET请求获取凭证
//		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
//
//		if (null != jsonObject) {
//			try {
//				System.out.println(jsonObject.toString());
//				auth2toAccess_token = new AccessToken();
//				auth2toAccess_token.setToken(jsonObject.getString("access_token"));
//				auth2toAccess_token.setExpiresIn(jsonObject.getInt("expires_in"));
//			} catch (JSONException e) {
//				auth2toAccess_token = null;
//				// 获取token失败
//				logger.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
//						jsonObject.getString("errmsg"));
//			}
//		}
//		logger.info("auth2toAccess_token为:" + auth2toAccess_token);
//		return auth2toAccess_token;
//	}

	// 第三步：通过oauth2token获取相应的用户信息
//	public static Wxuser getOauthUserInfo(String oauth2token) {
//
//		if (oauth2token != null) {
//			String requestUrl = GET_USER_URL.replace("ACCESS_TOKEN", oauth2token);
//			JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST", null);
//			logger.info(result.toString());
//			// 正常返回
//			Wxuser wxuser = null;
//			Object error = result.get("errcode");
//			wxuser = (Wxuser) JSONObject.toBean(result, Wxuser.class);
//			return wxuser;
//		}
//		return null;
//	}

	/**
	 * @desc 推送信息
	 * @param token
	 * @param msg
	 * @return
	 */
	public static JSONObject sendMessage(String token, String msg) {
		try {
			logger.info("sendMessage start.token:" + token + ",msg:" + msg);
			String requestUrl = sendMsgUrl.replace("ACCESS_TOKEN", token);
			JSONObject httpRequest = httpRequest(requestUrl, "POST", null);
			logger.info("return response=====end======");
			return httpRequest;
		} catch (Exception e) {
			logger.error("get send info exception", e);
			return null;
		}
	}

	/**
	 * 
	 * 
	 * sendMsgByOpenId:(根据openId列表群发消息). 消息类型有5种：
	 * 
	 * 1图文(mpnews)；2文本(text)；3语音(voice)；4图片(image)；5视频(mpvideo)。此处messagetype不能传错了，只有五种。
	 * 
	 * messageContent类型:
	 * 
	 * 1，文本类型（key-value ："key"-"value"）;
	 * 
	 * 2,图文,语音，图片类型（key-value ："media_id"-content）;
	 * 
	 * 3，视频类型，必须传三个参数（media_id，title，description）
	 * 
	 * @author HanKeQi
	 * 
	 * @param @return 设定文件
	 * 
	 * @throws String DOM对象
	 * 
	 * @since JDK 1.7
	 * 
	 */

	public static String sendMsgByOpenId(List<String> list, String messagetype, Map<String, Object> messageContent) {
		// 发送内容
		if (null == messagetype || "".equals(messagetype)) {
			return null;
		}

		// 微信群openId
		String jsonCenter = "";

		// 内容
		String jsonCenter2 = "";
		for (String str : list) {
			jsonCenter += "\"" + str + "\",";
		}
		if (jsonCenter.endsWith(",")) {
			jsonCenter = jsonCenter.substring(0, jsonCenter.length() - ",".length());
		}

		Set<Entry<String, Object>> entries = messageContent.entrySet();
		for (Entry<String, Object> entry : entries) {
			jsonCenter2 += "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\",";
		}
		if (jsonCenter2.endsWith(",")) {
			jsonCenter2 = jsonCenter2.substring(0, jsonCenter2.length() - ",".length());
		}

		AccessToken accessToken = getAccessToken(Constrants.WeChat.APP_ID, Constrants.WeChat.APP_SECRET);
		String requestUrl = sendMsgUrl.replace("ACCESS_TOKEN", accessToken.getToken());

		String jsonStr = "{\"touser\":[" + jsonCenter + "],\"" + messagetype + "\":{" + jsonCenter2 + "},\"msgtype\":\""
				+ messagetype + "\"}";

		logger.info("/****************jsonStr=" + jsonStr + "***************************/");

		JSONObject jsonObject = httpRequest(requestUrl, "POST", jsonStr);

		if (0 == jsonObject.getInt("errcode")) {

			return jsonObject.toString();

		}
		logger.error("分组群发消息失败 errcode:{" + jsonObject.getInt("errcode") + "} errmsg:{" + jsonObject.getString("errmsg")
				+ "} ");
		return null;

	}

//	public static JSONObject getUserInfo(String code) {
//		try {
//			OpenAccessToken openAccessToken = WeixinUtil.getOpenAccessToken(code);
//			String openid = openAccessToken.getOpenid();
//			AccessToken accessToken = getAccessToken(Constrants.WeChat.APP_ID, Constrants.WeChat.APP_SECRET);
//			logger.info("getUserInfo start.{token:" + accessToken.getToken() + ",openid:" + openid + "}");
//			String requestUrl = getUserInfoUrl.replace("ACCESS_TOKEN", accessToken.getToken()).replace("OPENID",
//					openid);
//			JSONObject httpRequest = httpRequest(requestUrl, "GET", null);
//			logger.info("httpRequest:" + httpRequest);
//			return httpRequest;
//		} catch (Exception e) {
//			logger.error("get user info exception", e);
//		}
//		return null;
//	}

	// 微信通过网页授权码获取用户信息
	/*
	 * 1、引导用户进入授权页面同意授权，获取code 2、通过code换取网页授权access_token（与基础支持中的access_token不同）
	 * 3、如果需要，开发者可以刷新网页授权access_token，避免过期
	 * 4、通过网页授权access_token和openid获取用户基本信息（支持UnionID机制）
	 */

//	public static OpenAccessToken getOauthUserInfoByCode(String code) {
//		try {
//
//
//			OpenAccessToken openAccessToken = getOpenAccessToken(code);
//			String openid = openAccessToken.getOpenid();
//			String access_token = openAccessToken.getAccess_token();
//
//			// 增加判断openid是否存在
//			if (StringUtils.isEmpty(openid)) {
//				logger.error("微信授权openid不能为空!");
//			}
//			logger.info("openAccessToken start.{openAccessToken:" + openAccessToken.toString() + "}");
//			// token 需要更换
//			// update by 2018-12-21 原先是通过静态授权，但是这个链接要移动到其他公众号上去，需要通过非静态授权（弹出框）来获取微信用户信息
//			// 所以不能用基础接口token,需要用网页授权token
//			// String access_token = WxTools.getAccessToken();
//
//			return openAccessToken;
//		} catch (Exception e) {
//			logger.error("get user info exception", e);
//		}
//		return null;
//	}

	/**
	 * 根据user_openid 获取关注用户的基本信息
	 * 
	 * @param userOpenId
	 * @return
	 * @throws WexinReqException
	 */
	public static Wxuser getWxuser(String accesstoken, String userOpenId) throws WexinReqException {
		if (accesstoken != null) {
			String requestUrl = GET_USER_URL.replace("ACCESS_TOKEN", accesstoken).replace("OPENID", userOpenId);
			JSONObject result = WxstoreUtils.httpRequest(requestUrl, "POST", null);
			logger.info(result.toString());
			// 正常返回
			Wxuser wxuser = null;
			Object error = result.get("errcode");
			wxuser = (Wxuser) JSONObject.toBean(result, Wxuser.class);
			return wxuser;
		}
		return null;
	}

	/**
	 * 根据user_openid 获取关注用户的基本信息
	 * 
	 * @param userOpenId
	 * @return
	 * @throws WexinReqException
	 */
	public static Wxuser getWxuserbyOpenId(String accesstoken, String userOpenId) throws WexinReqException {
		String requestUrl = GET_USER_URL.replace("ACCESS_TOKEN", accesstoken).replace("OPENID", userOpenId);
		JSONObject result = httpRequest(requestUrl, "GET", null);
		logger.info(result.toString());
		// 正常返回
		Wxuser wxuser = null;
		wxuser = (Wxuser) JSONObject.toBean(result, Wxuser.class);

		//
		return wxuser;
	}

	/**
	 * 根据openid token 获取非关注或者关注用户的基本信息
	 *
	 * @param accessToken Token
	 * @param userOpenId userOpenId
	 * @return Wxuser
	 */
	public static Wxuser getWXUserInfoUrl(String accessToken, String userOpenId) {
		String requestUrl = get_OauthUserInfo_ByCode_Url.replace("ACCESS_TOKEN", accessToken).
				replace("OPENID", userOpenId);
		JSONObject result = httpRequest(requestUrl, "GET", null);
		Wxuser wxuser = null;
		if (null != result) {
			try {
				wxuser = new Wxuser();
				wxuser.setOpenid(result.getString("openid"));
				wxuser.setNickname(result.getString("nickname"));
				wxuser.setSex(result.getString("sex"));
				wxuser.setProvince(result.getString("province"));
				wxuser.setCity(result.getString("city"));
				wxuser.setCountry(result.getString("country"));
				wxuser.setHeadimgurl(result.getString("headimgurl"));
				wxuser.setUnionid(result.getString("unionid"));
				wxuser.setLanguage(result.getString("language"));
			} catch (JSONException e) {
				logger.error("获取微信用户信息失败 errcode:{} errmsg:{}", result.getInt("errcode"),
						result.getString("errmsg"));
			}
			logger.info("获取微信用户信息 - wxUser - " + wxuser.toString());
		}
		return wxuser;

	}

	/**
	 * 根据在获取accessToken时返回的refreshToken刷新accessToken
	 * 
	 * @author zhu
	 * @param refreshToken
	 */
	public static OpenAccessToken getRefreshAccessToken(String refreshToken) {
		String requestUrl = getRefreshAccessTokenUrl.replace("REFRESH_TOKEN", refreshToken).replace("APPID",
				Constrants.WeChat.APP_ID);
		JSONObject result = httpRequest(requestUrl, "POST", null);
		return (OpenAccessToken) JSONObject.toBean(result, OpenAccessToken.class);
	}

	/**
	 * 获取所有关注用户信息信息
	 * 
	 * @return
	 * @throws WexinReqException
	 */
	public static List<Wxuser> getAllWxuser(String accesstoken, String next_openid) throws WexinReqException {
		if (accesstoken != null) {
			UserInfoListGet userInfoListGet = new UserInfoListGet();
			userInfoListGet.setAccess_token(accesstoken);
			userInfoListGet.setNext_openid(next_openid);
			JSONObject result = WeiXinReqService.getInstance().doWeinxinReqJson(userInfoListGet);
			Object error = result.get("errcode");
			List<Wxuser> lstUser = null;
			Wxuser mxuser = null;
			int total = result.getInt("total");
			int count = result.getInt("count");
			String strNextOpenId = result.getString("next_openid");
			JSONObject data = result.getJSONObject("data");
			lstUser = new ArrayList<Wxuser>(total);
			if (count > 0) {
				JSONArray lstOpenid = data.getJSONArray("openid");
				int iSize = lstOpenid.size();
				for (int i = 0; i < iSize; i++) {
					String openId = lstOpenid.getString(i);
					mxuser = getWxuser(accesstoken, openId);
					lstUser.add(mxuser);
				}
				if (strNextOpenId != null) {
					lstUser.addAll(getAllWxuser(accesstoken, strNextOpenId));
				}
			}
			return lstUser;
		}
		return null;
	}

//	public static String getOauthCode() {
//		String oauthCode = null;
//		// public static String web_oauth_url =
//		// "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
//
//		String requestUrl = web_oauth_url.replace("APPID", Constrants.WeChat.APP_ID).replace("REDIRECT_URI",
//				Constrants.WeChat.REDIRECT_URI);
//		// 发起GET请求获取凭证
//		JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
//
//		if (null != jsonObject) {
//			try {
//				System.out.println(jsonObject.toString());
//
//				oauthCode = jsonObject.getString("response_type");
//			} catch (JSONException e) {
//
//				// 获取oauthCode失败
//				logger.error("获取oauthCode失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),
//						jsonObject.getString("errmsg"));
//			}
//		}
//		logger.info("oauthCode为:" + oauthCode);
//		return oauthCode;
//	}

}
