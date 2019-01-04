package com.leletc.user.dao;

import java.util.List;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import com.leletc.user.entity.UserCarParkEntity;

/**
 * 功能描述：用户车辆停车位Dao
 * <p>
 *
 * @author 李斌
 *         <p>
 * @date 2018/12/16 00:55
 *       <p>
 *       修改记录：修改内容 修改人 修改时间
 *       <ul>
 *       <li></li>
 *       </ul>
 *       <p>
 *       Copyright © 2016-2018/12/16, 深圳市乐乐网络科技有限公司, All Rights Reserved
 *       <p>
 */
@Repository
public interface UserCarParkDao {

	/**
	 * getUserInfoByOpenId
	 *
	 * @param userId
	 * @return null
	 * @author 李斌
	 * @date 2018/12/16 00:56
	 */
	@Arguments({ "userId" })
	@Sql("SELECT * FROM auto_user_carpark WHERE user_id = :userId")
	List<UserCarParkEntity> getByUserId(String userId);
}
