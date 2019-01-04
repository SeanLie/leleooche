/**
 * 业务Service层
 */
package ${bussiPackage}.service.impl.${entityPackage};

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${bussiPackage}.service.${entityPackage}.I${entityName}Service;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

/**
 * 功能描述：${ftl_description}业务接口
 * <p>
 * @author Sean
 * <p>
 * @date ${ftl_create_time}
 * <p>
 * 修改记录：修改内容 修改人 修改时间
 * <ul>
 * <li></li>
 * </ul>
 * <p>
 * Copyright © 2016-2018, 深圳市乐乐网络科技有限公司, All Rights Reserved
 * <p>
 */
@Service("${entityName?uncap_first}Service")
@Transactional
public class ${entityName}ServiceImpl extends CommonServiceImpl implements I${entityName}Service {
	
}