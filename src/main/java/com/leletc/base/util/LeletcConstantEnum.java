package com.leletc.base.util;

/**
 * 功能描述：常量类的枚举
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/20 08:20
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public enum LeletcConstantEnum {

    /*************************** 订单状态 start */
    ORDER_STATUS_RESERVED(LeletcConstants.ORDER_STATUS_RESERVED, LeletcConstantName.ORDER_STATUS_RESERVED),
    ORDER_STATUS_WAITING_PROVIDER(LeletcConstants.ORDER_STATUS_WAITING_PROVIDER, LeletcConstantName.ORDER_STATUS_WAITING_PROVIDER),
    ORDER_STATUS_ACCEPTED(LeletcConstants.ORDER_STATUS_ACCEPTED, LeletcConstantName.ORDER_STATUS_ACCEPTED),
    ORDER_STATUS_IN_SERVICE(LeletcConstants.ORDER_STATUS_IN_SERVICE, LeletcConstantName.ORDER_STATUS_IN_SERVICE),
    ORDER_STATUS_WAITING_DRIVER(LeletcConstants.ORDER_STATUS_WAITING_DRIVER, LeletcConstantName.ORDER_STATUS_WAITING_DRIVER),
    ORDER_STATUS_FINISHED(LeletcConstants.ORDER_STATUS_FINISHED, LeletcConstantName.ORDER_STATUS_FINISHED),
    ORDER_STATUS_CANCELED(LeletcConstants.ORDER_STATUS_CANCELED, LeletcConstantName.ORDER_STATUS_CANCELED);
    /*************************** 订单状态 end */

    // 添加常量枚举请按照以上方式规范进行

    private String value;
    private String name;

    LeletcConstantEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
