package com.jeecg.wechat.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {

//	public static HttpResponse seedGetSqlUrl(String sqlUrl) throws IOException {
//		HttpResquest httpResquest = new HttpResquest();
//		httpResquest.setDefaultContentEncoding("UTF-8");
//		HttpResponse httpResponse = httpResquest.sendGet(sqlUrl);
//
//		return httpResponse;
//	}

	public static HttpResponse seedPostSqlUrl(String sqlUrl) throws IOException {
		HttpResquest httpResquest = new HttpResquest();
		httpResquest.setDefaultContentEncoding("UTF-8");
		HttpResponse httpResponse = httpResquest.sendPost(sqlUrl);

		return httpResponse;
	}

	/**
	 * @Description:使用HttpURLConnection发送get请求
	 * @author:liuyc
	 * @time:2016年5月17日 下午3:27:29
	 */
	public static String sendGet(String urlParam) {
		StringBuffer resultBuffer = null;
//		// 构建请求参数
//		StringBuffer sbParams = new StringBuffer();
//		if (params != null && params.size() > 0) {
//			for (Entry<String, Object> entry : params.entrySet()) {
//				sbParams.append(entry.getKey());
//				sbParams.append("=");
//				sbParams.append(entry.getValue());
//				sbParams.append("&");
//			}
//		}
		HttpURLConnection con = null;
		BufferedReader br = null;
		try {
			URL url = null;
//			if (sbParams != null && sbParams.length() > 0) {
//				url = new URL(urlParam + "?" + sbParams.substring(0, sbParams.length() - 1));
//			} else {
//				url = new URL(urlParam);
//			}
			url = new URL(urlParam);

			con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.connect();
			resultBuffer = new StringBuffer();
			br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String temp;
			while ((temp = br.readLine()) != null) {
				resultBuffer.append(temp);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
					throw new RuntimeException(e);
				} finally {
					if (con != null) {
						con.disconnect();
						con = null;
					}
				}
			}
		}
		return resultBuffer.toString();
	}

	public static String sendPost(String url, String param, String contentType) {
		OutputStreamWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			// out = new PrintWriter(conn.getOutputStream());
			out = new OutputStreamWriter(conn.getOutputStream(), "utf-8"); // 8859_1
			out.write(param); // post的关键所在
			// 发送请求参数
			// out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			int code = conn.getResponseCode();
			if (code == 200) {
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

}
