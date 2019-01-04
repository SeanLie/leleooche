package com.leletc.smartcabinet.web.controller;

import com.leletc.smartcabinet.entity.SmartCabinetBaseEntity;
import com.leletc.smartcabinet.entity.SmartCabinetDoorEntity;
import com.leletc.smartcabinet.service.ISmartCabinetBaseService;
import com.leletc.smartcabinet.web.vo.SmartCabinetBaseVO;
import io.swagger.annotations.Api;
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
 * 功能描述：智能柜基础配置
 * <p>
 * @author 李斌
 * <p>
 * @date 2018/11/10 22:16
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
@RequestMapping("/smartCabinetBaseController")
@Api(value = "smartCabinetBase", description = "智能柜基础配置", tags = "LOCAL_smartCabinetBaseController")
public class SmartCabinetBaseController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SmartCabinetBaseController.class);

    @Autowired
    private ISmartCabinetBaseService smartCabinetBaseService;
    @Autowired
    private SystemService systemService;

    /**
     * 智能柜设置列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "list")
    public ModelAndView list(HttpServletRequest request) {
        return new ModelAndView("com/leletc/leletc/autoSmartarkArkbaseList");
    }

    /**
     * easyui AJAX请求数据
     *
     * @param request
     * @param response
     * @param dataGrid
     */
    @RequestMapping(params = "datagrid")
    public void datagrid(SmartCabinetBaseEntity autoSmartarkArkbase, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(SmartCabinetBaseEntity.class, dataGrid);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, autoSmartarkArkbase, request.getParameterMap());
        try {
            //自定义追加查询条件
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.smartCabinetBaseService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 删除智能柜设置
     *
     * @return
     */
    @RequestMapping(params = "doDel")
    @ResponseBody
    public AjaxJson doDel(SmartCabinetBaseEntity autoSmartarkArkbase, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        autoSmartarkArkbase = systemService.getEntity(SmartCabinetBaseEntity.class, autoSmartarkArkbase.getId());
        String message = "智能柜设置删除成功";
        try {
            smartCabinetBaseService.delMain(autoSmartarkArkbase);
            systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "智能柜设置删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 批量删除智能柜设置
     *
     * @return
     */
    @RequestMapping(params = "doBatchDel")
    @ResponseBody
    public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
        AjaxJson j = new AjaxJson();
        String message = "智能柜设置删除成功";
        try {
            for (String id : ids.split(",")) {
                SmartCabinetBaseEntity autoSmartarkArkbase = systemService.getEntity(SmartCabinetBaseEntity.class,
                        id
                );
                smartCabinetBaseService.delMain(autoSmartarkArkbase);
                systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "智能柜设置删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 添加智能柜设置
     *
     * @param ids
     * @return
     */
    @RequestMapping(params = "doAdd")
    @ResponseBody
    public AjaxJson doAdd(SmartCabinetBaseEntity autoSmartarkArkbase, SmartCabinetBaseVO smartCabinetBaseVO, HttpServletRequest request) {
        List<SmartCabinetDoorEntity> autoSmartarkArkdoorList = smartCabinetBaseVO.getSmartCabinetDoorEntityList();
        AjaxJson j = new AjaxJson();
        String message = "添加成功";
        try {
            smartCabinetBaseService.addMain(autoSmartarkArkbase, autoSmartarkArkdoorList);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "智能柜设置添加失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 更新智能柜设置
     *
     * @param ids
     * @return
     */
    @RequestMapping(params = "doUpdate")
    @ResponseBody
    public AjaxJson doUpdate(SmartCabinetBaseEntity autoSmartarkArkbase, SmartCabinetBaseVO smartCabinetBaseVO, HttpServletRequest request) {
        List<SmartCabinetDoorEntity> autoSmartarkArkdoorList = smartCabinetBaseVO.getSmartCabinetDoorEntityList();
        AjaxJson j = new AjaxJson();
        String message = "更新成功";
        try {
            smartCabinetBaseService.updateMain(autoSmartarkArkbase, autoSmartarkArkdoorList);
            systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "更新智能柜设置失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 智能柜设置新增页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goAdd")
    public ModelAndView goAdd(SmartCabinetBaseEntity autoSmartarkArkbase, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(autoSmartarkArkbase.getId())) {
            autoSmartarkArkbase = smartCabinetBaseService.getEntity(SmartCabinetBaseEntity.class, autoSmartarkArkbase.getId());
            req.setAttribute("smartCabinetBaseVO", autoSmartarkArkbase);
        }
        return new ModelAndView("com/leletc/leletc/autoSmartarkArkbase-add");
    }

    /**
     * 智能柜设置编辑页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goUpdate")
    public ModelAndView goUpdate(SmartCabinetBaseEntity autoSmartarkArkbase, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(autoSmartarkArkbase.getId())) {
            autoSmartarkArkbase = smartCabinetBaseService.getEntity(SmartCabinetBaseEntity.class, autoSmartarkArkbase.getId());
            req.setAttribute("smartCabinetBaseVO", autoSmartarkArkbase);
        }
        return new ModelAndView("com/leletc/leletc/autoSmartarkArkbase-update");
    }


    /**
     * 加载明细列表[智能柜门设置]
     *
     * @return
     */
    @RequestMapping(params = "autoSmartarkArkdoorList")
    public ModelAndView autoSmartarkArkdoorList(SmartCabinetBaseEntity autoSmartarkArkbase, HttpServletRequest req) {

        //===================================================================================
        //获取参数
        Object id0 = autoSmartarkArkbase.getId();
        //===================================================================================
        //查询-智能柜门设置
        String hql0 = "from SmartCabinetDoorEntity where 1 = 1 AND arkId = ? ";
        try {
            List<SmartCabinetDoorEntity> smartCabinetDoorEntityList = systemService.findHql(hql0, id0);
            req.setAttribute("autoSmartarkArkdoorList", smartCabinetDoorEntityList);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return new ModelAndView("com/leletc/leletc/autoSmartarkArkdoorList");
    }

    /**
     * 导出excel
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXls")
    public String exportXls(SmartCabinetBaseEntity autoSmartarkArkbase, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid, ModelMap map) {
        CriteriaQuery cq = new CriteriaQuery(SmartCabinetBaseEntity.class, dataGrid);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, autoSmartarkArkbase);
        try {
            //自定义追加查询条件
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        List<SmartCabinetBaseEntity> list = this.smartCabinetBaseService.getListByCriteriaQuery(cq, false);
        List<SmartCabinetBaseVO> pageList = new ArrayList<SmartCabinetBaseVO>();
        if (list != null && list.size() > 0) {
            for (SmartCabinetBaseEntity entity : list) {
                try {
                    SmartCabinetBaseVO page = new SmartCabinetBaseVO();
                    MyBeanUtils.copyBeanNotNull2Bean(entity, page);
                    Object id0 = entity.getId();
                    String hql0 = "from SmartCabinetDoorEntity where 1 = 1 AND arkId = ? ";
                    List<SmartCabinetDoorEntity> smartCabinetDoorEntityList = systemService.findHql(hql0, id0);
                    page.setSmartCabinetDoorEntityList(smartCabinetDoorEntityList);
                    pageList.add(page);
                } catch (Exception e) {
                    logger.info(e.getMessage());
                }
            }
        }
        map.put(NormalExcelConstants.FILE_NAME, "智能柜设置");
        map.put(NormalExcelConstants.CLASS, SmartCabinetBaseVO.class);
        map.put(NormalExcelConstants.PARAMS, new ExportParams("智能柜设置列表", "导出人:Jeecg",
                "导出信息"));
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
                List<SmartCabinetBaseVO> list = ExcelImportUtil.importExcel(file.getInputStream(), SmartCabinetBaseVO.class, params);
                SmartCabinetBaseEntity entity1 = null;
                for (SmartCabinetBaseVO page : list) {
                    entity1 = new SmartCabinetBaseEntity();
                    MyBeanUtils.copyBeanNotNull2Bean(page, entity1);
                    smartCabinetBaseService.addMain(entity1, page.getSmartCabinetDoorEntityList());
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
        map.put(NormalExcelConstants.FILE_NAME, "智能柜设置");
        map.put(NormalExcelConstants.CLASS, SmartCabinetBaseVO.class);
        map.put(NormalExcelConstants.PARAMS, new ExportParams("智能柜设置列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(),
                "导出信息"));
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
        req.setAttribute("controller_name", "smartCabinetBaseController");
        return new ModelAndView("common/upload/pub_excel_upload");
    }


}
