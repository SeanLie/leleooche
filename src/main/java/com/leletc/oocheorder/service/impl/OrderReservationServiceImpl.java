package com.leletc.oocheorder.service.impl;

import com.leletc.oocheorder.entity.OrderDetailEntity;
import com.leletc.oocheorder.entity.OrderReservationEntity;
import com.leletc.oocheorder.service.IOrderReservationService;
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

@Service("orderReservationService")
@Transactional
public class OrderReservationServiceImpl extends CommonServiceImpl implements IOrderReservationService {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void delete(OrderReservationEntity entity) throws Exception {
        super.delete(entity);
    }

    public void addMain(OrderReservationEntity aOReservation,
                        List<OrderDetailEntity> autoOrdersDetailList) throws Exception {
        //保存主信息
        this.save(aOReservation);

        /**保存-预约订单明细*/
        for (OrderDetailEntity autoOrdersDetail : autoOrdersDetailList) {
            //外键设置
            autoOrdersDetail.setOrderId(aOReservation.getId());
            this.save(autoOrdersDetail);
        }
    }

    public void updateMain(OrderReservationEntity aOReservation,
                           List<OrderDetailEntity> autoOrdersDetailList) throws Exception {
        //保存主表信息
        if (StringUtil.isNotEmpty(aOReservation.getId())) {
            try {
                OrderReservationEntity temp = findUniqueByProperty(OrderReservationEntity.class, "id", aOReservation.getId());
                MyBeanUtils.copyBeanNotNull2Bean(aOReservation, temp);
                this.saveOrUpdate(temp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.saveOrUpdate(aOReservation);
        }
        //===================================================================================
        //获取参数
        Object id0 = aOReservation.getId();
        //===================================================================================
        //1.查询出数据库的明细数据-预约订单明细
        String hql0 = "from OrderDetailEntity where 1 = 1 AND orderId = ? ";
        List<OrderDetailEntity> autoOrdersDetailOldList = this.findHql(hql0, id0);
        //2.筛选更新明细数据-预约订单明细
        if (autoOrdersDetailList != null && autoOrdersDetailList.size() > 0) {
            for (OrderDetailEntity oldE : autoOrdersDetailOldList) {
                boolean isUpdate = false;
                for (OrderDetailEntity sendE : autoOrdersDetailList) {
                    //需要更新的明细数据-预约订单明细
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
                    //如果数据库存在的明细，前台没有传递过来则是删除-预约订单明细
                    super.delete(oldE);
                }

            }
            //3.持久化新增的数据-预约订单明细
            for (OrderDetailEntity autoOrdersDetail : autoOrdersDetailList) {
                if (oConvertUtils.isEmpty(autoOrdersDetail.getId())) {
                    //外键设置
                    autoOrdersDetail.setOrderId(aOReservation.getId());
                    this.save(autoOrdersDetail);
                }
            }
        }
    }

    public void delMain(OrderReservationEntity aOReservation) throws Exception {
        //删除主表信息
        this.delete(aOReservation);
        //===================================================================================
        //获取参数
        Object id0 = aOReservation.getId();
        //===================================================================================
        //删除-预约订单明细
        String hql0 = "from OrderDetailEntity where 1 = 1 AND orderId = ? ";
        List<OrderDetailEntity> autoOrdersDetailOldList = this.findHql(hql0, id0);
        this.deleteAllEntitie(autoOrdersDetailOldList);

    }

}