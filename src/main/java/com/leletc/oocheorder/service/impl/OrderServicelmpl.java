package com.leletc.oocheorder.service.impl;

import com.jeecg.wechat.util.OrderUtil;
import com.leletc.base.api.response.RspHead;
import com.leletc.base.util.LeletcConstantEnum;
import com.leletc.base.util.LeletcConstants;
import com.leletc.oocheorder.dao.OrderHandleDao;
import com.leletc.oocheorder.dao.OrderHandleReservationDao;
import com.leletc.oocheorder.dao.OrderQueueDao;
import com.leletc.oocheorder.dao.OrderReservationDao;
import com.leletc.oocheorder.entity.OrderReservationEntity;
import com.leletc.oocheorder.entity.OrdersHandleEntity;
import com.leletc.oocheorder.entity.OrdersQueueEntity;
import com.leletc.oocheorder.service.IOrderService;
import com.leletc.oocheorder.web.api.request.OrderReservationReq;
import com.leletc.oocheorder.web.api.request.ReserveRsp;
import com.leletc.oocheorder.web.api.response.*;
import com.leletc.oocheorder.web.bo.OrderBO;
import com.leletc.oocheorder.web.bo.ReservationBO;
import com.leletc.product.dao.UserProductsDao;
import com.leletc.product.entity.BaseUserProductsEntity;
import com.leletc.reservecfg.dao.ReservePermissionConfigDao;
import com.leletc.reservecfg.dao.ReserveUserCfgDao;
import com.leletc.reservecfg.entity.AutoReservePermissionsConfigEntity;
import com.leletc.smartcabinet.dao.SmartCabinetDoorDao;
import com.leletc.smartcabinet.entity.SmartCabinetDoorEntity;
import com.leletc.smartcabinet.web.vo.ScanSmartCabinetReq;
import com.leletc.user.dao.UserBoxCfgDao;
import com.leletc.user.dao.UserVehicleDao;
import com.leletc.user.entity.UserVehicleEntity;
import io.jsonwebtoken.lang.Collections;
import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.jwt.util.menu.ResponseMessageCodeEnum;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * 功能描述：订单业务实现类
 * <p>
 *
 * @author 李斌
 *         <p>
 * @date 2018/11/11 01:13
 *       <p>
 *       修改记录：修改内容 修改人 修改时间
 *       <ul>
 *       <li></li>
 *       </ul>
 *       <p>
 *       Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 *       <p>
 */
@Service("orderService")
@Transactional
public class OrderServicelmpl extends CommonServiceImpl implements IOrderService {

	private static final String TAG = OrderServicelmpl.class.getSimpleName() + " - 预约订单 - ";

	private static Logger logger = LoggerFactory.getLogger(OrderServicelmpl.class);

	@Autowired
	private OrderReservationDao orderReservationDao;

	@Autowired
	private OrderHandleDao orderHandleDao;

	@Autowired
	private OrderHandleReservationDao orderHandleReservationDao;

	@Autowired
	private UserProductsDao userProductsDao;

	@Autowired
	private ReservePermissionConfigDao reservePermissionConfigDao;

	@Autowired
	private OrderQueueDao orderQueueDao;

	@Autowired
	private ReserveUserCfgDao reserveUserCfgDao;

	@Autowired
	private UserVehicleDao userVehicleDao;

	@Autowired
	private SmartCabinetDoorDao smartCabinetDoorDao;

	@Autowired
	private UserBoxCfgDao userBoxCfgDao;

