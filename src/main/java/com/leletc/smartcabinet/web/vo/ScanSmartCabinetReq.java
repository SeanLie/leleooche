package com.leletc.smartcabinet.web.vo;

import com.leletc.base.api.request.ReqHead;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 功能描述：扫描智能柜子请求视图对象
 * <p>
 *
 * @author 李斌
 *         <p>
 * @date 2018/11/05 18:17
 *       <p>
 *       修改记录：修改内容 修改人 修改时间
 *       <ul>
 *       <li></li>
 *       </ul>
 *       <p>
 *       Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 *       <p>
 */
@ApiModel(value = "smartCabinet", description = "智能柜扫码请求对象")
public class ScanSmartCabinetReq extends ReqHead {

	// private String wxUserToken;
	@ApiModelProperty(value = "订单ID", name = "orderId", required = true)
	private String orderId;
	@ApiModelProperty(value = "用户ID", name = "userId", required = true)
	private String userId;
	@ApiModelProperty(value = "业务类型(1:存钥匙，2:取钥匙)", name = "bizType", required = true, example = "1")
	private Integer bizType;
	@ApiModelProperty(value = "柜子标识码", name = "token", required = true, example = "123adb")
	private String token;
	@ApiModelProperty(value = "格口号", name = "boxNo", required = true, example = "1")
	private String boxNo;
	@ApiModelProperty(value = "柜子编号", name = "cabinetNo", example = "LELETC20180001")
	private String cabinetNo;

	public ScanSmartCabinetReq(String orderId, String userId, Integer bizType, String token, String boxNo,
			String cabinetNo) {
		this.orderId = orderId;
		this.userId = userId;
		this.bizType = bizType;
		this.token = token;
		this.boxNo = boxNo;
		this.cabinetNo = cabinetNo;
	}

	public ScanSmartCabinetReq(Integer bizType, String token, String boxNo, String cabinetNo) {
		this.bizType = bizType;
		this.token = token;
		this.boxNo = boxNo;
		this.cabinetNo = cabinetNo;
	}

	public ScanSmartCabinetReq() {
	}

	/*
	 * public String getWxUserToken() { return wxUserToken; }
	 * 
	 * public void setWxUserToken(String wxUserToken) { this.wxUserToken =
	 * wxUserToken; }
	 */

	/**
	 * 订单ID
	 *
	 * @return
	 */
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * 用户ID
	 *
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 业务类型（1：存，2：取）
	 *
	 * @return
	 */
	public Integer getBizType() {
		return bizType;
	}

	public void setBizType(Integer bizType) {
		this.bizType = bizType;
	}

	/**
	 * 柜子唯一标识码
	 *
	 * @return
	 */
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * 箱门号
	 *
	 * @return
	 */
	public String getBoxNo() {
		return boxNo;
	}

	public void setBoxNo(String boxNo) {
		this.boxNo = boxNo;
	}

	public String getCabinetNo() {
		return cabinetNo;
	}

	public void setCabinetNo(String cabinetNo) {
		this.cabinetNo = cabinetNo;
	}

	@Override
	public String toString() {
		return "ScanSmartCabinetReq{" + "orderId='" + orderId + '\'' + ", userId='" + userId + '\'' + ", bizType="
				+ bizType + ", token='" + token + '\'' + ", boxNo='" + boxNo + '\'' + ", cabinetNo='" + cabinetNo + '\''
				+ '}';
	}
}
