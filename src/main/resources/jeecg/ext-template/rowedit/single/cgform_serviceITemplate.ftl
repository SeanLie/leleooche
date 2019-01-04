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
 * 功能描述：
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
public interface ${entityName}ServiceI extends CommonService{
	
 	public void delete(${entityName}Entity entity) throws Exception;
 	
 	public Serializable save(${entityName}Entity entity) throws Exception;
 	
 	public void saveOrUpdate(${entityName}Entity entity) throws Exception;
 	
	<#list buttons as btn>
 	<#if btn.optType=='action'>
 	/**
	 * 自定义按钮-[${btn.buttonName}]业务处理
	 * @param id
	 * @return
	 */
	 public void do${btn.buttonCode?cap_first}Bus(${entityName}Entity t) throws Exception;
 	</#if>
 	</#list>

}
