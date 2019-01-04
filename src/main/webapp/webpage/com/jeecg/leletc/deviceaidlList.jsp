<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="deviceaidlList" checkbox="false" pagination="true" fitColumns="true" title="智能柜接口_测试Minidao" sortName="createDate" actionUrl="deviceaidlController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="开门板ip"  field="ip"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="开门板端口号"  field="port"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="箱号"  field="boxNum"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="列号"  field="columnNum"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="等待休眠时间"  field="sleeptime"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="箱门总数"  field="boxTotal"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="智能柜类型"  field="boxType"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="维护用户"  field="boxPerson"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所在省"  field="prov"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所在市"  field="city"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所在区"  field="section"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="运单号"  field="awb"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否租用"  field="isrend"  queryMode="single"  dictionary="isrend"  width="120"></t:dgCol>
   <t:dgCol title="客户类型"  field="custyoe"  queryMode="single"  dictionary="paytype"  width="120"></t:dgCol>
   <t:dgCol title="上线时间"  field="onlinetime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="描述信息"  field="desr"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="弹出框"  field="popup"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="deviceaidlController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
	<t:dgFunOpt funname="doMyAdd(id)" title="我的添加" urlclass="ace_button" urlfont="fa-wrench" />
   <t:dgToolBar title="录入" icon="icon-add" url="deviceaidlController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="deviceaidlController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="deviceaidlController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="deviceaidlController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/leletc/deviceaidlList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
     	//自定义按钮-我的添加
	 	function doMyAdd(id,index){
	 	    var url = "deviceaidlController.do?doMyAdd";
			url = url+"&id="+id;
	 		createdialog('确认 ', '确定我的添加吗 ?', url,'deviceaidlList');
	 	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'deviceaidlController.do?upload', "deviceaidlList");
}

//导出
function ExportXls() {
	JeecgExcelExport("deviceaidlController.do?exportXls","deviceaidlList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("deviceaidlController.do?exportXlsByT","deviceaidlList");
}

 </script>