	@Override
	public synchronized OrderReservationRsp reserve(OrderReservationReq orderReq) throws Exception {
		OrderReservationRsp rsp = new OrderReservationRsp();
		rsp.setMsg("预约成功");
		rsp.setRspcode(ResponseMessageCodeEnum.SUCCESS.getCode());
		rsp.setChannel(LeletcConstants.PLATFORM_WX);
		// 预约流程：
		// 1.拍照不能为空
		// 2.产品类型不能为空
		// 3.是否还有剩余次数
		if (StringUtils.isBlank(orderReq.getParkNo())) {
			logger.error(TAG + "{}", "车位号不能为空");
			rsp.setMsg("车位号不能为空");
			rsp.setRspcode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			return rsp;
		}
		if (StringUtils.isBlank(orderReq.getParkNo())) {
			logger.error(TAG + "{}", "停车位置不能为空");
			rsp.setMsg("停车位置不能为空");
			rsp.setRspcode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			return rsp;
		}

		if (StringUtils.isBlank(orderReq.getProductId())) {
			logger.error(TAG + "{}", "产品类型不能为空");
			rsp.setMsg("产品类型不能为空");
			rsp.setRspcode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			return rsp;
		}
		// 通过orderReq.getUserId() 获得user对象
		// 获得用户信息
		final TSUser user = this.get(TSUser.class, orderReq.getUserId());
		if (StringUtils.isBlank(orderReq.getParkPhoto())
				&& !user.getPersonLevel().equals(LeletcConstants.PERSON_LEVEL_VIP_2)) {
			logger.error(TAG + "{}", "未上传照片");
			rsp.setError("未上传照片");
			rsp.setRspcode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			return rsp;
		}
		// 判断车位
        if (!StringUtils.isNumeric(orderReq.getParkNo())) {
            logger.error(TAG + "{}", "车位号输入不正确");
            rsp.setError("车位号输入不正确");
            rsp.setRspcode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
            return rsp;
        } else {
            int k = Integer.parseInt(orderReq.getParkNo());
            // 车位固定设置 301到 399
            if (!user.getPersonLevel().equals(LeletcConstants.PERSON_LEVEL_VIP_2)) {
                if (k < 301 || k > 399) {
                    logger.error(TAG + "{}", "请将您的爱车停在负4楼");
                    rsp.setError("请将您的爱车停在负4楼");
                    rsp.setRspcode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
                    return rsp;
                }
            }
        }
		// 判断是否允许预约
		ReserveRsp reserveRsp = isPermitReserve(orderReq.getUserId(), orderReq.getProductId(),
				orderReq.getPlateNumber());
		if (!reserveRsp.getRspcode().equals(ResponseMessageCodeEnum.SUCCESS.getCode())) {
			rsp.setError(reserveRsp.getMsg());
			rsp.setRspcode(reserveRsp.getRspcode());
			return rsp;
		}
		// 是否能够提前预约
		final Map<String, Integer> advanceDays = reserveUserCfgDao.getAdvanceDays(orderReq.getUserId(),
				orderReq.getProductId());
		if (null == advanceDays) {
			logger.error(TAG + "{}", "对不起，您不满足预约条件");
			rsp.setMsg("对不起，您不满足预约条件");
			rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
			return rsp;
		}
		final Integer userAdvanceDays = advanceDays.get("user_advance_days");
		// 订单时间-可提前天数=今天
		if (Integer.parseInt(DateUtils.formatDateYMD(orderReq.getOrderTime())) - userAdvanceDays > Integer
				.parseInt(DateUtils.formatDateYMD(new Date()))) {
			if (userAdvanceDays == 0) {
				logger.error(TAG + "{}", "对不起，您不能提前预约");
				rsp.setMsg("对不起，您不能提前预约");
			} else {
				logger.error(TAG + "{}", "对不起，您只能提前 " + userAdvanceDays + " 天预约");
				rsp.setMsg("对不起，您只能提前 " + userAdvanceDays + " 天预约");
			}
			rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
			return rsp;
		}
		// --------------- 1.保存订单信息
		logger.debug(TAG + "{}", "开始新增订单...");
		OrderReservationEntity orderEntity = new OrderReservationEntity();
		MyBeanUtils.copyBeanNotNull2Bean(orderReq, orderEntity);
		orderEntity.setOrderUsers(user.getId());
		orderEntity.setOrderStatus(LeletcConstants.ORDER_STATUS_RESERVED);
		orderEntity.setStatusName(LeletcConstantEnum.ORDER_STATUS_RESERVED.getName());
		orderEntity.setStatusRemark("车主[ " + user.getNickname() + " ]已预约");
		orderEntity.setCreateBy(user.getId());
		orderEntity.setCreateDate(new Date());
		orderEntity.setCreateName(StringUtils.isNotBlank(user.getRealName()) ? user.getRealName() : user.getNickname());
		orderEntity.setOrderCode(OrderUtil.getOrderNo());
		orderEntity.setParkSpace("中国移动深圳公司");
		orderEntity.setOrderLevel(
				Integer.parseInt(StringUtils.isEmpty(user.getPersonLevel()) ? "0" : user.getPersonLevel()));
		final String orderId = (String) this.save(orderEntity);
		if (StringUtils.isBlank(orderId)) {
			logger.error(TAG + "{}", "保存订单失败");
			rsp.setError("保存订单失败");
			rsp.setRspcode(ResponseMessageCodeEnum.ERROR.getCode());
			return rsp;
		}
		logger.debug(TAG + "{}{}", "新增订单成功 - orderId=", orderId);
		// --------------- 2.增加订单处理信息
		OrdersHandleEntity handle = setOrdersHandleEntity(user, orderEntity, user.getId());
		handle.setDealAct("预约");
		handle.setDealDesc("车主[ " + user.getNickname() + " ]预约完成");
		// 保存订单处理信息
		if (saveOrderHandle(rsp, orderEntity, handle))
			return rsp;
		logger.debug(TAG + "{}{}", "新增订单处理信息成功 - orderId=", orderId);
		// --------------- 3.增加预约队列
		// 查询当前排队编号
		String queueNo = orderQueueDao.getMaxQueueNo(DateUtils.formatDate());
		queueNo = StringUtils.isBlank(queueNo) ? "0" : queueNo;
		OrdersQueueEntity queue = new OrdersQueueEntity();
		queue.setOrderId(orderId);
		queue.setCreateBy(user.getId());
		queue.setCreateDate(new Date());
		queue.setCreateName(StringUtils.isNotBlank(user.getRealName()) ? user.getRealName() : user.getNickname());
		queue.setQueueDate(new Date());
		queue.setQueueUser(user.getId());
		// 排队中
		queue.setQueueStatus("1");
		queue.setQueueNo((Integer.parseInt(queueNo) + 1) + "");
		final Serializable queueId = this.save(queue);
		logger.debug(TAG + "{}{}", "新增订单队列信息成功 - queueId=", queueId);
		// 更新用户产品次数减1
		BaseUserProductsEntity singleUserProduct = userProductsDao.getSingleUserProduct(user.getId(),
				orderEntity.getProductId());
		singleUserProduct.setProductLeftNum(singleUserProduct.getProductLeftNum() - 1);
		this.saveOrUpdate(singleUserProduct);
		// 返回已插入的订单
		OrderBO orderBo = new OrderBO();
		final OrderReservationEntity entity = this.get(OrderReservationEntity.class, orderId);
		ReservationBO reservationBO = setReservationBO(user, entity);
		rsp.setReservation(reservationBO);
		logger.info(TAG + "{}{}", "预约成功 - order=", orderBo.toString());
		return rsp;
	}

