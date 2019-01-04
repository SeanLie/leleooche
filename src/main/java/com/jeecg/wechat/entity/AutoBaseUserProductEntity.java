package com.jeecg.wechat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
@SuppressWarnings("serial")
public class AutoBaseUserProductEntity {
	/** 主键 */
	private java.lang.String id;
	/** 用户ID */
	private java.lang.String user_id;
	/** 产品ID */
	private java.lang.String products_id;
	/** 产品名称' */
	private java.lang.String product_name;
	/** 服务产品状态 */
	private java.lang.String product_status;
	/** 产品剩余次数 */
	private java.lang.String product_left_num;

	/**
	 * 
	 */
	public AutoBaseUserProductEntity() {
		super();
	}

	/**
	 * @param id
	 * @param user_id
	 * @param products_id
	 * @param product_name
	 * @param product_status
	 * @param product_Left_Num
	 */
	public AutoBaseUserProductEntity(String id, String user_id, String products_id, String product_name,
			String product_status, String product_left_num) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.products_id = products_id;
		this.product_name = product_name;
		this.product_status = product_status;
		this.product_left_num = product_left_num;
	}

	/**
	 * @return the id
	 */
	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name = "ID", nullable = false, length = 36)
	public java.lang.String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(java.lang.String id) {
		this.id = id;
	}

	/**
	 * @return the user_id
	 */
	public java.lang.String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(java.lang.String user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the products_id
	 */
	public java.lang.String getProducts_id() {
		return products_id;
	}

	/**
	 * @param products_id the products_id to set
	 */
	public void setProducts_id(java.lang.String products_id) {
		this.products_id = products_id;
	}

	/**
	 * @return the product_name
	 */
	public java.lang.String getProduct_name() {
		return product_name;
	}

	/**
	 * @param product_name the product_name to set
	 */
	public void setProduct_name(java.lang.String product_name) {
		this.product_name = product_name;
	}

	/**
	 * @return the product_status
	 */
	public java.lang.String getProduct_status() {
		return product_status;
	}

	/**
	 * @param product_status the product_status to set
	 */
	public void setProduct_status(java.lang.String product_status) {
		this.product_status = product_status;
	}

	/**
	 * @return the product_left_num
	 */
	public java.lang.String getProduct_left_num() {
		return product_left_num;
	}

	/**
	 * @param product_left_num the product_left_num to set
	 */
	public void setProduct_left_num(java.lang.String product_left_num) {
		this.product_left_num = product_left_num;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AutoBaseUserProductEntity [id=" + id + ", user_id=" + user_id + ", products_id=" + products_id
				+ ", product_name=" + product_name + ", product_status=" + product_status + ", product_left_num="
				+ product_left_num + "]";
	}

}
