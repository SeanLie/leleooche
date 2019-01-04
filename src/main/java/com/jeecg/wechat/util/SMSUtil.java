package com.jeecg.wechat.util;

import com.leletc.base.api.request.SMSReq;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * 功能描述：手机短信工具类
 * <p>
 *
 * @author 朱磊
 * <p>
 * @date 2018/11/12 11:23
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public class SMSUtil {

    private static final Logger logger = LoggerFactory.getLogger(SMSUtil.class);

    /**
     * 获取短信验证码
     *
     * @param tel 手机号
     * @return Message
     */
    public static String getRspCodeByTel(String tel) {
        String msg = "短信验证码已发送成功";
        Cache cacheInfo = CacheManager.getCacheInfo(tel);
        if (!CacheManager.cacheExpired(cacheInfo)) {
            if (null != cacheInfo) {
                if (null != cacheInfo.getValue() && StringUtils.isNotBlank(cacheInfo.getValue().toString())) {
                    return msg;
                }
            }
        }
        SMSReq smsReq = setSMSCodeReq(tel);
        if (!sendSms(tel, smsReq)) msg = "短信验证码发送失败";
        return msg;
//		} else if (rspcode.equals("-1")) {
//			msg = "参数不全（某参数为空或参数数据类型不正确）";
//		} else if (rspcode.equals("-2")) {
//			msg = "用户名或密码验证错误";
//		} else if (rspcode.equals("-3")) {
//			msg = "发送短信余额不足（账户中必须有存款大于1条）";
//		} else if (rspcode.equals("-4")) {
//			msg = "没有手机号码或手机号码超过100个";
//		} else if (rspcode.equals("-5")) {
//			msg = "发送手机里含有错误号码";
//		} else if (rspcode.equals("-6")) {
//			msg = "内容超长";
//		} else if (rspcode.equals("-7")) {
//			msg = "短信中含有非法字符或非法词汇（内容含被过滤的关键字）";
//		} else if (rspcode.equals("-8")) {
//			msg = "未开放HTTP接口";
//		} else if (rspcode.equals("-9")) {
//			msg = "IP地址认证失败";
//		} else if (rspcode.equals("-10")) {
//			msg = "发送时间限制";
//		} else if (rspcode.equals("-11")) {
//			msg = "短信类别ID不存在或不正确";
//		} else if (rspcode.equals("-12")) {
//			msg = "提交的短信条数不正确";
//		}
    }

    public static String sendSMSContent(String tel, String content) {
        String msg = "信息发送成功！Tel = " + tel + ", Content = " + content;
        SMSReq smsReq = setSMSContentReq(tel, content);
        if (sendSms(tel, smsReq)) return null;
        return msg;
    }

	/*private static SMSReq postSmsReq(String tel) {
		SMSReq req = new SMSReq();
		String smsCode = generateSmsCode();
		req.setZh(SMSConfig.smsusername);
		req.setMm(SMSConfig.smspassword);
		req.setHm(tel);
		req.setNr("尊敬的用户：" + tel + "，您的注册验证码为：" + smsCode + "，当前验证码有效时间2分钟。【乐乐科技】");
		req.setDxlbid("124");
		logger.info("[注册-获得验证码] - Tel:" + tel + ",code:" + smsCode);
		// 把这个电话号码存入缓存，等会登陆成功之后在去掉缓存，同时设置时间
		Cache cache = new Cache();
		cache.setKey(tel);
		cache.setValue("9999");
		// 系统当前的毫秒数,120秒之后，验证码失效
		long nowDt = System.currentTimeMillis();
		long isExpiredTime = 120 * 1000 + nowDt;
		cache.setTimeOut(isExpiredTime);
		CacheManager.putCache(tel, cache);
		return req;
	}*/

    private static SMSReq setSMSCodeReq(String tel) {
        SMSReq req = new SMSReq();
        String smsCode = generateSmsCode();
        req.setZh(SMSConfig.smsusername);
        req.setMm(SMSConfig.smspassword);
        req.setHm(tel);
        req.setNr("验证码：" + smsCode + "，有效时间2分钟【乐乐科技】");
        req.setDxlbid("124");
        // 把这个电话号码存入缓存，等会登陆成功之后在去掉缓存，同时设置时间
        Cache cache = new Cache();
        cache.setKey(tel);
        cache.setValue(smsCode);
        // 系统当前的毫秒数
        long nowDt = System.currentTimeMillis();
        long isExpiredTime = 120 * 1000 + nowDt;
        cache.setTimeOut(isExpiredTime);
        CacheManager.putCache(tel, cache);
        return req;
    }

    private static SMSReq setSMSContentReq(String tel, String content) {
        SMSReq req = new SMSReq();
        req.setZh(SMSConfig.smsusername);
        req.setMm(SMSConfig.smspassword);
        req.setHm(tel);
        req.setNr(content);
        req.setDxlbid("124");
        return req;
    }

    /**
     * 发送
     *
     * @param tel
     * @param smsReq
     * @return
     */
    private static boolean sendSms(String tel, SMSReq smsReq) {
        String param = SMSConfig.smsurlParm.replace("SMSUSERNAME", smsReq.getZh())
                .replace("SMSPASWORLD", smsReq.getMm())
                .replace("TEL", tel)
                .replace("CONTENT", smsReq.getNr())
                .replace("DXLBID", smsReq.getDxlbid())
                .replace("EXTNO", "");
        String rspMsg = HttpRequestUtil.sendPost(SMSConfig.smsurl, param, false);
        String rspCode = rspMsg.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                + "<string xmlns=\"http://tempuri.org/\">", "").replace("</string>", "");
        logger.info("-------------发送验证码------------");
        logger.info("------  Tel = " + tel + "  ------");
        logger.info("Content = " + smsReq.getNr());
        logger.info("---------------------------------");
        if (StringUtils.isBlank(rspCode) || !rspCode.equals("0")) {
            return false;
        }
        return true;
    }

    private static String generateSmsCode() {
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if (randLength < 4) {
            for (int i = 1; i <= 4 - randLength; i++)
                fourRandom = "0" + fourRandom;
        }
        return fourRandom;
    }

}
