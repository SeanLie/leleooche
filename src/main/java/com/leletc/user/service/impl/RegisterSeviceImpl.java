package com.leletc.user.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.jwt.util.ResponseMessage;
import org.jeecgframework.jwt.util.menu.ResponseMessageCodeEnum;
import org.jeecgframework.p3.core.utils.common.StringUtils;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeewx.api.wxuser.user.model.Wxuser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.jeecg.wechat.dao.TsUserDao;
import com.leletc.base.util.LeletcConstants;
import com.leletc.product.dao.UserProductsDao;
import com.leletc.product.entity.BaseProductsEntity;
import com.leletc.product.entity.BaseUserProductsEntity;
import com.leletc.product.web.bo.UserProductsBO;
import com.leletc.user.api.response.UserRsp;
import com.leletc.reservecfg.dao.ReserveUserCfgDao;
import com.leletc.user.dao.UserCarParkDao;
import com.leletc.user.dao.UserVehicleDao;
import com.leletc.user.entity.UserCarParkEntity;
import com.leletc.user.entity.UserVehicleEntity;
import com.leletc.user.pojo.CarPark;
import com.leletc.user.pojo.Vehicle;
import com.leletc.user.service.IRegisterService;

/**
 * 功能描述：用户注册业务实现类(微信)
 * <p>
 *
 * @author 李斌
 *         <p>
 * @date 2018/11/19 15:17
 *       <p>
 *       修改记录：修改内容 修改人 修改时间
 *       <ul>
 *       <li></li>
 *       </ul>
 *       <p>
 *       Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 *       <p>
 */
@Service("registerService")
@Transactional
public class RegisterSeviceImpl extends CommonServiceImpl implements IRegisterService {

	private static final String TAG = RegisterSeviceImpl.class.getSimpleName() + "- 注册 - ";

	private static final Logger logger = LoggerFactory.getLogger(RegisterSeviceImpl.class);

	@Autowired
	private TsUserDao tsUserDao;

	@Autowired
	private UserProductsDao userProductsDao;

	@Autowired
	private UserCarParkDao userCarParkDao;

	@Autowired
	private ReserveUserCfgDao reserveUserCfgDao;

	@Autowired
	private UserVehicleDao userVehicleDao;

	private final String defaultProductId = "402881e765aa06530165aa0c97c10009";

