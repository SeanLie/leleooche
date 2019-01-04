package com.jeecg.wechat.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.UUID;

import org.jeecgframework.web.system.service.CacheServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SignUtil {
	private static final Logger logger = LoggerFactory.getLogger(SignUtil.class);

	@Autowired
	private static CacheServiceI cacheService;
//	@Autowired
//	private static StringRedisTemplate redisTemplate;

	// private static RedisService redisService = new RedisService();

	/*
	 * // 微信js签名token private static String get_sign_token_Url =
	 * "https://api.weixin.qq.com/cgi-bin/token"; // 微信js签名ticket private static
	 * String get_sign_ticket_Url =
	 * "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
	 */
	/**
	 * 验证签名
	 * 
	 * @param token     微信服务器token，在env.properties文件中配置的和在开发者中心配置的必须一致
	 * @param signature 微信服务器传过来sha1加密的证书签名
	 * @param timestamp 时间戳
	 * @param nonce     随机数
	 * @return
	 */
	public static boolean checkSignature(String token, String signature, String timestamp, String nonce) {
		String[] arr = new String[] { token, timestamp, nonce };
		// 将token、timestamp、nonce三个参数进行字典序排序
		Arrays.sort(arr);

		// 将三个参数字符串拼接成一个字符串进行sha1加密

		String tmpStr = "";// SHA1.encode(arr[0] + arr[1] + arr[2]);

		// 将sha1加密后的字符串可与signature对比，标识该请求来源于微信
		// return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
		return true;
	}

//	public String httpget(String url, String param) throws Exception {
//		PrintWriter out = null;
//		BufferedReader in = null;
//		String result = "";
//		try {
//			URL realUrl = new URL(url);
//			// 打开和URL之间的连接
//			URLConnection conn = realUrl.openConnection();
//			// 设置通用的请求属性
//			conn.setRequestProperty("accept", "*/*");
//			conn.setRequestProperty("connection", "Keep-Alive");
//			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//			// 发送POST请求必须设置如下两行
//			conn.setDoOutput(true);
//			conn.setDoInput(true);
//			// 获取URLConnection对象对应的输出流
//			out = new PrintWriter(conn.getOutputStream());
//			// 发送请求参数
//			out.print(param);
//			// flush输出流的缓冲
//			out.flush();
//			// 定义BufferedReader输入流来读取URL的响应
//			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			String line;
//			while ((line = in.readLine()) != null) {
//				result += line;
//			}
//		} catch (Exception e) {
//			System.out.println("发送 POST 请求出现异常！" + e);
//			e.printStackTrace();
//		}
//		// 使用finally块来关闭输出流、输入流
//		finally {
//			try {
//				if (out != null) {
//					out.close();
//				}
//				if (in != null) {
//					in.close();
//				}
//			} catch (IOException ex) {
//				ex.printStackTrace();
//			}
//		}
//		return result;
//	}
//
//	public String sendGet(String url, String param) throws Exception {
//		String result = "";
//		BufferedReader in = null;
//		try {
//			String urlNameString = url + "?" + param;
//			URL realUrl = new URL(urlNameString);
//			logger.info("realUrl=" + realUrl);
//			// 打开和URL之间的连接
//			URLConnection connection = realUrl.openConnection();
//			// 设置通用的请求属性
//			connection.setRequestProperty("accept", "*/*");
//			connection.setRequestProperty("connection", "Keep-Alive");
//			// 建立实际的连接
//			connection.connect();
//			// 获取所有响应头字段
//			Map<String, List<String>> map = connection.getHeaderFields();
//			// 遍历所有的响应头字段
//
//			for (String key : map.keySet()) {
//				System.out.println("key:" + key + "--->" + map.get(key));
//			}
//			// 定义 BufferedReader输入流来读取URL的响应
//			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//			String line;
//			while ((line = in.readLine()) != null) {
//				result += line;
//			}
//
//		} catch (Exception e) {
//			System.out.println("发送GET请求出现异常！" + e);
//			e.printStackTrace();
//		}
//		// 使用finally块来关闭输入流
//		finally {
//			try {
//				if (in != null) {
//					in.close();
//				}
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		return result;
//	}

	// 获取随机字符串

	public static String create_nonce_str() throws Exception {
		return UUID.randomUUID().toString();
	}

	public static String create_timestamp() throws Exception {
		return Long.toString(System.currentTimeMillis() / 1000);
	}

	/**
	 * 用SHA1算法生成安全签名
	 *
	 * @param token     票据
	 * @param timestamp 时间戳
	 * @param nonce     随机字符串
	 * @return 安全签名
	 * @throws NoSuchAlgorithmException
	 */
	public String getSHA1(String token, String timestamp, String nonce) throws NoSuchAlgorithmException {
		String[] array = new String[] { token, timestamp, nonce };
		StringBuffer sb = new StringBuffer();
		// 字符串排序
		Arrays.sort(array);
		for (int i = 0; i < 3; i++) {
			sb.append(array[i]);
		}
		String str = sb.toString();
		// SHA1签名生成
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(str.getBytes());
		byte[] digest = md.digest();

		StringBuffer hexstr = new StringBuffer();
		String shaHex = "";
		for (int i = 0; i < digest.length; i++) {
			shaHex = Integer.toHexString(digest[i] & 0xFF);
			if (shaHex.length() < 2) {
				hexstr.append(0);
			}
			hexstr.append(shaHex);
		}
		return hexstr.toString();
	}

//	@SuppressWarnings("unused")
//	public static String getWeiXinTicket() throws Exception {
//		String access_token = WxTools.getAccessTokenOrTicket();
//		String ticket = "";
//		Object apiticket = null;
//		// 取出缓存
//		// 先从缓存数据中获取access_token, 因为一般有效期是7200s；
////		Object act = null;// cacheService.get(CacheServiceI.WEIXIN_SYSTEM_BASE,
////							// CacheConfig.WEIXIN_BASE_ACCESS_TOKEN);
////
////		Object apiticket = null;
////		if (null == act) {
////			AccessToken accessToken = WeixinUtil.getAccessToken(Constrants.WeChat.APP_ID, Constrants.WeChat.APP_SECRET);
////			access_token = accessToken.getToken();
////			long expiresIn = accessToken.getExpiresIn();
////
////			if (access_token == null) {
////				return null;
////			}
//////			redisTemplate.boundValueOps("WEIXIN_BASE_ACCESS_TOKEN").set(access_token, JwtConstants.TOKEN_EXPIRESIN_HOUR,
//////					TimeUnit.HOURS);
////			// 所以添加到了缓存中中，默认先从缓存中获取，失效后再发送GET请求获取；
////			// String WEIXIN_BASE_ACCESS_TOKEN = "WEIXIN_BASE_ACCESS_TOKEN";
////			// redisService.set(WEIXIN_BASE_ACCESS_TOKEN, access_token, expiresIn - 1200);
////			// cacheService.put(CacheServiceI.WEIXIN_SYSTEM_BASE,
////			// CacheConfig.WEIXIN_BASE_ACCESS_TOKEN, access_token);
////
//////			Object WEIXIN_TOKEN = cacheService.get(CacheServiceI.WEIXIN_SYSTEM_BASE,
//////					CacheConfig.WEIXIN_BASE_ACCESS_TOKEN);
//////			System.out.println("WEIXIN_TOKEN:" + WEIXIN_TOKEN);
////			// redisTemplate.boundValueOps("WEIXIN_BASE_ACCESS_TOKEN").get();
////			// String WEIXIN_TOKEN = redisService.get(WEIXIN_BASE_ACCESS_TOKEN);
////			// System.out.println("WEIXIN_TOKEN:" + WEIXIN_TOKEN);
////		} else {
////			access_token = (String) act;
////		}
//		logger.info("=================================================");
//		if (null == apiticket) {
//
//			GetticketRtn getticketRtn = WeixinUtil.getJsApiTicketByToken(access_token);
//
//			ticket = getticketRtn.getTicket();
//
//		} else {
//			ticket = (String) apiticket;
//		}
//
//		return ticket;
//	}

	public static String byteToHex(byte[] hash) throws Exception {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	public static String getWeiXinSignNature(String sdkList) throws Exception {
		String signature = null;
		logger.info("获取sdkList=" + sdkList);
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(sdkList.getBytes("UTF-8"));

			signature = SignUtil.byteToHex(crypt.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return signature;
	}

}
