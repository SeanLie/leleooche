<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="autoOrdersQueueList" checkbox="true" pagination="true" fitColumns="true" title="预约队列" sortName="createDate" actionUrl="autoOrdersQueueController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="订单ID"  field="orderId"  query="true"  queryMode="single"  dictionary="auto_orders_reservation,id,order_code"  width="120"></t:dgCol>
   <t:dgCol title="队列日期"  field="queueDate"  formatter="yyyy-MM-dd hh:mm:ss"  query="true"  queryMode="group"  width="200"></t:dgCol>
   <t:dgCol title="排队编号"  field="queueNo"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="排队用户"  field="queueUser"  query="true"  queryMode="single"  dictionary="t_s_base_user,id,realname"  width="120"></t:dgCol>
   <t:dgCol title="排队状态"  field="queueStatus"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="group"  width="200"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="group"  width="200"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="autoOrdersQueueController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="autoOrdersQueueController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="autoOrdersQueueController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="autoOrdersQueueController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="autoOrdersQueueController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/leletc/autoOrdersQueueList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'autoOrdersQueueController.do?upload', "autoOrdersQueueList");
}

//导出
function ExportXls() {
	JeecgExcelExport("autoOrdersQueueController.do?exportXls","autoOrdersQueueList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("autoOrdersQueueController.do?exportXlsByT","autoOrdersQueueList");
}

 </script>