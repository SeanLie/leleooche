package com.leletc.smartcabinet.web.controller;

import com.leletc.smartcabinet.entity.SmartCabinetDoorAllotEntity;
import com.leletc.smartcabinet.service.ISmartCabinetDoorAllotService;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Title: Controller  
 * @Description: 智能柜门分配
 * @author onlineGenerator
 * @date 2018-09-06 21:24:40
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/askdoorargController")
public class SmartCabinetDoorAllotController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(SmartCabinetDoorAllotController.class);

	@Autowired
	private ISmartCabinetDoorAllotService askdoorargService;
	@Autowired
	private SystemService systemService;

	/**
	 * 智能柜门分配列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/leletc/askdoorargList");
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
	public void datagrid(SmartCabinetDoorAllotEntity askdoorarg, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(SmartCabinetDoorAllotEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, askdoorarg, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.askdoorargService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除智能柜门分配
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(SmartCabinetDoorAllotEntity askdoorarg, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		askdoorarg = systemService.getEntity(SmartCabinetDoorAllotEntity.class, askdoorarg.getId());
		message = "智能柜门分配删除成功";
		try{
			askdoorargService.delete(askdoorarg);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "智能柜门分配删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除智能柜门分配
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "智能柜门分配删除成功";
		try{
			for(String id:ids.split(",")){
				SmartCabinetDoorAllotEntity askdoorarg = systemService.getEntity(SmartCabinetDoorAllotEntity.class,
				id
				);
				askdoorargService.delete(askdoorarg);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "智能柜门分配删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加智能柜门分配
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(SmartCabinetDoorAllotEntity askdoorarg, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "智能柜门分配添加成功";
		try{
			askdoorargService.save(askdoorarg);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "智能柜门分配添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新智能柜门分配
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(SmartCabinetDoorAllotEntity askdoorarg, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "智能柜门分配更新成功";
		SmartCabinetDoorAllotEntity t = askdoorargService.get(SmartCabinetDoorAllotEntity.class, askdoorarg.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(askdoorarg, t);
			askdoorargService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "智能柜门分配更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 智能柜门分配新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(SmartCabinetDoorAllotEntity askdoorarg, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(askdoorarg.getId())) {
			askdoorarg = askdoorargService.getEntity(SmartCabinetDoorAllotEntity.class, askdoorarg.getId());
			req.setAttribute("askdoorargPage", askdoorarg);
		}
		return new ModelAndView("com/jeecg/leletc/askdoorarg-add");
	}
	/**
	 * 智能柜门分配编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(SmartCabinetDoorAllotEntity askdoorarg, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(askdoorarg.getId())) {
			askdoorarg = askdoorargService.getEntity(SmartCabinetDoorAllotEntity.class, askdoorarg.getId());
			req.setAttribute("askdoorargPage", askdoorarg);
		}
		return new ModelAndView("com/jeecg/leletc/askdoorarg-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","askdoorargController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(SmartCabinetDoorAllotEntity askdoorarg, HttpServletRequest request, HttpServletResponse response
			, DataGrid dataGrid, ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(SmartCabinetDoorAllotEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, askdoorarg, request.getParameterMap());
		List<SmartCabinetDoorAllotEntity> askdoorargs = this.askdoorargService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"智能柜门分配");
		modelMap.put(NormalExcelConstants.CLASS,SmartCabinetDoorAllotEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("智能柜门分配列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,askdoorargs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(SmartCabinetDoorAllotEntity askdoorarg, HttpServletRequest request, HttpServletResponse response
			, DataGrid dataGrid, ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"智能柜门分配");
    	modelMap.put(NormalExcelConstants.CLASS,SmartCabinetDoorAllotEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("智能柜门分配列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<SmartCabinetDoorAllotEntity> listSmartCabinetDoorAllotEntities = ExcelImportUtil.importExcel(file.getInputStream(),SmartCabinetDoorAllotEntity.class,params);
				for (SmartCabinetDoorAllotEntity askdoorarg : listSmartCabinetDoorAllotEntities) {
					askdoorargService.save(askdoorarg);
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
