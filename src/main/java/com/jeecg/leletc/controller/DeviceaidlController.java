package com.jeecg.leletc.controller;
import com.jeecg.leletc.entity.DeviceaidlEntity;
import com.jeecg.leletc.service.DeviceaidlServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
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
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.jwt.util.GsonUtil;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
 * @Title: Controller  
 * @Description: 智能柜接口_测试Minidao
 * @author onlineGenerator
 * @date 2018-10-04 09:11:33
 * @version V1.0   
 *
 */
@Api(value="Deviceaidl",description="智能柜接口_测试Minidao",tags="deviceaidlController")
@Controller
@RequestMapping("/deviceaidlController")
public class DeviceaidlController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(DeviceaidlController.class);

	@Autowired
	private DeviceaidlServiceI deviceaidlService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 智能柜接口_测试Minidao列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/leletc/deviceaidlList");
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
	public void datagrid(DeviceaidlEntity deviceaidl,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DeviceaidlEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, deviceaidl, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.deviceaidlService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除智能柜接口_测试Minidao
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DeviceaidlEntity deviceaidl, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		deviceaidl = systemService.getEntity(DeviceaidlEntity.class, deviceaidl.getId());
		message = "智能柜接口_测试Minidao删除成功";
		try{
			deviceaidlService.delete(deviceaidl);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "智能柜接口_测试Minidao删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除智能柜接口_测试Minidao
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "智能柜接口_测试Minidao删除成功";
		try{
			for(String id:ids.split(",")){
				DeviceaidlEntity deviceaidl = systemService.getEntity(DeviceaidlEntity.class, 
				id
				);
				deviceaidlService.delete(deviceaidl);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "智能柜接口_测试Minidao删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加智能柜接口_测试Minidao
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DeviceaidlEntity deviceaidl, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "智能柜接口_测试Minidao添加成功";
		try{
			deviceaidlService.save(deviceaidl);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "智能柜接口_测试Minidao添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新智能柜接口_测试Minidao
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DeviceaidlEntity deviceaidl, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "智能柜接口_测试Minidao更新成功";
		DeviceaidlEntity t = deviceaidlService.get(DeviceaidlEntity.class, deviceaidl.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(deviceaidl, t);
			deviceaidlService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "智能柜接口_测试Minidao更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
 	/**
	 * 自定义按钮-[我的添加]业务
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doMyAdd")
	@ResponseBody
	public AjaxJson doMyAdd(DeviceaidlEntity deviceaidl, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "我的添加成功";
		DeviceaidlEntity t = deviceaidlService.get(DeviceaidlEntity.class, deviceaidl.getId());
		try{
			deviceaidlService.doMyAddBus(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "我的添加失败";
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 智能柜接口_测试Minidao新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DeviceaidlEntity deviceaidl, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(deviceaidl.getId())) {
			deviceaidl = deviceaidlService.getEntity(DeviceaidlEntity.class, deviceaidl.getId());
			req.setAttribute("deviceaidlPage", deviceaidl);
		}
		return new ModelAndView("com/jeecg/leletc/deviceaidl-add");
	}
	/**
	 * 智能柜接口_测试Minidao编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DeviceaidlEntity deviceaidl, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(deviceaidl.getId())) {
			deviceaidl = deviceaidlService.getEntity(DeviceaidlEntity.class, deviceaidl.getId());
			req.setAttribute("deviceaidlPage", deviceaidl);
		}
		return new ModelAndView("com/jeecg/leletc/deviceaidl-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","deviceaidlController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DeviceaidlEntity deviceaidl,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DeviceaidlEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, deviceaidl, request.getParameterMap());
		List<DeviceaidlEntity> deviceaidls = this.deviceaidlService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"智能柜接口_测试Minidao");
		modelMap.put(NormalExcelConstants.CLASS,DeviceaidlEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("智能柜接口_测试Minidao列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,deviceaidls);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DeviceaidlEntity deviceaidl,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"智能柜接口_测试Minidao");
    	modelMap.put(NormalExcelConstants.CLASS,DeviceaidlEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("智能柜接口_测试Minidao列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<DeviceaidlEntity> listDeviceaidlEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DeviceaidlEntity.class,params);
				for (DeviceaidlEntity deviceaidl : listDeviceaidlEntitys) {
					deviceaidlService.save(deviceaidl);
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
	
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="智能柜接口_测试Minidao列表信息",produces="application/json",httpMethod="GET")
	public ResponseMessage<List<DeviceaidlEntity>> list() {
		List<DeviceaidlEntity> listDeviceaidls=deviceaidlService.getList(DeviceaidlEntity.class);
		return Result.success(listDeviceaidls);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value="根据ID获取智能柜接口_测试Minidao信息",notes="根据ID获取智能柜接口_测试Minidao信息",httpMethod="GET",produces="application/json")
	public ResponseMessage<?> get(@ApiParam(required=true,name="id",value="ID")@PathVariable("id") String id) {
		DeviceaidlEntity task = deviceaidlService.get(DeviceaidlEntity.class, id);
		if (task == null) {
			return Result.error("根据ID获取智能柜接口_测试Minidao信息为空");
		}
		return Result.success(task);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="创建智能柜接口_测试Minidao")
	public ResponseMessage<?> create(@ApiParam(name="智能柜接口_测试Minidao对象")@RequestBody DeviceaidlEntity deviceaidl, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DeviceaidlEntity>> failures = validator.validate(deviceaidl);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			deviceaidlService.save(deviceaidl);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("智能柜接口_测试Minidao信息保存失败");
		}
		return Result.success(deviceaidl);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value="更新智能柜接口_测试Minidao",notes="更新智能柜接口_测试Minidao")
	public ResponseMessage<?> update(@ApiParam(name="智能柜接口_测试Minidao对象")@RequestBody DeviceaidlEntity deviceaidl) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DeviceaidlEntity>> failures = validator.validate(deviceaidl);
		if (!failures.isEmpty()) {
			return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
		}

		//保存
		try{
			deviceaidlService.saveOrUpdate(deviceaidl);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("更新智能柜接口_测试Minidao信息失败");
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return Result.success("更新智能柜接口_测试Minidao信息成功");
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="删除智能柜接口_测试Minidao")
	public ResponseMessage<?> delete(@ApiParam(name="id",value="ID",required=true)@PathVariable("id") String id) {
		logger.info("delete[{}]" , id);
		// 验证
		if (StringUtils.isEmpty(id)) {
			return Result.error("ID不能为空");
		}
		try {
			deviceaidlService.deleteEntityById(DeviceaidlEntity.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("智能柜接口_测试Minidao删除失败");
		}

		return Result.success();
	}
}
