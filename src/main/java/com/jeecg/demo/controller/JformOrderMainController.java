package com.jeecg.demo.controller;
import com.jeecg.demo.entity.JformOrderMainEntity;
import com.jeecg.demo.service.JformOrderMainServiceI;
import com.jeecg.demo.page.JformOrderMainPage;
import com.jeecg.demo.entity.JformOrderCustomerEntity;
import com.jeecg.demo.entity.JformOrderTicketEntity;

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
import org.jeecgframework.core.util.oConvertUtils;
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


import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import java.util.HashMap;
/**   
 * @Title: Controller
 * @Description: 订单主信息
 * @author onlineGenerator
 * @date 2018-09-01 17:41:45
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/jformOrderMainController")
public class JformOrderMainController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(JformOrderMainController.class);

	@Autowired
	private JformOrderMainServiceI jformOrderMainService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;

	/**
	 * 订单主信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/demo/jformOrderMainList");
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
	public void datagrid(JformOrderMainEntity jformOrderMain,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(JformOrderMainEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, jformOrderMain,request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.jformOrderMainService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除订单主信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(JformOrderMainEntity jformOrderMain, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		jformOrderMain = systemService.getEntity(JformOrderMainEntity.class, jformOrderMain.getId());
		String message = "订单主信息删除成功";
		try{
			jformOrderMainService.delMain(jformOrderMain);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "订单主信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除订单主信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "订单主信息删除成功";
		try{
			for(String id:ids.split(",")){
				JformOrderMainEntity jformOrderMain = systemService.getEntity(JformOrderMainEntity.class,
				id
				);
				jformOrderMainService.delMain(jformOrderMain);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "订单主信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加订单主信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HttpServletRequest request,JformOrderMainPage jformOrderMainPage) {
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try {
			jformOrderMainService.addMain(jformOrderMainPage);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "订单主信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新订单主信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HttpServletRequest request,JformOrderMainPage jformOrderMainPage) {
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			jformOrderMainService.updateMain(jformOrderMainPage);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新订单主信息失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 订单主信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HttpServletRequest req) {
		return new ModelAndView("com/jeecg/demo/jformOrderMain-add");
	}
	
	/**
	 * 订单主信息编辑页面跳转
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HttpServletRequest req) {
		String id = req.getParameter("id");
		JformOrderMainPage jformOrderMainPage = new JformOrderMainPage();
		if (StringUtil.isNotEmpty(id)) {
			JformOrderMainEntity jformOrderMain = jformOrderMainService.getEntity(JformOrderMainEntity.class,id);
			try {
				MyBeanUtils.copyBeanNotNull2Bean(jformOrderMain,jformOrderMainPage);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//===================================================================================
			//获取参数
			Object id0 = jformOrderMain.getId();
			//===================================================================================
		    //查询-订单客户信息
		    String hql0 = "from JformOrderCustomerEntity where 1 = 1 AND fkId = ? ";
		    List<JformOrderCustomerEntity> jformOrderCustomerEntityList = systemService.findHql(hql0,id0);
		    if(jformOrderCustomerEntityList==null || jformOrderCustomerEntityList.size()<=0){
		    	jformOrderCustomerEntityList = new ArrayList<JformOrderCustomerEntity>();
		    	jformOrderCustomerEntityList.add(new JformOrderCustomerEntity());
		    }
		    jformOrderMainPage.setJformOrderCustomerList(jformOrderCustomerEntityList);
			//===================================================================================
			//获取参数
			Object id1 = jformOrderMain.getId();
			//===================================================================================
		    //查询-订单票务信息
		    String hql1 = "from JformOrderTicketEntity where 1 = 1 AND fckId = ? ";
		    List<JformOrderTicketEntity> jformOrderTicketEntityList = systemService.findHql(hql1,id1);
		    if(jformOrderTicketEntityList==null || jformOrderTicketEntityList.size()<=0){
		    	jformOrderTicketEntityList = new ArrayList<JformOrderTicketEntity>();
		    	jformOrderTicketEntityList.add(new JformOrderTicketEntity());
		    }
		    jformOrderMainPage.setJformOrderTicketList(jformOrderTicketEntityList);
		}
		req.setAttribute("jformOrderMainPage", jformOrderMainPage);
		return new ModelAndView("com/jeecg/demo/jformOrderMain-update");
	}
	
    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(JformOrderMainEntity jformOrderMain,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(JformOrderMainEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, jformOrderMain);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<JformOrderMainEntity> list=this.jformOrderMainService.getListByCriteriaQuery(cq, false);
    	List<JformOrderMainPage> pageList=new ArrayList<JformOrderMainPage>();
        if(list!=null&&list.size()>0){
        	for(JformOrderMainEntity entity:list){
        		try{
        			JformOrderMainPage page=new JformOrderMainPage();
        			MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            		Object id0 = entity.getId();
					String hql0 = "from JformOrderCustomerEntity where 1 = 1 AND fkId = ? ";
					List<JformOrderCustomerEntity> jformOrderCustomerEntityList = systemService.findHql(hql0,id0);
					page.setJformOrderCustomerList(jformOrderCustomerEntityList);
            		Object id1 = entity.getId();
					String hql1 = "from JformOrderTicketEntity where 1 = 1 AND fckId = ? ";
					List<JformOrderTicketEntity> jformOrderTicketEntityList = systemService.findHql(hql1,id1);
					page.setJformOrderTicketList(jformOrderTicketEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"订单主信息");
        map.put(NormalExcelConstants.CLASS,JformOrderMainPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("订单主信息列表", "导出人:Jeecg", "导出信息"));
        map.put(NormalExcelConstants.DATA_LIST,pageList);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

    /**
	 * 通过excel导入数据
	 * @param request
	 * @param
	 * @return
	 */
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
			params.setHeadRows(2);
			params.setNeedSave(true);
			try {
				List<JformOrderMainPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), JformOrderMainPage.class, params);
				for (JformOrderMainPage page : list) {
		            jformOrderMainService.addMain(page);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
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
	/**
	* 导出excel 使模板
	*/
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ModelMap map) {
		map.put(NormalExcelConstants.FILE_NAME,"订单主信息");
		map.put(NormalExcelConstants.CLASS,JformOrderMainPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("订单主信息列表", "导出人:"+ ResourceUtil.getSessionUser().getRealName(),
		"导出信息"));
		map.put(NormalExcelConstants.DATA_LIST,new ArrayList());
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	* 导入功能跳转
	*
	* @return
	*/
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name", "jformOrderMainController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

 	
	
	/**
	 * 获取文件附件信息
	 * 
	 * @param id jformOrderMain主键id
	 */
	@RequestMapping(params = "getFiles")
	@ResponseBody
	public AjaxJson getFiles(String id){
		List<CgUploadEntity> uploadBeans = cgFormFieldService.findByProperty(CgUploadEntity.class, "cgformId", id);
		List<Map<String,Object>> files = new ArrayList<Map<String,Object>>(0);
		for(CgUploadEntity b:uploadBeans){
			String title = b.getAttachmenttitle();//附件名
			String fileKey = b.getId();//附件主键
			String path = b.getRealpath();//附件路径
			String field = b.getCgformField();//表单中作为附件控件的字段
			Map<String, Object> file = new HashMap<String, Object>();
			file.put("title", title);
			file.put("fileKey", fileKey);
			file.put("path", path);
			file.put("field", field==null?"":field);
			files.add(file);
		}
		AjaxJson j = new AjaxJson();
		j.setObj(files);
		return j;
	}
}