	// 把t_s_user表中微信信息增加进去，根据tel去匹配
	@Override
	public ResponseMessage<UserRsp> registerUserByTel(Wxuser wxUser, String telNum) throws Exception {
		// 查看这个库中有没有这个电话号码的使用者，如果有就返回直接登陆，如果没有就进行保存
		ResponseMessage<UserRsp> response = new ResponseMessage<>();
		TSUser user = tsUserDao.checkUserByTel(telNum);
		UserRsp userRsp = new UserRsp();
		// 是否已存在（true:已存在，false:不存在）
		boolean isExists = null != user;
		if (!isExists) {
			user = new TSUser();
			// 将微信用户信息的字段复制到新用户中
			MyBeanUtils.copyBeanNotNull2Bean(wxUser, user);
			logger.info(TAG + "{}{}", "复制微信用户到系统用户 - user=", user.getNickname());
		}
		user.setMobilePhone(telNum);
		user.setNickname(wxUser.getNickname());
		user.setCreateBy(user.getId());
		user.setCreateDate(new Date());
		user.setCreateName(StringUtils.isNotBlank(user.getRealName()) ? user.getRealName() : user.getNickname());
		user.setSubscribe_time(DateUtils.formatDateTime());
		user.setSubscribe(1);
		user.setUserName(user.getMobilePhone());
		user.setUserType("3");
		user.setDevFlag("0");
		// 防止游客用户在首次在系统中保留了号码，第二次登陆成为移动用户的BUG
		// 为洗车工
		if (isExists && user.getPerson_type().equals(LeletcConstants.PERSON_TYPE_PROVIDER)) {
			// 系统已存在此用户，表示移动机构用户事先导入，所以系统里面有手机号码。
			// 所以需要把相应的微信用户信息与本地这个电话号码进行绑定
			if (StringUtils.isBlank(user.getOpenid())) {
				// 将微信用户信息的字段复制到新用户中
				MyBeanUtils.copyBeanNotNull2Bean(wxUser, user);
			}
			logger.info(TAG + "{}{}", isExists ? "登录成功" : "注册成功", "，且该用户为供应商用户");
			response.setMessage(isExists ? "登录成功" : "注册成功");
		} // 为移动员工
		else if (isExists && user.getPerson_type().equals(LeletcConstants.PERSON_TYPE_PARTNER)) {
			// 系统已存在此用户，表示移动机构用户事先导入，所以系统里面有手机号码。
			// 所以需要把相应的微信用户信息与本地这个电话号码进行绑定
			if (StringUtils.isBlank(user.getOpenid())) {
				// 将微信用户信息的字段复制到新用户中
				MyBeanUtils.copyBeanNotNull2Bean(wxUser, user);
			}
			// add by zhulei 如果Person_type没有值才进行赋值，如有有值就沿用之前值
			// user.setPerson_type(LeletcConstants.PERSON_TYPE_PARTNER);
			// end by zhulei
			// String personLevel = user.getPersonLevel();
			// addProducts(user, personLevel);
			logger.info(TAG + "{}{}", isExists ? "登录成功" : "注册成功", "，且该用户为服务商用户");
			response.setMessage(isExists ? "登录成功" : "注册成功");
		} else {
			// 不存在用户也可以进行操作，但是不能下订单，但是可以开展洗车业务，但是其他业务，
			// 后期可以进行不同机构开展不同业务，根据机构来进行操作，可分共有业务，私有业务
			// 注意：如果这里开放以后要注意一个问题：这个用户为普通用户，下次注册登陆，就会直接用上面一个if执行
			user.setPerson_type(LeletcConstants.PERSON_TYPE_NORMAL);
			user.setPersonLevel("0");
			logger.info(TAG + "{}{}", isExists ? "登录成功" : "注册成功", "，但由于您不是服务商和供应商用户，不能进行下单");
			response.setMessage(isExists ? "登录成功" : "注册成功" + "，但由于您不是服务商或供应商用户，不能进行下单");
		}
		// 保存/更新用户信息
		String userId;
		if (isExists) {
			userId = user.getId();
			this.updateEntitie(user);
		} else {
			userId = (String) this.save(user);
		}
		// 复制用户信息至用户返回对象
		MyBeanUtils.copyBeanNotNull2Bean(user, userRsp);
		logger.info(TAG + "{}{}", isExists ? "更新" : "保存", "用户信息成功 - userRsp");
		// 需要修改用户车辆信息
		List<UserVehicleEntity> vehicleList = userVehicleDao.getByUserId(userId);
		if (!CollectionUtils.isEmpty(vehicleList)) {
			UserVehicleEntity vehicleEntity = vehicleList.get(0);
			logger.info(TAG + "{}{}", "获取用户车辆信息 - user=" + user.getNickname(), ",vehicle=" + vehicleEntity.toString());
			Vehicle vehicle = new Vehicle();
			// 只有等于2的状态用户才需要获取到这个值
			if (user.getPerson_type().equals(LeletcConstants.PERSON_TYPE_PARTNER)) {
				userRsp.setVehicles(StringUtils.isNotBlank(vehicleEntity.getCarNum()) ? vehicleEntity.getCarNum() : "");
				vehicle.setCarNum(StringUtils.isNotBlank(vehicleEntity.getCarNum()) ? vehicleEntity.getCarNum() : "");
				vehicle.setModel(
						StringUtils.isNotBlank(vehicleEntity.getCarModel()) ? vehicleEntity.getCarModel() : "");
				if (StringUtils.isNotBlank(vehicleEntity.getCarBuyDate())) {
					vehicle.setAge(DateUtils.parseDate(vehicleEntity.getCarBuyDate(), "yyyy-MM-dd"));
				}
				userRsp.setVehicles(JSON.toJSONString(vehicle));
//		// FIXME 增加第一次注册的时候 显示车辆信息
//		List<UserVehicleEntity> vehicleList = userVehicleDao.getByUserId(userId);
//		if (!CollectionUtils.isEmpty(vehicleList)) {
//			UserVehicleEntity vehicleEntity = vehicleList.get(0);
//			logger.info(TAG + "{}{}", "获取用户车辆信息 - user=" + user.getNickname(), ",vehicle=" + vehicleEntity.toString());
//			Vehicle vehicle = new Vehicle();
//			// 只有等于2的状态用户才需要获取到这个值
//			if (user.getPerson_type().equals(LeletcConstants.PERSON_TYPE_PARTNER)) {
//				logger.info(TAG + "userRsp", "userRsp=" + userRsp.toString(), ",vehicle=" + vehicleEntity.getCarNum());
//				userRsp.setVehicles(StringUtils.isNotBlank(vehicleEntity.getCarNum()) ? vehicleEntity.getCarNum() : "");
			}
		}
		// 第一次注册的时候 显示停车位信息
		List<UserCarParkEntity> carParkList = userCarParkDao.getByUserId(userId);
		if (!CollectionUtils.isEmpty(carParkList)) {
			UserCarParkEntity carParkEntity = carParkList.get(0);
			logger.info(TAG + "{}{}", "获取用户停车位信息 - user=" + user.getNickname(), ",carPark=" + carParkEntity.toString());
			CarPark carPark = new CarPark();
			carPark.setPark_num(StringUtils.isNotBlank(carParkEntity.getPark_num()) ? carParkEntity.getPark_num() : "");
			carPark.setPark_add(StringUtils.isNotBlank(carParkEntity.getPark_add()) ? carParkEntity.getPark_add() : "");
			userRsp.setCarparks(JSON.toJSONString(carPark));
		}
		// 设置用户产品信息
		BaseUserProductsEntity userProduct = userProductsDao.getSingleUserProduct(userId, defaultProductId);
		if (null != userProduct) {
			UserProductsBO userProductBo = new UserProductsBO(userProduct.getProductId(), userProduct.getProductName(),
					userProduct.getProductLeftNum(), userProduct.getProductAmount());
			userRsp.setUserProduct(userProductBo);
		}
		logger.info("userRsp:" + userRsp.toString());
		response.setData(userRsp);
		response.setRespCode(ResponseMessageCodeEnum.SUCCESS.getCode());
		return response;
	}

