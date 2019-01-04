package com.leletc.reservecfg.service;

import com.leletc.reservecfg.entity.ReserveUserCfgEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.Map;

/**
 * 功能描述：用户预约配置业务接口
 * <p>
 *
 * @author Sean
 * <p>
 * @date 2018-12-08 11:32:18
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public interface IReserveUserCfgService extends CommonService {

    void delete(ReserveUserCfgEntity entity) throws Exception;

    Serializable save(ReserveUserCfgEntity entity) throws Exception;

    void saveOrUpdate(ReserveUserCfgEntity entity) throws Exception;

    /**
     * 获得产品服务次数
     *
     * @param personLevel 用户等级
     * @param productId   产品ID
     * @return Map
     */
    Map<String, Integer> getProductNum(String personLevel, String productId);

    /**
     * 获得用户可提前预约天数
     *
     * @param userId    用户ID
     * @param productId 产品ID
     * @return Map
     */
    Map<String, Integer> getAdvanceDays(String userId, String productId);

}
