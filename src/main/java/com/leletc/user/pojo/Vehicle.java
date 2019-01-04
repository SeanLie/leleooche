package com.leletc.user.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 功能描述：用户座驾
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/13 00:30
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@ApiModel(value = "vehicle", description = "用户座驾")
public class Vehicle {

    /**
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号", required = true, name = "carNum", example = "粤B123456")
    private String carNum;
    /**
     * 车型号
     */
    @ApiModelProperty(value = "车型号", required = true, name = "model", example = "马自达")
    private String model;
    /**
     * 购置日期
     */
    @ApiModelProperty(value = "购置日期", required = true, name = "age", example = "2018-10-12T15:20:20.123Z")
    private Date age;
    /**
     * 描述
     */
    @ApiModelProperty(value = "描述", required = true, name = "desc", example = "详细描述")
    private String desc;

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
