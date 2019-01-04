package com.leletc.smartcabinet.web.controller;
import com.leletc.smartcabinet.entity.SmartCabinetPartnerEntity;
import com.leletc.smartcabinet.service.ISmartCabinetPartnerService;
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
 * @Description: 智能柜使用方
 * @author onlineGenerator
 * @date 2018-09-06 21:18:12
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/asapartnerController")
public class SmartCabinetPartnerController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(SmartCabinetPartnerController.class);

	@Autowired
	private ISmartCabinetPartnerService asapartnerService;
	@Autowired
	private SystemService systemService;

	/**
	 * 智能柜使用方列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/leletc/asapartnerList");
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
	public void datagrid(SmartCabinetPartnerEntity asapartner, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(SmartCabinetPartnerEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, asapartner, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.asapartnerService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除智能柜使用方
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(SmartCabinetPartnerEntity asapartner, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		asapartner = systemService.getEntity(SmartCabinetPartnerEntity.class, asapartner.getId());
		message = "智能柜使用方删除成功";
		try{
			asapartnerService.delete(asapartner);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "智能柜使用方删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除智能柜使用方
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "智能柜使用方删除成功";
		try{
			for(String id:ids.split(",")){
				SmartCabinetPartnerEntity asapartner = systemService.getEntity(SmartCabinetPartnerEntity.class,
				id
				);
				asapartnerService.delete(asapartner);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "智能柜使用方删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加智能柜使用方
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(SmartCabinetPartnerEntity asapartner, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "智能柜使用方添加成功";
		try{
			asapartnerService.save(asapartner);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "智能柜使用方添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新智能柜使用方
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(SmartCabinetPartnerEntity asapartner, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "智能柜使用方更新成功";
		SmartCabinetPartnerEntity t = asapartnerService.get(SmartCabinetPartnerEntity.class, asapartner.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(asapartner, t);
			asapartnerService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "智能柜使用方更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 智能柜使用方新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(SmartCabinetPartnerEntity asapartner, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(asapartner.getId())) {
			asapartner = asapartnerService.getEntity(SmartCabinetPartnerEntity.class, asapartner.getId());
			req.setAttribute("asapartnerPage", asapartner);
		}
		return new ModelAndView("com/jeecg/leletc/asapartner-add");
	}
	/**
	 * 智能柜使用方编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(SmartCabinetPartnerEntity asapartner, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(asapartner.getId())) {
			asapartner = asapartnerService.getEntity(SmartCabinetPartnerEntity.class, asapartner.getId());
			req.setAttribute("asapartnerPage", asapartner);
		}
		return new ModelAndView("com/jeecg/leletc/asapartner-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","asapartnerController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(SmartCabinetPartnerEntity asapartner, HttpServletRequest request, HttpServletResponse response
			, DataGrid dataGrid, ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(SmartCabinetPartnerEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, asapartner, request.getParameterMap());
		List<SmartCabinetPartnerEntity> asapartners = this.asapartnerService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"智能柜使用方");
		modelMap.put(NormalExcelConstants.CLASS,SmartCabinetPartnerEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("智能柜使用方列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,asapartners);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(SmartCabinetPartnerEntity asapartner, HttpServletRequest request, HttpServletResponse response
			, DataGrid dataGrid, ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"智能柜使用方");
    	modelMap.put(NormalExcelConstants.CLASS,SmartCabinetPartnerEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("智能柜使用方列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<SmartCabinetPartnerEntity> listSmartCabinetPartnerEntities = ExcelImportUtil.importExcel(file.getInputStream(),SmartCabinetPartnerEntity.class,params);
				for (SmartCabinetPartnerEntity asapartner : listSmartCabinetPartnerEntities) {
					asapartnerService.save(asapartner);
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
