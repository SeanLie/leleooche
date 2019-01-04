package com.leletc.user.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 功能描述：用户座驾
 * <p>
 *
 * @author 李斌
 *         <p>
 * @date 2018/11/13 00:30
 *       <p>
 *       修改记录：修改内容 修改人 修改时间
 *       <ul>
 *       <li></li>
 *       </ul>
 *       <p>
 *       Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 *       <p>
 */
@ApiModel(value = "carPark", description = "用户停车位")
public class CarPark {

	/**
	 * 车牌号
	 */
	@ApiModelProperty(value = "停车位", required = true, name = "park_num", example = "108")
	private String park_num;
	/**
	 * 车型号
	 */
	@ApiModelProperty(value = "停车位地点", required = true, name = "park_add", example = "中国移动大厦")
	private String park_add;

	/**
	 * @return the park_num
	 */
	public String getPark_num() {
		return park_num;
	}

	/**
	 * @param park_num the park_num to set
	 */
	public void setPark_num(String park_num) {
		this.park_num = park_num;
	}

	/**
	 * @return the park_add
	 */
	public String getPark_add() {
		return park_add;
	}

	/**
	 * @param park_add the park_add to set
	 */
	public void setPark_add(String park_add) {
		this.park_add = park_add;
	}

}
