package com.jeecg.wechat.service.impl;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.wechat.entity.WxSdkSign;
import com.jeecg.wechat.service.WxSdkSignServiceI;
import com.jeecg.wechat.util.Constrants;
import com.jeecg.wechat.util.SignUtil;
import com.jeecg.wechat.util.WxTools;

/**
 * 业务层:微信认证签名接口实现类
 * 
 * @author zhulei 2018年8月14日
 */
@Service
@Transactional
public class WxSdkSignServiceImpl extends CommonServiceImpl implements WxSdkSignServiceI {

	private static Logger logger = Logger.getLogger(WxSdkSignServiceImpl.class);

	@Override
	public WxSdkSign getJsSdkSignByUrl(String url) throws Exception {
		String noncestr = SignUtil.create_nonce_str();
		String timestamp = SignUtil.create_timestamp();
		// 获取access_token, 因为一般有效期是7200s；
		// 所以添加到了缓存中中，默认先从缓存中获取，失效后再发送GET请求获取；
		String access_token = WxTools.getAccessToken();
		String jsapi_ticket = WxTools.getTicketByToken(access_token);
		// String jsapi_ticket = SignUtil.getWeiXinTicket();
		// 注意这里参数名必须全部小写，且必须有序
		String sdkList = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url="
				+ url;
		String signature = SignUtil.getWeiXinSignNature(sdkList);

		WxSdkSign sdkConfigSign = new WxSdkSign();
//		logger.info("获取jsapi_ticket=" + jsapi_ticket);
//		logger.info("获取signature=" + signature);
//		logger.info("获取sdkConfigSign=" + sdkConfigSign);
		// if (sdkConfigSign == null) {
		sdkConfigSign.setAppId_(Constrants.WeChat.APP_ID);
		sdkConfigSign.setIsdebug_(true);
		sdkConfigSign.setUrl_(url);
		sdkConfigSign.setTimestamp_(timestamp);
		sdkConfigSign.setNoncestr_(noncestr);
		sdkConfigSign.setSignature_(signature);
		sdkConfigSign.setJsapi_ticket_(jsapi_ticket);
		// }
		logger.info("开始获取sdkConfigSign=" + sdkConfigSign.toString());
		return sdkConfigSign;
	}
}
