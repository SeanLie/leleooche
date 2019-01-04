package com.jeecg.wechat.Model;

/**
 * Token的Model类，可以增加字段提高安全性，例如时间戳、url签名
 * @author ScienJus
 * @date 2015/7/31.
 */
public class TokenOpenIdModel {

    //用户id
    private String openid;

    //随机生成的uuid
    private String token;

    public TokenOpenIdModel(String openid, String token) {
        this.openid = openid;
        this.token = token;
    }

    public String getopenid() {
		return openid;
	}

	public void setopenid(String openid) {
		this.openid = openid;
	}

	public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
