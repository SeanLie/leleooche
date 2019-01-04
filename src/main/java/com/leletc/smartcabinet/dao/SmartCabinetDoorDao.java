package com.leletc.smartcabinet.dao;

import com.leletc.smartcabinet.entity.SmartCabinetDoorEntity;
import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.Sql;
import org.springframework.stereotype.Repository;

/**
 * 功能描述：
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/11/02 16:25
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
public interface SmartCabinetDoorDao {

    /**
     * 根据柜子token查询可用的柜子信息，并分配一个柜子
     *
     * @param cabinetNo 柜子编号
     * @return
     */
    @Arguments({"cabinetNo"})
    @Sql("SELECT * FROM auto_smart_cabinet_door CD WHERE CD.cabinet_id = "
            + "(SELECT ID FROM auto_smart_cabinet_base CB WHERE CB.cab_code = :cabinetNo)"
            + " AND is_occupancy = 0 AND is_valid = 1 ORDER BY box_no LIMIT 1")
    SmartCabinetDoorEntity getFreeDoor(String cabinetNo);

    /**
     * 根据箱门ID获得箱门信息
     *
     * @param cabinetId
     * @return
     */
    @Arguments({"cabinetId"})
    @Sql("SELECT * FROM auto_smart_cabinet_door CD WHERE CD.id = :cabinetId")
    SmartCabinetDoorEntity get(String cabinetId);

    /**
     * 更新
     *
     * @param doorEntity
     * @return
     */
    @Arguments({"doorEntity"})
    int update(SmartCabinetDoorEntity doorEntity);

}
