/**
 * 2018年8月27日
 * WxApiServiceImpl.java
 * 朱磊
 */
package com.jeecg.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.jeecg.wechat.dao.TsUserDao;
import com.jeecg.wechat.entity.OpenAccessToken;
import com.jeecg.wechat.service.WxApiBaseServiceI;
import com.jeecg.wechat.util.WeixinUtil;
import com.leletc.user.api.response.UserRsp;
import com.leletc.user.dao.UserCarParkDao;
import com.leletc.user.dao.UserVehicleDao;
import com.leletc.user.entity.UserCarParkEntity;
import com.leletc.user.entity.UserVehicleEntity;
import com.leletc.user.pojo.CarPark;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeewx.api.wxuser.user.model.Wxuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述：微信接口基础类实现类
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/12/27 23:33
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018/12/27, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Service
@Transactional
public class WxApiBaseServiceImpl extends CommonServiceImpl implements WxApiBaseServiceI {

	private static Logger logger = Logger.getLogger(WxApiBaseServiceImpl.class);

	@Autowired
	private TsUserDao tsUserDao;

	@Autowired
	private UserVehicleDao userVehicleDao;

	@Autowired
	private UserCarParkDao userCarParkDao;

	@Resource
	private RedisTemplate redisTemplate;

	@Override
	public Wxuser getOauthUserInfoByCode(String code) {
		Wxuser wxUser;
		Object codeCache = redisTemplate.boundValueOps(code).get();
		if (null != codeCache) {
			logger.debug("从Redis缓存中获取微信用户信息 - code - " + code);
			logger.debug("------------------------ - wxUser - " + codeCache.toString());
			return (Wxuser) codeCache;
		}
		OpenAccessToken openAccessToken = WeixinUtil.getOpenAccessToken(code);
		wxUser = WeixinUtil.getWXUserInfoUrl(openAccessToken.getAccess_token(), openAccessToken.getOpenid());
		if (wxUser == null) {
			logger.error("获取微信用户信息失败");
			return null;
		}
		// 添加到缓存
		redisTemplate.boundValueOps(code).set(wxUser, 24, TimeUnit.HOURS);
		return wxUser;
	}

	@Override
	public Serializable save(Wxuser wxuser) throws Exception {
		return super.save(wxuser);
	}

	@Override
	public UserRsp getUserInfoByOpenId(String openId) {
		UserRsp rsp = new UserRsp();
		TSUser user = tsUserDao.getUserInfoByOpenid(openId);
		// 增加车牌信息
		List<UserVehicleEntity> vehicleList = userVehicleDao.getByUserId(user.getId());
		if (!CollectionUtils.isEmpty(vehicleList)) {
			rsp.setVehicles(JSON.toJSONString(vehicleList.get(0)));
		}
		try {
			MyBeanUtils.copyBeanNotNull2Bean(user, rsp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 增加停车位信息
		// 增加车位信息
		List<UserCarParkEntity> carParkList = userCarParkDao.getByUserId(user.getId());
		if (!CollectionUtils.isEmpty(carParkList)) {
			UserCarParkEntity carParkEntity = carParkList.get(0);
			logger.info("carParkEntity:" + carParkEntity.toString());
			CarPark carPark = new CarPark();
			carPark.setPark_num(StringUtils.isNotBlank(carParkEntity.getPark_num()) ? carParkEntity.getPark_num() : "");
			carPark.setPark_add(StringUtils.isNotBlank(carParkEntity.getPark_add()) ? carParkEntity.getPark_add() : "");
			rsp.setCarparks(JSON.toJSONString(carPark));
		}
		logger.info("注册通过微信Openid获取用户rsp=" + rsp.toString());
		return rsp;
	}

}
