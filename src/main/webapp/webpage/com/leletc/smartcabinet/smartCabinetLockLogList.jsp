<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>智能柜开关锁日志</title>
<meta name="viewport" content="width=device-width" />
<t:base type="bootstrap,bootstrap-table,layer"></t:base>
</head>
<body>
<t:datagrid name="smartCabinetLockLogList" component="bootstrap-table"  checkbox="true" sortName="createDate"  sortOrder="desc"  pagination="true" fitColumns="true" title="智能柜开关锁日志" actionUrl="smartCabinetLockLogController.do?datagrid" idField="id"  fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="订单ID，引用auto_orders_reservation.id"  field="orderId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="箱门ID（箱门信息表的id）"  field="doorId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开关锁业务类型（1：存钥匙，2：取钥匙）"  field="bizType"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="格口号"  field="boxNo"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开关锁指令"  field="lockInstruct"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开关锁动作"  field="lockAct"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开关锁时间"  field="lockTime"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开关锁动作结果"  field="lockResult"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开关锁用户"  field="lockUser"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="微信用户TOKEN"  field="wxUserToken"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="smartCabinetLockLogController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="smartCabinetLockLogController.do?goAdd" funname="add"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="smartCabinetLockLogController.do?goUpdate" funname="update"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="smartCabinetLockLogController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="smartCabinetLockLogController.do?goUpdate" funname="detail"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  <script type="text/javascript">
	 $(document).ready(function(){
	 });
	 
	   
	 
	//导入
	function ImportXls() {
		openuploadwin('Excel导入', 'smartCabinetLockLogController.do?upload', "smartCabinetLockLogList");
	}
	
	//导出
	function ExportXls() {
		JeecgExcelExport("smartCabinetLockLogController.do?exportXls","smartCabinetLockLogList");
	}
	
	//模板下载
	function ExportXlsByT() {
		JeecgExcelExport("smartCabinetLockLogController.do?exportXlsByT","smartCabinetLockLogList");
	}
	
	 </script>
</body>
</html>