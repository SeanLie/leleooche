/**
 * 业务控制器
 */
package com.leletc.smartcabinet.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.leletc.smartcabinet.entity.SmartCabinetDoorEntity;
import com.leletc.smartcabinet.service.ISmartCabinetDoorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.beanvalidator.BeanValidators;
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
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.Result;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 功能描述：智能柜箱门业务控制类
 * <p>
 *
 * @author Sean
 * <p>
 * @date 2018-11-21 11:55:18
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
@RequestMapping("/smartCabinetDoorController")
@Api(value = "smartCabinetDoorController", hidden = true, description = "订单处智能柜箱门业务", tags = "API_SmartCabinetDoor")
public class SmartCabinetDoorController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SmartCabinetDoorController.class);

    @Autowired
    private ISmartCabinetDoorService smartCabinetDoorService;

    @Autowired
    private SystemService systemService;

    @Autowired
    private Validator validator;

    /**
     * 智能柜箱门列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "list")
    public ModelAndView list(HttpServletRequest request) {
        return new ModelAndView("com/leletc/smartcabinet/smartCabinetDoorList");
    }

    /**
     * easyui AJAX请求数据
     *
     * @param request
     * @param response
     * @param dataGrid
     */

    @RequestMapping(params = "datagrid")
    public void datagrid(SmartCabinetDoorEntity smartCabinetDoor, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(SmartCabinetDoorEntity.class, dataGrid);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, smartCabinetDoor, request.getParameterMap());
        try {
            //自定义追加查询条件

        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.smartCabinetDoorService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 删除智能柜箱门
     *
     * @return
     */
    @RequestMapping(params = "doDel")
    @ResponseBody
    public AjaxJson doDel(SmartCabinetDoorEntity smartCabinetDoor, HttpServletRequest request) {
        String message;
        AjaxJson j = new AjaxJson();
        smartCabinetDoor = systemService.getEntity(SmartCabinetDoorEntity.class, smartCabinetDoor.getId());
        try {
            message = "智能柜箱门删除成功";
            smartCabinetDoorService.delete(smartCabinetDoor);
            systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "智能柜箱门删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 批量删除智能柜箱门
     *
     * @return
     */
    @RequestMapping(params = "doBatchDel")
    @ResponseBody
    public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "智能柜箱门删除成功";
        try {
            for (String id : ids.split(",")) {
                SmartCabinetDoorEntity smartCabinetDoor = systemService.getEntity(SmartCabinetDoorEntity.class,
                        id
                );
                smartCabinetDoorService.delete(smartCabinetDoor);
                systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "智能柜箱门删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 添加智能柜箱门
     *
     * @param smartCabinetDoor
     * @return
     */
    @RequestMapping(params = "doAdd")
    @ResponseBody
    public AjaxJson doAdd(SmartCabinetDoorEntity smartCabinetDoor, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "智能柜箱门添加成功";
        try {
            smartCabinetDoorService.save(smartCabinetDoor);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "智能柜箱门添加失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 更新智能柜箱门
     *
     * @param smartCabinetDoor
     * @return
     */
    @RequestMapping(params = "doUpdate")
    @ResponseBody
    public AjaxJson doUpdate(SmartCabinetDoorEntity smartCabinetDoor, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "智能柜箱门更新成功";
        SmartCabinetDoorEntity t = smartCabinetDoorService.get(SmartCabinetDoorEntity.class, smartCabinetDoor.getId());
        try {
            MyBeanUtils.copyBeanNotNull2Bean(smartCabinetDoor, t);
            smartCabinetDoorService.saveOrUpdate(t);
            systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "智能柜箱门更新失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 智能柜箱门新增页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goAdd")
    public ModelAndView goAdd(SmartCabinetDoorEntity smartCabinetDoor, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(smartCabinetDoor.getId())) {
            smartCabinetDoor = smartCabinetDoorService.getEntity(SmartCabinetDoorEntity.class, smartCabinetDoor.getId());
            req.setAttribute("smartCabinetDoor", smartCabinetDoor);
        }
        return new ModelAndView("com/leletc/smartcabinet/smartCabinetDoor-add");
    }

    /**
     * 智能柜箱门编辑页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goUpdate")
    public ModelAndView goUpdate(SmartCabinetDoorEntity smartCabinetDoor, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(smartCabinetDoor.getId())) {
            smartCabinetDoor = smartCabinetDoorService.getEntity(SmartCabinetDoorEntity.class, smartCabinetDoor.getId());
            req.setAttribute("smartCabinetDoor", smartCabinetDoor);
        }
        return new ModelAndView("com/leletc/smartcabinet/smartCabinetDoor-update");
    }

    /**
     * 导入功能跳转
     *
     * @return
     */
    @RequestMapping(params = "upload")
    public ModelAndView upload(HttpServletRequest req) {
        req.setAttribute("controller_name", "smartCabinetDoorController");
        return new ModelAndView("common/upload/pub_excel_upload");
    }

    /**
     * 导出excel
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXls")
    public String exportXls(SmartCabinetDoorEntity smartCabinetDoor, HttpServletRequest request, HttpServletResponse response
            , DataGrid dataGrid, ModelMap modelMap) {
        CriteriaQuery cq = new CriteriaQuery(SmartCabinetDoorEntity.class, dataGrid);
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, smartCabinetDoor, request.getParameterMap());
        List<SmartCabinetDoorEntity> smartCabinetDoors = this.smartCabinetDoorService.getListByCriteriaQuery(cq, false);
        modelMap.put(NormalExcelConstants.FILE_NAME, "智能柜箱门");
        modelMap.put(NormalExcelConstants.CLASS, SmartCabinetDoorEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("智能柜箱门列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(),
                "导出信息"));
        modelMap.put(NormalExcelConstants.DATA_LIST, smartCabinetDoors);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }

    /**
     * 导出excel 使模板
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXlsByT")
    public String exportXlsByT(SmartCabinetDoorEntity smartCabinetDoor, HttpServletRequest request, HttpServletResponse response
            , DataGrid dataGrid, ModelMap modelMap) {
        modelMap.put(NormalExcelConstants.FILE_NAME, "智能柜箱门");
        modelMap.put(NormalExcelConstants.CLASS, SmartCabinetDoorEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("智能柜箱门列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(),
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
                List<SmartCabinetDoorEntity> listSmartCabinetDoorEntitys = ExcelImportUtil.importExcel(file.getInputStream(), SmartCabinetDoorEntity.class, params);
                for (SmartCabinetDoorEntity smartCabinetDoor : listSmartCabinetDoorEntitys) {
                    smartCabinetDoorService.save(smartCabinetDoor);
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


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "智能柜箱门列表信息", produces = "application/json", httpMethod = "GET")
    public ResponseMessage<List<SmartCabinetDoorEntity>> list() {
        List<SmartCabinetDoorEntity> listSmartCabinetDoors = smartCabinetDoorService.getList(SmartCabinetDoorEntity.class);
        return Result.success(listSmartCabinetDoors);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据ID获取智能柜箱门信息", notes = "根据ID获取智能柜箱门信息", httpMethod = "GET", produces = "application/json")
    public ResponseMessage<?> get(@ApiParam(required = true, name = "id", value = "ID") @PathVariable("id") String id) {
        SmartCabinetDoorEntity task = smartCabinetDoorService.get(SmartCabinetDoorEntity.class, id);
        if (task == null) {
            return Result.error("根据ID获取智能柜箱门信息为空");
        }
        return Result.success(task);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "创建智能柜箱门")
    public ResponseMessage<?> create(@ApiParam(name = "智能柜箱门对象") @RequestBody SmartCabinetDoorEntity smartCabinetDoor, UriComponentsBuilder uriBuilder) {
        //调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
        Set<ConstraintViolation<SmartCabinetDoorEntity>> failures = validator.validate(smartCabinetDoor);
        if (!failures.isEmpty()) {
            return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
        }

        //保存
        try {
            smartCabinetDoorService.save(smartCabinetDoor);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("智能柜箱门信息保存失败");
        }
        return Result.success(smartCabinetDoor);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "更新智能柜箱门", notes = "更新智能柜箱门")
    public ResponseMessage<?> update(@ApiParam(name = "智能柜箱门对象") @RequestBody SmartCabinetDoorEntity smartCabinetDoor) {
        //调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
        Set<ConstraintViolation<SmartCabinetDoorEntity>> failures = validator.validate(smartCabinetDoor);
        if (!failures.isEmpty()) {
            return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
        }

        //保存
        try {
            smartCabinetDoorService.saveOrUpdate(smartCabinetDoor);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("更新智能柜箱门信息失败");
        }

        //按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
        return Result.success("更新智能柜箱门信息成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "删除智能柜箱门")
    public ResponseMessage<?> delete(@ApiParam(name = "id", value = "ID", required = true) @PathVariable("id") String id) {
        logger.info("delete[{}]", id);
        // 验证
        if (StringUtils.isEmpty(id)) {
            return Result.error("ID不能为空");
        }
        try {
            smartCabinetDoorService.deleteEntityById(SmartCabinetDoorEntity.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("智能柜箱门删除失败");
        }

        return Result.success();
    }
}
