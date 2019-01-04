package com.leletc.product.web.controller;

import com.leletc.product.entity.BaseProductsEntity;
import com.leletc.product.service.IBaseProductsService;
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
 * @Description: 服务产品表
 * @date 2018-09-05 21:55:44
 */
@Controller
@RequestMapping("/autoBaseProductsController")
public class BaseProductsController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseProductsController.class);

    @Autowired
    private IBaseProductsService baseProductsService;
    @Autowired
    private SystemService systemService;

    /**
     * 服务产品表列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "list")
    public ModelAndView list(HttpServletRequest request) {
        return new ModelAndView("com/jeecg/leletc/autoBaseProductsList");
    }

    /**
     * easyui AJAX请求数据
     *
     * @param request
     * @param response
     * @param dataGrid
     */
    @RequestMapping(params = "datagrid")
    public void datagrid(BaseProductsEntity autoBaseProducts, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(BaseProductsEntity.class, dataGrid);
        if (StringUtil.isEmpty(autoBaseProducts.getId())) {
            cq.isNull("parentProductId");
        } else {
            cq.eq("parentProductId", autoBaseProducts.getId());
            autoBaseProducts.setId(null);
        }
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, autoBaseProducts, request.getParameterMap());
        try {
            //自定义追加查询条件
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.baseProductsService.getDataGridReturn(cq, true);
        TagUtil.treegrid(response, dataGrid);
    }

    /**
     * 删除服务产品表
     *
     * @return
     */
    @RequestMapping(params = "doDel")
    @ResponseBody
    public AjaxJson doDel(BaseProductsEntity autoBaseProducts, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        autoBaseProducts = systemService.getEntity(BaseProductsEntity.class, autoBaseProducts.getId());
        message = "服务产品表删除成功";
        try {
            baseProductsService.delete(autoBaseProducts);
            systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "服务产品表删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 批量删除服务产品表
     *
     * @return
     */
    @RequestMapping(params = "doBatchDel")
    @ResponseBody
    public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "服务产品表删除成功";
        try {
            for (String id : ids.split(",")) {
                BaseProductsEntity autoBaseProducts = systemService.getEntity(BaseProductsEntity.class,
                        id
                );
                baseProductsService.delete(autoBaseProducts);
                systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "服务产品表删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 添加服务产品表
     *
     * @param ids
     * @return
     */
    @RequestMapping(params = "doAdd")
    @ResponseBody
    public AjaxJson doAdd(BaseProductsEntity autoBaseProducts, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "服务产品表添加成功";
        try {
            if (StringUtil.isEmpty(autoBaseProducts.getParentProductId())) {
                autoBaseProducts.setParentProductId(null);
            }
            baseProductsService.save(autoBaseProducts);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "服务产品表添加失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 更新服务产品表
     *
     * @param ids
     * @return
     */
    @RequestMapping(params = "doUpdate")
    @ResponseBody
    public AjaxJson doUpdate(BaseProductsEntity autoBaseProducts, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "服务产品表更新成功";
        BaseProductsEntity t = baseProductsService.get(BaseProductsEntity.class, autoBaseProducts.getId());
        try {
            MyBeanUtils.copyBeanNotNull2Bean(autoBaseProducts, t);
            if (StringUtil.isEmpty(t.getParentProductId())) {
                t.setParentProductId(null);
            }
            baseProductsService.saveOrUpdate(t);
            systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "服务产品表更新失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 服务产品表新增页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goAdd")
    public ModelAndView goAdd(BaseProductsEntity autoBaseProducts, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(autoBaseProducts.getId())) {
            autoBaseProducts = baseProductsService.getEntity(BaseProductsEntity.class, autoBaseProducts.getId());
            req.setAttribute("autoBaseProductsPage", autoBaseProducts);
        }
        return new ModelAndView("com/jeecg/leletc/autoBaseProducts-add");
    }

    /**
     * 服务产品表编辑页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goUpdate")
    public ModelAndView goUpdate(BaseProductsEntity autoBaseProducts, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(autoBaseProducts.getId())) {
            autoBaseProducts = baseProductsService.getEntity(BaseProductsEntity.class, autoBaseProducts.getId());
            req.setAttribute("autoBaseProductsPage", autoBaseProducts);
        }
        return new ModelAndView("com/jeecg/leletc/autoBaseProducts-update");
    }

    /**
     * 导入功能跳转
     *
     * @return
     */
    @RequestMapping(params = "upload")
    public ModelAndView upload(HttpServletRequest req) {
        req.setAttribute("controller_name", "autoBaseProductsController");
        return new ModelAndView("common/upload/pub_excel_upload");
    }

    /**
     * 导出excel
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXls")
    public String exportXls(BaseProductsEntity autoBaseProducts, HttpServletRequest request, HttpServletResponse response
            , DataGrid dataGrid, ModelMap modelMap) {
        CriteriaQuery cq = new CriteriaQuery(BaseProductsEntity.class, dataGrid);
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, autoBaseProducts, request.getParameterMap());
        List<BaseProductsEntity> autoBaseProductss = this.baseProductsService.getListByCriteriaQuery(cq, false);
        modelMap.put(NormalExcelConstants.FILE_NAME, "服务产品表");
        modelMap.put(NormalExcelConstants.CLASS, BaseProductsEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("服务产品表列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(),
                "导出信息"));
        modelMap.put(NormalExcelConstants.DATA_LIST, autoBaseProductss);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }

    /**
     * 导出excel 使模板
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXlsByT")
    public String exportXlsByT(BaseProductsEntity autoBaseProducts, HttpServletRequest request, HttpServletResponse response
            , DataGrid dataGrid, ModelMap modelMap) {
        modelMap.put(NormalExcelConstants.FILE_NAME, "服务产品表");
        modelMap.put(NormalExcelConstants.CLASS, BaseProductsEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("服务产品表列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(),
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
                List<BaseProductsEntity> listBaseProductsEntities = ExcelImportUtil.importExcel(file.getInputStream(), BaseProductsEntity.class, params);
                for (BaseProductsEntity autoBaseProducts : listBaseProductsEntities) {
                    baseProductsService.save(autoBaseProducts);
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
