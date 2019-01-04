package com.leletc.smartcabinet.service;

import com.leletc.smartcabinet.entity.SmartCabinetLockLogEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ISmartCabinetLockLogService extends CommonService {

    /**
     * @description 删除
     * @param entity 实体对象
     * @author 李斌
     * @date 2018/10/31
     * @return 无
     * @throws Exception
    */
    void delete(SmartCabinetLockLogEntity entity) throws Exception;

    /**
     * @description 保存实体对象 
     * @param entity 实体对象
     * @author 李斌
     * @date 2018/10/31 23:28
     * @return 
    */
    Serializable save(SmartCabinetLockLogEntity entity) throws Exception;

    /**
     *
     * @description
     * @param entity
     * @return void
     * @author 李斌
     * @date 2018/10/31 19:15
    */
    void saveOrUpdate(SmartCabinetLockLogEntity entity) throws Exception;

}
