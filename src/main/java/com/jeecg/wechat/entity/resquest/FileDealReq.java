package com.jeecg.wechat.entity.resquest;

import com.leletc.base.api.request.ReqHead;

public class FileDealReq extends ReqHead {

	/** 使用者ID,t_s_user表主键 */
	private String user_id;

	// 文件ID，为了去获取数据库图片的时候可以传递这个
	private String id;

	/** 是否有效 */
	private String isValid;

	/** 是否上传有效 */
	private String isUpValid;

	/** 是否删除有效 */
	private String isDelValid;

	// 是否将文件转换成swf
	private String swfTransform;

	// 上传业务名称,可以为空
	private String bizType;

	// 路径，isDelValid为0时候才可以
	private String path;

	/** 响应信息 */
	private String msg;

	/**
	 * 
	 */
	public FileDealReq() {
		super();
	}

	/**
	 * @param user_id
	 * @param id
	 * @param isValid
	 * @param isUpValid
	 * @param isDelValid
	 * @param swfTransform
	 * @param bizType
	 * @param path
	 * @param msg
	 */
	public FileDealReq(String user_id, String id, String isValid, String isUpValid, String isDelValid,
			String swfTransform, String bizType, String path, String msg) {
		super();
		this.user_id = user_id;
		this.id = id;
		this.isValid = isValid;
		this.isUpValid = isUpValid;
		this.isDelValid = isDelValid;
		this.swfTransform = swfTransform;
		this.bizType = bizType;
		this.path = path;
		this.msg = msg;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the isValid
	 */
	public String getIsValid() {
		return isValid;
	}

	/**
	 * @param isValid the isValid to set
	 */
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	/**
	 * @return the isUpValid
	 */
	public String getIsUpValid() {
		return isUpValid;
	}

	/**
	 * @param isUpValid the isUpValid to set
	 */
	public void setIsUpValid(String isUpValid) {
		this.isUpValid = isUpValid;
	}

	/**
	 * @return the isDelValid
	 */
	public String getIsDelValid() {
		return isDelValid;
	}

	/**
	 * @param isDelValid the isDelValid to set
	 */
	public void setIsDelValid(String isDelValid) {
		this.isDelValid = isDelValid;
	}

	/**
	 * @return the swfTransform
	 */
	public String getSwfTransform() {
		return swfTransform;
	}

	/**
	 * @param swfTransform the swfTransform to set
	 */
	public void setSwfTransform(String swfTransform) {
		this.swfTransform = swfTransform;
	}

	/**
	 * @return the bizType
	 */
	public String getBizType() {
		return bizType;
	}

	/**
	 * @param bizType the bizType to set
	 */
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FileDealReq [user_id=" + user_id + ", id=" + id + ", isValid=" + isValid + ", isUpValid=" + isUpValid
				+ ", isDelValid=" + isDelValid + ", swfTransform=" + swfTransform + ", bizType=" + bizType + ", path="
				+ path + ", msg=" + msg + "]";
	}

}
