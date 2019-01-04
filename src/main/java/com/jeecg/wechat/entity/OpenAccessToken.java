package com.jeecg.wechat.entity;

public class OpenAccessToken {

	/**
	 * @param access_token
	 * @param expires_in
	 * @param refresh_token
	 * @param openid
	 * @param scope
	 * @param unionid
	 */
	public OpenAccessToken(String access_token, String expires_in, String refresh_token, String openid, String scope,
			String unionid) {
		super();
		this.access_token = access_token;
		this.expires_in = expires_in;
		this.refresh_token = refresh_token;
		this.openid = openid;
		this.scope = scope;
		this.unionid = unionid;
	}

	public OpenAccessToken() {
	}

	/**
	 * getOpenIdUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?
	 * appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code";
	 * 
	 * access_token 接口调用凭证 expires_in access_token接口调用凭证超时时间，单位（秒） refresh_token
	 * 用户刷新access_token openid 授权用户唯一标识 scope 用户授权的作用域，使用逗号（,）分隔
	 */
	private String access_token;
	private String expires_in;
	private String refresh_token;
	private String openid;
	private String scope;
	private String unionid;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	/**
	 * @return the unionid
	 */
	public String getUnionid() {
		return unionid;
	}

	/**
	 * @param unionid the unionid to set
	 */
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OpenAccessToken [access_token=" + access_token + ", expires_in=" + expires_in + ", refresh_token="
				+ refresh_token + ", openid=" + openid + ", scope=" + scope + ", unionid=" + unionid + "]";
	}

}