	/**
	 * 订单处理表实体对象
	 *
	 * @param user
	 * @param orderEntity
	 * @param handleUserId
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private OrdersHandleEntity setOrdersHandleEntity(TSUser user, OrderReservationEntity orderEntity,
			String handleUserId) throws UnsupportedEncodingException {
		OrdersHandleEntity handle = new OrdersHandleEntity();
		handle.setOrderId(orderEntity.getId());
		handle.setOrderStatus(orderEntity.getOrderStatus());
		handle.setStatusName(orderEntity.getStatusName());
		handle.setDealUserId(user.getId());
		handle.setDealUserName(user.getMobilePhone());
		handle.setDealTime(new Date());
		handle.setCreateBy(handleUserId);
		handle.setCreateDate(new Date());
		handle.setCreateName(StringUtils.isNotBlank(user.getRealName()) ? user.getRealName() : user.getNickname());
		return handle;
	}

	/**
	 * 预约业务对象
	 * 
	 * @param user
	 * @param entity
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private ReservationBO setReservationBO(TSUser user, OrderReservationEntity entity)
			throws UnsupportedEncodingException {
		ReservationBO reservationBO = new ReservationBO();
		reservationBO.setUserId(user.getId());
		reservationBO.setOrderId(entity.getId());
		reservationBO.setOrderCode(entity.getOrderCode());
		reservationBO.setStatusName(entity.getStatusName());
		reservationBO.setOrderTime(DateUtils.formatDateTime(entity.getOrderTime()));
		reservationBO.setUserName(user.getNickname());
		reservationBO.setHeadImgUrl(user.getHeadimgurl());
		List<UserVehicleEntity> vehicleList = userVehicleDao.getByUserId(user.getId());
		if (!CollectionUtils.isEmpty(vehicleList)) {
			UserVehicleEntity userVehicle = vehicleList.get(0);
			reservationBO.setVehicleModel(userVehicle.getCarModel());
		}
		reservationBO.setParkNo(entity.getParkNo());
		reservationBO.setPlateNumber(entity.getPlateNumber());
		return reservationBO;
	}

	@Override
	public ReserveRsp isPermitReserve(String userId, String productId, String plateNumber) {
		ReserveRsp rsp = new ReserveRsp();
		rsp.setMsg("允许预约");
		rsp.setRspcode(ResponseMessageCodeEnum.SUCCESS.getCode());
		rsp.setChannel(LeletcConstants.PLATFORM_WX);
		// 获取用户资料
		TSUser user = this.get(TSUser.class, userId);
		// usertype用户类型 1:系统用户 \2接口用户\3.APP
		// persontype人员类型 1.供应商\2.合作商,服务商\3.自由群体 4.我司
		// level人员级别，部门架构越高，级别越高，目前只有2级,1级，0级，高级低级
		// 人员类型为不是2或者用户类型不为3 就不允许下单
		if ((!user.getPerson_type().equals("2")) || !user.getUserType().equals("3")) {
			logger.info(TAG + "{}", "系统用户虽注册成功，但此用户非服务商用户且非供应商用户，不能进行下单，但是其他功能不影响");
			rsp.setMsg("用户注册成功，但此用户非服务商用户且非供应商用户，不能进行下单，但是其他功能不影响");
			rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
			return rsp;
		}
		// 判断该用户是否有未结束的订单，并且未结束的订单车牌号是否与当前的相同
		List<String> finishedStatusList = new ArrayList<>();
		finishedStatusList.add(LeletcConstants.ORDER_STATUS_CANCELED);
		finishedStatusList.add(LeletcConstants.ORDER_STATUS_FINISHED);
		final List<OrderReservationEntity> orderList = orderReservationDao.getNotFinishList(userId, plateNumber,
				finishedStatusList);
		if (null != orderList && orderList.size() > 0) {
			for (OrderReservationEntity order : orderList) {
				if (!order.getOrderStatus().equals(LeletcConstants.ORDER_STATUS_FINISHED)
						&& !order.getOrderStatus().equals(LeletcConstants.ORDER_STATUS_CANCELED)) {
					logger.error(TAG + "{}", "您有未结束的订单，暂时不能预约");
					rsp.setMsg("您有未结束的订单，暂时不能预约");
					rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
					return rsp;
				}
			}
		}
		// 预约剩余次数
		BaseUserProductsEntity userProductsEntity = userProductsDao.getSingleUserProduct(userId, productId);
		int remainCount = userProductsEntity.getProductLeftNum();
		if (remainCount == 0) {
			logger.error(TAG + "{}", "对不起，您当前可预约的剩余次数为0");
			rsp.setMsg("对不起，您当前可预约的剩余次数为0");
			rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
			return rsp;
		}
		// 不同等级的人判断其还有没有可用格口，有才允许其下单
		int userBoxCounts = userBoxCfgDao.getUserBoxCounts(user.getPersonLevel());
		if (userBoxCounts == 0) {
			logger.error(TAG + "{}", "对不起，当前没有可用格口");
			rsp.setMsg("对不起，当前没有可用格口");
			rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
			return rsp;
		}
		// 箱门信息
		SmartCabinetDoorEntity door;
		ScanSmartCabinetReq smartCabinetVO = new ScanSmartCabinetReq(1, "18071adc0326f8fe50d", null, "LELETC20180001");
		// 根据柜子编号查询可用的柜子信息，并分配一个柜子
		door = smartCabinetDoorDao.getFreeDoor(smartCabinetVO.getCabinetNo());
		if (null == door) {
			logger.error(TAG + " - {}", "当前柜子没有可用格口");
			rsp.setMsg("当前柜子没有可用格口");
			rsp.setRspcode(ResponseMessageCodeEnum.NULL_ERROR.getCode());
			return rsp;
		}
		// TODO 需要配置部门信息
		String departId = "2c9181af66fc93990166fcaa62790011";
		// 从机构预约权限参数表获取数据
		AutoReservePermissionsConfigEntity config = reservePermissionConfigDao.getReservePermission(departId);
		String Flag = config.getFlag();
		String resOrderNum = config.getResOrderNum();
		String resStartTime = config.getResStartTime();
		String resEndTime = config.getResEndTime();
		if (Integer.parseInt(Flag) == 0) {
			logger.error(TAG + "{}", "对不起，您所在机构未开通预约权限");
			rsp.setMsg("对不起，您所在机构未开通预约权限");
			rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
			return rsp;
		}
		// -----------end---------------
		// 获得预约队列是否已经满
		// 去表auto_orders_queue查看队列情况。
		// int queueCount = orderHandleDao.getCount(DateUtils.formatDate(new Date()));
		int queueCount = orderQueueDao.getCurrentCount(DateUtils.formatDate(new Date()));
		if (queueCount > Integer.parseInt(resOrderNum)) {
			logger.error(TAG + "{}", "对不起，今日预约已满，请明天再来");
			rsp.setMsg("对不起，今日预约已满，请明天再来");
			rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
			return rsp;
		}
		// 获得当前的时分
		final String hm = DateUtils.formatShortTime();
		final String[] hourMin = hm.split(":");
		final String[] origStartHm = resStartTime.split(":");
		// 当前预约时间范围在后台配置
		String timeErrorMsg = "当前预约时间不在允许范围内(" + resStartTime + "~" + resEndTime + ")";
		if (Integer.parseInt(hourMin[0]) < Integer.parseInt(origStartHm[0])
				|| (Integer.parseInt(hourMin[0]) == Integer.parseInt(origStartHm[0])
						&& Integer.parseInt(hourMin[1]) <= Integer.parseInt(origStartHm[1]))) {
			logger.error(TAG + "{}", timeErrorMsg);
			rsp.setMsg(timeErrorMsg);
			rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
			return rsp;
		}
		final String[] origEndHm = resEndTime.split(":");
		if (Integer.parseInt(hourMin[0]) > Integer.parseInt(origEndHm[0])
				|| (Integer.parseInt(hourMin[0]) == Integer.parseInt(origEndHm[0])
						&& Integer.parseInt(hourMin[1]) > Integer.parseInt(origEndHm[1]))) {
			logger.error(TAG + "{}", timeErrorMsg);
			rsp.setMsg(timeErrorMsg);
			rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
			return rsp;
		}
		// 获得当前系统时间 预约时间范围
		rsp.setSystenDate(new Date());
		rsp.setSystemDateDsc(resStartTime + "~" + resEndTime);
		rsp.setLeftnum(String.valueOf(remainCount));
		rsp.setOrderNum(queueCount);
		return rsp;
	}

	@Override
	public OrderReservationRsp cancelReservationOrder(String orderId) throws Exception {
		OrderReservationRsp rsp = new OrderReservationRsp();
		rsp.setRspcode(ResponseMessageCodeEnum.SUCCESS.getCode());
		rsp.setChannel(LeletcConstants.PLATFORM_WX);
		// 先去判断这个订单的状态是否为预约成功，如果是预约成功可以取消订单，如果是等待供应商取车中，那么就不允许取消
		OrderReservationEntity orderEntity = orderReservationDao.get(orderId);
		TSUser user;
		if (null != orderEntity) {
			String orderStatus = orderEntity.getOrderStatus();
			// 如果状态为1就可以取消订单
			if (orderStatus.equals(LeletcConstants.ORDER_STATUS_RESERVED)) {
				// 获得用户信息
				user = this.get(TSUser.class, orderEntity.getOrderUsers());
				// 更新订单状态为：订单已结束
				orderEntity.setUpdateBy(user.getId());
				orderEntity.setUpdateDate(new Date());
				orderEntity.setUpdateName(user.getMobilePhone());
				orderEntity.setOrderStatus(LeletcConstants.ORDER_STATUS_CANCELED);
				orderEntity.setStatusName(LeletcConstantEnum.ORDER_STATUS_CANCELED.getName());
				orderEntity.setStatusRemark("车主[ " + user.getNickname() + " ]已自主取消订单");
				this.saveOrUpdate(orderEntity);
				// 产品服务次数加回
				BaseUserProductsEntity singleUserProduct = userProductsDao.getSingleUserProduct(user.getId(),
						orderEntity.getProductId());
				singleUserProduct.setProductLeftNum(singleUserProduct.getProductLeftNum() + 1);
				this.saveOrUpdate(singleUserProduct);
				logger.info(TAG + "{}", "取消订单成功");
				// 2.增加订单处理信息
				OrdersHandleEntity handle = setOrdersHandleEntity(user, orderEntity, user.getId());
				handle.setDealAct("取消订单");
				handle.setDealUserId(user.getId());
				handle.setDealUserName(user.getMobilePhone());
				handle.setDealDesc("用户[ " + user.getNickname() + " ]取消订单");
				handle.setDealTime(new Date());
				// 保存订单处理信息
				if (saveOrderHandle(rsp, orderEntity, handle))
					return rsp;
				// ------------ 修改订单队列
				OrdersQueueEntity queue = orderQueueDao.getByOrderId(orderId);
				queue.setUpdateBy(user.getId());
				queue.setUpdateDate(new Date());
				queue.setUpdateName(user.getMobilePhone());
				// 排队结束
				queue.setQueueStatus("0");
				this.saveOrUpdate(queue);
				rsp.setMsg("取消订单成功");
				rsp.setRspcode(ResponseMessageCodeEnum.SUCCESS.getCode());
			} else {
				logger.error(TAG + "{} - {} - {}",
						new String[] { "取消订单失败，当前订单状态不允许取消", "orderId", orderId, "orderStatus=", orderStatus });
				rsp.setMsg("取消订单失败，当前订单状态不允许取消");
				rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
				return rsp;
			}
		} else {
			logger.error(TAG + "{} - {} - {}", new String[] { "操作失败，订单不存在", "orderId", orderId });
			rsp.setMsg("操作失败，订单不存在");
			rsp.setRspcode(ResponseMessageCodeEnum.NULL_ERROR.getCode());
			return rsp;
		}
		final OrderReservationEntity entity = this.get(OrderReservationEntity.class, orderId);
		final ReservationBO reservation = setReservationBO(user, entity);
		rsp.setReservation(reservation);
		return rsp;
	}

	private boolean saveOrderHandle(RspHead rsp, OrderReservationEntity orderEntity, OrdersHandleEntity handle) {
		final String id = (String) this.save(handle);
		if (null == id) {
			logger.error(TAG + "{}{}", "订单处理操作异常 - orderId=", orderEntity.getId());
			rsp.setError("订单处理异常");
			rsp.setRspcode(ResponseMessageCodeEnum.ERROR.getCode());
			return true;
		}
		return false;
	}

	@Override
	public List<OrdersHandleEntity> getOrdersHandleListByOrderId(String orderId) {
		return orderHandleDao.getListByOrderId(orderId);
	}

	@Override
	public OrderReservationListRsp getOrderListByStatus(String orderStatus) throws Exception {
		OrderReservationListRsp rsp = new OrderReservationListRsp();
		rsp.setRspcode(ResponseMessageCodeEnum.SUCCESS.getCode());
		rsp.setChannel(LeletcConstants.PLATFORM_WX);
		List<ReservationBO> list = new ArrayList<>();
		// 获得当天的订单
		final List<OrderReservationEntity> orders = orderReservationDao.getListByStatus(orderStatus,
				DateUtils.formatDate(new Date()));
		if (!CollectionUtils.isEmpty(orders)) {
			ReservationBO reservation;
			/*
			 * OrderReservationBO orderBiz; BaseProductsBO productsBO; OrderUserBO userBo;
			 * OrderBO orderBo;
			 */
			for (OrderReservationEntity order : orders) {
				// 用户信息
				TSUser user = this.get(TSUser.class, order.getOrderUsers());
				reservation = setReservationBO(user, order);
				/*
				 * orderBiz = new OrderReservationBO(); orderBo = new OrderBO();
				 * MyBeanUtils.copyBeanNotNull2Bean(order, orderBo); orderBiz.setOrder(orderBo);
				 */
				/*
				 * userBo = new OrderUserBO(); MyBeanUtils.copyBeanNotNull2Bean(user, userBo);
				 * orderBiz.setUser(userBo); // 车辆信息，目前只支持1车1用户 final List<Vehicle> vehicles =
				 * JSON.parseArray(user.getVehicleId(), Vehicle.class);
				 * orderBiz.setVehicle(vehicles.get(0)); // 产品信息 productsBO = new
				 * BaseProductsBO(); final BaseProductsEntity product =
				 * this.get(BaseProductsEntity.class, order.getProductId());
				 * MyBeanUtils.copyBeanNotNull2Bean(product, productsBO); final
				 * BaseUserProductsEntity userProduct =
				 * userProductsDao.getSingleUserProduct(user.getId(), order.getProductId()); //
				 * 复制用户产品对象 org.springframework.beans.BeanUtils.copyProperties(userProduct,
				 * productsBO, "id"); orderBiz.setProduct(productsBO);
				 */
				// 添加到集合
				list.add(reservation);
			}
		} else {
			logger.error(TAG + "{} - {} - {}", new String[] { "当前没有订单", "orderStatus", orderStatus });
			rsp.setMsg("当前没有订单");
			rsp.setRspcode(ResponseMessageCodeEnum.NULL_ERROR.getCode());
			return rsp;
		}
		rsp.setReservationList(list);
		rsp.setMsg("查询订单成功");
		return rsp;
	}

	@Override
	public OrderReservationListRsp getOrderListByUserId(String userId, String currentDate) throws Exception {
		OrderReservationListRsp rsp = new OrderReservationListRsp();
		rsp.setRspcode(ResponseMessageCodeEnum.SUCCESS.getCode());
		rsp.setChannel(LeletcConstants.PLATFORM_WX);
		List<ReservationBO> list = new ArrayList<>();
		// 获得用户信息
		final TSUser user = this.get(TSUser.class, userId);
		// OrderUserBO userBo = new OrderUserBO();
		// BaseProductsBO productsBO = new BaseProductsBO();
		// 人员类型(1.供应商,2.合作商,3.自由群体,4.我司)
		// 为1：查询已接历史订单（根据订单处理表）
		// 为2、4：查询已下订单
		final String personType = user.getPerson_type();
		if (personType.equals(LeletcConstants.PERSON_TYPE_PROVIDER)) {
			// 供应商
			final List<OrderReservationEntity> handleList = orderReservationDao.getHandleOrdersByUserId(userId,
					currentDate);
			if (!Collections.isEmpty(handleList)) {
				collectOrderUser(list, handleList);
			} else {
				rsp.setMsg("当前没有历史订单");
				rsp.setRspcode(ResponseMessageCodeEnum.NULL_ERROR.getCode());
				return rsp;
			}
		} else if (personType.equals(LeletcConstants.PERSON_TYPE_PARTNER)
				|| personType.equals(LeletcConstants.PERSON_TYPE_OUR_COMPANY)) {
			// 合作商、我司
			final List<OrderReservationEntity> orders = orderReservationDao.getListByUserId(userId, currentDate);
			if (!Collections.isEmpty(orders)) {
				collectOrderUser(list, orders);
			} else {
				rsp.setMsg("您当前没有订单，快去下单吧");
				rsp.setRspcode(ResponseMessageCodeEnum.NULL_ERROR.getCode());
				return rsp;
			}
		}
		rsp.setReservationList(list);
		rsp.setRspcode(ResponseMessageCodeEnum.SUCCESS.getCode());
		rsp.setMsg("查询订单成功");
		return rsp;
	}

	/**
	 * 设置订单用户信息
	 *
	 * @param list   业务订单对象集合
	 * @param orders 实体订单对象集合
	 */
	private void collectOrderUser(List<ReservationBO> list, List<OrderReservationEntity> orders) throws Exception {
		ReservationBO reservationBO;
		for (OrderReservationEntity entity : orders) {
			final TSUser user = this.get(TSUser.class, entity.getOrderUsers());
			reservationBO = setReservationBO(user, entity);
			list.add(reservationBO);
			/*
			 * order = new OrderReservationBO(); // 用户信息 userBo = new OrderUserBO();
			 */
			/*
			 * MyBeanUtils.copyBeanNotNull2Bean(user, userBo); if
			 * (StringUtils.isNotBlank(user.getVehicleId())) { // 车辆信息，目前只支持1车1用户 final
			 * List<Vehicle> vehicles = JSON.parseArray(user.getVehicleId(), Vehicle.class);
			 * order.setVehicle(vehicles.get(0)); } // 产品信息 productsBO = new
			 * BaseProductsBO(); final BaseProductsEntity product =
			 * this.get(BaseProductsEntity.class, orderEntity.getProductId());
			 * MyBeanUtils.copyBeanNotNull2Bean(product, productsBO); final
			 * BaseUserProductsEntity userProduct =
			 * userProductsDao.getSingleUserProduct(user.getId(),
			 * orderEntity.getProductId()); if (null != userProduct) { // 复制用户产品对象
			 * org.springframework.beans.BeanUtils.copyProperties(userProduct, productsBO,
			 * "id"); } // 设置对象 order.setProduct(productsBO); OrderBO orderBo = new
			 * OrderBO(); MyBeanUtils.copyBeanNotNull2Bean(orderEntity, orderBo);
			 * order.setOrder(orderBo); order.setUser(userBo);
			 */
		}
	}

	@Override
	public ProviderServiceRsp acceptReservationOrder(String userId, String orderId) throws Exception {
		ProviderServiceRsp rsp = new ProviderServiceRsp();
		rsp.setRspcode(ResponseMessageCodeEnum.SUCCESS.getCode());
		rsp.setChannel(LeletcConstants.PLATFORM_WX);
		// 1.查询预约订单中是否有可接订单（状态为待服务商处理，排序为最高，时间为当天最早）；
		// 2.有订单则往订单处理表中插入数据；
		// 3.返回已插入的订单处理数据。
		final OrderReservationEntity order = orderReservationDao.getAcceptableOrder(orderId,
				LeletcConstants.ORDER_STATUS_WAITING_PROVIDER, DateUtils.formatDate(new Date()));
		if (null != order) {
			// 获得用户信息
			final TSUser user = this.get(TSUser.class, userId);
			if (null != user) {
				// 获得当前已接的且未完成洗车的订单数，如果超过6个，则不允许再接单(处理中的订单：已接单、服务中)
				List<OrdersHandleEntity> handleList = orderHandleDao.getProcessingOrdersByUserId(userId,
						LeletcConstants.ORDER_STATUS_ACCEPTED, LeletcConstants.ORDER_STATUS_IN_SERVICE);
				// TODO 配置一次可接单数
				int orderHandleCounts = 6;
				if (!CollectionUtils.isEmpty(handleList) && handleList.size() >= orderHandleCounts) {
					logger.error(TAG + "{}{}", "您已有" + orderHandleCounts + "个未处理订单，无法接单 - userId - ", userId);
					rsp.setMsg("您已有" + orderHandleCounts + "个未处理订单");
					rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
					return rsp;
				}
				// 1.更新订单状态为：供应商已接单
				order.setUpdateBy(userId);
				order.setUpdateDate(new Date());
				order.setUpdateName(user.getMobilePhone());
				order.setOrderStatus(LeletcConstants.ORDER_STATUS_ACCEPTED);
				order.setStatusName(LeletcConstantEnum.ORDER_STATUS_ACCEPTED.getName());
				order.setStatusRemark("已被用户[ " + user.getNickname() + " ]接单");
				this.saveOrUpdate(order);
				// 2.订单处理信息
				OrdersHandleEntity handle = setOrdersHandleEntity(user, order, userId);
				handle.setDealAct("接单");
				handle.setDealDesc("用户[ " + user.getNickname() + " ]接单完成");
				// 保存订单处理信息
				if (saveOrderHandle(rsp, order, handle))
					return rsp;
				// 订单用户
				final TSUser orderUser = this.get(TSUser.class, order.getOrderUsers());
				rsp.setOrder(order);
				rsp.setMsg("您已成功接到顾客 " + orderUser.getNickname() + " 的订单");
			} else {
				logger.error(TAG + "{} - {}", "接单失败，您的信息不存在。userId - ", userId);
				rsp.setMsg("接单失败，您的信息不存在");
				rsp.setRspcode(ResponseMessageCodeEnum.NULL_ERROR.getCode());
				return rsp;
			}
		} else {
			logger.error(TAG + "{}", "目前没有可接的订单");
			rsp.setMsg("目前没有可接的订单");
			rsp.setRspcode(ResponseMessageCodeEnum.NULL_ERROR.getCode());
			return rsp;
		}
		return rsp;
	}

	@Override
	public QueueLocationRsp getOrderLocation(String orderId) {
		QueueLocationRsp rsp = new QueueLocationRsp();
		rsp.setRspcode(ResponseMessageCodeEnum.SUCCESS.getCode());
		rsp.setChannel(LeletcConstants.PLATFORM_WX);
		// 1.查询预约订单队列
		List<OrdersQueueEntity> list = orderQueueDao.getList();
		if (!CollectionUtils.isEmpty(list)) {
			// 队列Map（key:id,value=排号）
			Map<String, Integer> queueMap = new HashMap<>();
			for (int i = 0; i < list.size(); i++) {
				queueMap.put(list.get(i).getOrderId(), i + 1);
			}
			if (queueMap.containsKey(orderId)) {
				rsp.setRankingNo(queueMap.get(orderId));
			}
		}
		final OrderReservationEntity order = this.get(OrderReservationEntity.class, orderId);
		rsp.setOrderUserName(order.getCreateName());
		rsp.setOrderId(orderId);
		return rsp;
	}

	@Override
	public ReserveAmountRsp getRemainAmount(String userId) {
		ReserveAmountRsp rsp = new ReserveAmountRsp();
		rsp.setMsg("返回成功");
		rsp.setRspcode(ResponseMessageCodeEnum.SUCCESS.getCode());
		rsp.setChannel(LeletcConstants.PLATFORM_WX);
		// TODO 需要配置部门信息
		String departId = "2c9181af66fc93990166fcaa62790011";
		AutoReservePermissionsConfigEntity permission = reservePermissionConfigDao.getReservePermission(departId);
		// 1.获得当前每天可预约总数
		int totalAmount = Integer.parseInt(permission.getResOrderNum());
		// 2.根据用户等级获得已预约数
		String personLevel = this.get(TSUser.class, userId).getPersonLevel();
		int hasUsedAmount = orderReservationDao.getHasUsedCounts(personLevel, DateUtils.formatDate(new Date()));
		// 3.获得服务中的订单数
		int notFinishAmount = orderReservationDao.getNotFinishCounts(personLevel, LeletcConstants.ORDER_STATUS_CANCELED,
				LeletcConstants.ORDER_STATUS_FINISHED, DateUtils.formatDate(new Date()));
		// 4.用户格口数
		int userBoxCounts = userBoxCfgDao.getUserBoxCounts(personLevel);
		// 该用户可预约数
		int remainAmount = userBoxCounts + notFinishAmount - hasUsedAmount;
		rsp.setTotalAmount(totalAmount);
		rsp.setHasUsedAmount(totalAmount - remainAmount);
		rsp.setRemainAmount(remainAmount);
		return rsp;
	}
}