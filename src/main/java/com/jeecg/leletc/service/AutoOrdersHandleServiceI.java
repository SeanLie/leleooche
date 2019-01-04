package com.jeecg.leletc.service;
import com.jeecg.leletc.entity.AutoOrdersHandleEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

/**
 * 功能描述：订单处理业务接口
 * <p>
 * @author Sean
 * <p>
 * @date 2019-01-01 10:53:13
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public interface AutoOrdersHandleServiceI extends CommonService {
	
 	void delete(AutoOrdersHandleEntity entity) throws Exception;
 	
 	Serializable save(AutoOrdersHandleEntity entity) throws Exception;
 	
 	void saveOrUpdate(AutoOrdersHandleEntity entity) throws Exception;
 	

}
