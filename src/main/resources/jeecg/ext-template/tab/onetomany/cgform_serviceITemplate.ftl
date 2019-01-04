<#if packageStyle == "service">
package ${bussiPackage}.${entityPackage}.service;
import ${bussiPackage}.${entityPackage}.entity.${entityName}Entity;
<#list subTab as sub>
import ${bussiPackage}.${sub.entityPackage}.entity.${sub.entityName}Entity;
</#list>
<#else>
package ${bussiPackage}.service.${entityPackage};
import ${bussiPackage}.entity.${entityPackage}.${entityName}Entity;
<#list subTab as sub>
import ${bussiPackage}.entity.${sub.entityPackage}.${sub.entityName}Entity;
</#list>
</#if>

import java.util.List;
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

	<#-- update--begin--author:jiaqiankun date:20180711 for：TASK #2899 【代码生成器 - 少卿】新版一对多模板没有写java增强逻辑 -->
 	void delete(${entityName}Entity entity) throws Exception;
	/**
	 * 添加一对多
	 * 
	 */
	void addMain(${entityName}Entity ${entityName?uncap_first},
	        <#list subTab as sub>List<${sub.entityName}Entity> ${sub.entityName?uncap_first}List<#if sub_has_next>,</#if></#list>)  throws Exception;
	/**
	 * 修改一对多
	 * 
	 */
	void updateMain(${entityName}Entity ${entityName?uncap_first},
	        <#list subTab as sub>List<${sub.entityName}Entity> ${sub.entityName?uncap_first}List<#if sub_has_next>,</#if></#list>) throws Exception;
	/**
	 * 删除一对多
	 * 
	 */
	void delMain (${entityName}Entity ${entityName?uncap_first}) throws Exception;
	<#-- update--end--author:jiaqiankun date:20180711 for：TASK #2899 【代码生成器 - 少卿】新版一对多模板没有写java增强逻辑 -->

}
