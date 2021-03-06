<#if packageStyle == "service">
package ${bussiPackage}.${entityPackage}.service;
import ${bussiPackage}.${entityPackage}.entity.${entityName}Entity;
<#else>
package ${bussiPackage}.service.${entityPackage};
import ${bussiPackage}.entity.${entityPackage}.${entityName}Entity;
</#if>
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

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
public interface I${entityName}Service extends CommonService {
	
 	void delete(${entityName}Entity entity) throws Exception;
 	
 	Serializable save(${entityName}Entity entity) throws Exception;
 	
 	void saveOrUpdate(${entityName}Entity entity) throws Exception;
 	
	<#list buttons as btn>
 	<#if btn.optType=='action'>
 	/**
	 * 自定义按钮-[${btn.buttonName}]业务处理
	 * @param id
	 * @return
	 */
	void do${btn.buttonCode?cap_first}Bus(${entityName}Entity t) throws Exception;
 	</#if>
 	</#list>

}
