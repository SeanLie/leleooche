package com.leletc.reservecfg.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import com.leletc.reservecfg.entity.AutoReservePermissionsConfigEntity;

@Repository
public interface ReservePermissionConfigDao {

	/**
	 * 根据公司机构ID获得该机构参数信息
	 * 
	 * @param orgId
	 * @return
	 */
	@Arguments({ "orgId" })
	@Sql("SELECT * FROM auto_reserve_permissions_config WHERE company_code = :orgId")
	AutoReservePermissionsConfigEntity getReservePermission(String orgId);

}
