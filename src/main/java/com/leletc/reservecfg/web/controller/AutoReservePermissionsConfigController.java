/**
 * 业务控制器
 */
package com.leletc.reservecfg.web.controller;

import com.leletc.reservecfg.entity.AutoReservePermissionsConfigEntity;
import com.leletc.reservecfg.service.IAutoReservePermissionsConfigService;
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
 * 功能描述：auto_reserve_permissions_config
 * <p>
 *
 * @author Sean
 * <p>
 * @date 2018-11-12 00:51:17
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Controller
@RequestMapping("/autoReservePermissionsConfigController")
public class AutoReservePermissionsConfigController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(AutoReservePermissionsConfigController.class);

    @Autowired
    private IAutoReservePermissionsConfigService autoReservePermissionsConfigService;
    @Autowired
    private SystemService systemService;

    /**
     * auto_reserve_permissions_config列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "list")
    public ModelAndView list(HttpServletRequest request) {
        return new ModelAndView("com/leletc/base/autoReservePermissionsConfigList");
    }

    /**
     * easyui AJAX请求数据
     *
     * @param request
     * @param response
     * @param dataGrid
     * @param autoReservePermissionsConfig
     */

    @RequestMapping(params = "datagrid")
    public void datagrid(AutoReservePermissionsConfigEntity autoReservePermissionsConfig, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(AutoReservePermissionsConfigEntity.class, dataGrid);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, autoReservePermissionsConfig, request.getParameterMap());
        try {
            //自定义追加查询条件

        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.autoReservePermissionsConfigService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 删除auto_reserve_permissions_config
     *
     * @return
     */
    @RequestMapping(params = "doDel")
    @ResponseBody
    public AjaxJson doDel(AutoReservePermissionsConfigEntity autoReservePermissionsConfig, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        autoReservePermissionsConfig = systemService.getEntity(AutoReservePermissionsConfigEntity.class, autoReservePermissionsConfig.getId());
        message = "auto_reserve_permissions_config删除成功";
        try {
            autoReservePermissionsConfigService.delete(autoReservePermissionsConfig);
            systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "auto_reserve_permissions_config删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 批量删除auto_reserve_permissions_config
     *
     * @return
     */
    @RequestMapping(params = "doBatchDel")
    @ResponseBody
    public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "auto_reserve_permissions_config删除成功";
        try {
            for (String id : ids.split(",")) {
                AutoReservePermissionsConfigEntity autoReservePermissionsConfig = systemService.getEntity(AutoReservePermissionsConfigEntity.class,
                        id
                );
                autoReservePermissionsConfigService.delete(autoReservePermissionsConfig);
                systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "auto_reserve_permissions_config删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 添加auto_reserve_permissions_config
     *
     * @param autoReservePermissionsConfig
     * @return
     */
    @RequestMapping(params = "doAdd")
    @ResponseBody
    public AjaxJson doAdd(AutoReservePermissionsConfigEntity autoReservePermissionsConfig, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "auto_reserve_permissions_config添加成功";
        try {
            autoReservePermissionsConfigService.save(autoReservePermissionsConfig);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "auto_reserve_permissions_config添加失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 更新auto_reserve_permissions_config
     *
     * @param autoReservePermissionsConfig
     * @return
     */
    @RequestMapping(params = "doUpdate")
    @ResponseBody
    public AjaxJson doUpdate(AutoReservePermissionsConfigEntity autoReservePermissionsConfig, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "auto_reserve_permissions_config更新成功";
        AutoReservePermissionsConfigEntity t = autoReservePermissionsConfigService.get(AutoReservePermissionsConfigEntity.class, autoReservePermissionsConfig.getId());
        try {
            MyBeanUtils.copyBeanNotNull2Bean(autoReservePermissionsConfig, t);
            autoReservePermissionsConfigService.saveOrUpdate(t);
            systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "auto_reserve_permissions_config更新失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }


    /**
     * auto_reserve_permissions_config新增页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goAdd")
    public ModelAndView goAdd(AutoReservePermissionsConfigEntity autoReservePermissionsConfig, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(autoReservePermissionsConfig.getId())) {
            autoReservePermissionsConfig = autoReservePermissionsConfigService.getEntity(AutoReservePermissionsConfigEntity.class, autoReservePermissionsConfig.getId());
            req.setAttribute("autoReservePermissionsConfig", autoReservePermissionsConfig);
        }
        return new ModelAndView("com/leletc/base/autoReservePermissionsConfig-add");
    }

    /**
     * auto_reserve_permissions_config编辑页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goUpdate")
    public ModelAndView goUpdate(AutoReservePermissionsConfigEntity autoReservePermissionsConfig, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(autoReservePermissionsConfig.getId())) {
            autoReservePermissionsConfig = autoReservePermissionsConfigService.getEntity(AutoReservePermissionsConfigEntity.class, autoReservePermissionsConfig.getId());
            req.setAttribute("autoReservePermissionsConfig", autoReservePermissionsConfig);
        }
        return new ModelAndView("com/leletc/base/autoReservePermissionsConfig-update");
    }

    /**
     * 导入功能跳转
     *
     * @return
     */
    @RequestMapping(params = "upload")
    public ModelAndView upload(HttpServletRequest req) {
        req.setAttribute("controller_name", "autoReservePermissionsConfigController");
        return new ModelAndView("common/upload/pub_excel_upload");
    }

    /**
     * 导出excel
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXls")
    public String exportXls(AutoReservePermissionsConfigEntity autoReservePermissionsConfig, HttpServletRequest request, HttpServletResponse response
            , DataGrid dataGrid, ModelMap modelMap) {
        CriteriaQuery cq = new CriteriaQuery(AutoReservePermissionsConfigEntity.class, dataGrid);
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, autoReservePermissionsConfig, request.getParameterMap());
        List<AutoReservePermissionsConfigEntity> autoReservePermissionsConfigs = this.autoReservePermissionsConfigService.getListByCriteriaQuery(cq, false);
        modelMap.put(NormalExcelConstants.FILE_NAME, "auto_reserve_permissions_config");
        modelMap.put(NormalExcelConstants.CLASS, AutoReservePermissionsConfigEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("auto_reserve_permissions_config列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(),
                "导出信息"));
        modelMap.put(NormalExcelConstants.DATA_LIST, autoReservePermissionsConfigs);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }

    /**
     * 导出excel 使模板
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXlsByT")
    public String exportXlsByT(AutoReservePermissionsConfigEntity autoReservePermissionsConfig, HttpServletRequest request, HttpServletResponse response
            , DataGrid dataGrid, ModelMap modelMap) {
        modelMap.put(NormalExcelConstants.FILE_NAME, "auto_reserve_permissions_config");
        modelMap.put(NormalExcelConstants.CLASS, AutoReservePermissionsConfigEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("auto_reserve_permissions_config列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(),
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
                List<AutoReservePermissionsConfigEntity> listAutoReservePermissionsConfigEntitys = ExcelImportUtil.importExcel(file.getInputStream(), AutoReservePermissionsConfigEntity.class, params);
                for (AutoReservePermissionsConfigEntity autoReservePermissionsConfig : listAutoReservePermissionsConfigEntitys) {
                    autoReservePermissionsConfigService.save(autoReservePermissionsConfig);
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


}
