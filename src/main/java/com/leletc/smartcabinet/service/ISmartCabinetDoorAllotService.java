package com.leletc.smartcabinet.service;

import com.leletc.smartcabinet.entity.SmartCabinetDoorAllotEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ISmartCabinetDoorAllotService extends CommonService {

    void delete(SmartCabinetDoorAllotEntity entity) throws Exception;

    Serializable save(SmartCabinetDoorAllotEntity entity) throws Exception;

    void saveOrUpdate(SmartCabinetDoorAllotEntity entity) throws Exception;

}
