package com.leletc.user.api.controller;

import com.leletc.user.api.request.CarManagementReq;
import com.leletc.user.api.response.CarManagementRsp;
import com.leletc.user.service.ICarManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.menu.ResponseMessageCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 朱磊
 */
@Controller
@RequestMapping("/carManagementController")
@Api(value = "用户车辆基础信息", description = "用户车辆基础信息接口", tags = "API_CarManagement")
public class CarManagementController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CarManagementController.class);

    @Autowired
    private ICarManagementService carManagementService;

    // 增加用户车辆信息
    @ApiOperation(value = "增加用户车辆信息", notes = "增加用户车辆信息", httpMethod = "POST", produces = "application/json")
    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage<CarManagementRsp> addCar(@RequestBody CarManagementReq carManagementReq) {
        ResponseMessage<CarManagementRsp> responseMessage = new ResponseMessage<>();
        CarManagementRsp rsp = this.carManagementService.addCar(carManagementReq);
        responseMessage.setData(rsp);
        responseMessage.setMessage("返回成功");
        responseMessage.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
        return responseMessage;
    }

    /**
     * 删除用户车辆信息
     *
     * @param userId 用户ID
     * @param carNum 车牌号
     * @return ResponseMessage
     */
    @ApiOperation(value = "删除用户车辆信息", notes = "删除用户车辆信息", httpMethod = "DELETE", produces = "application/json")
    @RequestMapping(value = "/delCar/{userId}/{carNum}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseMessage<CarManagementRsp> delCar(
            @ApiParam(name = "userId", value = "用户ID", required = true) @PathVariable("userId") String userId,
            @ApiParam(name = "carNum", value = "车牌号", required = true) @PathVariable("carNum") String carNum) {
        ResponseMessage<CarManagementRsp> response = new ResponseMessage<>();
        CarManagementRsp rsp = this.carManagementService.delCar(userId, carNum);
        response.setData(rsp);
        response.setMessage(rsp.getMsg());
        response.setRespCode(rsp.getRspcode());
        return response;
    }

    // 修改用户车辆信息
    @ApiOperation(value = "修改用户车辆信息", notes = "修改用户车辆信息", httpMethod = "PUT", produces = "application/json")
    @RequestMapping(value = "/updateCar", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseMessage<CarManagementRsp> updateCar(@RequestBody CarManagementReq carManagementReq) {
        ResponseMessage<CarManagementRsp> responseMessage = new ResponseMessage<>();
        CarManagementRsp rsp = this.carManagementService.updateCar(carManagementReq);
        responseMessage.setData(rsp);
        responseMessage.setMessage("返回成功");
        responseMessage.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
        return responseMessage;
    }

    // 查找用户车辆信息
    @ApiOperation(value = "查询用户车辆信息", notes = "查询用户车辆信息", httpMethod = "GET", produces = "application/json")
    @RequestMapping(value = "/getCar/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage<List<CarManagementRsp>> getCar(
            @ApiParam(name = "userId", value = "用户ID", required = true) @PathVariable("userId") String userId) {
        if (StringUtils.isEmpty(userId)) {
            return new ResponseMessage<>(ResponseMessageCodeEnum.VALID_ERROR, "用户ID不能为空!");
        }
        ResponseMessage<List<CarManagementRsp>> responseMessage = new ResponseMessage<>();
        List<CarManagementRsp> list = null;// this.carManagementService.getAllCarMseeage(userId);
        if (list.size() <= 0) {
            responseMessage.setData(list);
            responseMessage.setMessage("当前不存在相关车辆信息");
            responseMessage.setRespCode(ResponseMessageCodeEnum.NULL_ERROR.getCode());
            return responseMessage;
        } else {
            responseMessage.setData(list);
            responseMessage.setMessage("返回成功");
            responseMessage.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
            return responseMessage;
        }
    }

}