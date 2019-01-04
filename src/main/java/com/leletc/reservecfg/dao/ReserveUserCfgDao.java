package com.leletc.reservecfg.dao;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * 功能描述：用户预约配置DAO操作接口
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/12/08 18:06
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Repository
public interface ReserveUserCfgDao {

    /**
     * 获得产品服务次数
     *
     * @param personLevel 用户等级
     * @param productId 产品ID
     * @return Map
     */
    @Arguments({ "personLevel", "productId" })
    @Sql("SELECT c.product_num FROM auto_reserve_user_cfg c WHERE c.user_person_level = :personLevel " +
            "AND c.product_id = :productId")
    Map<String, Integer> getProductNum(String personLevel, String productId);

    /**
     * 获得用户可提前预约天数
     *
     * @param userId 用户ID
     * @param productId 产品ID
     * @return Map
     */
    @Arguments({ "userId", "productId" })
    Map<String, Integer> getAdvanceDays(String userId, String productId);

}
