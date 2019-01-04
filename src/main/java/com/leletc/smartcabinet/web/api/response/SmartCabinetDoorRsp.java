package com.leletc.smartcabinet.web.api.response;

import com.leletc.base.api.response.RspHead;
import com.leletc.smartcabinet.web.bo.SmartCabinetDoorBO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 功能描述：智能柜箱门信息响应体
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/21 16:50
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@ApiModel(value = "smartCabinetDoorRsp", description = "智能柜箱门信息响应体")
public class SmartCabinetDoorRsp extends RspHead {

    @ApiModelProperty(value = "箱门对象", name = "smartCabinetDoor", required = true, example = "{}")
    private SmartCabinetDoorBO smartCabinetDoor;

    public SmartCabinetDoorBO getSmartCabinetDoor() {
        return smartCabinetDoor;
    }

    public void setSmartCabinetDoor(SmartCabinetDoorBO smartCabinetDoor) {
        this.smartCabinetDoor = smartCabinetDoor;
    }
}
