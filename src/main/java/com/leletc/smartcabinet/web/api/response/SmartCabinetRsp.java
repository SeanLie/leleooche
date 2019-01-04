package com.leletc.smartcabinet.web.api.response;

import com.leletc.base.api.response.RspHead;
import com.leletc.smartcabinet.web.bo.SmartCabinetDoorBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 功能描述：智能柜响应类
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/12 17:31
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@ApiModel(value = "smartCabinetRsp", description = "智能柜响应对象")
public class SmartCabinetRsp extends RspHead {

    @ApiModelProperty(value = "智能柜信息", name = "smartCabinetDoor", required = true, example = "{}")
    private SmartCabinetDoorBO smartCabinetDoor;

    public SmartCabinetDoorBO getSmartCabinetDoor() {
        return smartCabinetDoor;
    }

    public void setSmartCabinetDoor(SmartCabinetDoorBO smartCabinetDoor) {
        this.smartCabinetDoor = smartCabinetDoor;
    }
}
