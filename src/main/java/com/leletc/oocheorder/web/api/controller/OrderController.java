package com.leletc.oocheorder.web.api.controller;

import com.leletc.base.util.LeletcConstants;
import com.leletc.oocheorder.entity.OrderReservationEntity;
import com.leletc.oocheorder.entity.OrdersHandleEntity;
import com.leletc.oocheorder.service.IOrderService;
import com.leletc.oocheorder.web.api.request.OrderReservationReq;
import com.leletc.oocheorder.web.api.response.*;
import com.leletc.oocheorder.web.bo.OrderReservationBO;
import com.leletc.oocheorder.web.bo.ReservationBO;
import com.leletc.smartcabinet.service.ISmartCabinetCodeScannerService;
import com.leletc.smartcabinet.web.api.response.SmartCabinetRsp;
import com.leletc.smartcabinet.web.vo.ScanSmartCabinetReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.menu.ResponseMessageCodeEnum;
import org.jeewx.api.core.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 功能描述：订单服务业务控制器
 * <p>
 *
 * @author 朱磊
 * <p>
 * @date 2018/11/10 11:34
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
@RequestMapping("/orderController")
@Api(value = "订单服务", description = "订单服务业务处理", tags = "API_orderController")
public class OrderController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private CommonService commonService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private ISmartCabinetCodeScannerService smartCabinetCodeScannerService;

    /**
     * 预约
     *
     * @param orderReservationReq 预约请求对象
     * @return ResponseMessage
     * @throws Exception 异常
     */
    @RequestMapping(value = "/reserve", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "预约订单", notes = "预约订单", httpMethod = "POST", produces = "application/json")
    public ResponseMessage<ReservationBO> reserve(
            @ApiParam(value = "预约请求对象", required = true) @RequestBody OrderReservationReq orderReservationReq)
            throws Exception {
        ResponseMessage<ReservationBO> response = new ResponseMessage<>();
        final OrderReservationRsp rsp = this.orderService.reserve(orderReservationReq);
        logger.debug("【响应码下单后】" + rsp.toString());
        if (rsp.getRspcode().equals(ResponseMessageCodeEnum.SUCCESS.getCode())) {
            response.setMessage(rsp.getMsg());
            // FIXME 2018-12-18 为简化流程，免掉智能柜的扫码操作(mark1)
            // 车主存钥匙
            /*try {
                ReservationBO reservation = rsp.getReservation();
                ScanSmartCabinetReq smartCabinetVO = new ScanSmartCabinetReq(reservation.getOrderId(),
                        reservation.getUserId(), 1, "18071adc0326f8fe50d", null, "LELETC20180001");
                SmartCabinetRsp smartCabinetRsp = smartCabinetCodeScannerService.scanCodeOpenDoor(smartCabinetVO);
                String boxNo = smartCabinetRsp.getSmartCabinetDoor().getBoxNo();
                // 关门
                smartCabinetVO = new ScanSmartCabinetReq(reservation.getOrderId(), reservation.getUserId(), 1,
                        "18071adc0326f8fe50d", boxNo, "LELETC20180001");
                smartCabinetCodeScannerService.closeDoor(smartCabinetVO);
            } catch (Exception e) {
                e.printStackTrace();
            }*/
        } else {
            response.setMessage(rsp.getError());
        }
        response.setData(rsp.getReservation());
        response.setRespCode(rsp.getRspcode());
        return response;
    }

    /**
     * 根据订单ID获取预约订单的排名
     *
     * @param orderId 订单ID
     * @return ResponseMessage
     */
    @RequestMapping(value = "/getReserveRanking/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据订单ID获取当前订单在预约队列的位置", notes = "获取当前订单在预约队列的位置", httpMethod = "GET", produces = "application/json")
    public ResponseMessage<QueueLocationRsp> getReserveRanking(
            @ApiParam(value = "订单ID", required = true) @PathVariable("orderId") String orderId) {
        ResponseMessage<QueueLocationRsp> response = new ResponseMessage<>();
        final QueueLocationRsp rsp = this.orderService.getOrderLocation(orderId);
        new ResponseMessage<QueueLocationRsp>().setReturnData(response, rsp, rsp);
        return response;
    }

    /**
     * 获取当天剩余可预约数
     *
     * @param userId 用户ID
     * @return ResponseMessage
     */
    @RequestMapping(value = "/getRemainReserveAmount/{userId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取当天剩余可预约数", notes = "获取当天剩余可预约数", httpMethod = "GET", produces = "application/json")
    public ResponseMessage<ReserveAmountRsp> getRemainReserveAmount(
            @ApiParam(value = "用户ID", required = true) @PathVariable("userId") String userId) {
        ResponseMessage<ReserveAmountRsp> response = new ResponseMessage<>();
        final ReserveAmountRsp rsp = this.orderService.getRemainAmount(userId);
        new ResponseMessage<ReserveAmountRsp>().setReturnData(response, rsp, rsp);
        return response;
    }

    /**
     * 根据用户ID查询订单列表
     *
     * @param userId 用户ID
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getReservationOrderList/{userId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据用户ID查询订单列表", notes = "查询订单", httpMethod = "GET", produces = "application/json")
    public ResponseMessage<List<ReservationBO>> getReservationOrderList(
            @ApiParam(value = "用户ID", required = true) @PathVariable("userId") String userId) throws Exception {
        ResponseMessage<List<ReservationBO>> response = new ResponseMessage<>();
        final OrderReservationListRsp rsp = this.orderService.getOrderListByUserId(userId, "");
        new ResponseMessage<List<ReservationBO>>().setReturnData(response, rsp, rsp.getReservationList());
        return response;
    }

    /**
     * 根据用户ID查询今日订单列表
     *
     * @param userId 用户ID
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getTodayReservationOrderList/{userId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据用户ID查询今日订单列表", notes = "查询订单", httpMethod = "GET", produces = "application/json")
    public ResponseMessage<List<ReservationBO>> getTodayReservationOrderList(
            @ApiParam(value = "用户ID", required = true) @PathVariable("userId") String userId) throws Exception {
        ResponseMessage<List<ReservationBO>> response = new ResponseMessage<>();
        final OrderReservationListRsp rsp = this.orderService.getOrderListByUserId(userId, DateUtils.formatDate());
        new ResponseMessage<List<ReservationBO>>().setReturnData(response, rsp, rsp.getReservationList());
        return response;
    }

    /**
     * 取消预约订单
     *
     * @param orderId 订单ID
     * @return ResponseMessage
     * @throws Exception
     */
    @RequestMapping(value = "/cancelReservationOrder/{orderId}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "取消预约订单", notes = "取消订单", httpMethod = "POST", produces = "application/json")
    public ResponseMessage<ReservationBO> cancelReservationOrder(
            @ApiParam(value = "订单ID", required = true) @PathVariable("orderId") String orderId) throws Exception {
        ResponseMessage<ReservationBO> response = new ResponseMessage<>();
        OrderReservationRsp rsp = orderService.cancelReservationOrder(orderId);
        new ResponseMessage<ReservationBO>().setReturnData(response, rsp, rsp.getReservation());
        return response;
    }

    /**
     * 获取待服务的订单列表
     *
     * @return ResponseMessage
     * @throws Exception
     */
    @RequestMapping(value = "/getAwaitQueueOrdersByStatus", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取待服务的订单列表", notes = "获取订单列表", httpMethod = "GET", produces = "application/json")
    public ResponseMessage<List<ReservationBO>> getAwaitQueueOrdersByStatus() throws Exception {
        ResponseMessage<List<ReservationBO>> response = new ResponseMessage<>();
        // 状态2为等待服务商取车状态
        OrderReservationListRsp rsp = orderService.getOrderListByStatus(LeletcConstants.ORDER_STATUS_WAITING_PROVIDER);
        new ResponseMessage<List<ReservationBO>>().setReturnData(response, rsp, rsp.getReservationList());
        return response;
    }

    /**
     * 根据订单ID获取订单信息
     *
     * @param orderId 订单ID
     * @return ResponseMessage
     * @throws Exception
     */
    @RequestMapping(value = "/getReservationOrderByOrderId/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据订单ID获取订单信息", notes = "获取订单", httpMethod = "GET", produces = "application/json")
    public ResponseMessage<OrderReservationEntity> getReservationOrderByOrderId(
            @ApiParam(value = "订单ID") @PathVariable("orderId") String orderId) {
        ResponseMessage<OrderReservationEntity> respone = new ResponseMessage<>();
        OrderReservationEntity entity = commonService.get(OrderReservationEntity.class, orderId);
        if (null == entity) {
            entity = new OrderReservationEntity();
            respone.setMessage("订单不存在");
            respone.setRespCode(ResponseMessageCodeEnum.NULL_ERROR.getCode());
        } else {
            respone.setMessage("获取订单成功");
            respone.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
        }
        respone.setData(entity);
        return respone;
    }

    /**
     * 根据订单ID获取正在处理的订单列表
     *
     * @param orderId 订单ID
     * @return ResponseMessage
     * @throws Exception
     */
    @RequestMapping(value = "/getOrderHandleByOrderId/{orderId}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "根据订单ID获取正在处理的订单列表", notes = "获取处理订单", httpMethod = "GET", produces = "application/json")
    public ResponseMessage<List<OrdersHandleEntity>> getOrderHandleByOrderId(
            @ApiParam(value = "订单ID") @PathVariable("orderId") String orderId) {
        ResponseMessage<List<OrdersHandleEntity>> response = new ResponseMessage<>();
        List<OrdersHandleEntity> list = this.orderService.getOrdersHandleListByOrderId(orderId);
        if (CollectionUtils.isEmpty(list)) {
            response.setData(list);
            response.setMessage("您没有可处理的订单，快去接单吧");
            response.setRespCode(ResponseMessageCodeEnum.NULL_ERROR.getCode());
            return response;
        } else {
            response.setData(list);
            response.setMessage("返回成功");
            response.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
            return response;
        }
    }

    /**
     * 服务商接订单
     * <p>
     * 1.查询订单，是否已存在； 2.往订单处理表中插入数据； 3.返回已插入的订单处理数据。
     * </p>
     *
     * @param userId  用户ID
     * @param orderId 订单ID
     * @return ResponseMessage
     * @throws Exception
     */
    @RequestMapping(value = "/acceptReservationOrder/{userId}/{orderId}", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "服务商接订单", notes = "服务商接订单", httpMethod = "POST", produces = "application/json")
    public ResponseMessage<OrderReservationEntity> acceptReservationOrder(
            @ApiParam(value = "用户ID", required = true) @PathVariable("userId") String userId,
            @ApiParam(value = "订单ID", required = true) @PathVariable("orderId") String orderId) throws Exception {
        ResponseMessage<OrderReservationEntity> response = new ResponseMessage<>();
        final ProviderServiceRsp rsp = orderService.acceptReservationOrder(userId, orderId);
        final OrderReservationEntity order = rsp.getOrder();
        if (null == order || StringUtils.isEmpty(order.getId())) {
            response.setMessage(rsp.getError());
        } else {
            response.setMessage(rsp.getMsg());
            // FIXME 2018-12-18 为简化流程，免掉智能柜的扫码操作(mark2)
            /*try {
                // 洗车工接单后开门取钥匙，关门存钥匙
                OrderReservationEntity reservation = rsp.getOrder();
                ScanSmartCabinetReq smartCabinetVO = new ScanSmartCabinetReq(reservation.getId(), userId, 2,
                        "18071adc0326f8fe50d", null, "LELETC20180001");
                SmartCabinetRsp smartCabinetRsp = smartCabinetCodeScannerService.scanCodeOpenDoor(smartCabinetVO);
                String boxNo = smartCabinetRsp.getSmartCabinetDoor().getBoxNo();
                // 关门
                smartCabinetVO = new ScanSmartCabinetReq(reservation.getId(), userId, 2, "18071adc0326f8fe50d", boxNo,
                        "LELETC20180001");
                smartCabinetCodeScannerService.closeDoor(smartCabinetVO);

            } catch (Exception e) {
                e.printStackTrace();
            }*/
        }
        response.setData(order);
        response.setRespCode(rsp.getRspcode());
        return response;
    }

    /**
     * 服务商洗好车完成订单
     *
     * @param userId  用户ID
     * @param orderId 订单ID
     * @return ResponseMessage
     */
    @RequestMapping(value = "/finishOrder", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "服务商洗好车完成订单", notes = "服务商洗好车完成订单", httpMethod = "POST", produces = "application/json")
    public ResponseMessage<OrderReservationBO> finishOrder(@ApiParam(value = "订单ID", required = true) String orderId,
                                                           @ApiParam(value = "用户ID", required = true) String userId) {
        ResponseMessage<OrderReservationBO> response = new ResponseMessage<>();
        // FIXME 2018-12-18 为简化流程，免掉智能柜的扫码操作(mark3)
        // 洗车工存钥匙
        /*try {
            ScanSmartCabinetReq smartCabinetVO = new ScanSmartCabinetReq(orderId, userId, 1, "18071adc0326f8fe50d",
                    null, "LELETC20180001");
            SmartCabinetRsp smartCabinetRsp = smartCabinetCodeScannerService.scanCodeOpenDoor(smartCabinetVO);
            String boxNo = smartCabinetRsp.getSmartCabinetDoor().getBoxNo();
            // 关门
            smartCabinetVO = new ScanSmartCabinetReq(orderId, userId, 1, "18071adc0326f8fe50d", boxNo,
                    "LELETC20180001");
            smartCabinetCodeScannerService.closeDoor(smartCabinetVO);

            // ---- 车主取钥匙来完成订单
            OrderReservationEntity order = this.commonService.get(OrderReservationEntity.class, orderId);

            smartCabinetVO = new ScanSmartCabinetReq(order.getId(), order.getOrderUsers(), 2, "18071adc0326f8fe50d",
                    null, "LELETC20180001");
            smartCabinetRsp = smartCabinetCodeScannerService.scanCodeOpenDoor(smartCabinetVO);
            boxNo = smartCabinetRsp.getSmartCabinetDoor().getBoxNo();
            // 关门
            smartCabinetVO = new ScanSmartCabinetReq(order.getId(), order.getOrderUsers(), 2, "18071adc0326f8fe50d",
                    boxNo, "LELETC20180001");
            smartCabinetCodeScannerService.closeDoor(smartCabinetVO);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return response;
    }

}
