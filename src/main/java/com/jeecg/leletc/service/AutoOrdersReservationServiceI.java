package com.jeecg.leletc.service;
import com.jeecg.leletc.entity.AutoOrdersReservationEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

/**
 * 功能描述：预约订单业务接口
 * <p>
 * @author Sean
 * <p>
 * @date 2018-12-31 18:24:02
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public interface AutoOrdersReservationServiceI extends CommonService {
	
 	void delete(AutoOrdersReservationEntity entity) throws Exception;
 	
 	Serializable save(AutoOrdersReservationEntity entity) throws Exception;
 	
 	void saveOrUpdate(AutoOrdersReservationEntity entity) throws Exception;
 	

}
