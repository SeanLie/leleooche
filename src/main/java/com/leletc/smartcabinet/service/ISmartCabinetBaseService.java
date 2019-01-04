package com.leletc.smartcabinet.service;

import com.leletc.smartcabinet.entity.SmartCabinetBaseEntity;
import com.leletc.smartcabinet.entity.SmartCabinetDoorEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.util.List;

/**
 *
 */
public interface ISmartCabinetBaseService extends CommonService {

    void delete(SmartCabinetBaseEntity entity) throws Exception;

    /**
     * 添加一对多
     *
     * @param smartCabinetBaseEntity
     * @param smartCabinetDoorEntityList
     * @throws Exception
     */
    void addMain(SmartCabinetBaseEntity smartCabinetBaseEntity,
                 List<SmartCabinetDoorEntity> smartCabinetDoorEntityList) throws Exception;

    /**
     * 修改一对多
     */
    void updateMain(SmartCabinetBaseEntity smartCabinetBaseEntity,
                    List<SmartCabinetDoorEntity> smartCabinetDoorEntityList) throws Exception;

    /**
     * 删除一对多
     */
    void delMain(SmartCabinetBaseEntity smartCabinetBaseEntity) throws Exception;

}
