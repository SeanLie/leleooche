package com.leletc.oocheorder.web.controller;

import com.leletc.oocheorder.entity.OrdersCommentEntity;
import com.leletc.oocheorder.service.IOrderCommentService;
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
 * @Description: 订单评论管理
 * @date 2018-09-06 22:39:40
 */
@Controller
@RequestMapping("/orderCommentController")
public class OrderCommentController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(OrderCommentController.class);

    @Autowired
    private IOrderCommentService orderCommentService;
    @Autowired
    private SystemService systemService;

    /**
     * 订单评论管理列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "list")
    public ModelAndView list(HttpServletRequest request) {
        return new ModelAndView("com/jeecg/leletc/aOCommentList");
    }

    /**
     * easyui AJAX请求数据
     *
     * @param aOComment
     * @param request
     * @param response
     * @param dataGrid
     */

    @RequestMapping(params = "datagrid")
    public void datagrid(OrdersCommentEntity aOComment, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(OrdersCommentEntity.class, dataGrid);
        if (StringUtil.isEmpty(aOComment.getId())) {
            cq.isNull("parentCommentId");
        } else {
            cq.eq("parentCommentId", aOComment.getId());
            aOComment.setId(null);
        }
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, aOComment, request.getParameterMap());
        try {
            //自定义追加查询条件
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.orderCommentService.getDataGridReturn(cq, true);
        TagUtil.treegrid(response, dataGrid);
    }

    /**
     * 删除订单评论管理
     *
     * @return
     */
    @RequestMapping(params = "doDel")
    @ResponseBody
    public AjaxJson doDel(OrdersCommentEntity aOComment, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        aOComment = systemService.getEntity(OrdersCommentEntity.class, aOComment.getId());
        message = "订单评论管理删除成功";
        try {
            orderCommentService.delete(aOComment);
            systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "订单评论管理删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 批量删除订单评论管理
     *
     * @return
     */
    @RequestMapping(params = "doBatchDel")
    @ResponseBody
    public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "订单评论管理删除成功";
        try {
            for (String id : ids.split(",")) {
                OrdersCommentEntity aOComment = systemService.getEntity(OrdersCommentEntity.class,
                        id
                );
                orderCommentService.delete(aOComment);
                systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = "订单评论管理删除失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 添加订单评论管理
     *
     * @param aOComment
     * @return
     */
    @RequestMapping(params = "doAdd")
    @ResponseBody
    public AjaxJson doAdd(OrdersCommentEntity aOComment, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "订单评论管理添加成功";
        try {
            if (StringUtil.isEmpty(aOComment.getParentCommentId())) {
                aOComment.setParentCommentId(null);
            }
            orderCommentService.save(aOComment);
            systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "订单评论管理添加失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 更新订单评论管理
     *
     * @param aOComment
     * @return
     */
    @RequestMapping(params = "doUpdate")
    @ResponseBody
    public AjaxJson doUpdate(OrdersCommentEntity aOComment, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "订单评论管理更新成功";
        OrdersCommentEntity t = orderCommentService.get(OrdersCommentEntity.class, aOComment.getId());
        try {
            MyBeanUtils.copyBeanNotNull2Bean(aOComment, t);
            if (StringUtil.isEmpty(t.getParentCommentId())) {
                t.setParentCommentId(null);
            }
            orderCommentService.saveOrUpdate(t);
            systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
        } catch (Exception e) {
            e.printStackTrace();
            message = "订单评论管理更新失败";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 订单评论管理新增页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goAdd")
    public ModelAndView goAdd(OrdersCommentEntity aOComment, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(aOComment.getId())) {
            aOComment = orderCommentService.getEntity(OrdersCommentEntity.class, aOComment.getId());
            req.setAttribute("aOCommentPage", aOComment);
        }
        return new ModelAndView("com/jeecg/leletc/aOComment-add");
    }

    /**
     * 订单评论管理编辑页面跳转
     *
     * @return
     */
    @RequestMapping(params = "goUpdate")
    public ModelAndView goUpdate(OrdersCommentEntity aOComment, HttpServletRequest req) {
        if (StringUtil.isNotEmpty(aOComment.getId())) {
            aOComment = orderCommentService.getEntity(OrdersCommentEntity.class, aOComment.getId());
            req.setAttribute("aOCommentPage", aOComment);
        }
        return new ModelAndView("com/jeecg/leletc/aOComment-update");
    }

    /**
     * 导入功能跳转
     *
     * @return
     */
    @RequestMapping(params = "upload")
    public ModelAndView upload(HttpServletRequest req) {
        req.setAttribute("controller_name", "orderCommentController");
        return new ModelAndView("common/upload/pub_excel_upload");
    }

    /**
     * 导出excel
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXls")
    public String exportXls(OrdersCommentEntity aOComment, HttpServletRequest request, HttpServletResponse response
            , DataGrid dataGrid, ModelMap modelMap) {
        CriteriaQuery cq = new CriteriaQuery(OrdersCommentEntity.class, dataGrid);
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, aOComment, request.getParameterMap());
        List<OrdersCommentEntity> aOComments = this.orderCommentService.getListByCriteriaQuery(cq, false);
        modelMap.put(NormalExcelConstants.FILE_NAME, "订单评论管理");
        modelMap.put(NormalExcelConstants.CLASS, OrdersCommentEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("订单评论管理列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(),
                "导出信息"));
        modelMap.put(NormalExcelConstants.DATA_LIST, aOComments);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }

    /**
     * 导出excel 使模板
     *
     * @param request
     * @param response
     */
    @RequestMapping(params = "exportXlsByT")
    public String exportXlsByT(OrdersCommentEntity aOComment, HttpServletRequest request, HttpServletResponse response
            , DataGrid dataGrid, ModelMap modelMap) {
        modelMap.put(NormalExcelConstants.FILE_NAME, "订单评论管理");
        modelMap.put(NormalExcelConstants.CLASS, OrdersCommentEntity.class);
        modelMap.put(NormalExcelConstants.PARAMS, new ExportParams("订单评论管理列表", "导出人:" + ResourceUtil.getSessionUser().getRealName(),
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
                List<OrdersCommentEntity> listOrdersCommentEntities = ExcelImportUtil.importExcel(file.getInputStream(), OrdersCommentEntity.class, params);
                for (OrdersCommentEntity aOComment : listOrdersCommentEntities) {
                    orderCommentService.save(aOComment);
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