	private void addProducts(TSUser user, String personLevel) throws Exception {
		// 查询用户产品信息是否已存在
		final BaseUserProductsEntity userProduct = userProductsDao.getSingleUserProduct(user.getId(), defaultProductId);
		if (null == userProduct) {
			// FIXME 默认的用户产品信息未配置
			final BaseProductsEntity defProduct = this.get(BaseProductsEntity.class, defaultProductId);
			BaseUserProductsEntity entity = new BaseUserProductsEntity();
			entity.setUserId(user.getId());
			entity.setUserPersonLevel(personLevel);
			entity.setUserName(user.getNickname());
			entity.setCreateBy(user.getId());
			entity.setCreateDate(new Date());
			entity.setCreateName(StringUtils.isNotBlank(user.getRealName()) ? user.getRealName() : user.getNickname());
			entity.setProductId(defaultProductId);
			entity.setProductName(defProduct.getProductName());
			Map<String, Integer> productNumMap;
			// 根据用户等级设置其产品服务次数
			if (personLevel.equals(LeletcConstants.PERSON_LEVEL_GENERAL_1)) {
				productNumMap = reserveUserCfgDao.getProductNum(LeletcConstants.PERSON_LEVEL_GENERAL_1,
						defProduct.getId());
			} else if (personLevel.equals(LeletcConstants.PERSON_LEVEL_VIP_2)) {
				productNumMap = reserveUserCfgDao.getProductNum(LeletcConstants.PERSON_LEVEL_VIP_2, defProduct.getId());
			} else {
				productNumMap = reserveUserCfgDao.getProductNum(LeletcConstants.PERSON_LEVEL_VISITOR_0,
						defProduct.getId());
			}
			if (!productNumMap.isEmpty()) {
				entity.setProductAmount(productNumMap.get("product_num"));
				entity.setProductLeftNum(productNumMap.get("product_num"));
			}
			this.save(entity);
			logger.info(TAG + "{}", "保存用户服务产品成功");
		}

	}

}
