/**
 * 业务控制器
 */
package com.leletc.user.web.controller;

import com.leletc.user.entity.UserBoxCfgEntity;
import com.leletc.user.service.IUserBoxCfgService;
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
 * 功能描述：用户格口配置业务控制类
 * <p>
 *
 * @author Sean
 * <p>
 * @date 2018-12-20 08:12:28
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
@RequestMapping("/userBoxCfgController")
public class UserBoxCfgController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(UserBoxCfgController.class);

    @Autowired
    private IUserBoxCfgService userBoxCfgService;
    @Autowired
    private SystemService systemService;

    /**
     * 用户格口配置列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "list")
    public ModelAndView list(HttpServletRequest request) {
        return new ModelAndView("com/leletc/user/userBoxCfgList");
    }

    /**
     * easyui AJAX请求数据
     *
     * @param userBoxCfg
     * @param request
     * @param response
     * @param dataGrid
     */
    @RequestMapping(params = "datagrid")
    public void datagrid(UserBoxCfgEntity userBoxCfg, HttpServletRequest request, HttpServletResponse response,
                         DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(UserBoxCfgEntity.class, dataGrid);
        // 查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, userBoxCfg, request.getParameterMap());
        try {
            // 自定义追加查询条件

        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.userBoxCfgService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 删除用户格口配置
     *
     * @return
     */
    @RequestMapping(params = "doDel")
    @ResponseBody
    public AjaxJson doDel(UserBoxCfgEntity userBoxCfg, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        userBoxCfg = systemService.getEntity(UserBoxCfgEntity.class, userBoxCfg.getId());
        message = "用户格口配置删除成功";
        try {
            userBoxCfgService.delete(userBoxCfg);
            systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "用户格口配置删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 批量删除用户格口配置
     *
     * @return
     */
    @RequestMapping(params = "doBatchDel")
    @ResponseBody
    public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "用户格口配置删除成功";
        try {
            for (String id : ids.split(",")) {
                UserBoxCfgEntity userBoxCfg = systemService.getEntity(UserBoxCfgEntity.class, id);
                userBoxCfgService.delete(userBoxCfg);
                systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "用户格口配置删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 添加用户格口配置
     *
     * @param userBoxCfg
     * @return
     */
    @RequestMapping(params = "doAdd")
    @ResponseBody
    public AjaxJson doAdd(UserBoxCfgEntity userBoxCfg) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "用户格口配置添加成功";
        try {
            userBoxCfgService.save(userBoxCfg);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "用户格口配置添加失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 更新用户格口配置
     *
     * @param userBoxCfg
     * @return
     */
    @RequestMapping(params = "doUpdate")
    @ResponseBody
    public AjaxJson doUpdate(UserBoxCfgEntity userBoxCfg) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "用户格口配置更新成功";
        UserBoxCfgEntity t = userBoxCfgService.get(UserBoxCfgEntity.class, userBoxCfg.getId());
        try {
            MyBeanUtils.copyBeanNotNull2Bean(userBoxCfg, t);
            userBoxCfgService.saveOrUpdate(t);
            systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "用户格口配置更新失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 用户格口配置新增页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goAdd")
    public ModelAndView goAdd(UserBoxCfgEntity userBoxCfg, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(userBoxCfg.getId())) {
            userBoxCfg = userBoxCfgService.getEntity(UserBoxCfgEntity.class, userBoxCfg.getId());
            req.setAttribute("userBoxCfg", userBoxCfg);
        }
        return new ModelAndView("com/leletc/user/userBoxCfg-add");
    }

    /**
     * 用户格口配置编辑页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goUpdate")
    public ModelAndView goUpdate(UserBoxCfgEntity userBoxCfg, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(userBoxCfg.getId())) {
            userBoxCfg = userBoxCfgService.getEntity(UserBoxCfgEntity.class, userBoxCfg.getId());
            req.setAttribute("userBoxCfg", userBoxCfg);
        }
        return new ModelAndView("com/leletc/user/userBoxCfg-update");
    }

    /**
     * 导入功能跳转
     *
     * @return
     */
    @RequestMapping(params = "upload")
    public ModelAndView upload(HttpServletRequest req) {
        req.setAttribute("controller_name", "userBoxCfgController");
        return new ModelAndView("common/upload/pub_excel_upload");
    }

    /**
     * 导出excel
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXls")
    public String exportXls(UserBoxCfgEntity userBoxCfg, HttpServletRequest request, HttpServletResponse response,
                            DataGrid dataGrid, ModelMap modelMap) {
        CriteriaQuery cq = new CriteriaQuery(UserBoxCfgEntity.class, dataGrid);
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, userBoxCfg, request.getParameterMap());
        List<UserBoxCfgEntity> userBoxCfgs = this.userBoxCfgService.getListByCriteriaQuery(cq, false);
        modelMap.put(NormalExcelConstants.FILE_NAME, "用户格口配置");
        modelMap.put(NormalExcelConstants.CLASS, UserBoxCfgEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS,
                new ExportParams("用户格口配置列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(), "导出信息"));
        modelMap.put(NormalExcelConstants.DATA_LIST, userBoxCfgs);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }

    /**
     * 导出excel 使模板
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXlsByT")
    public String exportXlsByT(UserBoxCfgEntity userBoxCfg, HttpServletRequest request, HttpServletResponse response,
                               DataGrid dataGrid, ModelMap modelMap) {
        modelMap.put(NormalExcelConstants.FILE_NAME, "用户格口配置");
        modelMap.put(NormalExcelConstants.CLASS, UserBoxCfgEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS,
                new ExportParams("用户格口配置列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(), "导出信息"));
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
                List<UserBoxCfgEntity> listUserBoxCfgEntitys = ExcelImportUtil.importExcel(file.getInputStream(),
                        UserBoxCfgEntity.class, params);
                for (UserBoxCfgEntity userBoxCfg : listUserBoxCfgEntitys) {
                    userBoxCfgService.save(userBoxCfg);
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
