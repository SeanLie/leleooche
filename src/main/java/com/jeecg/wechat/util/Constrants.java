package com.jeecg.wechat.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constrants {
	private static Logger log = LoggerFactory.getLogger(Constrants.class);
	private static final Properties pop = new Properties();

	static {
		InputStream resourceAsStream = Constrants.class.getClassLoader().getResourceAsStream("wechat.properties");

		try {
			pop.load(resourceAsStream);
			// log.info("加载静态资源为:" + pop);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("加载静态资源失败，无法找到wechat.properties文件", e);
		}
	}

	public static class WeChat {
		public static String APP_ID = pop.getProperty("wechat.appId");
		public static String APP_SECRET = pop.getProperty("wechat.appSecret");
		public static String APP_TOKEN = pop.getProperty("wechat.token");
		public static String XCX_APPID = pop.getProperty("wechat.xcx.appId");
		public static String XCX_APP_SECRET = pop.getProperty("wechat.xcx.appSecret");
//		public static String JS_DOMIN = pop.getProperty("wechat.jsDomin");
//		public static String WEB_DOMIN = pop.getProperty("wechat.webDomin");
		// public static String REDIRECT_URI = pop.getProperty("wechat.redirect_uri");

	}
}
