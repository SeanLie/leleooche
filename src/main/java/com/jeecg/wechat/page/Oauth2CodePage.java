package com.jeecg.wechat.page;

/**
 * @author 朱磊
 *
 */
public class Oauth2CodePage {
	private String appId;
	private String appSecret;
	private String code;
	private String grant_type;

	public Oauth2CodePage(String appId, String appSecret, String code) {
		super();
		this.appId = appId;
		this.appSecret = appSecret;
		this.code = code;
	}

	public Oauth2CodePage() {
		super();
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGrant_type() {
		return grant_type;
	}

	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}
}
