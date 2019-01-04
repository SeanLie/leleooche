package com.jeecg.leletc.controller;
import com.leletc.oocheorder.entity.ApiRequestLogEntity;
import com.jeecg.leletc.service.AutoJiekouDetailServiceI;
import com.jeecg.wechat.util.HttpRequestUtil;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;


/**   
 * @Title: Controller  
 * @Description: 智能柜接口明细
 * @author onlineGenerator
 * @date 2018-09-11 22:25:51
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/autoJiekouDetailController")
public class AutoJiekouDetailController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(AutoJiekouDetailController.class);

	@Autowired
	private AutoJiekouDetailServiceI autoJiekouDetailService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 智能柜接口明细列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/leletc/autoJiekouDetailList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(ApiRequestLogEntity autoJiekouDetail, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ApiRequestLogEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, autoJiekouDetail, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.autoJiekouDetailService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除智能柜接口明细
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ApiRequestLogEntity autoJiekouDetail, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		autoJiekouDetail = systemService.getEntity(ApiRequestLogEntity.class, autoJiekouDetail.getId());
		message = "智能柜接口明细删除成功";
		try{
			autoJiekouDetailService.delete(autoJiekouDetail);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "智能柜接口明细删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除智能柜接口明细
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "智能柜接口明细删除成功";
		try{
			for(String id:ids.split(",")){
				ApiRequestLogEntity autoJiekouDetail = systemService.getEntity(ApiRequestLogEntity.class,
				id
				);
				autoJiekouDetailService.delete(autoJiekouDetail);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "智能柜接口明细删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加智能柜接口明细
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ApiRequestLogEntity autoJiekouDetail, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "智能柜接口明细添加成功";
		try{
			//调用get和post方式调用接口
			//autoJiekouDetail.setRequestContent(HttpRequestUtil.httpRequestIO("http://localhost:8612/jeecg/httpRequestIO.html").toString());
			//autoJiekouDetail.setResponseContent(HttpRequestUtil.httpRequest("http://localhost:8612/jeecg/httprequest.php"));
			//调用restful api
			autoJiekouDetail.setRequestContent(HttpRequestUtil.seeRequest());
			autoJiekouDetail.setResponseContent(HttpRequestUtil.addResource("http://localhost:8080/jeecg/rest/jformOrderMain2Controller",autoJiekouDetail.getResponseContent()));
			//autoJiekouDetail.setResponseContent(HttpRequestUtil.addResource("http://localhost:8612/jeecg/httprequest.php",autoJiekouDetail.getResponseContent()));
			autoJiekouDetailService.save(autoJiekouDetail);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "智能柜接口明细添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新智能柜接口明细
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ApiRequestLogEntity autoJiekouDetail, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "智能柜接口明细更新成功";
		ApiRequestLogEntity t = autoJiekouDetailService.get(ApiRequestLogEntity.class, autoJiekouDetail.getId());
		try {
			autoJiekouDetail.setRequestContent(HttpRequestUtil.sendGet("http://localhost:8612/jeecg/httpget.php", "proj=mobile&pm=liubin"));
			autoJiekouDetail.setResponseContent(HttpRequestUtil.sendPost("http://localhost:8612/jeecg/httppost.php", "proj=mobile&pm=liubin&future=free",false));
			MyBeanUtils.copyBeanNotNull2Bean(autoJiekouDetail, t);			
			autoJiekouDetailService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "智能柜接口明细更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 智能柜接口明细新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ApiRequestLogEntity autoJiekouDetail, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(autoJiekouDetail.getId())) {
			autoJiekouDetail = autoJiekouDetailService.getEntity(ApiRequestLogEntity.class, autoJiekouDetail.getId());
			req.setAttribute("autoJiekouDetailPage", autoJiekouDetail);
		}
		return new ModelAndView("com/jeecg/leletc/autoJiekouDetail-add");
	}
	/**
	 * 智能柜接口明细编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ApiRequestLogEntity autoJiekouDetail, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(autoJiekouDetail.getId())) {
			autoJiekouDetail = autoJiekouDetailService.getEntity(ApiRequestLogEntity.class, autoJiekouDetail.getId());
			req.setAttribute("autoJiekouDetailPage", autoJiekouDetail);
		}
		return new ModelAndView("com/jeecg/leletc/autoJiekouDetail-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","autoJiekouDetailController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(ApiRequestLogEntity autoJiekouDetail, HttpServletRequest request, HttpServletResponse response
			, DataGrid dataGrid, ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(ApiRequestLogEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, autoJiekouDetail, request.getParameterMap());
		List<ApiRequestLogEntity> autoJiekouDetails = this.autoJiekouDetailService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"智能柜接口明细");
		modelMap.put(NormalExcelConstants.CLASS,ApiRequestLogEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("智能柜接口明细列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,autoJiekouDetails);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ApiRequestLogEntity autoJiekouDetail, HttpServletRequest request, HttpServletResponse response
			, DataGrid dataGrid, ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"智能柜接口明细");
    	modelMap.put(NormalExcelConstants.CLASS,ApiRequestLogEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("智能柜接口明细列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<ApiRequestLogEntity> listApiRequestDetailEntities = ExcelImportUtil.importExcel(file.getInputStream(),ApiRequestLogEntity.class,params);
				for (ApiRequestLogEntity autoJiekouDetail : listApiRequestDetailEntities) {
					autoJiekouDetailService.save(autoJiekouDetail);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(e.getMessage());
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	
}
