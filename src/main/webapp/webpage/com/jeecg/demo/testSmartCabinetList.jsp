<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="testSmartCabinetList" checkbox="false" pagination="true" fitColumns="true" title="测试智能柜基础表" actionUrl="testSmartCabinetController.do?datagrid" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="智能柜编号"  field="smartCabCode"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="智能柜提供商"  field="smartCabProv"  query="true"  queryMode="single"  dictionary="wise_partner,smartCabProv,departname"  popup="true"  width="120"></t:dgCol>
   <t:dgCol title="智能柜箱门数"  field="smartCabDoors"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="智能柜投放地址"  field="smartCabAddr"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="智能柜状态"  field="smartCabStatus"  query="true"  queryMode="single"  dictionary="sc_status"  width="120"></t:dgCol>
   <t:dgCol title="智能柜投放时间"  field="smartCabSetdate"  formatter="yyyy-MM-dd hh:mm:ss"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="智能柜租金"  field="smartCabRent"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="智能柜图片"  field="smartCabPic"  queryMode="single"  formatterjs="btListFileFormatter" width="240"></t:dgCol>
   <t:dgCol title="智能柜描述"  field="smartCabDesc"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="智能柜维护用户"  field="smartCabPerson"  query="true"  queryMode="single"  dictionary="wise_person,smartCabPerson,realname"  popup="true"  width="120"></t:dgCol>
   <t:dgCol title="智能柜是否在库"  field="smartCabInstock"  query="true"  queryMode="single"  dictionary="sc_stock"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="testSmartCabinetController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="testSmartCabinetController.do?goAdd" funname="add"  width="768"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="testSmartCabinetController.do?goUpdate" funname="update"  width="768"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="testSmartCabinetController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="testSmartCabinetController.do?goUpdate" funname="detail"  width="768"></t:dgToolBar>
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
	openuploadwin('Excel导入', 'testSmartCabinetController.do?upload', "testSmartCabinetList");
}

//导出
function ExportXls() {
	JeecgExcelExport("testSmartCabinetController.do?exportXls","testSmartCabinetList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("testSmartCabinetController.do?exportXlsByT","testSmartCabinetList");
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
