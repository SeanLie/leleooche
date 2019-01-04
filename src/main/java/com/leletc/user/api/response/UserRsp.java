package com.leletc.user.api.response;

import org.jeecgframework.web.system.pojo.base.TSUser;

import com.leletc.product.web.bo.UserProductsBO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 功能描述：用户对象返回体
 * <p>
 *
 * @author 李斌
 *         <p>
 * @date 2018/12/15 23:39
 *       <p>
 *       修改记录：修改内容 修改人 修改时间
 *       <ul>
 *       <li></li>
 *       </ul>
 *       <p>
 *       Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 *       <p>
 */
@ApiModel(value = "userRsp", description = "返回用户对象")
public class UserRsp extends TSUser {

	@ApiModelProperty(value = "车辆信息", required = true, name = "vehicles", example = "{}")
	private String vehicles;

	@ApiModelProperty(value = "车位信息", required = true, name = "carparks", example = "{}")
	private String carparks;

	@ApiModelProperty(value = "用户产品信息", name = "userProduct", example = "{}")
	private UserProductsBO userProduct;

	public UserProductsBO getUserProduct() {
		return userProduct;
	}

	public void setUserProduct(UserProductsBO userProduct) {
		this.userProduct = userProduct;
	}

	public String getVehicles() {
		return vehicles;
	}

	public void setVehicles(String vehicles) {
		this.vehicles = vehicles;
	}

	/**
	 * @return the carparks
	 */
	public String getCarparks() {
		return carparks;
	}

	/**
	 * @param carparks the carparks to set
	 */
	public void setCarparks(String carparks) {
		this.carparks = carparks;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserRsp [vehicles=" + vehicles + ", carparks=" + carparks + ", userProduct=" + userProduct + "]";
	}

}
