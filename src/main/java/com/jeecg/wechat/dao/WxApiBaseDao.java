//package com.jeecg.wechat.dao;
//
//import javax.transaction.SystemException;
//
//import org.jeewx.api.core.common.JSONHelper;
//
//import com.jeecg.wechat.entity.WxUserInfo;
//import com.jeecg.wechat.util.WxTools;
//
///**
// * @author 朱磊
// *
// */
//public class WxApiBaseDao {
//
//	public WxUserInfo getWxUserInfo(String access_token) throws SystemException {
//		WxUserInfo wxUserInfo = null;
//		String auserInfoUrl = String.format(WxTools.auserInfoUrl, WxTools.wxapi, access_token);
//
//		String userJson = WxTools.sendGet(auserInfoUrl);
//		// 把JSON转换成Bean格式
//		// WxUser WxUser = WxTools.getJsonToBean(userJson);
//		String errcode = WxTools.getJsonToKey(userJson, "errcode");
//		if (errcode != null) {
//			logger.error("获取微信用户信息失败:" + errcode);
//		}
//		wxUserInfo = JSONHelper.fromJsonToObject(userJson, WxUserInfo.class);
//
//		return wxUserInfo;
//
//	}
//
//	public String getCodeToken(String code_) {
//		String accessUrl = String.format(WxTools.accessUrl, WxTools.wxapi, WxTools.wxSecret, code_);
//
//		String json = WxTools.sendGet(accessUrl);
//
//		String access_token = WxTools.getJsonToKey(json, "access_token");
//
//		return access_token;
//	}
//
//}
