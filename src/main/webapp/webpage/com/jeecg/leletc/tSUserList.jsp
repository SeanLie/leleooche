<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tSUserList" checkbox="true" pagination="true" fitColumns="true" title="用户信息" sortName="createDate" actionUrl="tSUserController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="手机号"  field="mobilephone"  query="true"  queryMode="group"  width="150"></t:dgCol>
   <t:dgCol title="用户昵称"  field="nickname"  query="true"  queryMode="group"  width="200"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  queryMode="group"  dictionary="sex"  width="120"></t:dgCol>
   <t:dgCol title="邮箱"  field="email"  hidden="true"  queryMode="group"  width="200"></t:dgCol>
   <t:dgCol title="办公座机"  field="officephone"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="portrait"  field="portrait"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="imsign"  field="imsign"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户类型"  field="userType"  query="true"  queryMode="group"  dictionary="user_type"  width="120"></t:dgCol>
   <t:dgCol title="人员类型"  field="personType"  query="true"  queryMode="group"  dictionary="personType"  width="120"></t:dgCol>
   <t:dgCol title="人员级别"  field="personlevel"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户车辆ID"  field="vehicleId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户头像"  field="headimgurl"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户是否关注"  field="subscribe"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户关注时间"  field="subscribeTime"  hidden="true"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="工号"  field="empNo"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份证号"  field="citizenNo"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="传真"  field="fax"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开发权限标志"  field="devFlag"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户分组ID"  field="groupid"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="签名文件"  field="signaturefile"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="联系地址"  field="address"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="邮编"  field="post"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="memo"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="微信OpenId"  field="openid"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="微信用户唯一标识"  field="unionid"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所在城市"  field="city"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="国家"  field="country"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所在省份"  field="province"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户的语言"  field="language"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户标签"  field="tagidList"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="粉丝备注"  field="remark"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人id"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人"  field="createName"  hidden="true"  queryMode="group"  width="200"></t:dgCol>
   <t:dgCol title="创建时间"  field="createDate"  formatter="yyyy-MM-dd hh:mm:ss"  hidden="true"  queryMode="group"  width="220"></t:dgCol>
   <t:dgCol title="修改人id"  field="updateBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="修改人"  field="updateName"  queryMode="group"  width="200"></t:dgCol>
   <t:dgCol title="修改时间"  field="updateDate"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="group"  width="220"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tSUserController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="tSUserController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="tSUserController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tSUserController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tSUserController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/leletc/tSUserList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tSUserController.do?upload', "tSUserList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tSUserController.do?exportXls","tSUserList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tSUserController.do?exportXlsByT","tSUserList");
}

 </script>