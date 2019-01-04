package com.jeecg.wechat.api.base.media;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

import org.jeewx.api.core.common.WxstoreUtils;
import org.jeewx.api.core.exception.WexinReqException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeecg.wechat.api.util.DloadImgUtil;
import com.jeecg.wechat.api.util.WeixinUtil;
import com.jeecg.wechat.dbtable.AutoBaseFile;
import com.jeecg.wechat.entity.WxUpload;

import net.sf.json.JSONObject;

public class MediaAPI {

	private static final Logger logger = LoggerFactory.getLogger(MediaAPI.class);

	/**
	 * 上传媒体文件
	 * 
	 * @param accessToken  接口访问凭证
	 * @param type         媒体文件类型，分别有图片（image）、语音（voice）、视频（video），普通文件(file)
	 * @param media        form-data中媒体文件标识，有filename、filelength、content-type等信息
	 * @param mediaFileUrl 媒体文件的url 上传的媒体文件限制 图片（image）:1MB，支持JPG格式
	 *                     语音（voice）：2MB，播放长度不超过60s，支持AMR格式 视频（video）：10MB，支持MP4格式
	 *                     普通文件（file）：10MB
	 */
	public static WxUpload uploadMedia(String accessToken, String type, String mediaFileUrl) {
		WxUpload wxUpload = null;

		String uploadMediaUrl = WeixinUtil.uploadMediaFileUrl.replace("ACCESS_TOKEN", accessToken).replace("TYPE",
				type);
		// 定义数据分隔符
		String boundary = "------------7da2e536604c8";
		try {
			URL uploadUrl = new URL(uploadMediaUrl);
			HttpURLConnection uploadConn = (HttpURLConnection) uploadUrl.openConnection();
			uploadConn.setDoOutput(true);
			uploadConn.setDoInput(true);
			uploadConn.setRequestMethod("POST");
			// 设置请求头Content-Type
			uploadConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			// 获取媒体文件上传的输出流（往微信服务器写数据）
			OutputStream outputStream = uploadConn.getOutputStream();

			URL mediaUrl = new URL(mediaFileUrl);
			HttpURLConnection meidaConn = (HttpURLConnection) mediaUrl.openConnection();
			meidaConn.setDoOutput(true);
			meidaConn.setRequestMethod("GET");
			// 从请求头中获取内容类型
			String contentType = meidaConn.getHeaderField("Content-Type");
			// 根据内容类型判断文件扩展名
			String fileExt = DloadImgUtil.getFileexpandedName(contentType);
			// 请求体开始
			outputStream.write(("--" + boundary + "\r\n").getBytes());
			outputStream.write(
					String.format("Content-Disposition: form-data; name=\"media\"; filename=\"file1%s\"\r\n", fileExt)
							.getBytes());
			outputStream.write(String.format("Content-Type: %s\r\n\r\n", contentType).getBytes());

			// 获取媒体文件的输入流（读取文件）
			BufferedInputStream bis = new BufferedInputStream(meidaConn.getInputStream());
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = bis.read(buf)) != -1) {
				// 将媒体文件写到输出流（往微信服务器写数据）
				outputStream.write(buf, 0, size);
			}
			// 请求体结束
			outputStream.write(("\r\n--" + boundary + "--\r\n").getBytes());
			outputStream.close();
			bis.close();
			meidaConn.disconnect();

			// 获取媒体文件上传的输入流（从微信服务器读数据）
			InputStream inputStream = uploadConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			StringBuffer buffer = new StringBuffer();
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			uploadConn.disconnect();

			// 使用JSON-lib解析返回结果
			JSONObject jsonObject = JSONObject.fromObject(buffer.toString());

			wxUpload = new WxUpload();
			wxUpload.setType(jsonObject.getString("type"));
			// type等于 缩略图（thumb） 时的返回结果和其它类型不一样
			if ("thumb".equals(type))
				wxUpload.setMedia_id(jsonObject.getString("thumb_media_id"));
			else
				wxUpload.setMedia_id(jsonObject.getString("media_id"));

			wxUpload.setCreated_at(Integer.toString(jsonObject.getInt("created_at")));
		} catch (Exception e) {
			wxUpload = null;
			String error = String.format("上传媒体文件失败：%s", e);
			System.out.println(error);
		}
		return wxUpload;
	}

	/**
	 * 图片下载
	 * 
	 * @param accessToken
	 * @param mediaId
	 */
	public static JSONObject downMedia(String access_token, String media_id) throws Exception {

		String requestUrl = WeixinUtil.downMediaUrl.replace("ACCESSTOKEN", access_token).replace("MEDIAID", media_id);

		JSONObject result = WxstoreUtils.httpRequest(requestUrl, "GET", null);

		if (result.has("errcode") && result.get("errcode") != "0") {
			logger.error("删除消息失败！errcode=" + result.getString("errcode") + ",errmsg = " + result.getString("errmsg"));
			throw new WexinReqException(
					"删除消息失败！errcode=" + result.getString("errcode") + ",errmsg = " + result.getString("errmsg"));
		}
		return result;
	}

	/**
	 * 获取媒体文件
	 * 
	 * @param accessToken 接口访问凭证
	 * @param mediaId     媒体文件id
	 * @param savePath    文件在本地服务器上的存储路径
	 */
	public static AutoBaseFile downloadMedia(String accessToken, String mediaId, String savePath) {
		String filePath;
		AutoBaseFile autoBaseFile = new AutoBaseFile();
		// 拼接请求地址
		String requestUrl = WeixinUtil.downMediaFileUrl.replace("ACCESSTOKEN", accessToken).replace("MEDIAID", mediaId);

		// 拼装获取素材的url
//		com.alibaba.fastjson.JSONObject jsonObject = HttpUtil.sendGet(requestUrl);
//		logger.info("[CREATEMENU]", "sendMessage response:{}", new Object[] { jsonObject.toJSONString() });
//		logger.info("jsonObject:" + jsonObject.toJSONString());
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setRequestMethod("GET");

			if (!savePath.endsWith("/")) {
				savePath += "/";
			}
			// 根据内容类型获取扩展名

			logger.info("Content-Type:" + conn.getHeaderField("Content-Type"));
			String fileExt = DloadImgUtil.getFileexpandedName(conn.getHeaderField("Content-Type"));
			// 将mediaId作为文件名
			filePath = savePath + mediaId + fileExt;
			logger.info("filePath:" + filePath);

			File file = new File(savePath);
			if (!file.exists()) {
				file.mkdirs();// 创建文件根目录
			}

			BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = bis.read(buf)) != -1)
				fos.write(buf, 0, size);
			fos.close();
			bis.close();

			conn.disconnect();

			// 插入数据库

			// TSUser currentUser = ResourceUtil.getSessionUser();
			// logger.info("currentUser:" + currentUser.toString());
			autoBaseFile.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			// autoBaseFile.setUserId(currentUser.getId() + "");
			autoBaseFile.setOrgfile_name(mediaId);
			autoBaseFile.setFile_name(mediaId + fileExt);
			autoBaseFile.setFile_savePath(filePath);
			autoBaseFile.setIsValid("1");
			autoBaseFile.setCreate_date(new Date());
			// autoBaseFile.setCreate_name(currentUser.getRealName());
			autoBaseFile.setMsg("上传成功且数据库保存成功");

			String info = String.format("下载媒体文件成功，filePath=" + filePath);
			logger.info(info);
		} catch (Exception e) {
			filePath = null;
			String error = String.format("下载媒体文件失败：%s", e);
			logger.error(error);
		}

		return autoBaseFile;
	}
}
