package com.leletc.smartcabinet.service.impl;

import com.alibaba.fastjson.JSON;
import com.jeecg.wechat.util.SMSUtil;
import com.leletc.base.pushing.PushMessageServer;
import com.leletc.base.util.LeletcConstantEnum;
import com.leletc.base.util.LeletcConstants;
import com.leletc.oocheorder.dao.OrderQueueDao;
import com.leletc.oocheorder.dao.OrderReservationDao;
import com.leletc.oocheorder.entity.OrderReservationEntity;
import com.leletc.oocheorder.entity.OrdersHandleEntity;
import com.leletc.smartcabinet.dao.SmartCabinetDoorDao;
import com.leletc.smartcabinet.dao.SmartCabinetLockLogDao;
import com.leletc.smartcabinet.entity.SmartCabinetDoorEntity;
import com.leletc.smartcabinet.entity.SmartCabinetLockLogEntity;
import com.leletc.smartcabinet.service.ISmartCabinetCodeScannerService;
import com.leletc.smartcabinet.web.api.response.SmartCabinetDoorRsp;
import com.leletc.smartcabinet.web.api.response.SmartCabinetRsp;
import com.leletc.smartcabinet.web.bo.SmartCabinetDoorBO;
import com.leletc.smartcabinet.web.vo.ScanSmartCabinetReq;
import com.leletc.user.dao.UserBoxCfgDao;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.jwt.service.TokenManager;
import org.jeecgframework.jwt.util.menu.ResponseMessageCodeEnum;
import org.jeecgframework.p3.core.utils.common.StringUtils;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 功能描述：扫描柜子二维码业务类实现类
 * <p>
 *
 * @author 李斌
 *         <p>
 * @date 2018/10/13 01:30
 *       <p>
 *       修改记录：修改内容 修改人 修改时间
 *       <ul>
 *       <li></li>
 *       </ul>
 *       <p>
 *       Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 *       <p>
 */
@Service("smartCabinetCodeScannerService")
@Transactional(rollbackFor = Exception.class)
public class SmartCabinetCodeScannerServiceImpl extends CommonServiceImpl implements ISmartCabinetCodeScannerService {

	private static final String TAG = SmartCabinetCodeScannerServiceImpl.class.getSimpleName() + "- 智能柜扫码";

	private static Logger logger = LoggerFactory.getLogger(SmartCabinetCodeScannerServiceImpl.class);

	@Autowired
	private TokenManager tokenManager;

	@Autowired
	private OrderReservationDao orderReservationDao;

	@Autowired
	private SmartCabinetDoorDao smartCabinetDoorDao;

	@Autowired
	private SmartCabinetLockLogDao smartCabinetLockLogDao;

	@Autowired
	private OrderQueueDao orderQueueDao;

	@Autowired
	private UserBoxCfgDao userBoxCfgDao;

