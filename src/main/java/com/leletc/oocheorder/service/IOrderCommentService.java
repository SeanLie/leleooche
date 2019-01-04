package com.leletc.oocheorder.service;

import com.leletc.oocheorder.entity.OrdersCommentEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface IOrderCommentService extends CommonService {

    void delete(OrdersCommentEntity entity) throws Exception;

    Serializable save(OrdersCommentEntity entity) throws Exception;

    void saveOrUpdate(OrdersCommentEntity entity) throws Exception;

}
