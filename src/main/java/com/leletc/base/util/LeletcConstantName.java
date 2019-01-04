package com.leletc.base.util;

/**
 * 功能描述：常量值对应的名称类
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/20 08:19
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public class LeletcConstantName {

    /*************************** 订单状态 start */

    /** 订单状态：1=车主已预约 */
    public static final String ORDER_STATUS_RESERVED = "已预约";
    /** 订单状态：2=车主已存车，待接单 */
    public static final String ORDER_STATUS_WAITING_PROVIDER = "待接单";
    /** 订单状态：3=供应商已接单，待供应商洗车 */
    public static final String ORDER_STATUS_ACCEPTED = "待洗车";
    /** 订单状态：4=供应商已取车，洗车中 */
    public static final String ORDER_STATUS_IN_SERVICE = "洗车中";
    /** 订单状态：5=供应商已洗好车，待取车 */
    public static final String ORDER_STATUS_WAITING_DRIVER = "待取车";
    /** 订单状态：6=车主已取车，已完成，服务结束 */
    public static final String ORDER_STATUS_FINISHED = "已完成";
    /** 订单状态：6=车主已取消 */
    public static final String ORDER_STATUS_CANCELED = "已取消";

    /*************************** 订单状态 end */

    // 添加常量请按照以上方式规范进行

    public static void main(String[] args) {
        String reserved = LeletcConstantEnum.ORDER_STATUS_RESERVED.getValue() + "=" + LeletcConstantEnum.ORDER_STATUS_RESERVED.getName();
        String provider = LeletcConstantEnum.ORDER_STATUS_WAITING_PROVIDER.getValue() + "=" + LeletcConstantEnum.ORDER_STATUS_WAITING_PROVIDER.getName();
        String accepted = LeletcConstantEnum.ORDER_STATUS_ACCEPTED.getValue() + "=" + LeletcConstantEnum.ORDER_STATUS_ACCEPTED.getName();
        String inService = LeletcConstantEnum.ORDER_STATUS_IN_SERVICE.getValue() + "=" + LeletcConstantEnum.ORDER_STATUS_IN_SERVICE.getName();
        String driver = LeletcConstantEnum.ORDER_STATUS_WAITING_DRIVER.getValue() + "=" + LeletcConstantEnum.ORDER_STATUS_WAITING_DRIVER.getName();
        String finished = LeletcConstantEnum.ORDER_STATUS_FINISHED.getValue() + "=" + LeletcConstantEnum.ORDER_STATUS_FINISHED.getName();
        System.out.println(reserved);
        System.out.println(provider);
        System.out.println(accepted);
        System.out.println(inService);
        System.out.println(driver);
        System.out.println(finished);
    }

}
