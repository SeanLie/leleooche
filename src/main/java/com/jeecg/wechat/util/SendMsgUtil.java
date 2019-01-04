package com.jeecg.wechat.util;

import java.util.Date;

import com.jeecg.wechat.entity.AccessToken;
import com.jeecg.wechat.entity.MessageUtil;
import com.jeecg.wechat.entity.TextMessage;

import net.sf.json.JSONObject;

public class SendMsgUtil {
   /* public static void main(String[] args) {  
        // 第三方用户唯一凭证  
        String appId = "wxac41f5298de784da";  
        // 第三方用户唯一凭证密钥  
        String appSecret = "63634cb7a3a3b0b5113d44607a1b3da8";  
  
        // 调用接口获取access_token  
        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);  
        WeixinUtil.getOpen
 	
        JSONObject sendMessage =MessageUtil.getUserInfo(at.getToken(),); 
        System.out.println("sendMessage==>"+sendMessage);
  
    } */
    
    public static void main1(String[] args) {  
        // 第三方用户唯一凭证  
        String appId = "wxac41f5298de784da";  
        // 第三方用户唯一凭证密钥  
        String appSecret = "63634cb7a3a3b0b5113d44607a1b3da8";  
  
        // 调用接口获取access_token  
        AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);  
 	   TextMessage textMessage = new TextMessage(); 
 	   textMessage.setToUserName("<![CDATA[oxSKO0zxitreDFLgh2ZGSzxXM6xs]]>"); 
 	   
 	   textMessage.setFromUserName("<![CDATA[gh_4aa8d06df19b]]>"); 
 	   textMessage.setCreateTime(new Date().getTime()); 
 	   textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT); 
 	   textMessage.setFuncFlag(0); 
 	   textMessage.setContent("==>测试数据");

 	   String msg="{\r\n" + 
 	   		"   \"touser\":[\r\n" + 
 	   		"    \"OPENID1\",\r\n" + 
 	   		"    \"OPENID2\"\r\n" + 
 	   		"   ],\r\n" + 
 	   		"   \"mpnews\":{\r\n" + 
 	   		"      \"media_id\":\"123dsdajkasd231jhksad\"\r\n" + 
 	   		"   },\r\n" + 
 	   		"    \"msgtype\":\"mpnews\"\r\n" + 
 	   		"}";
 	   String respMessage = MessageUtil.textMessageToXml(textMessage); 
        JSONObject sendMessage = WeixinUtil.sendMessage(at.getToken(), respMessage);  
        System.out.println("sendMessage==>"+sendMessage);
  
    } 
}
