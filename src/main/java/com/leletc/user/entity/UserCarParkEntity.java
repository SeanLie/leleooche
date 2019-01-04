/**
 * 实体Entity层
 */
package com.leletc.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * 功能描述：用户车辆信息表实体类
 * <p>
 *
 * @author Sean
 *         <p>
 * @date 2018-12-15 20:19:04
 *       <p>
 *       修改记录：修改内容 修改人 修改时间
 *       <ul>
 *       <li></li>
 *       </ul>
 *       <p>
 *       Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 *       <p>
 */
@Entity
@Table(name = "auto_user_carpark")
public class UserCarParkEntity implements java.io.Serializable {

	/**
	 * 主键
	 */
	private String id;
	/**
	 * 用户ID
	 */
	@Excel(name = "用户ID", width = 15, dictTable = "t_s_user", dicCode = "user_id", dicText = "id")
	private String userId;
	/**
	 * 车牌号
	 */
	@Excel(name = "车停车位", width = 15)
	private String park_num;
	/**
	 * 车型号
	 */
	@Excel(name = "地点", width = 15)
	private String park_add;
	/**
	 * 创建人名称
	 */
	private String createName;
	/**
	 * 创建人登录名称
	 */
	private String createBy;
	/**
	 * 创建日期
	 */
	private Date createDate;
	/**
	 * 更新人名称
	 */
	private String updateName;
	/**
	 * 更新人登录名称
	 */
	private String updateBy;
	/**
	 * 更新日期
	 */
	private Date updateDate;

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "ID", nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 主键
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 用户ID
	 */

	@Column(name = "USER_ID", nullable = true, length = 36)
	public String getUserId() {
		return this.userId;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the park_num
	 */
	@Column(name = "PARK_NUM", nullable = false, length = 32)
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
	@Column(name = "PARK_ADD", nullable = false, length = 32)
	public String getPark_add() {
		return park_add;
	}

	/**
	 * @param park_add the park_add to set
	 */
	public void setPark_add(String park_add) {
		this.park_add = park_add;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 创建人名称
	 */

	@Column(name = "CREATE_NAME", nullable = true, length = 50)
	public String getCreateName() {
		return this.createName;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 创建人名称
	 */
	public void setCreateName(String createName) {
		this.createName = createName;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 创建人登录名称
	 */

	@Column(name = "CREATE_BY", nullable = true, length = 50)
	public String getCreateBy() {
		return this.createBy;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 创建人登录名称
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * 方法: 取得java.util.Date
	 *
	 * @return: java.util.Date 创建日期
	 */

	@Column(name = "CREATE_DATE", nullable = true, length = 20)
	public Date getCreateDate() {
		return this.createDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 *
	 * @param: java.util.Date 创建日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 更新人名称
	 */

	@Column(name = "UPDATE_NAME", nullable = true, length = 50)
	public String getUpdateName() {
		return this.updateName;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 更新人名称
	 */
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	/**
	 * 方法: 取得java.lang.String
	 *
	 * @return: java.lang.String 更新人登录名称
	 */

	@Column(name = "UPDATE_BY", nullable = true, length = 50)
	public String getUpdateBy() {
		return this.updateBy;
	}

	/**
	 * 方法: 设置java.lang.String
	 *
	 * @param: java.lang.String 更新人登录名称
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * 方法: 取得java.util.Date
	 *
	 * @return: java.util.Date 更新日期
	 */

	@Column(name = "UPDATE_DATE", nullable = true, length = 20)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 *
	 * @param: java.util.Date 更新日期
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserCarParkEntity [id=" + id + ", userId=" + userId + ", park_num=" + park_num + ", park_add="
				+ park_add + ", createName=" + createName + ", createBy=" + createBy + ", createDate=" + createDate
				+ ", updateName=" + updateName + ", updateBy=" + updateBy + ", updateDate=" + updateDate + "]";
	}

}