package com.jeecg.wechat.util;

import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * Http请求工具类
 *
 * @author 朱朱
 * @date 2018/09/20
 */
public class HttpRequestUtil {

    static String proxyHost = "127.0.0.1";
    static int proxyPort = 8087;

    private static final Logger logger = LoggerFactory.getLogger(HttpRequestUtil.class);

    /**
     * * 编码
     *
     * @param source
     * @return
     */
    public static String urlEncode(String source, String encode) {
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source, encode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "0";
        }
        return result;
    }

    public static String urlEncodeGBK(String source) {
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "0";
        }
        return result;
    }

    /**
     * 发起http请求获取返回结果
     *
     * @param req_url 请求地址
     * @return
     */
    public static String httpRequest(String req_url) {
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL(req_url);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoOutput(false);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();
            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    /**
     * 发送http请求取得返回的输入流
     *
     * @param requestUrl 请求地址
     * @return InputStream
     */
    public static InputStream httpRequestIO(String requestUrl) {
        InputStream inputStream = null;
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();
            // 获得返回的输入流
            inputStream = httpUrlConn.getInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputStream;
    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数，请求参数应该是 name1=value1param&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url     发送请求的 URL
     * @param param   请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param isproxy 是否使用代理模式
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param, boolean isproxy) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            HttpURLConnection connection;
            if (isproxy) {// 使用代理模式
                @SuppressWarnings("static-access")
                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
                connection = (HttpURLConnection) realUrl.openConnection(proxy);
            } else {
                connection = (HttpURLConnection) realUrl.openConnection();
            }
            // 发送POST请求必须设置如下两行
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST"); // POST方法
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.connect();
            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(connection.getOutputStream(), StandardCharsets.UTF_8);
            // 发送请求参数
            out.write(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.error("发送 POST 请求出现异常！" + e.getMessage());
            e.printStackTrace();
        } finally {
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

    /*
     * public static void main(String[] args) { //demo:代理访问 String url =
     * "http://api.adf.ly/api.php"; String para =
     * "key=youkeyid&youuid=uid&advert_type=int&domain=adf.ly&url=http://somewebsite.com";
     *
     * String sr=HttpRequestUtil.sendPost(url,para,true); System.out.println(sr); }
     */

    /**
     * 调用restful接口工具类示例
     *
     * @param restAPI
     * @param tokenHead
     * @return
     * @throws Exception
     */
    public static String addResource(String restAPI, String tokenHead) throws Exception {
        HttpClient httpClient = HttpClientBuilder.create().build();
        // PersonEntity entity = new PersonEntity("NO2", "Joker", "http://");
        // ObjectMapper mapper = new ObjectMapper();
        // String JSON_MULTI = "{'content': '把bean对象转化成JSONObject对象','id':
        // 'gogogosadfsafdasfs','jformOrderCustomer2List': [{'fkId':
        // 'cusididididid','id': 'gogogosadfsafdasfs','money': 200,'name':
        // 'sinan','sex': '1','telphone': '13800188000'}],'jformOrderTicket2List':
        // [{'fckId': '9876','id': 'gogogosadfsafdasfs','tickectDate':
        // '2018-09-12T03:28:29.829Z','ticketCode': '888666888'}],'orderCode':
        // 'thistherestful','orderDate': '2018-09-12T03:28:29.829Z','orderMoney':
        // 1000}";
        // String JSON_MULTI = "{'content': 'afsdfsdafasdfdsfsadffsafd','id':
        // 'gggggosadfsafdasfs','jformOrderCustomer2List': [{'fkId':
        // 'cusididididid','id': 'gggggosadfsafdasfs','money': 200,'name':
        // 'sinan','sex': '1','telphone': '13800188000'}],'jformOrderTicket2List':
        // [{'fckId': '9876','id': 'gggggosadfsafdasfs','tickectDate':
        // '2018-09-12T03:28:29.829Z','ticketCode': '888666888'}],'orderCode':
        // 'thistherestful','orderDate': '2018-09-12T03:28:29.829Z','orderMoney':
        // 1000}";
        String JSON_MULTI = "{\"content\": \"把bean对象转化成JSONObject对象\",\"id\": \"gogogosadfsafdasfs\",\"jformOrderCustomer2List\": [{\"fkId\": \"cusididididid\",\"id\": \"gogogosadfsafdasfs\",\"money\": 200,\"name\": \"sinan\",\"sex\": \"1\",\"telphone\": \"13800188000\"}],\"jformOrderTicket2List\": [{\"fckId\": \"9876\",\"id\": \"gogogosadfsafdasfs\",\"tickectDate\": \"2018-09-12T03:28:29.829Z\",\"ticketCode\": \"888666888\"}],\"orderCode\": \"thistherestful\",\"orderDate\": \"2018-09-12T03:28:29.829Z\",\"orderMoney\": 1000}";

        HttpPost request = new HttpPost(restAPI);
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Accept", "application/json");
        request.setHeader("X-AUTH-TOKEN", tokenHead);
        // StringEntity requestJson = new
        // StringEntity(mapper.writeValueAsString(entity), "utf-8");
        StringEntity requestJson = new StringEntity(JSON_MULTI, "utf-8");
        requestJson.setContentType("application/json");
        request.setEntity(requestJson);
        HttpResponse response = httpClient.execute(request);
        String json = EntityUtils.toString(response.getEntity());
        return json;
    }

    public static String seeRequest() throws Exception {
        String JSON_MULTI = "{'content': 'afsdfsdafasdfdsfsadffsafd','id': 'gggggosadfsafdasfs','jformOrderCustomer2List': [{'fkId': 'cusididididid','id': 'gggggosadfsafdasfs','money': 200,'name': 'sinan','sex': '1','telphone': '13800188000'}],'jformOrderTicket2List': [{'fckId': '9876','id': 'gggggosadfsafdasfs','tickectDate': '2018-09-12T03:28:29.829Z','ticketCode': '888666888'}],'orderCode': 'thistherestful','orderDate': '2018-09-12T03:28:29.829Z','orderMoney': 1000}";

        StringEntity requestJson = new StringEntity(JSON_MULTI, "utf-8");
        requestJson.setContentType("application/json");
        return requestJson.toString();
    }

    public static void getAllResource(String restAPI) throws Exception {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(restAPI);
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(request);
        String json = EntityUtils.toString(response.getEntity());
        System.out.print("getAllResource result is : " + json + "\n");
    }

    public static JSONObject setJsonObject() {
        String JSON_MULTI = "{'content': '把bean对象转化成JSONObject对象','id': 'gogogosadfsafdasfs','jformOrderCustomer2List': [{'fkId': 'cusididididid','id': 'gogogosadfsafdasfs','money': 200,'name': 'sinan','sex': '1','telphone': '13800188000'}],'jformOrderTicket2List': [{'fckId': '9876','id': 'gogogosadfsafdasfs','tickectDate': '2018-09-12T03:28:29.829Z','ticketCode': '888666888'}],'orderCode': 'thistherestful','orderDate': '2018-09-12T03:28:29.829Z','orderMoney': 1000}";
        JSONObject obj = JSONObject.fromObject(JSON_MULTI);

        return obj;
    }

    /**
     * 调用数据库接口方法
     *
     * @param url
     * @param body
     * @return
     * @throws Exception
     */
    public static String seedPostSqlUrl(String url, String body) throws Exception {
        HttpClient httpClient = HttpClientBuilder.create().build();
        // body = "{\"sex\": \"1\",\"unionid\": \"BZKxt1oksNJvzP2JPiRIIt5w4UcM\"}";
        HttpPost request = new HttpPost(url);
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Accept", "application/json");
        // request.setHeader("X-AUTH-TOKEN", "");
        StringEntity requestJson = new StringEntity(body, "utf-8");
        requestJson.setContentType("application/json");
        request.setEntity(requestJson);
        System.out.println(request.toString());
        System.out.println(request);
        HttpResponse response = httpClient.execute(request);
        logger.info("response:" + response.toString());
        String json = EntityUtils.toString(response.getEntity());
        logger.info("json:" + json);
        return json;
    }

    public static void seedPostUrl(String url, String body) throws Exception {
        HttpClient httpClient = HttpClientBuilder.create().build();
        // body = "{\"sex\": \"1\",\"unionid\": \"BZKxt1oksNJvzP2JPiRIIt5w4UcM\"}";
        HttpPost request = new HttpPost(url);
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Accept", "application/json");
        // request.setHeader("X-AUTH-TOKEN", "");
        StringEntity requestJson = new StringEntity(body, "utf-8");
        requestJson.setContentType("application/json");
        request.setEntity(requestJson);
        HttpResponse response = httpClient.execute(request);
        logger.info("response:" + response.toString());
    }

}
