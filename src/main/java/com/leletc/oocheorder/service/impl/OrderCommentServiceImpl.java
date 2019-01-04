package com.leletc.oocheorder.service.impl;

import com.leletc.oocheorder.entity.OrdersCommentEntity;
import com.leletc.oocheorder.service.IOrderCommentService;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service("orderCommentService")
@Transactional
public class OrderCommentServiceImpl extends CommonServiceImpl implements IOrderCommentService {

    public void delete(OrdersCommentEntity entity) throws Exception {
        super.delete(entity);
    }

    public Serializable save(OrdersCommentEntity entity) throws Exception {
        Serializable t = super.save(entity);
        return t;
    }

    public void saveOrUpdate(OrdersCommentEntity entity) throws Exception {
        super.saveOrUpdate(entity);
    }

}