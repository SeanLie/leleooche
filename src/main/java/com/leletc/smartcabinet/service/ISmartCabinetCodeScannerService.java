package com.leletc.smartcabinet.service;

import org.jeecgframework.core.common.service.CommonService;

import com.leletc.oocheorder.entity.OrderReservationEntity;
import com.leletc.smartcabinet.web.api.response.SmartCabinetDoorRsp;
import com.leletc.smartcabinet.web.api.response.SmartCabinetRsp;
import com.leletc.smartcabinet.web.vo.ScanSmartCabinetReq;

/**
 * 功能描述：扫描柜子二维码业务类接口
 * <p>
 *
 * @author 李斌
 *         <p>
 * @date 2018/10/13 00:30
 *       <p>
 *       修改记录：修改内容 修改人 修改时间
 *       <ul>
 *       <li></li>
 *       </ul>
 *       <p>
 *       Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 *       <p>
 */
public interface ISmartCabinetCodeScannerService extends CommonService {

	/**
	 * 扫描柜子二维码开箱门
	 *
	 * @param smartCabinetVO 柜子请求对象
	 * @return SmartCabinetRsp
	 * @description 扫描柜子二维码开箱门
	 * @author 李斌
	 * @date 2018/11/01 17:20
	 */
	SmartCabinetRsp scanCodeOpenDoor(ScanSmartCabinetReq smartCabinetVO) throws Exception;

	/**
	 * 关箱门
	 *
	 * @param smartCabinetVO 智能柜请求对象
	 * @return SmartCabinetRsp
	 * @throws Exception
	 */
	SmartCabinetRsp closeDoor(ScanSmartCabinetReq smartCabinetVO) throws Exception;

	/**
	 * 查询箱门状态
	 *
	 * @param doorId 箱门ID
	 * @return SmartCabinetDoorRsp
	 */
	SmartCabinetDoorRsp getDoorStatus(String doorId);

	/**
	 * 通过订单状态查询订单
	 *
	 * @param orderStatusReserved 订单ID
	 * @return OrderReservationEntity
	 */
	OrderReservationEntity getOrderByUser(String userId, String orderStatusReserved);

	/**
	 * 用户直接扫一扫开箱门
	 *
	 * @param smartCabinetVO 柜子请求对象
	 * @return SmartCabinetRsp
	 * @description 扫描柜子二维码开箱门
	 * @author 李斌
	 * @date 2018/11/01 17:20
	 */
	//SmartCabinetRsp scanCodeOpenDoorAgain(ScanSmartCabinetReq smartCabinetVO) throws Exception;
}
