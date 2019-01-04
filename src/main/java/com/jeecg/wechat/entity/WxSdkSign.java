package com.jeecg.wechat.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 数据对象:微信Config配置
 *
 * @author zhulei
 * @date 2018年8月14日
 */
@ApiModel(value = "微信Config配置")
public class WxSdkSign implements java.io.Serializable {

	@ApiModelProperty(value = "是否调试模式")
	private boolean isdebug_;

	@ApiModelProperty(value = "公众号的唯一标识")
	private String appId_;

	@ApiModelProperty(value = "签名地址")
	private String url_;

	@ApiModelProperty(value = "时间戳")
	private String timestamp_;

	@ApiModelProperty(value = "随机串")
	private String noncestr_;

	@ApiModelProperty(value = "签名")
	private String signature_;

	@ApiModelProperty(value = "Token密钥")
	private String jsapi_ticket_;

	public WxSdkSign() {
	}

	public WxSdkSign(boolean isdebug_, String appId_, String url_, String timestamp_, String noncestr_,
			String signature_, String jsapi_ticket_) {
		this.isdebug_ = isdebug_;
		this.appId_ = appId_;
		this.url_ = url_;
		this.timestamp_ = timestamp_;
		this.noncestr_ = noncestr_;
		this.signature_ = signature_;
		this.jsapi_ticket_ = jsapi_ticket_;
	}

	public boolean isIsdebug_() {
		return isdebug_;
	}

	public void setIsdebug_(boolean isdebug_) {
		this.isdebug_ = isdebug_;
	}

	public String getAppId_() {
		return appId_;
	}

	public void setAppId_(String appId_) {
		this.appId_ = appId_;
	}

	public String getUrl_() {
		return url_;
	}

	public void setUrl_(String url_) {
		this.url_ = url_;
	}

	public String getTimestamp_() {
		return timestamp_;
	}

	public void setTimestamp_(String timestamp_) {
		this.timestamp_ = timestamp_;
	}

	public String getNoncestr_() {
		return noncestr_;
	}

	public void setNoncestr_(String noncestr_) {
		this.noncestr_ = noncestr_;
	}

	public String getSignature_() {
		return signature_;
	}

	public void setSignature_(String signature_) {
		this.signature_ = signature_;
	}

	public String getJsapi_ticket_() {
		return jsapi_ticket_;
	}

	public void setJsapi_ticket_(String jsapi_ticket_) {
		this.jsapi_ticket_ = jsapi_ticket_;
	}

	@Override
	public String toString() {
		return "WxSdkSign{" + "isdebug_=" + isdebug_ + ", appId_='" + appId_ + '\'' + ", url_='" + url_ + '\''
				+ ", timestamp_='" + timestamp_ + '\'' + ", noncestr_='" + noncestr_ + '\'' + ", signature_='"
				+ signature_ + '\'' + ", jsapi_ticket_='" + jsapi_ticket_ + '\'' + '}';
	}
}
