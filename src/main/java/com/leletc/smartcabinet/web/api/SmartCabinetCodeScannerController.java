package com.leletc.smartcabinet.web.api;

import com.leletc.smartcabinet.service.ISmartCabinetCodeScannerService;
import com.leletc.smartcabinet.web.api.response.SmartCabinetDoorRsp;
import com.leletc.smartcabinet.web.api.response.SmartCabinetRsp;
import com.leletc.smartcabinet.web.bo.SmartCabinetDoorBO;
import com.leletc.smartcabinet.web.vo.ScanSmartCabinetReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 功能描述：智能柜扫码处理控制器
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/10/13 10:30
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
@RequestMapping(value = "/smartCabinetCodeScanner")
@Api(value = "智能柜扫码处理", description = "智能柜扫码处理，开箱门、关箱门", tags = "API_SmartCabinetCodeScanner")
public class SmartCabinetCodeScannerController extends BaseController {

    @Autowired
    private ISmartCabinetCodeScannerService smartCabinetCodeScannerService;

    /**
     * 扫描二维码控制智能柜开门
     *
     * @param orderId 订单ID
     * @param userId  用户ID
     * @param bizType 业务类型（1：存，2：取）
     * @param token   柜子标识码
     * @return ResponseMessage
     */
    @RequestMapping(value = "/scanSmartCabinetQRCode/{bizType}/{token}/{cabinetNo}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "扫描二维码操作智能柜", notes = "智能柜", httpMethod = "POST", produces = "application/json")
    public ResponseMessage<SmartCabinetRsp> scanSmartCabinetQRCode(
            @ApiParam(value = "业务类型", required = true) @PathVariable("bizType") Integer bizType,
            @ApiParam(value = "柜子唯一标识码", required = true) @PathVariable("token") String token,
            @ApiParam(value = "柜子编号", required = true) @PathVariable("cabinetNo") String cabinetNo,
            @ApiParam(value = "用户ID", required = true) @RequestParam String userId,
            @ApiParam(value = "订单ID") @RequestParam String orderId) throws Exception {
        ResponseMessage<SmartCabinetRsp> response = new ResponseMessage<>();
        ScanSmartCabinetReq smartCabinetVO = new ScanSmartCabinetReq(orderId, userId, bizType, token,
                null, cabinetNo);
        SmartCabinetRsp rsp = smartCabinetCodeScannerService.scanCodeOpenDoor(smartCabinetVO);
        new ResponseMessage<SmartCabinetRsp>().setReturnData(response, rsp, rsp);
        return response;
    }

    /**
     * 扫一扫二维码开箱门（车主）
     *
     * @param userId  用户ID
     * @param bizType 业务类型（1：存，2：取）
     * @param token   柜子标识码
     * @return ResponseMessage
     */
    /*@RequestMapping(value = "/scanSmartCabinetQRCode/{bizType}/{token}/{cabinetNo}/{userId}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "扫描二维码操作智能柜", notes = "智能柜", httpMethod = "POST", produces = "application/json")
    public ResponseMessage<SmartCabinetRsp> scanSmartCabinetQRCode(
            @ApiParam(value = "业务类型", required = true) @PathVariable("bizType") Integer bizType,
            @ApiParam(value = "柜子唯一标识码", required = true) @PathVariable("token") String token,
            @ApiParam(value = "柜子编号", required = true) @PathVariable("cabinetNo") String cabinetNo,
            @ApiParam(value = "用户ID", required = true) @PathVariable("userId") String userId) throws Exception {
        ResponseMessage<SmartCabinetRsp> response = new ResponseMessage<>();
        ScanSmartCabinetReq smartCabinetVO = new ScanSmartCabinetReq("", userId, bizType, token,
                null, cabinetNo);
        SmartCabinetRsp rsp = smartCabinetCodeScannerService.scanCodeOpenDoor(smartCabinetVO);
        new ResponseMessage<SmartCabinetRsp>().setReturnData(response, rsp, rsp);
        return response;
    }*/

    /**
     * 关箱门
     *
     * @param smartCabinetVO 智能柜请求对象
     * @return ResponseMessage
     */
    @RequestMapping(value = "/closeSmartCabinetDoor", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "关箱门", notes = "智能柜关箱门业务", httpMethod = "POST", produces = "application/json")
    public ResponseMessage<SmartCabinetRsp> closeSmartCabinetDoor(
            @ApiParam("智能柜请求对象{orderId:订单ID,userId:用户ID,bizType:业务类型（1：存，2：取）,token:柜子标识码}")
            @RequestBody ScanSmartCabinetReq smartCabinetVO)
            throws Exception {
        ResponseMessage<SmartCabinetRsp> response = new ResponseMessage<>();
        SmartCabinetRsp rsp = this.smartCabinetCodeScannerService.closeDoor(smartCabinetVO);
        new ResponseMessage<SmartCabinetRsp>().setReturnData(response, rsp, rsp);
        return response;
    }

    /**
     * 获取箱门状态
     *
     * @param doorId 箱门ID
     * @return ResponseMessage
     */
    @RequestMapping(value = "/getDoorStatus/{doorId}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "获取箱门状态", notes = "智能柜", httpMethod = "POST", produces = "application/json")
    public ResponseMessage<SmartCabinetDoorBO> getDoorStatus(
            @ApiParam(value = "箱门ID", required = true) @PathVariable("doorId") String doorId) {
        ResponseMessage<SmartCabinetDoorBO> response = new ResponseMessage<>();
        SmartCabinetDoorRsp rsp = smartCabinetCodeScannerService.getDoorStatus(doorId);
        new ResponseMessage<SmartCabinetDoorBO>().setReturnData(response, rsp, rsp.getSmartCabinetDoor());
        return response;
    }

}
