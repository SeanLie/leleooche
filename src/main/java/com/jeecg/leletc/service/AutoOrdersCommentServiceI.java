package com.jeecg.leletc.service;
import com.jeecg.leletc.entity.AutoOrdersCommentEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

/**
 * 功能描述：订单评论管理业务接口
 * <p>
 * @author Sean
 * <p>
 * @date 2019-01-01 12:30:32
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public interface AutoOrdersCommentServiceI extends CommonService {
	
 	void delete(AutoOrdersCommentEntity entity) throws Exception;
 	
 	Serializable save(AutoOrdersCommentEntity entity) throws Exception;
 	
 	void saveOrUpdate(AutoOrdersCommentEntity entity) throws Exception;
 	

}
