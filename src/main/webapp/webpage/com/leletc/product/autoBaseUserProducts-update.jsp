<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>auto_base_user_products</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="autoBaseUserProductsController.do?doUpdate" >
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								userId:
							</label>
						</td>
						<td class="value">
						    <input id="userId" name="userId" type="text" maxlength="36" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked"  value='${autoBaseUserProductsPage.userId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">userId</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								产品ID:
							</label>
						</td>
						<td class="value">
						    <input id="productId" name="productId" type="text" maxlength="36" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked"  value='${autoBaseUserProductsPage.productId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">产品ID</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								产品剩余次数:
							</label>
						</td>
						<td class="value">
						    <input id="productLeftNum" name="productLeftNum" type="text" maxlength="10" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${autoBaseUserProductsPage.productLeftNum}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">产品剩余次数</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								productAmount:
							</label>
						</td>
						<td class="value">
						    <input id="productAmount" name="productAmount" type="text" maxlength="10" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${autoBaseUserProductsPage.productAmount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">productAmount</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								创建人名称:
							</label>
						</td>
						<td class="value">
						    <input id="createName" name="createName" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${autoBaseUserProductsPage.createName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								创建人登录名称:
							</label>
						</td>
						<td class="value">
						    <input id="createBy" name="createBy" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${autoBaseUserProductsPage.createBy}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人登录名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								创建日期:
							</label>
						</td>
						<td class="value">
									  <input id="createDate" name="createDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${autoBaseUserProductsPage.createDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建日期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								更新人名称:
							</label>
						</td>
						<td class="value">
						    <input id="updateName" name="updateName" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${autoBaseUserProductsPage.updateName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新人名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								更新人登录名称:
							</label>
						</td>
						<td class="value">
						    <input id="updateBy" name="updateBy" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${autoBaseUserProductsPage.updateBy}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新人登录名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								更新日期:
							</label>
						</td>
						<td class="value">
									  <input id="updateDate" name="updateDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${autoBaseUserProductsPage.updateDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								所属部门:
							</label>
						</td>
						<td class="value">
						    <input id="sysOrgCode" name="sysOrgCode" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${autoBaseUserProductsPage.sysOrgCode}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所属部门</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								所属公司:
							</label>
						</td>
						<td class="value">
						    <input id="sysCompanyCode" name="sysCompanyCode" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${autoBaseUserProductsPage.sysCompanyCode}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所属公司</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/leletc/product/autoBaseUserProducts.js"></script>		
