package com.leletc.oocheorder.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.leletc.oocheorder.entity.OrdersHandleEntity;
import com.leletc.oocheorder.service.IOrdersHandleService;
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
 * 功能描述：订单处理控制器
 * <p>
 *
 * @author Sean
 * <p>
 * @date 2018-11-11 11:56:12
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
@RequestMapping("/ordersHandleController")
@Api(value = "OrdersHandle", hidden = true, description = "订单处理", tags = "ordersHandleController")
public class OrdersHandleController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(OrdersHandleController.class);

    @Autowired
    private IOrdersHandleService ordersHandleService;
    @Autowired
    private SystemService systemService;
    @Autowired
    private Validator validator;

    /**
     * 订单处理列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "list")
    public ModelAndView list(HttpServletRequest request) {
        return new ModelAndView("com/leletc/leletc.oocheorder/ordersHandleList");
    }

    /**
     * easyui AJAX请求数据
     *
     * @param ordersHandle
     * @param request
     * @param response
     * @param dataGrid
     */

    @RequestMapping(params = "datagrid")
    public void datagrid(OrdersHandleEntity ordersHandle, HttpServletRequest request, HttpServletResponse response,
                         DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(OrdersHandleEntity.class, dataGrid);
        // 查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ordersHandle,
                request.getParameterMap());
        try {
            // 自定义追加查询条件

        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.ordersHandleService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 删除订单处理
     *
     * @return
     */
    @RequestMapping(params = "doDel")
    @ResponseBody
    public AjaxJson doDel(OrdersHandleEntity ordersHandle, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        ordersHandle = systemService.getEntity(OrdersHandleEntity.class, ordersHandle.getId());
        message = "订单处理删除成功";
        try {
            ordersHandleService.delete(ordersHandle);
            systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "订单处理删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 批量删除订单处理
     *
     * @return
     */
    @RequestMapping(params = "doBatchDel")
    @ResponseBody
    public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "订单处理删除成功";
        try {
            for (String id : ids.split(",")) {
                OrdersHandleEntity ordersHandle = systemService.getEntity(OrdersHandleEntity.class, id);
                ordersHandleService.delete(ordersHandle);
                systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "订单处理删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 添加订单处理
     *
     * @param ordersHandle
     * @return
     */
    @RequestMapping(params = "doAdd")
    @ResponseBody
    public AjaxJson doAdd(OrdersHandleEntity ordersHandle, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "订单处理添加成功";
        try {
            ordersHandleService.save(ordersHandle);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "订单处理添加失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 更新订单处理
     *
     * @param ordersHandle
     * @return
     */
    @RequestMapping(params = "doUpdate")
    @ResponseBody
    public AjaxJson doUpdate(OrdersHandleEntity ordersHandle, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "订单处理更新成功";
        OrdersHandleEntity t = ordersHandleService.get(OrdersHandleEntity.class, ordersHandle.getId());
        try {
            MyBeanUtils.copyBeanNotNull2Bean(ordersHandle, t);
            ordersHandleService.saveOrUpdate(t);
            systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "订单处理更新失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 订单处理新增页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goAdd")
    public ModelAndView goAdd(OrdersHandleEntity ordersHandle, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(ordersHandle.getId())) {
            ordersHandle = ordersHandleService.getEntity(OrdersHandleEntity.class, ordersHandle.getId());
            req.setAttribute("ordersHandle", ordersHandle);
        }
        return new ModelAndView("com/leletc/leletc.oocheorder/ordersHandle-add");
    }

    /**
     * 订单处理编辑页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goUpdate")
    public ModelAndView goUpdate(OrdersHandleEntity ordersHandle, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(ordersHandle.getId())) {
            ordersHandle = ordersHandleService.getEntity(OrdersHandleEntity.class, ordersHandle.getId());
            req.setAttribute("ordersHandle", ordersHandle);
        }
        return new ModelAndView("com/leletc/leletc.oocheorder/ordersHandle-update");
    }

    /**
     * 导入功能跳转
     *
     * @return
     */
    @RequestMapping(params = "upload")
    public ModelAndView upload(HttpServletRequest req) {
        req.setAttribute("controller_name", "ordersHandleController");
        return new ModelAndView("common/upload/pub_excel_upload");
    }

    /**
     * 导出excel
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXls")
    public String exportXls(OrdersHandleEntity ordersHandle, HttpServletRequest request, HttpServletResponse response,
                            DataGrid dataGrid, ModelMap modelMap) {
        CriteriaQuery cq = new CriteriaQuery(OrdersHandleEntity.class, dataGrid);
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ordersHandle,
                request.getParameterMap());
        List<OrdersHandleEntity> ordersHandles = this.ordersHandleService.getListByCriteriaQuery(cq, false);
        modelMap.put(NormalExcelConstants.FILE_NAME, "订单处理");
        modelMap.put(NormalExcelConstants.CLASS, OrdersHandleEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS,
                new ExportParams("订单处理列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(), "导出信息"));
        modelMap.put(NormalExcelConstants.DATA_LIST, ordersHandles);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }

    /**
     * 导出excel 使模板
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXlsByT")
    public String exportXlsByT(OrdersHandleEntity ordersHandle, HttpServletRequest request,
                               HttpServletResponse response, DataGrid dataGrid, ModelMap modelMap) {
        modelMap.put(NormalExcelConstants.FILE_NAME, "订单处理");
        modelMap.put(NormalExcelConstants.CLASS, OrdersHandleEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS,
                new ExportParams("订单处理列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(), "导出信息"));
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
                List<OrdersHandleEntity> listOrdersHandleEntitys = ExcelImportUtil.importExcel(file.getInputStream(),
                        OrdersHandleEntity.class, params);
                for (OrdersHandleEntity ordersHandle : listOrdersHandleEntitys) {
                    ordersHandleService.save(ordersHandle);
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
    @ApiOperation(value = "订单处理列表信息", produces = "application/json", httpMethod = "GET")
    public ResponseMessage<List<OrdersHandleEntity>> list() {
        List<OrdersHandleEntity> listOrdersHandles = ordersHandleService.getList(OrdersHandleEntity.class);
        return Result.success(listOrdersHandles);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据ID获取订单处理信息", notes = "根据ID获取订单处理信息", httpMethod = "GET", produces = "application/json")
    public ResponseMessage<?> get(@ApiParam(required = true, name = "id", value = "ID") @PathVariable("id") String id) {
        OrdersHandleEntity task = ordersHandleService.get(OrdersHandleEntity.class, id);
        if (task == null) {
            return Result.error("根据ID获取订单处理信息为空");
        }
        return Result.success(task);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "创建订单处理")
    public ResponseMessage<?> create(@ApiParam(name = "订单处理对象") @RequestBody OrdersHandleEntity ordersHandle,
                                     UriComponentsBuilder uriBuilder) {
        // 调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
        Set<ConstraintViolation<OrdersHandleEntity>> failures = validator.validate(ordersHandle);
        if (!failures.isEmpty()) {
            return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
        }

        // 保存
        try {
            ordersHandleService.save(ordersHandle);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("订单处理信息保存失败");
        }
        return Result.success(ordersHandle);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "更新订单处理", notes = "更新订单处理")
    public ResponseMessage<?> update(@ApiParam(name = "订单处理对象") @RequestBody OrdersHandleEntity ordersHandle) {
        // 调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
        Set<ConstraintViolation<OrdersHandleEntity>> failures = validator.validate(ordersHandle);
        if (!failures.isEmpty()) {
            return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
        }

        // 保存
        try {
            ordersHandleService.saveOrUpdate(ordersHandle);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("更新订单处理信息失败");
        }

        // 按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
        return Result.success("更新订单处理信息成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "删除订单处理")
    public ResponseMessage<?> delete(
            @ApiParam(name = "id", value = "ID", required = true) @PathVariable("id") String id) {
        logger.info("delete[{}]", id);
        // 验证
        if (StringUtils.isEmpty(id)) {
            return Result.error("ID不能为空");
        }
        try {
            ordersHandleService.deleteEntityById(OrdersHandleEntity.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("订单处理删除失败");
        }

        return Result.success();
    }
}
