package com.leletc.smartcabinet.service.impl;

import com.leletc.smartcabinet.entity.SmartCabinetBaseEntity;
import com.leletc.smartcabinet.entity.SmartCabinetDoorEntity;
import com.leletc.smartcabinet.service.ISmartCabinetBaseService;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 功能描述：智能柜基础信息业务操作类
 * <p>
 *
 * @author 李斌
 * <p>
 * @date 2018/10/31 23:40
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Service("smartCabinetBaseService")
@Transactional(rollbackFor = Exception.class)
public class SmartCabinetBaseServiceImpl extends CommonServiceImpl implements ISmartCabinetBaseService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void delete(SmartCabinetBaseEntity entity) throws Exception {
        super.delete(entity);
    }

    public void addMain(SmartCabinetBaseEntity autoSmartarkArkbase,
                        List<SmartCabinetDoorEntity> autoSmartarkArkdoorList) throws Exception {
        //保存主信息
        this.save(autoSmartarkArkbase);

        /**保存-智能柜门设置*/
        for (SmartCabinetDoorEntity autoSmartarkArkdoor : autoSmartarkArkdoorList) {
            //外键设置
            autoSmartarkArkdoor.setCabinetId(autoSmartarkArkbase.getId());
            this.save(autoSmartarkArkdoor);
        }
    }

    public void updateMain(SmartCabinetBaseEntity autoSmartarkArkbase,
                           List<SmartCabinetDoorEntity> autoSmartarkArkdoorList) throws Exception {
        //保存主表信息
        if (StringUtil.isNotEmpty(autoSmartarkArkbase.getId())) {
            try {
                SmartCabinetBaseEntity temp = findUniqueByProperty(SmartCabinetBaseEntity.class, "id", autoSmartarkArkbase.getId());
                MyBeanUtils.copyBeanNotNull2Bean(autoSmartarkArkbase, temp);
                this.saveOrUpdate(temp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.saveOrUpdate(autoSmartarkArkbase);
        }
        //===================================================================================
        //获取参数
        Object id0 = autoSmartarkArkbase.getId();
        //===================================================================================
        //1.查询出数据库的明细数据-智能柜门设置
        String hql0 = "from SmartCabinetDoorEntity where 1 = 1 AND arkId = ? ";
        List<SmartCabinetDoorEntity> autoSmartarkArkdoorOldList = this.findHql(hql0, id0);
        //2.筛选更新明细数据-智能柜门设置
        if (autoSmartarkArkdoorList != null && autoSmartarkArkdoorList.size() > 0) {
            for (SmartCabinetDoorEntity oldE : autoSmartarkArkdoorOldList) {
                boolean isUpdate = false;
                for (SmartCabinetDoorEntity sendE : autoSmartarkArkdoorList) {
                    //需要更新的明细数据-智能柜门设置
                    if (oldE.getId().equals(sendE.getId())) {
                        try {
                            MyBeanUtils.copyBeanNotNull2Bean(sendE, oldE);
                            this.saveOrUpdate(oldE);
                        } catch (Exception e) {
                            e.printStackTrace();
                            throw new BusinessException(e.getMessage());
                        }
                        isUpdate = true;
                        break;
                    }
                }
                if (!isUpdate) {
                    //如果数据库存在的明细，前台没有传递过来则是删除-智能柜门设置
                    super.delete(oldE);
                }

            }
            //3.持久化新增的数据-智能柜门设置
            for (SmartCabinetDoorEntity autoSmartarkArkdoor : autoSmartarkArkdoorList) {
                if (oConvertUtils.isEmpty(autoSmartarkArkdoor.getId())) {
                    //外键设置
                    autoSmartarkArkdoor.setCabinetId(autoSmartarkArkbase.getId());
                    this.save(autoSmartarkArkdoor);
                }
            }
        }
    }

    public void delMain(SmartCabinetBaseEntity autoSmartarkArkbase) throws Exception {
        //删除主表信息
        this.delete(autoSmartarkArkbase);
        //===================================================================================
        //获取参数
        Object id0 = autoSmartarkArkbase.getId();
        //===================================================================================
        //删除-智能柜门设置
        String hql0 = "from SmartCabinetDoorEntity where 1 = 1 AND arkId = ? ";
        List<SmartCabinetDoorEntity> autoSmartarkArkdoorOldList = this.findHql(hql0, id0);
        this.deleteAllEntitie(autoSmartarkArkdoorOldList);

    }

}