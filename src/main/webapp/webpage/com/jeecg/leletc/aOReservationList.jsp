<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="aOReservationList" checkbox="true" fitColumns="true" title="预约订单" sortName="createDate" actionUrl="orderReservationController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="服务产品ID"  field="productId"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="订单编号"  field="orderCode"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="预订用户"  field="orderUsers"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="订单状态"  field="orderStatus"  query="true"  queryMode="group"  dictionary="ord_status"  width="120"></t:dgCol>
   <t:dgCol title="订单日期"  field="orderTime"  formatter="yyyy-MM-dd"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="预约排序"  field="orderSort"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户停车地点"  field="parkSpace"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户停车位"  field="parkNo"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户停车照片"  field="parkPhoto"  queryMode="group"  image="true" imageSize="50,50"  width="120"></t:dgCol>
   <t:dgCol title="服务商停车位"  field="providerParkNo"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="服务商停车照片"  field="providerParkPhoto"  queryMode="group"  image="true" imageSize="50,50"  width="120"></t:dgCol>
   <t:dgCol title="订单描述"  field="orderDesc"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="orderReservationController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="orderReservationController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="orderReservationController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="orderReservationController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="orderReservationController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/leletc/aOReservationList.js"></script>		
 <script type="text/javascript">
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'orderReservationController.do?upload', "aOReservationList");
}

//导出
function ExportXls() {
	JeecgExcelExport("orderReservationController.do?exportXls","aOReservationList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("orderReservationController.do?exportXlsByT","aOReservationList");
}
 </script>