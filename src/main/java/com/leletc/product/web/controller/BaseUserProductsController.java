/**
 * 业务控制器
 */
package com.leletc.product.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.leletc.product.entity.BaseUserProductsEntity;
import com.leletc.product.service.IBaseUserProductsService;
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
 * 功能描述：auto_base_user_products
 * <p>
 *
 * @author Sean
 * <p>
 * @date 2018-11-11 22:39:47
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Api(value = "AutoBaseUserProducts", description = "用户服务产品配置", tags = "API_BaseUserProductsController")
@Controller
@RequestMapping("/autoBaseUserProductsController")
public class BaseUserProductsController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseUserProductsController.class);

    @Autowired
    private IBaseUserProductsService baseUserProductsService;
    @Autowired
    private SystemService systemService;
    @Autowired
    private Validator validator;


    /**
     * auto_base_user_products列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "list")
    public ModelAndView list(HttpServletRequest request) {
        return new ModelAndView("com/leletc/product/autoBaseUserProductsList");
    }

    /**
     * easyui AJAX请求数据
     *
     * @param request
     * @param response
     * @param dataGrid
     */
    @RequestMapping(params = "datagrid")
    public void datagrid(BaseUserProductsEntity autoBaseUserProducts, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(BaseUserProductsEntity.class, dataGrid);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, autoBaseUserProducts, request.getParameterMap());
        try {
            //自定义追加查询条件

        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.baseUserProductsService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 删除auto_base_user_products
     *
     * @return
     */
    @RequestMapping(params = "doDel")
    @ResponseBody
    public AjaxJson doDel(BaseUserProductsEntity autoBaseUserProducts, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        autoBaseUserProducts = systemService.getEntity(BaseUserProductsEntity.class, autoBaseUserProducts.getId());
        message = "auto_base_user_products删除成功";
        try {
            baseUserProductsService.delete(autoBaseUserProducts);
            systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "auto_base_user_products删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 批量删除auto_base_user_products
     *
     * @return
     */
    @RequestMapping(params = "doBatchDel")
    @ResponseBody
    public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "auto_base_user_products删除成功";
        try {
            for (String id : ids.split(",")) {
                BaseUserProductsEntity autoBaseUserProducts = systemService.getEntity(BaseUserProductsEntity.class,
                        id
                );
                baseUserProductsService.delete(autoBaseUserProducts);
                systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "auto_base_user_products删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 添加auto_base_user_products
     *
     * @param ids
     * @return
     */
    @RequestMapping(params = "doAdd")
    @ResponseBody
    public AjaxJson doAdd(BaseUserProductsEntity autoBaseUserProducts, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "auto_base_user_products添加成功";
        try {
            baseUserProductsService.save(autoBaseUserProducts);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "auto_base_user_products添加失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 更新auto_base_user_products
     *
     * @param ids
     * @return
     */
    @RequestMapping(params = "doUpdate")
    @ResponseBody
    public AjaxJson doUpdate(BaseUserProductsEntity autoBaseUserProducts, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "auto_base_user_products更新成功";
        BaseUserProductsEntity t = baseUserProductsService.get(BaseUserProductsEntity.class, autoBaseUserProducts.getId());
        try {
            MyBeanUtils.copyBeanNotNull2Bean(autoBaseUserProducts, t);
            baseUserProductsService.saveOrUpdate(t);
            systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "auto_base_user_products更新失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }


    /**
     * auto_base_user_products新增页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goAdd")
    public ModelAndView goAdd(BaseUserProductsEntity autoBaseUserProducts, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(autoBaseUserProducts.getId())) {
            autoBaseUserProducts = baseUserProductsService.getEntity(BaseUserProductsEntity.class, autoBaseUserProducts.getId());
            req.setAttribute("autoBaseUserProducts", autoBaseUserProducts);
        }
        return new ModelAndView("com/leletc/product/autoBaseUserProducts-add");
    }

    /**
     * auto_base_user_products编辑页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goUpdate")
    public ModelAndView goUpdate(BaseUserProductsEntity autoBaseUserProducts, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(autoBaseUserProducts.getId())) {
            autoBaseUserProducts = baseUserProductsService.getEntity(BaseUserProductsEntity.class, autoBaseUserProducts.getId());
            req.setAttribute("autoBaseUserProducts", autoBaseUserProducts);
        }
        return new ModelAndView("com/leletc/product/autoBaseUserProducts-update");
    }

    /**
     * 导入功能跳转
     *
     * @return
     */
    @RequestMapping(params = "upload")
    public ModelAndView upload(HttpServletRequest req) {
        req.setAttribute("controller_name", "autoBaseUserProductsController");
        return new ModelAndView("common/upload/pub_excel_upload");
    }

    /**
     * 导出excel
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXls")
    public String exportXls(BaseUserProductsEntity autoBaseUserProducts, HttpServletRequest request, HttpServletResponse response
            , DataGrid dataGrid, ModelMap modelMap) {
        CriteriaQuery cq = new CriteriaQuery(BaseUserProductsEntity.class, dataGrid);
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, autoBaseUserProducts, request.getParameterMap());
        List<BaseUserProductsEntity> autoBaseUserProductss = this.baseUserProductsService.getListByCriteriaQuery(cq, false);
        modelMap.put(NormalExcelConstants.FILE_NAME, "auto_base_user_products");
        modelMap.put(NormalExcelConstants.CLASS, BaseUserProductsEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("auto_base_user_products列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(),
                "导出信息"));
        modelMap.put(NormalExcelConstants.DATA_LIST, autoBaseUserProductss);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }

    /**
     * 导出excel 使模板
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXlsByT")
    public String exportXlsByT(BaseUserProductsEntity autoBaseUserProducts, HttpServletRequest request, HttpServletResponse response
            , DataGrid dataGrid, ModelMap modelMap) {
        modelMap.put(NormalExcelConstants.FILE_NAME, "auto_base_user_products");
        modelMap.put(NormalExcelConstants.CLASS, BaseUserProductsEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("auto_base_user_products列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(),
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
                List<BaseUserProductsEntity> listBaseUserProductsEntitys = ExcelImportUtil.importExcel(file.getInputStream(), BaseUserProductsEntity.class, params);
                for (BaseUserProductsEntity autoBaseUserProducts : listBaseUserProductsEntitys) {
                    baseUserProductsService.save(autoBaseUserProducts);
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
    @ApiOperation(value = "auto_base_user_products列表信息", produces = "application/json", httpMethod = "GET")
    public ResponseMessage<List<BaseUserProductsEntity>> list() {
        List<BaseUserProductsEntity> listAutoBaseUserProductss = baseUserProductsService.getList(BaseUserProductsEntity.class);
        return Result.success(listAutoBaseUserProductss);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据ID获取auto_base_user_products信息", notes = "根据ID获取auto_base_user_products信息", httpMethod = "GET", produces = "application/json")
    public ResponseMessage<?> get(@ApiParam(required = true, name = "id", value = "ID") @PathVariable("id") String id) {
        BaseUserProductsEntity task = baseUserProductsService.get(BaseUserProductsEntity.class, id);
        if (task == null) {
            return Result.error("根据ID获取auto_base_user_products信息为空");
        }
        return Result.success(task);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "创建auto_base_user_products")
    public ResponseMessage<?> create(@ApiParam(name = "auto_base_user_products对象") @RequestBody BaseUserProductsEntity autoBaseUserProducts, UriComponentsBuilder uriBuilder) {
        //调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
        Set<ConstraintViolation<BaseUserProductsEntity>> failures = validator.validate(autoBaseUserProducts);
        if (!failures.isEmpty()) {
            return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
        }

        //保存
        try {
            baseUserProductsService.save(autoBaseUserProducts);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("auto_base_user_products信息保存失败");
        }
        return Result.success(autoBaseUserProducts);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "更新auto_base_user_products", notes = "更新auto_base_user_products")
    public ResponseMessage<?> update(@ApiParam(name = "auto_base_user_products对象") @RequestBody BaseUserProductsEntity autoBaseUserProducts) {
        //调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
        Set<ConstraintViolation<BaseUserProductsEntity>> failures = validator.validate(autoBaseUserProducts);
        if (!failures.isEmpty()) {
            return Result.error(JSONArray.toJSONString(BeanValidators.extractPropertyAndMessage(failures)));
        }

        //保存
        try {
            baseUserProductsService.saveOrUpdate(autoBaseUserProducts);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("更新auto_base_user_products信息失败");
        }

        //按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
        return Result.success("更新auto_base_user_products信息成功");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "删除auto_base_user_products")
    public ResponseMessage<?> delete(@ApiParam(name = "id", value = "ID", required = true) @PathVariable("id") String id) {
        logger.info("delete[{}]", id);
        // 验证
        if (StringUtils.isEmpty(id)) {
            return Result.error("ID不能为空");
        }
        try {
            baseUserProductsService.deleteEntityById(BaseUserProductsEntity.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("auto_base_user_products删除失败");
        }

        return Result.success();
    }
}
