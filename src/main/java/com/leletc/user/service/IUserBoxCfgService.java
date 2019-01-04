package com.leletc.user.service;
import com.leletc.user.entity.UserBoxCfgEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

/**
 * 功能描述：用户格口配置业务接口
 * <p>
 * @author Sean
 * <p>
 * @date 2018-12-20 08:12:28
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
public interface IUserBoxCfgService extends CommonService {
	
 	void delete(UserBoxCfgEntity entity) throws Exception;
 	
 	Serializable save(UserBoxCfgEntity entity) throws Exception;
 	
 	void saveOrUpdate(UserBoxCfgEntity entity) throws Exception;
 	
}
