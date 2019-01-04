package com.jeecg.wechat.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeixinUtil {

	private static Logger log = LoggerFactory.getLogger(WeixinUtil.class);
	// 获取access_token的接口地址（GET） 限200（次/天）
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	// 创建菜单的方法限100(次/天)
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	// 删除菜单的方法限100(次/天)
	public static String menu_delete_url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
	// 微信通过授权码获取微信用户OpenId
	// private static String web_oauth_accesstoken_url =
	// "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code";
	// 微信网页授权获取网页accesstoken和OPENID
	private static String web_oauth_accesstoken_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code";
	// 获取用户基本信息（包括UnionID机制）
	private static String GET_USER_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	// 微信通过授权码获取微信用户信息
	private static String get_OauthUserInfo_ByCode_Url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
	// 客服接口地址
	public static String send_message_url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
	// 创建二维码ticket请求
	public static String qrcode_ticket_url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
	// 通过ticket换取二维码
	public static String get_qrcode_url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
	// 微信网页授权获取CODE
	// public static String web_oauth_url =
	// "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
	// 微信网页授权获取CODE
	public static String web_oauth_url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";

	// 微信网页授权获取用户信息
	public static String web_oauth_userinfo_url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
	// --update-begin---author:张肖江 ---date:20150321
	// ---for:验证token是否有效------------------------------------------------------------------------
	// 获取微信服务器IP地址
	public static String get_callbackip_url = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";
	// --update-end-----author:张肖江 ---date:20150321
	// ---for:验证token是否有效------------------------------------------------------------------------
	// jsapi调用接口临时凭证的接口地址（GET） 限200（次/天）
	public final static String jsapi_ticket_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

	/**
	 * 拉微信用户信息接口
	 */
	public static String getUserInfoUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
	/**
	 * 主动推送信息接口
	 */
	public static String sendMsgUrl = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN";

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

}
