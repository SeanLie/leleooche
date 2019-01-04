package com.jeecg.wechat.controller;

import com.jeecg.wechat.api.base.media.MediaAPI;
import com.jeecg.wechat.dao.AutoBaseFileDao;
import com.jeecg.wechat.dbtable.AutoBaseFile;
import com.jeecg.wechat.util.WxTools;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.util.FileUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.menu.ResponseMessageCodeEnum;
import org.jeewx.api.wxbase.wxmedia.model.WxUpdateArticle;
import org.jeewx.api.wxsendmsg.model.WxArticle;
import org.jeewx.api.wxsendmsg.model.WxArticlesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 文件处理控制器
 */
@Controller
@RequestMapping("/fileDealController")
@Api(value = "文件处理控制器", description = "文件处理服务", tags = "API_FileDeal")
public class FileDealController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(FileDealController.class);

	@Autowired
	private AutoBaseFileDao autoBaseFileDao;
	/**
	 * 
	 * @param accessToke
	 * @param type         媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
	 * @param fileNamePath 上传的文件目录
	 * @return
	 * @throws WexinReqException
	 */
//	@RequestMapping(value = "/doMediaUp", method = RequestMethod.POST)
//	@ResponseBody
//	@ApiOperation(value = "文件上传处理", notes = "文件上传处理", httpMethod = "POST", produces = "application/json")
//	public ResponseMessage<WxUpload> uploadMedia(@ApiParam(value = "媒体文件ID") @PathVariable("type") String type,
//			@ApiParam(value = "媒体文件路径") @PathVariable("fileNamePath") String fileNamePath, HttpServletRequest request)
//			throws Exception {
//		// AjaxJson ajaxJson = new AjaxJson();
//		ResponseMessage<WxUpload> responseMessage = new ResponseMessage<>();
//		String accessToken = WxTools.getAccessToken();
//		WxUpload wxUpload = JwMediaAPI.uploadMedia(accessToken, type, fileNamePath);
//		responseMessage.setData(wxUpload);
//		responseMessage.setMessage("返回成功");
//		responseMessage.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
//		return responseMessage;
//
//	}

	/**
	 * 下载多媒体
	 * 
	 * @param accessToke
	 * @param media_id
	 * @param filePath
	 * @return
	 * @throws WexinReqException
	 */
	// @RequestMapping(value = "/downMedia/{media_id}/{filePath}", method =
	// RequestMethod.POST)
	// @ResponseBody
	// @ApiOperation(value = "文件下载处理", notes = "文件下载处理", httpMethod = "POST",
	// produces = "application/json")
	// public ResponseMessage<WxDwonload> downMedia(@ApiParam(value = "媒体文件ID")
	// @PathVariable("media_id") String media_id,
	// @ApiParam(value = "媒体文件路径") @PathVariable("filePath") String filePath,
	// HttpServletRequest request)
	// throws Exception {
	// // AjaxJson ajaxJson = new AjaxJson();
	// ResponseMessage<WxDwonload> responseMessage = new ResponseMessage<>();
	// String token = WxTools.getAccessToken();
	// WxDwonload wxDwonload = JwMediaAPI.downMedia(token, media_id, filePath);
	// responseMessage.setData(wxDwonload);
	// responseMessage.setMessage("返回成功");
	// responseMessage.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
	// return responseMessage;
	//
	// }

	/**
	 * WebUploader 文件上传处理
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/doMediaUp", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "文件上传处理", notes = "文件上传处理", httpMethod = "POST", produces = "application/json")
	public ResponseMessage<WxArticlesResponse> doMediaUp(@RequestBody List<WxArticle> wxArticles,
			HttpServletRequest request) throws Exception {
		// AjaxJson ajaxJson = new AjaxJson();
		ResponseMessage<WxArticlesResponse> responseMessage = new ResponseMessage<>();
		String token = WxTools.getAccessToken();
		WxArticlesResponse wxArticlesResponse = JwMediaAPI.uploadArticlesByMaterialNews(token, wxArticles);
		responseMessage.setData(wxArticlesResponse);
		responseMessage.setMessage("返回成功");
		responseMessage.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
		return responseMessage;

	}

	/**
	 * WebUploader 文件下载处理
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/doMediaDown/{media_id}", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "文件下载处理", notes = "文件下载处理", httpMethod = "POST", produces = "application/json")
	public ResponseMessage<AutoBaseFile> doMediaDown(
			@ApiParam(value = "媒体文件ID") @PathVariable("media_id") String media_id, HttpServletRequest request)
			throws Exception {
		// AjaxJson ajaxJson = new AjaxJson();
		ResponseMessage<AutoBaseFile> responseMessage = new ResponseMessage<>();
		String token = WxTools.getAccessToken();
		// String savePath = "D:\\upFiles";

		String ctxPath = ResourceUtil.getConfigByName("webUploadpath") + "//parkImage";
		// 根据业务名称判断上传路径
		// String bizPath = StoreUploadFilePathEnum.getPath("Image");
		String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String savePath = ctxPath + File.separator + File.separator + currentDate;
		logger.info("savePath:" + savePath);
		AutoBaseFile autoBaseFile = MediaAPI.downloadMedia(token, media_id, savePath);

		logger.info("autoBaseFile:" + autoBaseFile);
		this.autoBaseFileDao.insert(autoBaseFile);

		responseMessage.setData(autoBaseFile);
		responseMessage.setMessage("返回成功");
		responseMessage.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
		return responseMessage;

	}

	/**
	 * WebUploader 文件删除处理
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/doMediaDelete/{media_id}", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "文件删除处理", notes = "文件删除处理", httpMethod = "POST", produces = "application/json")
	public ResponseMessage<?> doMediaDelete(@ApiParam(value = "媒体文件ID") @PathVariable("media_id") String media_id,
			HttpServletRequest request) throws Exception {
		// AjaxJson ajaxJson = new AjaxJson();
		ResponseMessage<?> responseMessage = new ResponseMessage<>();
		String token = WxTools.getAccessToken();
		JwMediaAPI.deleteArticlesByMaterial(token, media_id);
		responseMessage.setMessage("返回成功");
		responseMessage.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
		return responseMessage;

	}

	/**
	 * WebUploader 文件修改处理
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/doMediaUpdate", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "文件修改处理", notes = "文件修改处理", httpMethod = "POST", produces = "application/json")
	public ResponseMessage<?> doMediaUpdate(@ApiParam(value = "媒体文件ID") String media_id,
			@RequestBody WxUpdateArticle wxUpdateArticle, HttpServletRequest request) throws Exception {
		// AjaxJson ajaxJson = new AjaxJson();
		ResponseMessage<?> responseMessage = new ResponseMessage<>();
		String token = WxTools.getAccessToken();
		JwMediaAPI.updateArticlesByMaterial(media_id, wxUpdateArticle);
		responseMessage.setMessage("返回成功");
		responseMessage.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
		return responseMessage;

	}

//	/**
//	 * WebUploader 文件上传处理/删除处理
//	 * 
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/filedeal", method = RequestMethod.POST)
//	@ResponseBody
//	@ApiOperation(value = "文件上传处理/删除处理", notes = "文件上传处理/删除处理", httpMethod = "POST", produces = "application/json")
//	public ResponseMessage<AutoBaseFile> filedeal(HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		// AjaxJson ajaxJson = new AjaxJson();
//		ResponseMessage<AutoBaseFile> responseMessage = new ResponseMessage<>();
//
//		String msg = "啥都没干-没传参数吧！";
//		String upFlag = request.getParameter("isup");
//		String delFlag = request.getParameter("isdel");
//		// 是否将文件转换成swf
//		String swfTransform = request.getParameter("swfTransform");
//		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//		// 获取上传文件对象
//		MultipartFile mf = multipartRequest.getFile("file");
//		// demo中设置为D://upFiles,实际项目应因事制宜
//		String ctxPath = ResourceUtil.getConfigByName("webUploadpath");
//
//		// 默认上传文件是否转换为swf，实现在线预览功能开关
//		String globalSwfTransformFlag = ResourceUtil.getConfigByName("swf.transform.flag");
//
//		logger.debug("----ctxPath-----" + ctxPath);
//		try {
//			// 如果是上传操作
//			if ("1".equals(upFlag)) {
//				String fileName = null;
//				// 上传业务名称
//				String bizType = request.getParameter("bizType");
//				logger.debug("---bizType----" + bizType);
//				// 根据业务名称判断上传路径
//				String bizPath = StoreUploadFilePathEnum.getPath(bizType);
//				String nowday = new SimpleDateFormat("yyyyMMdd").format(new Date());
//				logger.debug("---nowday----" + nowday);
//				File file = new File(ctxPath + File.separator + bizPath + File.separator + nowday);
//				if (!file.exists()) {
//					file.mkdirs();// 创建文件根目录
//				}
//
//				String orgfile_name = mf.getOriginalFilename();// 获取文件名
//				fileName = orgfile_name.substring(0, orgfile_name.lastIndexOf(".")) + "_" + System.currentTimeMillis()
//						+ orgfile_name.substring(orgfile_name.indexOf("."));
//
//				String savePath = file.getPath() + File.separator + fileName;
//				String fileExt = FileUtils.getExtend(fileName);
//				if ("txt".equals(fileExt)) {
//					FileUtils.uploadTxtFile(mf, savePath);
//				} else {
//					File savefile = new File(savePath);
//					FileCopyUtils.copy(mf.getBytes(), savefile);
//				}
//				// 插入数据库
//				AutoBaseFile autoBaseFile = new AutoBaseFile();
//
//				// TSUser currentUser = ResourceUtil.getSessionUser();
//				autoBaseFile.setId(UUID.randomUUID().toString().replaceAll("-", ""));
//				// autoBaseFile.setUserId(currentUser.getId());
//				autoBaseFile.setOrgfile_name(orgfile_name);
//				autoBaseFile.setFile_name(fileName);
//				autoBaseFile.setFile_savePath(savePath);
//				autoBaseFile.setIsValid("1");
//				autoBaseFile.setCreate_date(new Date());
//				// autoBaseFile.setCreate_name(currentUser.getRealName());
//				autoBaseFile.setMsg("上传成功且数据库保存成功");
//
//				autoBaseFile.setIsDelValid("0");
//				this.autoBaseFileDao.insert(autoBaseFile);
//
//				String dbpath = bizPath + File.separator + nowday + File.separator + fileName;
//				logger.info("---nowday----" + nowday);
//				logger.info("---orgfile_name----" + orgfile_name);
//				logger.info("---fileName----" + fileName);
//				logger.info("---savePath----" + savePath);
//				logger.info("---fileExt----" + fileExt);
//				logger.info("---dbpath----" + dbpath);
//				if (dbpath.contains("\\")) {
//					dbpath = dbpath.replace("\\", "/");
//				}
//
//				// 1、将文件路径赋值给obj,前台可获取之,随表单提交,然后数据库中存储该路径
//				// 2、demo这里用的是AjaxJson对象,开发者可自定义返回对象,但是用t标签的时候路径属性名需为 obj或 filePath
//				// 或自己在标签内指定若在标签内指定则action返回路径的名称应保持一致
//				if ("true".equals(globalSwfTransformFlag) && "true".equals(swfTransform)) {
//					// 转换swf
//					SwfToolsUtil.convert2SWF(savePath);
//				}
//
//				// 插入数据库
//				msg = "上传成功且数据库保存成功";
//				responseMessage.setData(autoBaseFile);
//				responseMessage.setMessage(msg);
//				responseMessage.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
//
//				// 如果是删除操作
//			} else if ("1".equals(delFlag)) {
//				String path = request.getParameter("path");
//				String delpath = ctxPath + File.separator + path;
//				logger.info("---delpath----" + delpath);
//				File fileDelete = new File(delpath);
//				if (!fileDelete.exists() || !fileDelete.isFile()) {
//					msg = "警告: " + delpath + "不存在!";
//					logger.info(msg);
//					responseMessage.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());// 不存在前台也给他删除
//				} else {
//					if (fileDelete.delete()) {
//
//						AutoBaseFile autoBaseFile = new AutoBaseFile();
//
//						autoBaseFile.setFile_name(fileDelete.getName());
//						autoBaseFile.setFile_savePath(fileDelete.toString().replace("\\", "/"));
//						autoBaseFile.setIsValid("0");
//						// autoBaseFile.setIsUpValid("1");
//						autoBaseFile.setIsDelValid("1");
//						autoBaseFile.setMsg("删除成功且数据库更新成功");
//				        this.autoBaseFileDao.delete(autoBaseFile);
//						msg = "删除成功且数据库更新成功";
//
//						logger.info("---fileDelete----" + fileDelete.toString());
//						msg = "--------成功删除文件---------" + delpath;
//						logger.info(msg);
//
//						msg = "删除成功且数据库更新成功";
//						responseMessage.setData(autoBaseFile);
//						responseMessage.setMessage(msg);
//						responseMessage.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
//
//						// 删除swf/pdf文件
//						if ("true".equals(globalSwfTransformFlag) && "true".equals(swfTransform)) {
//							try {
//								String swfPath = FileUtils.getSwfPath(delpath);
//								new File(swfPath).delete();
//								logger.info("--------成功删除swf文件---------" + swfPath);
//								if (!delpath.endsWith("pdf")) {
//									String pdfPath = delpath.substring(0, delpath.lastIndexOf(".") + 1) + "pdf";
//									new File(pdfPath).delete();
//									logger.info("--------成功删除pdf文件---------" + pdfPath);
//								}
//							} catch (Exception e) {
//								logger.info("swf文件ORpdf文件未删除成功");
//							}
//						}
//					} else {
//						responseMessage.setRespCode("10001");
//						msg = "没删除成功--jdk的问题还是你文件的问题请重新试试";
//						responseMessage.setMessage(msg);
//						logger.info(msg);
//					}
//				}
//			} else {
//				throw new BusinessException("没有传参指定上传还是删除操作！");
//			}
//		} catch (IOException e) {
//			responseMessage.setRespCode("10001");
//			logger.info(e.getMessage());
//		} catch (BusinessException b) {
//			responseMessage.setRespCode("10001");
//			logger.info(b.getMessage());
//		}
//		logger.debug("-----fileDealController/filedeal.do------------" + msg);
//		responseMessage.setMessage(msg);
//
//		return responseMessage;
//	}

	/**
	 * 预览图片/word/excel/PDF文件
	 * 
	 * @author taoYan
	 * @since 2018年7月26日
	 */
	@RequestMapping(params = "openViewFile")
	public ModelAndView openViewFile(HttpServletRequest request) {
		String inputFile = request.getParameter("path");
		String extend = FileUtils.getExtend(inputFile);
		if (FileUtils.isPicture(extend)) {
			request.setAttribute("realpath", "img/server/" + inputFile);
			return new ModelAndView("common/upload/imageView");
		} else {
			String swfPath = FileUtils.getSwfPath(inputFile);
			request.setAttribute("swfpath", "img/server/" + swfPath + "?down=true");
			return new ModelAndView("common/upload/swfView");
		}
	}

	/**
	 * 获取图片流/获取文件用于下载
	 * 
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "downloadFile", method = RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, HttpServletRequest request) throws Exception {

		String ctxPath = request.getSession().getServletContext().getRealPath("/");
		String dbpath = request.getParameter("filePath");
		String downLoadPath = ctxPath + dbpath;
		response.setContentType("application/x-msdownload;charset=utf-8");
		String fileName = dbpath.substring(dbpath.lastIndexOf("/") + 1);
		String userAgent = request.getHeader("user-agent").toLowerCase();
		if (userAgent.contains("msie") || userAgent.contains("like gecko")) {
			fileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
		}
		response.setHeader("Content-disposition", "attachment; filename=" + fileName);
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = new BufferedInputStream(new FileInputStream(downLoadPath));
			outputStream = response.getOutputStream();
			byte[] buf = new byte[1024];
			int len;
			while ((len = inputStream.read(buf)) > 0) {
				outputStream.write(buf, 0, len);
			}
			response.flushBuffer();
		} catch (Exception e) {
			logger.info("--通过流的方式获取文件异常--" + e.getMessage());
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

}
