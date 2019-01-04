package com.leletc.smartcabinet.web.controller;

import com.leletc.smartcabinet.entity.SmartCabinetLockLogEntity;
import com.leletc.smartcabinet.service.ISmartCabinetLockLogService;
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
 * @author onlineGenerator
 * @version V1.0
 * @Title: Controller
 * @Description: 开关锁日志
 * @date 2018-09-06 21:41:13
 */
@Controller
@RequestMapping("/smartCabinetLockLogController")
public class SmartCabinetLockLogController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SmartCabinetLockLogController.class);

    @Autowired
    private ISmartCabinetLockLogService smartCabinetLockLogService;
    @Autowired
    private SystemService systemService;

    /**
     * 开关锁清单列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "list")
    public ModelAndView list(HttpServletRequest request) {
        return new ModelAndView("com/jeecg/leletc/askdoorlockList");
    }

    /**
     * easyui AJAX请求数据
     *
     * @param request
     * @param response
     * @param dataGrid
     */

    @RequestMapping(params = "datagrid")
    public void datagrid(SmartCabinetLockLogEntity askdoorlock, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(SmartCabinetLockLogEntity.class, dataGrid);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, askdoorlock, request.getParameterMap());
        try {
            //自定义追加查询条件
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.smartCabinetLockLogService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 删除开关锁清单
     *
     * @return
     */
    @RequestMapping(params = "doDel")
    @ResponseBody
    public AjaxJson doDel(SmartCabinetLockLogEntity askdoorlock, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        askdoorlock = systemService.getEntity(SmartCabinetLockLogEntity.class, askdoorlock.getId());
        message = "开关锁清单删除成功";
        try {
            smartCabinetLockLogService.delete(askdoorlock);
            systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "开关锁清单删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 批量删除开关锁清单
     *
     * @return
     */
    @RequestMapping(params = "doBatchDel")
    @ResponseBody
    public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "开关锁清单删除成功";
        try {
            for (String id : ids.split(",")) {
                SmartCabinetLockLogEntity askdoorlock = systemService.getEntity(SmartCabinetLockLogEntity.class,
                        id
                );
                smartCabinetLockLogService.delete(askdoorlock);
                systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "开关锁清单删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 添加开关锁清单
     *
     * @param lockLogEntity
     * @param request
     * @return
     */
    @RequestMapping(params = "doAdd")
    @ResponseBody
    public AjaxJson doAdd(SmartCabinetLockLogEntity lockLogEntity, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "开关锁清单添加成功";
        try {
            smartCabinetLockLogService.save(lockLogEntity);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "开关锁清单添加失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 更新开关锁清单
     *
     * @param lockLogEntity
     * @param request
     * @return
     */
    @RequestMapping(params = "doUpdate")
    @ResponseBody
    public AjaxJson doUpdate(SmartCabinetLockLogEntity lockLogEntity, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "开关锁清单更新成功";
        SmartCabinetLockLogEntity t = smartCabinetLockLogService.get(SmartCabinetLockLogEntity.class, lockLogEntity.getId());
        try {
            MyBeanUtils.copyBeanNotNull2Bean(lockLogEntity, t);
            smartCabinetLockLogService.saveOrUpdate(t);
            systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "开关锁清单更新失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 开关锁清单新增页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goAdd")
    public ModelAndView goAdd(SmartCabinetLockLogEntity askdoorlock, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(askdoorlock.getId())) {
            askdoorlock = smartCabinetLockLogService.getEntity(SmartCabinetLockLogEntity.class, askdoorlock.getId());
            req.setAttribute("askdoorlockPage", askdoorlock);
        }
        return new ModelAndView("com/jeecg/leletc/askdoorlock-add");
    }

    /**
     * 开关锁清单编辑页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goUpdate")
    public ModelAndView goUpdate(SmartCabinetLockLogEntity askdoorlock, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(askdoorlock.getId())) {
            askdoorlock = smartCabinetLockLogService.getEntity(SmartCabinetLockLogEntity.class, askdoorlock.getId());
            req.setAttribute("askdoorlockPage", askdoorlock);
        }
        return new ModelAndView("com/jeecg/leletc/askdoorlock-update");
    }

    /**
     * 导入功能跳转
     *
     * @return
     */
    @RequestMapping(params = "upload")
    public ModelAndView upload(HttpServletRequest req) {
        req.setAttribute("controller_name", "smartCabinetLockLogController");
        return new ModelAndView("common/upload/pub_excel_upload");
    }

    /**
     * 导出excel
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXls")
    public String exportXls(SmartCabinetLockLogEntity askdoorlock, HttpServletRequest request, HttpServletResponse response
            , DataGrid dataGrid, ModelMap modelMap) {
        CriteriaQuery cq = new CriteriaQuery(SmartCabinetLockLogEntity.class, dataGrid);
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, askdoorlock, request.getParameterMap());
        List<SmartCabinetLockLogEntity> askdoorlocks = this.smartCabinetLockLogService.getListByCriteriaQuery(cq, false);
        modelMap.put(NormalExcelConstants.FILE_NAME, "开关锁清单");
        modelMap.put(NormalExcelConstants.CLASS, SmartCabinetLockLogEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("开关锁清单列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(),
                "导出信息"));
        modelMap.put(NormalExcelConstants.DATA_LIST, askdoorlocks);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }

    /**
     * 导出excel 使模板
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXlsByT")
    public String exportXlsByT(SmartCabinetLockLogEntity askdoorlock, HttpServletRequest request, HttpServletResponse response
            , DataGrid dataGrid, ModelMap modelMap) {
        modelMap.put(NormalExcelConstants.FILE_NAME, "开关锁清单");
        modelMap.put(NormalExcelConstants.CLASS, SmartCabinetLockLogEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("开关锁清单列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(),
                "导出信息"));
        modelMap.put(NormalExcelConstants.DATA_LIST, new ArrayList());
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
                List<SmartCabinetLockLogEntity> listSmartCabinetLockLogEntities = ExcelImportUtil.importExcel(file.getInputStream(), SmartCabinetLockLogEntity.class, params);
                for (SmartCabinetLockLogEntity askdoorlock : listSmartCabinetLockLogEntities) {
                    smartCabinetLockLogService.save(askdoorlock);
                }
                j.setMsg("文件导入成功！");
            } catch (Exception e) {
                j.setMsg("文件导入失败！");
                logger.error(e.getMessage());
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


}
