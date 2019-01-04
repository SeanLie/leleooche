package com.leletc.product.web.api.controller;

import com.leletc.product.entity.BaseProductsEntity;
import com.leletc.product.service.IOOcheProductService;
import com.leletc.product.web.api.response.BaseProductsRsp;
import com.leletc.product.web.bo.BaseProductsBO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.menu.ResponseMessageCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述：产品服务业务控制器
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/12 00:21
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
@RequestMapping("/oocheProductController")
@Api(value = "产品服务接口", description = "产品服务", tags = "API_OocheProduct")
public class OocheProductController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(OocheProductController.class);

    @Autowired
    private IOOcheProductService oocheProductService;

    /**
     * 根据用户ID获取用户产品服务列表
     *
     * @param userId 用户ID
     * @return ResponseMessage
     * @throws Exception
     */
    @RequestMapping(value = "getUserProductByUserId/{userId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据用户ID获取用户产品服务列表", notes = "获取用户产品服务", httpMethod = "GET", produces = "application/json")
    public ResponseMessage<BaseProductsBO> getUserProductByUserId(
            @ApiParam(value = "用户ID", required = true) @PathVariable("userId") String userId) throws Exception {
        ResponseMessage<BaseProductsBO> response = new ResponseMessage<>();
        BaseProductsRsp rsp = this.oocheProductService.getUserProductByUserId(userId);
        List<BaseProductsBO> list = rsp.getProducts();
        BaseProductsBO baseProductsBO = null;
        if (!CollectionUtils.isEmpty(list)) {
            baseProductsBO = list.get(0);
        }
        new ResponseMessage<BaseProductsBO>().setReturnData(response, rsp, baseProductsBO);
        return response;
    }

    /**
     * 根据用户ID和产品父级ID获取产品服务列表
     *
     * @param userId
     * @param parentProductId
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getUserProducts/{userId}/{parentProductId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据用户ID和产品父级ID获取产品服务列表", notes = "获取产品服务", httpMethod = "GET", produces = "application/json")
    public ResponseMessage<List<BaseProductsEntity>> getUserProducts(
            @ApiParam(value = "用户ID", required = true) @PathVariable("userId") String userId,
            @ApiParam(value = "产品父ID") @PathVariable("parentProductId") String parentProductId,
            HttpServletRequest request) throws Exception {
        ResponseMessage<List<BaseProductsEntity>> response = new ResponseMessage<>();
        List<BaseProductsEntity> list = oocheProductService.getBaseProducts(userId, parentProductId);
        if (CollectionUtils.isEmpty(list)) {
            response.setData(new ArrayList<BaseProductsEntity>());
            response.setMessage("返回成功，但未查询到结果");
            response.setRespCode(ResponseMessageCodeEnum.NULL_ERROR.getCode());
        } else {
            response.setData(list);
            response.setMessage("返回成功");
            response.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
        }
        return response;
    }

}
