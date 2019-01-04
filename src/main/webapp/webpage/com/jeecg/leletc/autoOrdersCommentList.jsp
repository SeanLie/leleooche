<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="autoOrdersCommentList" checkbox="true" pagination="true" treegrid="true" treeField="comments" fitColumns="true" title="订单评论管理" sortName="createDate" actionUrl="autoOrdersCommentController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="订单ID"  field="orderId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="回复评论ID"  field="parentCommentId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="评论用户ID"  field="commentUserId"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="评论内容"  field="comments"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="服务星级"  field="serverStarsLevel"  query="true"  queryMode="single"  dictionary="a_starts"  width="120"></t:dgCol>
   <t:dgCol title="评论状态"  field="commentStatus"  query="true"  queryMode="single"  dictionary="comstatus"  width="120"></t:dgCol>
   <t:dgCol title="评论时间"  field="commentTime"  formatter="yyyy-MM-dd"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="评论用户"  field="commentUserName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="autoOrdersCommentController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="autoOrdersCommentController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="autoOrdersCommentController.do?goUpdate" funname="updatetree" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="autoOrdersCommentController.do?doBatchDel" funname="deleteALLSelecttree"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="autoOrdersCommentController.do?goUpdate" funname="detailtree" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/leletc/autoOrdersCommentList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
		$("#autoOrdersCommentList").treegrid({
 				 onExpand : function(row){
 					var children = $("#autoOrdersCommentList").treegrid('getChildren',row.id);
 					 if(children.length<=0){
 					 	row.leaf=true;
 					 	$("#autoOrdersCommentList").treegrid('refresh', row.id);
 					 }
 				}
 		});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'autoOrdersCommentController.do?upload', "autoOrdersCommentList");
}

//导出
function ExportXls() {
	JeecgExcelExport("autoOrdersCommentController.do?exportXls","autoOrdersCommentList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("autoOrdersCommentController.do?exportXlsByT","autoOrdersCommentList");
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