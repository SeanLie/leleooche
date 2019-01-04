<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="autoOrdersReservationList" checkbox="true" pagination="true" fitColumns="true" title="预约订单" sortName="createDate" actionUrl="autoOrdersReservationController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="服务产品ID"  field="productId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="订单编号"  field="orderCode"  query="true"  queryMode="single"  width="280"></t:dgCol>
   <t:dgCol title="预订用户"  field="orderUsers"  queryMode="single"  dictionary="t_s_base_user,id,realname"  width="120"></t:dgCol>
   <t:dgCol title="订单状态"  field="orderStatus"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状态名称"  field="statusName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状态备注"  field="statusRemark"  queryMode="single"  width="200"></t:dgCol>
   <t:dgCol title="订单日期"  field="orderTime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="group"  width="220"></t:dgCol>
   <t:dgCol title="预约排序"  field="orderLevel"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="用户停车地点"  field="parkSpace"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="用户停车位"  field="parkNo"  query="true"  queryMode="single"  width="200"></t:dgCol>
   <t:dgCol title="车牌号"  field="plateNumber"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="用户停车照片"  field="parkPhoto"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="服务商停车位"  field="providerParkNo"  hidden="true"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="服务商停车照片"  field="providerParkPhoto"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="订单描述"  field="orderDesc"  queryMode="single"  width="200"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  query="true"  queryMode="single"  dictionary="base_user,orderUsers@createName,id@realname"  popup="true"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd hh:mm:ss"  hidden="true"  queryMode="group"  width="220"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="group"  width="200"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="autoOrdersReservationController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="autoOrdersReservationController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="autoOrdersReservationController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="autoOrdersReservationController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="autoOrdersReservationController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/leletc/autoOrdersReservationList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'autoOrdersReservationController.do?upload', "autoOrdersReservationList");
}

//导出
function ExportXls() {
	JeecgExcelExport("autoOrdersReservationController.do?exportXls","autoOrdersReservationList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("autoOrdersReservationController.do?exportXlsByT","autoOrdersReservationList");
}

 </script>