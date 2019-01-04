<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>订单处理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="aOHandleController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${aOHandlePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								订单ID:
							</label>
						</td>
						<td class="value">
						    <input id="orderId" name="orderId" type="text" maxlength="36" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked"  value='${aOHandlePage.orderId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">订单ID</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								处理人ID:
							</label>
						</td>
						<td class="value">
						    <input id="dealUserId" name="dealUserId" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked"  value='${aOHandlePage.dealUserId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">处理人ID</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								处理动作:
							</label>
						</td>
						<td class="value">
						    <input id="dealAct" name="dealAct" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${aOHandlePage.dealAct}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">处理动作</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								处理时间:
							</label>
						</td>
						<td class="value">
									  <input id="dealTime" name="dealTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${aOHandlePage.dealTime}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">处理时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								处理描述:
							</label>
						</td>
						<td class="value">
						    <input id="dealDesc" name="dealDesc" type="text" maxlength="255" style="width: 150px" class="inputxt"  ignore="ignore"  value='${aOHandlePage.dealDesc}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">处理描述</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								处理人名字:
							</label>
						</td>
						<td class="value">
						    <input id="dealUserName" name="dealUserName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${aOHandlePage.dealUserName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">处理人名字</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/leletc/aOHandle.js"></script>		
