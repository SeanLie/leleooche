package com.jeecg.wechat.service;

import org.jeecgframework.core.common.service.CommonService;

import com.jeecg.wechat.entity.WxSdkSign;

/**
 * 业务层:微信认证签名接口
 *
 * @author zhulei
 * @date 2018年8月14日
 */
public interface WxSdkSignServiceI extends CommonService {

	public WxSdkSign getJsSdkSignByUrl(String url_) throws Exception;

}
