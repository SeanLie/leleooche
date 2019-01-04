package com.jeecg.wechat.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.stereotype.Repository;

import com.jeecg.wechat.dbtable.TsUserDb;

/**
 * @author 朱磊
 *
 */
@Repository
public interface TsUserDao {

	/**
	 * 根据用户微信ID获得微信整体用户信息
	 * 
	 * @param openId
	 * @return
	 */
	@Arguments({ "openId" })
	@Sql("SELECT * FROM t_s_user WHERE openid = :openId")
	TSUser getUserInfoByOpenid(String openId);

	/**
	 * 根据用户ID获得微信整体用户信息
	 * 
	 * @param userid
	 * @return
	 */
	/*
	 * @Arguments({ "userid" })
	 * 
	 * @Sql("SELECT * FROM t_s_user WHERE id = :userid") TsUserDb
	 * getUserInfoByUserid(String userid);
	 */

	/**
	 * 根据用户ID获得微信整体用户信息
	 * 
	 * @return
	 */
	/*
	 * @Arguments({ "userid" })
	 * 
	 * @Sql("SELECT * FROM t_s_user WHERE id = :userid") TSUser getUserInfo(String
	 * userid);
	 */

	@Arguments({ "tel" })
	@Sql("SELECT * FROM t_s_user WHERE mobilePhone = :tel")
	TSUser checkUserByTel(String tel);

	/**
	 * 插入数据 【SQL文件】
	 * 
	 * @param t_s_user 参数
	 */
	@Arguments({ "t_s_user" })
	void insert(TsUserDb t_s_user);

}
