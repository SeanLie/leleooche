<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="autoBaseProductsList" checkbox="true" pagination="true" treegrid="true" treeField="productName" fitColumns="true" title="服务产品表" sortName="createDate" actionUrl="autoBaseProductsController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="父服务产品"  field="parentProductId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="服务产品名称"  field="productName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="服务产品状态"  field="productStatus"  query="true"  queryMode="single"  dictionary="prostatus"  width="120"></t:dgCol>
   <t:dgCol title="服务产品介绍"  field="productDesc"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="autoBaseProductsController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="autoBaseProductsController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="autoBaseProductsController.do?goUpdate" funname="updatetree" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="autoBaseProductsController.do?doBatchDel" funname="deleteALLSelecttree"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="autoBaseProductsController.do?goUpdate" funname="detailtree" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/leletc/autoBaseProductsList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
		$("#autoBaseProductsList").treegrid({
 				 onExpand : function(row){
 					var children = $("#autoBaseProductsList").treegrid('getChildren',row.id);
 					 if(children.length<=0){
 					 	row.leaf=true;
 					 	$("#autoBaseProductsList").treegrid('refresh', row.id);
 					 }
 				}
 		});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'autoBaseProductsController.do?upload', "autoBaseProductsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("autoBaseProductsController.do?exportXls","autoBaseProductsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("autoBaseProductsController.do?exportXlsByT","autoBaseProductsList");
}

/**
 * 获取表格对象
 * @return 表格对象
 */
function getDataGrid(){
	var datagrid = $('#'+gridname);
	return datagrid;
}
 </script>