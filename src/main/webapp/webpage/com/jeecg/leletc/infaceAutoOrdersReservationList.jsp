<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="infaceAutoOrdersReservationList" checkbox="true" pagination="true" fitColumns="true" title="预约订单" sortName="createDate" actionUrl="infaceAutoOrdersReservationController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="服务产品ID"  field="productId"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="订单编号"  field="orderCode"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="预订用户"  field="orderUsers"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="订单状态"  field="orderStatus"  query="true"  queryMode="group"  dictionary="ord_status"  width="120"></t:dgCol>
   <t:dgCol title="订单日期"  field="orderTime"  formatter="yyyy-MM-dd"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="预约排序"  field="orderSort"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户停车地点"  field="parkSpace"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户停车位"  field="parkNo"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户停车照片"  field="parkPhoto"  queryMode="group"  image="true" imageSize="50,50" formatterjs="btListImgFormatter" width="120"></t:dgCol>
   <t:dgCol title="服务商停车位"  field="providerParkNo"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="服务商停车照片"  field="providerParkPhoto"  queryMode="group"  image="true" imageSize="50,50" formatterjs="btListImgFormatter" width="120"></t:dgCol>
   <t:dgCol title="订单描述"  field="orderDesc"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="infaceAutoOrdersReservationController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="infaceAutoOrdersReservationController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="infaceAutoOrdersReservationController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="infaceAutoOrdersReservationController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="infaceAutoOrdersReservationController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'infaceAutoOrdersReservationController.do?upload', "infaceAutoOrdersReservationList");
}

//导出
function ExportXls() {
	JeecgExcelExport("infaceAutoOrdersReservationController.do?exportXls","infaceAutoOrdersReservationList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("infaceAutoOrdersReservationController.do?exportXlsByT","infaceAutoOrdersReservationList");
}

//bootstrap列表图片格式化
function btListImgFormatter(value,row,index){
	return listFileImgFormat(value,"image");
}
//bootstrap列表文件格式化
function btListFileFormatter(value,row,index){
	return listFileImgFormat(value);
}

//列表文件图片 列格式化方法
function listFileImgFormat(value,type){
	var href='';
	if(value==null || value.length==0){
		return href;
	}
	var value1 = "img/server/"+value;
	if("image"==type){
 		href+="<img src='"+value1+"' width=30 height=30  onmouseover='tipImg(this)' onmouseout='moveTipImg()' style='vertical-align:middle'/>";
	}else{
 		if(value.indexOf(".jpg")>-1 || value.indexOf(".gif")>-1 || value.indexOf(".png")>-1){
 			href+="<img src='"+value1+"' onmouseover='tipImg(this)' onmouseout='moveTipImg()' width=30 height=30 style='vertical-align:middle'/>";
 		}else{
 			var value2 = "img/server/"+value+"?down=true";
 			href+="<a href='"+value2+"' class='ace_button' style='text-decoration:none;' target=_blank><u><i class='fa fa-download'></i>点击下载</u></a>";
 		}
	}
	return href;
}

</script>
