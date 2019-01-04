package com.leletc.base.util;

/**
 * 功能描述：常量类
 * <p>
 * 作者：李斌
 * <p>
 * 日期：2018/10/29 21:10
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public class LeletcConstants {

	/*************************** 平台类型 start */

	/** 平台：全部 */
	public static final String PLATFORM_ALL = "all";
	/** 平台：微信 */
	public static final String PLATFORM_WX = "wx";
	/** 平台：APP */
	public static final String PLATFORM_APP = "app";
	/** 平台：PC网页 */
	public static final String PLATFORM_WEB = "web";
	/** 平台：WAP网页 */
	public static final String PLATFORM_WAP = "wap";

	/*************************** 平台类型 end */

	/*************************** 订单状态 start */

	/** 订单状态：1=车主已预约 */
	public static final String ORDER_STATUS_RESERVED = "1";
	/** 订单状态：2=车主已存车，待供应商接单 */
	public static final String ORDER_STATUS_WAITING_PROVIDER = "2";
	/** 订单状态：3=供应商已接单，待供应商取车 */
	public static final String ORDER_STATUS_ACCEPTED = "3";
	/** 订单状态：4=供应商已取车，正在服务中 */
	public static final String ORDER_STATUS_IN_SERVICE = "4";
	/** 订单状态：5=供应商已洗好车，待车主取车 */
	public static final String ORDER_STATUS_WAITING_DRIVER = "5";
	/** 订单状态：6=车主已取车，服务结束 */
	public static final String ORDER_STATUS_FINISHED = "6";
	/** 订单状态：-1=车主已取消 */
	public static final String ORDER_STATUS_CANCELED = "-1";

	/*************************** 订单状态 end */

	/*************************** 人员类型 start */

	/** 人员类型：1=供应商 */
	public static final String PERSON_TYPE_PROVIDER = "1";
	/** 人员类型；2=合作商 */
	public static final String PERSON_TYPE_PARTNER = "2";
	/** 人员类型；3=自由群体，普通人 */
	public static final String PERSON_TYPE_NORMAL = "3";
	/** 人员类型；4=本公司 */
	public static final String PERSON_TYPE_OUR_COMPANY = "4";

	/*************************** 人员类型 end */

	/*************************** 洗车业务类型 start */

	/** 洗车：1=存钥匙 */
	public static final int WASH_CAR_BIZ_TYPE_SAVE_KEY = 1;
	/** 洗车：2=取钥匙 */
	public static final int WASH_CAR_BIZ_TYPE_GET_KEY = 2;

	/*************************** 洗车业务类型 end */

	/*************************** 人员级别:部门架构越高，级别越高,目前只有2级,1级，0级，高级低级 start */

	/** 0=普通游客等级 */
	public static final String PERSON_LEVEL_VISITOR_0 = "0";
	/** 1=普通用户 */
	public static final String PERSON_LEVEL_GENERAL_1 = "1";
	/** 2=贵宾用户 */
	public static final String PERSON_LEVEL_VIP_2 = "2";

	/*************************** 人员级别 end */

	// 添加常量请按照以上方式规范进行

}
