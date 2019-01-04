package com.jeecg.wechat.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.jeecgframework.web.system.pojo.base.TSUserOrg;
import org.springframework.stereotype.Repository;

@Repository
public interface TsUserOrgDao {

	/**
	 * 根据用户ID获的机构ID
	 * 
	 * @param openId
	 * @return
	 */
	@Arguments({ "userId" })
	@Sql("SELECT * FROM t_s_user_org WHERE user_id = :userId")
	TSUserOrg getOrgIdByUserId(String userId);
}
