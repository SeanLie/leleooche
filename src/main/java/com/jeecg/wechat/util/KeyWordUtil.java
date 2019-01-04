package com.jeecg.wechat.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeecg.wechat.page.KeyWordPage;
import com.jeecg.wechat.service.IKeyWordAppServiceI;

public class KeyWordUtil {
	private static Logger log=LoggerFactory.getLogger(KeyWordUtil.class.getName());
	private static String warmmingInfo="深航君身体不适;系统正在维护,请联系管理员进行反馈";
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
	private static SimpleDateFormat sdfDate=new SimpleDateFormat("yyyyMMdd");
	private static SimpleDateFormat YYYYMMDDHHMM=new SimpleDateFormat("yyyy-MM-ddHHmm");
	private static SimpleDateFormat toYYYYMMDDHHMM=new SimpleDateFormat("MM月dd日HH时mm分");
	
	
	//public static String  keyToMsg(String content, HttpServletRequest request, String fromUserName, List<Object> keyPops, IKeyWordApp keyWordAppImpl, IWaybillApp waybillAppImpl) {
	public static String  keyToMsg(String content, HttpServletRequest request, String fromUserName, List<Object> keyPops, IKeyWordAppServiceI keyWordAppImpl) {
	
		String respContent = "";
		//判断输入是否为帮助
		if ("?".equals(content) || "?".equals(content)) {
			keyPops.clear();
			keyPops.add("?");
			request.getSession().getServletContext().setAttribute(fromUserName, keyPops); 
			respContent = "您好，请回复以下数字选择需要查询的内容：\r\n" + "1、航班动态\r\n" + "2、运单查询\r\n" + "3、客户服务热线 \r\n";
			return respContent;
		}
		//关键字队列是否存放关键字
		if (keyPops.size() == 0) {
			respContent = getWarmmingInfo(keyWordAppImpl);
			return respContent;
		}
		//关键字队列最后一个关键字是否为运单查询和航班查询
		String key = (String)keyPops.get(keyPops.size() - 1);
		/*
		//查询运单
		if ("YDQRY".equals(key)) {
			return getWayBillDto(content, waybillAppImpl);
		}
		//查询航班
		if ("HBHQRY".equals(key)) {
			return getFlightInquiriesDto(content, waybillAppImpl,keyWordAppImpl);
		} 
		*/
		//关键字队列最后一个关键字是否为帮助
		if("?".equals(key) || "?".equals(key)) {
			List<String> keys=Arrays.asList("1","2","3");
			if(keys.contains(content)) {
				if(!"3".equals(content)) {
					keyPops.add(content);
				}
				List<KeyWordPage> keyWords = keyWordAppImpl.getKeyWords(Arrays.asList(content));
				if(keyWords.size()>0) {
					respContent=keyWords.get(0).getfShow();
			/*		return "<a href=\"https://open.weixin.qq.com/connect/oauth2/authorize?"
					+ "appid=wxac41f5298de784da&redirect_uri=http://ppf8080.d1.natapp.cc/freight-cargo-wechat-web/sys/login/flyNo/flyNo.do"
					+ "&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect\">测试登录认证</a>";*/
						//snsapi_userinfo snsapi_login
					
				}
				else {
					respContent=warmmingInfo;
				}
				return respContent;
			}else {
				respContent = getWarmmingInfo(keyWordAppImpl);
				return respContent;
			}
		}
		if(keyPops.size()>1) {
			String keyNext =(String) keyPops.get(keyPops.size() - 2);
			/*
			if("?".equals(keyNext) || "?".equals(keyNext)) {
				//航班查询
				if("1".equals(key)) {
					return getFlightInquiriesDto(content, waybillAppImpl,keyWordAppImpl);
				}
				//运单查询
				if("2".equals(key)) {
					return getWayBillDto(content, waybillAppImpl);
				}
				return getWarmmingInfo(keyWordAppImpl);
			}*/
		}

		return getWarmmingInfo(keyWordAppImpl);
	}
	
	/**
	 * 查询警告信息
	 * @param keyWordAppImpl
	 * @return
	 */
	public static String getKeyInfo(IKeyWordAppServiceI keyWordAppImpl,String key) {
		String respContent;
		List<KeyWordPage> keyWords = keyWordAppImpl.getKeyWords(Arrays.asList(key));
		if(keyWords.size()>0) {
			respContent=keyWords.get(0).getfShow();
		}else {
			respContent=warmmingInfo;
		}
		return respContent;
	}
	/**
	 * 查询警告信息
	 * @param keyWordAppImpl
	 * @return
	 */
	private static String getWarmmingInfo(IKeyWordAppServiceI keyWordAppImpl) {
		String respContent;
		List<KeyWordPage> keyWords = keyWordAppImpl.getKeyWords(Arrays.asList("100"));
		if(keyWords.size()>0) {
			respContent=keyWords.get(0).getfShow();
		}else {
			respContent=warmmingInfo;
		}
		return respContent;
	}
	

	public static String dateStrFormat(String dateStr) {
		Date date;
		try {
			date = YYYYMMDDHHMM.parse(dateStr);
		} catch (ParseException e) {
			log.info("时间格式转换异常："+dateStr+"to yyyy-MM-ddHHmm");
			return "-";
		}
		return toYYYYMMDDHHMM.format(date);
	}
}
