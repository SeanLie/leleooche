<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>智能柜使用方</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="asapartnerController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${asapartnerPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							智能柜ID:
						</label>
					</td>
					<td class="value">
							<input id="arkId" name="arkId" type="text" style="width: 150px" class="searchbox-inputtext"  datatype="*"  ignore="checked"   onclick="popupClick(this,'id','arkId','ak_base')"  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">智能柜ID</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							使用合作方:
						</label>
					</td>
					<td class="value">
							<input id="arkPartner" name="arkPartner" type="text" style="width: 150px" class="searchbox-inputtext"  datatype="*"  ignore="checked"   onclick="popupClick(this,'departname','arkPartner','wise_partner')"  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">使用合作方</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							合作方类型:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="arkType" type="list"  datatype="n"  typeGroupCode="a_type"  defaultVal="${asapartnerPage.arkType}" hasLabel="false"  title="合作方类型" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">合作方类型</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/leletc/asapartner.js"></script>		
