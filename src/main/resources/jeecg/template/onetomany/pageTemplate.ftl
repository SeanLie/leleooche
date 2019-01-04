package ${bussiPackage}.page.${entityPackage};

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

<#list subTab as sub>
import ${bussiPackage}.entity.${sub.entityPackage}.${sub.entityName}Entity;
</#list>

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
@SuppressWarnings("serial")
public class ${entityName}Page implements java.io.Serializable {

	<#list subTab as sub>
	/**保存-${sub.ftlDescription}*/
	private List<${sub.entityName}Entity> ${sub.entityName?uncap_first}List = new ArrayList<${sub.entityName}Entity>();
	public List<${sub.entityName}Entity> get${sub.entityName}List() {
		return ${sub.entityName?uncap_first}List;
	}
	public void set${sub.entityName}List(List<${sub.entityName}Entity> ${sub.entityName?uncap_first}List) {
		this.${sub.entityName?uncap_first}List = ${sub.entityName?uncap_first}List;
	}
	</#list>


	<#list originalColumns as po>
	/**${po.filedComment}*/
	private ${po.fieldType} ${po.fieldName};
	</#list>
	
	<#list originalColumns as po>
	/**
	 *方法: 取得${po.fieldType}
	 *@return: ${po.fieldType}  ${po.filedComment}
	 */
	public ${po.fieldType} get${po.fieldName?cap_first}(){
		return this.${po.fieldName};
	}

	/**
	 *方法: 设置${po.fieldType}
	 *@param: ${po.fieldType}  ${po.filedComment}
	 */
	public void set${po.fieldName?cap_first}(${po.fieldType} ${po.fieldName}){
		this.${po.fieldName} = ${po.fieldName};
	}
	</#list>
}
