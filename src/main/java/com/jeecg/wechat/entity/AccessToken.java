package com.jeecg.wechat.entity;

public class AccessToken {
	// 获取到的凭证  
    private String token;  
    // 凭证有效时间，单位：秒  
    private long expiresIn;  
  
    public String getToken() {  
        return token;  
    }  
  
    public void setToken(String token) {  
        this.token = token;  
    }  
  
    public long getExpiresIn() {  
        return expiresIn;  
    }  
  
    public void setExpiresIn(long expiresIn) {  
        this.expiresIn = expiresIn;  
    }  
}
