package com.leletc.user.api.response;

import com.leletc.base.api.response.RspHead;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * 功能描述：车辆信息响应对象
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/12/26 22:00
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018/12/26, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@ApiModel(value = "carManagement", description = "车辆信息响应对象")
public class CarManagementRsp extends RspHead {

    private String userId;

    private String carNum;

    private String model;

    private Date age;

    private String desc;

    public CarManagementRsp(String userId, String carNum, String model, Date age, String desc) {
        super();
        this.userId = userId;
        this.carNum = carNum;
        this.model = model;
        this.age = age;
        this.desc = desc;
    }

    public CarManagementRsp() {
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the carNum
     */
    public String getCarNum() {
        return carNum;
    }

    /**
     * @param carNum the carNum to set
     */
    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the age
     */
    public Date getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Date age) {
        this.age = age;
    }

    /**
     * @return the dESC
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param dESC the dESC to set
     */
    public void setDesc(String dESC) {
        desc = dESC;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CarManagementReq [userId=" + userId + ", carNum=" + carNum + ", model=" + model + ", age=" + age
                + ", desc=" + desc + "]";
    }

}
