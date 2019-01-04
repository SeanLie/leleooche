package com.leletc.oocheorder.web.controller;

import com.leletc.oocheorder.service.IOrderReservationService;
import com.leletc.oocheorder.entity.OrderDetailEntity;
import com.leletc.oocheorder.entity.OrderReservationEntity;
import com.leletc.oocheorder.web.vo.OrderReservationVO;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: Controller
 * @Description: 预约订单
 * @author onlineGenerator
 * @date 2018-09-06 22:15:49
 * @version V1.0
 *
 */
@Controller
@RequestMapping("/orderReservationController")
public class OrderReservationController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(OrderReservationController.class);

	@Autowired
	private IOrderReservationService aOReservationService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;

	/**
	 * 预约订单列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/leletc/aOReservationList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(OrderReservationEntity aOReservation, HttpServletRequest request, HttpServletResponse response,
						 DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(OrderReservationEntity.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, aOReservation,
				request.getParameterMap());
		try {
			// 自定义追加查询条件
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.aOReservationService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除预约订单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(OrderReservationEntity aOReservation, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		aOReservation = systemService.getEntity(OrderReservationEntity.class, aOReservation.getId());
		String message = "预约订单删除成功";
		try {
			aOReservationService.delMain(aOReservation);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "预约订单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除预约订单
	 * 
	 * @return
	 */
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		String message = "预约订单删除成功";
		try {
			for (String id : ids.split(",")) {
				OrderReservationEntity aOReservation = systemService.getEntity(OrderReservationEntity.class, id);
				aOReservationService.delMain(aOReservation);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "预约订单删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加预约订单 http://地址:端口/项目名称/api/cgFormDataController.do?addFormInfo
	 * @param aOReservation
	 * @param aOReservationVO
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(OrderReservationEntity aOReservation, OrderReservationVO aOReservationVO,
						  HttpServletRequest request) {
		List<OrderDetailEntity> autoOrdersDetailList = aOReservationVO.getAutoOrdersDetailList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try {
			aOReservationService.addMain(aOReservation, autoOrdersDetailList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "预约订单添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(aOReservation);
		return j;
	}

	/**
	 * 更新预约订单
	 * @param aOReservation
	 * @param aOReservationVO
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(OrderReservationEntity aOReservation, OrderReservationVO aOReservationVO,
							 HttpServletRequest request) {
		List<OrderDetailEntity> autoOrdersDetailList = aOReservationVO.getAutoOrdersDetailList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try {
			aOReservationService.updateMain(aOReservation, autoOrdersDetailList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "更新预约订单失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 预约订单新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(OrderReservationEntity aOReservation, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(aOReservation.getId())) {
			aOReservation = aOReservationService.getEntity(OrderReservationEntity.class, aOReservation.getId());
			req.setAttribute("aOReservationPage", aOReservation);
		}
		return new ModelAndView("com/jeecg/leletc/aOReservation-add");
	}

	/**
	 * 预约订单编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(OrderReservationEntity aOReservation, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(aOReservation.getId())) {
			aOReservation = aOReservationService.getEntity(OrderReservationEntity.class, aOReservation.getId());
			req.setAttribute("aOReservationPage", aOReservation);
		}
		return new ModelAndView("com/jeecg/leletc/aOReservation-update");
	}

	/**
	 * 加载明细列表[预约订单明细]
	 * 
	 * @return
	 */
	@RequestMapping(params = "autoOrdersDetailList")
	public ModelAndView autoOrdersDetailList(OrderReservationEntity aOReservation, HttpServletRequest req) {

		// ===================================================================================
		// 获取参数
		Object id0 = aOReservation.getId();
		// ===================================================================================
		// 查询-预约订单明细
		String hql0 = "from OrderDetailEntity where 1 = 1 AND orderId = ? ";
		try {
			List<OrderDetailEntity> orderDetailEntityList = systemService.findHql(hql0, id0);
			req.setAttribute("autoOrdersDetailList", orderDetailEntityList);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/jeecg/leletc/autoOrdersDetailList");
	}

	/**
	 * 导出excel
	 *
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(OrderReservationEntity aOReservation, HttpServletRequest request, HttpServletResponse response,
							DataGrid dataGrid, ModelMap map) {
		CriteriaQuery cq = new CriteriaQuery(OrderReservationEntity.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, aOReservation);
		try {
			// 自定义追加查询条件
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		List<OrderReservationEntity> list = this.aOReservationService.getListByCriteriaQuery(cq, false);
		List<OrderReservationVO> pageList = new ArrayList<OrderReservationVO>();
		if (list != null && list.size() > 0) {
			for (OrderReservationEntity entity : list) {
				try {
					OrderReservationVO page = new OrderReservationVO();
					MyBeanUtils.copyBeanNotNull2Bean(entity, page);
					Object id0 = entity.getId();
					String hql0 = "from OrderDetailEntity where 1 = 1 AND orderId = ? ";
					List<OrderDetailEntity> orderDetailEntityList = systemService.findHql(hql0, id0);
					page.setAutoOrdersDetailList(orderDetailEntityList);
					pageList.add(page);
				} catch (Exception e) {
					logger.info(e.getMessage());
				}
			}
		}
		map.put(NormalExcelConstants.FILE_NAME, "预约订单");
		map.put(NormalExcelConstants.CLASS, OrderReservationVO.class);
		map.put(NormalExcelConstants.PARAMS, new ExportParams("预约订单列表", "导出人:Jeecg", "导出信息"));
		map.put(NormalExcelConstants.DATA_LIST, pageList);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

	/**
	 * 通过excel导入数据
	 * 
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
				List<OrderReservationVO> list = ExcelImportUtil.importExcel(file.getInputStream(),
						OrderReservationVO.class, params);
				OrderReservationEntity entity1 = null;
				for (OrderReservationVO page : list) {
					entity1 = new OrderReservationEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page, entity1);
					aOReservationService.addMain(entity1, page.getAutoOrdersDetailList());
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			} finally {
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
		map.put(NormalExcelConstants.FILE_NAME, "预约订单");
		map.put(NormalExcelConstants.CLASS, OrderReservationVO.class);
		map.put(NormalExcelConstants.PARAMS,
				new ExportParams("预约订单列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(), "导出信息"));
		map.put(NormalExcelConstants.DATA_LIST, new ArrayList());
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

	/**
	 * 导入功能跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name", "orderReservationController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

	/**
	 * 获取文件附件信息
	 * 
	 * @param id aOReservation主键id
	 */
	@RequestMapping(params = "getFiles")
	@ResponseBody
	public AjaxJson getFiles(String id) {
		List<CgUploadEntity> uploadBeans = cgFormFieldService.findByProperty(CgUploadEntity.class, "cgformId", id);
		List<Map<String, Object>> files = new ArrayList<Map<String, Object>>(0);
		for (CgUploadEntity b : uploadBeans) {
			String title = b.getAttachmenttitle();// 附件名
			String fileKey = b.getId();// 附件主键
			String path = b.getRealpath();// 附件路径
			String field = b.getCgformField();// 表单中作为附件控件的字段
			Map<String, Object> file = new HashMap<String, Object>();
			file.put("title", title);
			file.put("fileKey", fileKey);
			file.put("path", path);
			file.put("field", field == null ? "" : field);
			files.add(file);
		}
		AjaxJson j = new AjaxJson();
		j.setObj(files);
		return j;
	}

}
