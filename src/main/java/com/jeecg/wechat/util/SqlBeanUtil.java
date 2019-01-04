package com.jeecg.wechat.util;

public class SqlBeanUtil {

	public final static String HOST = "59.110.223.159:9001";

	// public final static String select_wxUser_OpenId = "http://" + HOST +
	// "/api/users/OPENID/byWXOpenID";
	// public final static String select_tsUser_id = "http://" + HOST +
	// "/api/users/USERID";
	// public final static String select_tsUser_telnum = "http://" + HOST +
	// "/api/users/TELNUM/byTel";

	//public final static String select_autoBaseUserProducts_userid = "http://" + HOST + "/api/products/USERID/byUser";

	//public final static String post_autoBaseUserProducts_userid = "http://" + HOST + "/api/baseUserProduct";

	// public final static String select_autoBaseUserProductsLeftNum = "http://" +
	// HOST
	// + "/api/products/leftNum/USERID/PRODUCTID";
	//public final static String select_autoBaseProducts_list = "http://" + HOST + "/api/products/userID/parentId";
	// public final static String select_autoBaseProducts_orgCode = null;
//	public final static String select_tsDepart_departid = "http://" + HOST + "/api/tsDepart/DEPARTID/byTSDepart";
	// public final static String insert_wxUser = "http://" + HOST + "/api/users/";
	// public final static String insert_autoBaseFile = "http://" + HOST +
	// "/api/File/";

	// public final static String select_autoBaseFile_byId = "http://" + HOST +
	// "/api/File/ID";

	// public final static String delete_autoBaseFile = "http://" + HOST + "/api/deleteautoBaseFile/SAVEPATH/FILENAME";
	// 获取队列数据
	//public final static String select_autoOrdersQueue_getQueueNo = "http://" + HOST + "/api/orders/noDesc/first";
	// 查看预约订单是否已经满
	//public final static String select_autoOrdersReservation_count = "http://" + HOST + "/api/orders/queueCount";
	// 插入订单的接口
	//public final static String insert_autoOrdersReservation = "http://" + HOST + "/api/orders";
	// 获取订单用户列表的接口，车行从autoOrderhandle表里面关联订单表获取，用户直接从订单表获取
	//public final static String getAutoOrdersReservationList = "http://" + HOST + "/api/orders/USERID/byUser";

	// 取消订单用户单一的接口(参数：orderid/orderstatus)
	//public final static String cancelAutoOrdersReservationSingle = "http://" + HOST + "/api/orders/orderid/orderstatus/statusremark";
	// 获取当天订单列表接口(参数：你后台搜索通过当天查询)
	//public final static String getCurrentReservationOrderList = "http://" + HOST + "/api/orders/today";
	// 获取所有订单列表接口(参数：无) 取前100订单列表
	//public final static String getALLReservationOrderList = "http://" + HOST + "/api/orders/top100";
	// 更新订单状态(参数：orderid/orderstatus/statusremark)
	//public final static String updateReservationOrderByStatus = "http://" + HOST + "/api/orders/orderid/orderstatus/statusremark";
	// 接单 更新订单状态(参数：userid)
	//public final static String postOrderTakingByUserId = "http://" + HOST + "/api/orders/orderTaking/USERID";

	// 插入auto_orders_handle数据
	//public final static String insert_autoOrdersHandle = "http://" + HOST + "/api/orderHandles";
	// 根据订单ID 获取auto_orders_handle数据
	//public final static String getAutoOrdersHandleByOrderId = "http://" + HOST + "/api/orderHandles/orderid";
	// 获取某一状态订单接口(参数：userid/orderid/orderstatus)
	//public final static String getReservationOrderByStatus = "http://" + HOST + "/api/orders/orderstatus/byStatus";
	// api/orders/{status}/byStatus
	// 问题接口
	// 获取订单用户单一的接口(参数：orderid)
	// public final static String getAutoOrdersReservationSingle = "http://" + HOST
	// + "/api/orders/orderid";

}