	@Override
	public SmartCabinetDoorRsp getDoorStatus(String doorId) {
		SmartCabinetDoorRsp rsp = new SmartCabinetDoorRsp();
		rsp.setChannel(LeletcConstants.PLATFORM_WX);
		rsp.setRspcode(ResponseMessageCodeEnum.SUCCESS.getCode());
		final SmartCabinetDoorEntity door = this.get(SmartCabinetDoorEntity.class, doorId);
		if (null != door) {
			if (door.getIsOpen() == 1) {
				rsp.setMsg("箱门未关闭，请关闭箱门，谢谢！");
				rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
				return rsp;
			}
		} else {
			rsp.setMsg("箱门不存在");
			rsp.setRspcode(ResponseMessageCodeEnum.NULL_ERROR.getCode());
			return rsp;
		}
		SmartCabinetDoorBO smartCabinetDoorBO = new SmartCabinetDoorBO();
		try {
			// 复制实体对象至业务对象BO
			MyBeanUtils.copyBeanNotNull2Bean(door, smartCabinetDoorBO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		rsp.setSmartCabinetDoor(smartCabinetDoorBO);
		rsp.setMsg("箱门已关闭");
		return rsp;
	}

	@Override
	public synchronized SmartCabinetRsp scanCodeOpenDoor(ScanSmartCabinetReq smartCabinetVO) throws Exception {
		SmartCabinetRsp rsp = new SmartCabinetRsp();
		rsp.setChannel(LeletcConstants.PLATFORM_WX);
		rsp.setRspcode(ResponseMessageCodeEnum.SUCCESS.getCode());
		logger.info(TAG + "扫码业务开始 - {}", smartCabinetVO.toString());
		if (StringUtils.isBlank(smartCabinetVO.getToken())) {
			logger.error(TAG + " - {}", "智能柜注册异常，请联系客服");
			rsp.setMsg("智能柜注册异常，请联系客服");
			rsp.setRspcode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			return rsp;
		}
		if (StringUtils.isBlank(smartCabinetVO.getCabinetNo())) {
			logger.error(TAG + " - {}", "智能柜编号有误，请联系客服");
			rsp.setMsg("智能柜编号有误，请联系客服");
			rsp.setRspcode(ResponseMessageCodeEnum.VALID_ERROR.getCode());
			return rsp;
		}
		// 查询订单
		OrderReservationEntity order;
		if (StringUtils.isNotBlank(smartCabinetVO.getOrderId())) {
			// 有订单ID，表示洗车工扫码
			order = orderReservationDao.get(smartCabinetVO.getOrderId());
		} else {
			// 无订单ID，为车主扫码
			order = orderReservationDao.getOrderByUserIdStatus(smartCabinetVO.getUserId(),
					LeletcConstants.ORDER_STATUS_RESERVED);
		}
		if (null == order) {
			logger.error(TAG + " - {}", "查询订单异常");
			rsp.setMsg("查询订单异常");
			rsp.setRspcode(ResponseMessageCodeEnum.NULL_ERROR.getCode());
			return rsp;
		}
		// 查询此订单是否已有开门记录，如果有则获取箱门号
		String boxNo;
		// 箱门信息
		SmartCabinetDoorEntity door;
		// 获得用户信息
		TSUser user = this.get(TSUser.class, smartCabinetVO.getUserId());
		// 根据订单ID、柜子ID查询开门记录，以取得上一个开门记录
		SmartCabinetLockLogEntity lockLogInfo = smartCabinetLockLogDao.getLatestOne(smartCabinetVO.getOrderId());
		if (null != lockLogInfo && StringUtils.isNotBlank(lockLogInfo.getId())) {
			// 已有订单，则获取箱门信息
			boxNo = lockLogInfo.getBoxNo();
			door = smartCabinetDoorDao.get(lockLogInfo.getDoorId());
		} else {
			// 根据柜子编号查询可用的柜子信息，并分配一个柜子
			door = smartCabinetDoorDao.getFreeDoor(smartCabinetVO.getCabinetNo());
			if (null == door) {
				logger.error(TAG + " - {}", "当前柜子没有可用格口");
				rsp.setMsg("当前柜子没有可用格口");
				rsp.setRspcode(ResponseMessageCodeEnum.NULL_ERROR.getCode());
				return rsp;
			}
			boxNo = door.getBoxNo();
		}
		/*************************** 开门业务处理 start */
		// 获取订单状态
		String orderStatus = order.getOrderStatus();
		// 业务类型
		final Integer bizType = smartCabinetVO.getBizType();
		// 箱门开关日志对象
		SmartCabinetLockLogEntity lockLogEntity = new SmartCabinetLockLogEntity();
		switch (orderStatus) {
		case LeletcConstants.ORDER_STATUS_RESERVED:
			/** 1.车主存钥匙开门：车主已预约 */
			if (user.getPerson_type().equals(LeletcConstants.PERSON_TYPE_PARTNER)) {
				if (bizType == LeletcConstants.WASH_CAR_BIZ_TYPE_SAVE_KEY) {
					// 存钥匙，箱门是否有效
					if (door.getIsValid() == 1) {
						// 箱门是关闭状态时，才能开启
						lockLogEntity.setBizType(LeletcConstants.WASH_CAR_BIZ_TYPE_SAVE_KEY);
					} else {
						logger.error(TAG + " - {}{}{}", new String[] { "箱门 ", boxNo, " 无效，请联系客服" });
						rsp.setError("箱门 " + boxNo + " 无效，请联系客服");
						rsp.setRspcode(ResponseMessageCodeEnum.ERROR.getCode());
						return rsp;
					}
				} else if (bizType == LeletcConstants.WASH_CAR_BIZ_TYPE_GET_KEY) {
					// 取钥匙
					logger.error(TAG + " - {}", "亲，您还没存钥匙呢~");
					rsp.setError("亲，您还没存钥匙呢~");
					rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
					return rsp;
				}
			} else {
				// 其他人，则不允许开门
				logger.error(TAG + " - {}", "您没有权限开箱门");
				rsp.setError("您没有权限开箱门");
				rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
				return rsp;
			}
			break;
		case LeletcConstants.ORDER_STATUS_ACCEPTED:
			/** 2.服务商取出钥匙开门：供应商已接单，待供应商取车 */
			if (user.getPerson_type().equals(LeletcConstants.PERSON_TYPE_PROVIDER)) {
				// 服务商取钥匙
				if (bizType == LeletcConstants.WASH_CAR_BIZ_TYPE_GET_KEY) {
					lockLogEntity.setBizType(LeletcConstants.WASH_CAR_BIZ_TYPE_GET_KEY);
				} else if (bizType == LeletcConstants.WASH_CAR_BIZ_TYPE_SAVE_KEY) {
					// 服务商在已接单状态下来存钥匙
					logger.error(TAG + " - {}", "您还没有取钥匙呢~");
					rsp.setError("您还没有取钥匙呢~");
					rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
					return rsp;
				}
			} else if (user.getPerson_type().equals(LeletcConstants.PERSON_TYPE_PARTNER)) {
				// 合作商
				logger.error(TAG + " - {}", "对不起，服务商已接单，您不能开箱门");
				rsp.setError("对不起，服务商已接单，您不能开箱门");
				rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
				return rsp;
			} else {
				// 非服务商和合作商
				logger.error(TAG + " - {}", "您没有权限开箱门");
				rsp.setError("您没有权限开箱门");
				rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
				return rsp;
			}
			break;
		case LeletcConstants.ORDER_STATUS_IN_SERVICE:
			/** 3.服务商洗好车存钥匙开门：供应商已取车，正在服务中 */
			if (user.getPerson_type().equals(LeletcConstants.PERSON_TYPE_PROVIDER)) {
				// 服务商
				if (bizType == LeletcConstants.WASH_CAR_BIZ_TYPE_SAVE_KEY) {
					// 存钥匙
					lockLogEntity.setBizType(LeletcConstants.WASH_CAR_BIZ_TYPE_SAVE_KEY);
				} else if (bizType == LeletcConstants.WASH_CAR_BIZ_TYPE_GET_KEY) {
					// 取钥匙
					logger.error(TAG + " - {}", "操作有误，请您选择存钥匙~");
					rsp.setError("操作有误，请您选择存钥匙~");
					rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
					return rsp;
				}
			} else if (user.getPerson_type().equals(LeletcConstants.PERSON_TYPE_PARTNER)) {
				// 合作商
				logger.error(TAG + " - {}", "对不起，订单正在服务中，您不能开箱门~");
				rsp.setError("对不起，订单正在服务中，您不能开箱门~");
				rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
				return rsp;
			} else {
				// 非服务商和合作商
				logger.error(TAG + " - {}", "您没有权限开箱门");
				rsp.setError("您没有权限开箱门");
				rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
				return rsp;
			}
			break;
		case LeletcConstants.ORDER_STATUS_WAITING_DRIVER:
			/** 4.车主取车取钥匙开门：供应商已洗好车，待车主取车 */
			if (user.getPerson_type().equals(LeletcConstants.PERSON_TYPE_PARTNER)) {
				// 合作商
				if (bizType == LeletcConstants.WASH_CAR_BIZ_TYPE_GET_KEY) {
					// 取钥匙
					lockLogEntity.setBizType(LeletcConstants.WASH_CAR_BIZ_TYPE_GET_KEY);
				} else if (bizType == LeletcConstants.WASH_CAR_BIZ_TYPE_SAVE_KEY) {
					// 存钥匙
					logger.error(TAG + " - {}", "操作有误，请您选择取钥匙~");
					rsp.setError("操作有误，请您选择取钥匙~");
					rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
					return rsp;
				}
			} else if (user.getPerson_type().equals(LeletcConstants.PERSON_TYPE_PROVIDER)) {
				// 服务商
				logger.error(TAG + " - {}", "对不起，订单处于待车主取车，您不能开箱门~");
				rsp.setError("对不起，订单处于待车主取车，您不能开箱门~");
				rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
				return rsp;
			} else {
				// 非服务商和合作商
				logger.error(TAG + " - {}", "您没有权限开箱门");
				rsp.setError("您没有权限开箱门");
				rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
				return rsp;
			}
			break;
		default:
			logger.error(TAG + " - {}{}{}", new String[] { "当前订单[ ", order.getOrderCode(), " ]不支持此操作或者您已经完成此操作" });
			rsp.setError("当前订单[ " + order.getOrderCode() + " ]不支持此操作或者您已经完成此操作");
			rsp.setRspcode(ResponseMessageCodeEnum.DO_NOT_ERROR.getCode());
			return rsp;
		}
		lockLogEntity
				.setCreateName(StringUtils.isNotBlank(user.getRealName()) ? user.getRealName() : user.getNickname());
		lockLogEntity.setCreateBy(user.getId());
		lockLogEntity.setCreateDate(new Date());
		lockLogEntity.setOrderId(order.getId());
		lockLogEntity.setOrderStatus(order.getOrderStatus());
		lockLogEntity.setDoorId(door.getId());
		lockLogEntity.setBoxNo(boxNo);
		lockLogEntity.setLockInstruct("1");
		lockLogEntity.setLockAct(1);
		lockLogEntity.setLockTime(new Date());
		lockLogEntity.setLockResult("格口号 " + boxNo + " 已打开");
		lockLogEntity.setLockUser(user.getId());
		lockLogEntity.setWxUserToken(tokenManager.getTokenByUser(user.getUserName()));
		String jsonStr = JSON.toJSONString(lockLogEntity);
		logger.info(TAG + " - {}", "正在开启箱门...格口号=" + boxNo);
		// ============================== 开箱门 start
		PushMessageServer.pushToCabinet(smartCabinetVO.getToken(), jsonStr);
		// ============================== 开箱门 end
		logger.info(TAG + " - {}", "格口 " + boxNo + " 已开启");
		if (orderStatus.equals(LeletcConstants.ORDER_STATUS_RESERVED)) {
			// 第一次开启箱门的时候，可用格子数-1
			int result = userBoxCfgDao.reduceUserBoxCounts(user.getPersonLevel());
			if (result == 0) {
				logger.error(TAG + "{} - {}", "更新可用格子数失败", "personLevel=" + user.getPersonLevel());
			}
		}
		// 更新柜子状态...
		door.setIsOpen(1);
		door.setId(lockLogEntity.getDoorId());
		door.setBoxNo(lockLogEntity.getBoxNo());
		smartCabinetDoorDao.update(door);
		logger.info(TAG + " 开门 - {}", "更新箱门状态成功(0)");
		// 保存开格口记录...
		saveDoorLockLog(lockLogEntity);
		rsp.setMsg("箱门 " + boxNo + " 已开启");
		/*************************** 开门业务处理 end */
		SmartCabinetDoorBO smartCabinetDoorBO = new SmartCabinetDoorBO();
		MyBeanUtils.copyBeanNotNull2Bean(door, smartCabinetDoorBO);
		rsp.setSmartCabinetDoor(smartCabinetDoorBO);
		return rsp;
	}

	@Override
	public SmartCabinetRsp closeDoor(ScanSmartCabinetReq smartCabinetVO) throws Exception {
		SmartCabinetRsp rsp = new SmartCabinetRsp();
		rsp.setChannel(LeletcConstants.PLATFORM_WX);
		rsp.setRspcode(ResponseMessageCodeEnum.SUCCESS.getCode());
		// 箱门信息
		SmartCabinetDoorEntity door = new SmartCabinetDoorEntity();
		// 查询订单
		OrderReservationEntity order = this.get(OrderReservationEntity.class, smartCabinetVO.getOrderId());
		// 根据订单ID、箱门ID查询开门记录，以取得上一个开门记录
		final SmartCabinetLockLogEntity lockLogInfo = smartCabinetLockLogDao.get(smartCabinetVO.getOrderId(),
				smartCabinetVO.getBoxNo());
		logger.debug("最新的开箱门记录 - " + lockLogInfo);
		// 获得用户信息
		final TSUser user = this.get(TSUser.class, smartCabinetVO.getUserId());
		// 创建关门记录(复制查询结果中的最新的一条记录)
		SmartCabinetLockLogEntity lockLogEntity = new SmartCabinetLockLogEntity();
		MyBeanUtils.copyBeanNotNull2Bean(lockLogInfo, lockLogEntity);
		// 柜子开关日志对象
		lockLogEntity.setCreateDate(new Date());
		lockLogEntity.setLockInstruct("2");
		lockLogEntity.setLockAct(2);
		lockLogEntity.setLockTime(new Date());
		lockLogEntity.setLockResult("格口号 " + smartCabinetVO.getBoxNo() + " 已关闭");
		// 订单状态
		String orderStatus = order.getOrderStatus();
		logger.debug("[orderStatus] =" + orderStatus);
		/* ************************** 关门业务处理 start */
		// -------------------------------------------------
		logger.debug("[Command] 正在关闭箱门...orderId=" + order.getId() + " - boxNo=" + smartCabinetVO.getBoxNo());
		if (orderStatus.equals(LeletcConstants.ORDER_STATUS_RESERVED)) {
			/* 1.车主存好钥匙后关门->待服务商处理 */
			order.setOrderStatus(LeletcConstants.ORDER_STATUS_WAITING_PROVIDER);
			order.setStatusName(LeletcConstantEnum.ORDER_STATUS_WAITING_PROVIDER.getName());
			order.setStatusRemark("车主 " + user.getNickname() + " 存好钥匙后关门");
			door.setIsOccupancy(1);
			door.setStorageStatus(1);
			lockLogEntity.setBizType(1);
			lockLogEntity.setOrderStatus(LeletcConstants.ORDER_STATUS_WAITING_PROVIDER);
		} else if (orderStatus.equals(LeletcConstants.ORDER_STATUS_ACCEPTED)) {
			/* 2.服务商取出钥匙后关门->服务中 */
			order.setOrderStatus(LeletcConstants.ORDER_STATUS_IN_SERVICE);
			order.setStatusName(LeletcConstantEnum.ORDER_STATUS_IN_SERVICE.getName());
			order.setStatusRemark("洗车工开始洗车取出钥匙后关门");
			door.setStorageStatus(2);
			lockLogEntity.setBizType(2);
			lockLogEntity.setOrderStatus(LeletcConstants.ORDER_STATUS_IN_SERVICE);
		} else if (orderStatus.equals(LeletcConstants.ORDER_STATUS_IN_SERVICE)) {
			/* 3.服务商洗完车存好钥匙后关门->待车主取车 */
			order.setOrderStatus(LeletcConstants.ORDER_STATUS_WAITING_DRIVER);
			order.setStatusName(LeletcConstantEnum.ORDER_STATUS_WAITING_DRIVER.getName());
			order.setStatusRemark("洗车工洗完车存好钥匙后关门");
			door.setStorageStatus(1);
			lockLogEntity.setBizType(1);
			lockLogEntity.setOrderStatus(LeletcConstants.ORDER_STATUS_WAITING_DRIVER);
		} else if (orderStatus.equals(LeletcConstants.ORDER_STATUS_WAITING_DRIVER)) {
			/* 4.车主取车取出钥匙后关门->结束 */
			order.setOrderStatus(LeletcConstants.ORDER_STATUS_FINISHED);
			order.setStatusName(LeletcConstantEnum.ORDER_STATUS_FINISHED.getName());
			order.setStatusRemark("服务已完成");
			door.setStorageStatus(0);
			door.setIsOccupancy(0);
			lockLogEntity.setBizType(2);
			lockLogEntity.setOrderStatus(LeletcConstants.ORDER_STATUS_FINISHED);
		}
		// 1.更新订单状态
		order.setUpdateBy(smartCabinetVO.getUserId());
		order.setUpdateDate(new Date());
		order.setUpdateName(user.getMobilePhone());
		this.updateEntitie(order);
		// 2.增加订单处理信息
		String dealDesc = lockLogEntity.getBizType() == 1 ? "存钥匙" : "取钥匙";
		OrdersHandleEntity handle = new OrdersHandleEntity();
		handle.setOrderId(order.getId());
		handle.setOrderStatus(order.getOrderStatus());
		handle.setStatusName(order.getStatusName());
		handle.setCreateBy(user.getId());
		handle.setCreateDate(new Date());
		handle.setCreateName(StringUtils.isNotBlank(user.getRealName()) ? user.getRealName() : user.getNickname());
		handle.setDealAct(dealDesc);
		handle.setDealUserId(user.getId());
		handle.setDealUserName(user.getMobilePhone());
		handle.setDealDesc("用户 " + user.getNickname() + " " + dealDesc + "完成");
		handle.setDealTime(new Date());
		// 保存订单处理信息
		final String id = (String) this.save(handle);
		if (null == id) {
			logger.error(TAG + "{}{}", "订单处理操作异常 - orderId=", order.getId());
			rsp.setError("订单处理异常");
			rsp.setRspcode(ResponseMessageCodeEnum.ERROR.getCode());
			return rsp;
		}
		// -------------- 3.更新柜子状态...
		door.setIsOpen(0);
		door.setId(lockLogEntity.getDoorId());
		door.setBoxNo(lockLogEntity.getBoxNo());
		smartCabinetDoorDao.update(door);
		logger.info(TAG + " 关门 - {} - {}", "更新箱门状态成功(0)", "boxNo = " + lockLogEntity.getBoxNo());
		// -------------- 4.保存关闭格口记录...
		saveDoorLockLog(lockLogEntity);
		if (order.getOrderStatus().equals(LeletcConstants.ORDER_STATUS_FINISHED)) {
			// -------------- 5.删除订单队列
			orderQueueDao.deleteByOrderId(order.getId());
			logger.info(TAG + "{}{}", "删除订单队列 - orderId=", order.getId());
			// 订单完成时，可用柜子数+1
			userBoxCfgDao.addUserBoxCounts(user.getPersonLevel());
			// 发送短信验证码通知车主
			try {
				SMSUtil.sendSMSContent(user.getMobilePhone(), "尊敬的用户：" +
						user.getMobilePhone() + "，您的爱车 " + order.getPlateNumber() +
						" 已清洗完成，请您在今日之内尽快取车。");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/* ************************* 关门业务处理 end */
		SmartCabinetDoorBO smartCabinetDoorBO = new SmartCabinetDoorBO();
		final SmartCabinetDoorEntity doorEntity = this.get(SmartCabinetDoorEntity.class, door.getId());
		MyBeanUtils.copyBeanNotNull2Bean(doorEntity, smartCabinetDoorBO);
		rsp.setSmartCabinetDoor(smartCabinetDoorBO);
		logger.debug(TAG + " - {}", "箱门 " + smartCabinetDoorBO.getBoxNo() + " 已关闭");
		rsp.setMsg("箱门 " + smartCabinetDoorBO.getBoxNo() + " 已关闭");
		return rsp;
	}

	/**
	 * 保存格口开关记录
	 *
	 * @param doorLockEntity 格口对象
	 */
	private void saveDoorLockLog(SmartCabinetLockLogEntity doorLockEntity) {
		String doorLockLogId = (String) this.save(doorLockEntity);
		if (StringUtils.isNotBlank(doorLockLogId)) {
			logger.info(TAG + " - {}", "[SAVE] - 保存格口记录成功！ID=" + doorLockLogId);
		} else {
			logger.error(TAG + " - {}", "[SAVE] - 保存格口记录失败！");
		}
	}

	@Override
	public OrderReservationEntity getOrderByUser(String userId, String orderStatusReserved) {
		return orderReservationDao.getOrderByUserIdStatus(userId, orderStatusReserved);
	}

}
