<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="awbApplyList" checkbox="false" pagination="true" fitColumns="true" title="申请运单_MiniDao" sortName="createDate" actionUrl="awbApplyController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="申请人"  field="appPerson"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="申请时间"  field="appTime"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="申请备注"  field="appRemarks"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="票证类型"  field="ticketType"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="运单类型"  field="awbType"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="申请数量"  field="appNumber"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审批人"  field="audPerson"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审批时间"  field="audTime"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审批人备注"  field="audRemarks"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状态"  field="appStatus"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审批数量"  field="audNumbers"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发放人"  field="pPerson"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发放时间"  field="paidTime"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="电子单标识"  field="eawb"  queryMode="single"  dictionary="eawb"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="awbApplyController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="awbApplyController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="awbApplyController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="awbApplyController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="awbApplyController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/leletc/awbApplyList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'awbApplyController.do?upload', "awbApplyList");
}

//导出
function ExportXls() {
	JeecgExcelExport("awbApplyController.do?exportXls","awbApplyList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("awbApplyController.do?exportXlsByT","awbApplyList");
}

 </script>