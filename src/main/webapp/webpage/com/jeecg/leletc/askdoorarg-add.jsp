<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>智能柜门分配</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="askdoorargController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${askdoorargPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							箱门ID:
						</label>
					</td>
					<td class="value">
					     	 <input id="arkdoorId" name="arkdoorId" type="text" maxlength="36" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">箱门ID</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							分配用户:
						</label>
					</td>
					<td class="value">
							<input id="arrangeUser" name="arrangeUser" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"   onclick="popupClick(this,'account','arrangeUser','user_msg')"  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">分配用户</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							分配时间:
						</label>
					</td>
					<td class="value">
							   <input id="arrangeTime" name="arrangeTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">分配时间</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							分配状态:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="arrangeStatus" type="list"  typeGroupCode="a_Arra"  defaultVal="${askdoorargPage.arrangeStatus}" hasLabel="false"  title="分配状态" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">分配状态</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/leletc/askdoorarg.js"></script>		
